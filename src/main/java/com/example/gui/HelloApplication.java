package com.example.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.*;

public class HelloApplication extends Application {

    TextArea textArea = new TextArea();
    TextField textField = new TextField();
    LinkedList<Integer> list = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) {

        Button btnSort = new Button("Sort");
        Button btnShuffle = new Button("Shuffle");
        Button btnReverse = new Button("Reverse");
        HBox paneForTextField = new HBox(10);
        paneForTextField.getChildren().addAll(new Label("Enter a number:"), textField);
        paneForTextField.setAlignment(Pos.CENTER);
        HBox paneForButtons = new HBox(9);
        paneForButtons.getChildren().addAll(btnSort, btnShuffle, btnReverse);
        paneForButtons.setAlignment(Pos.CENTER);

        textArea.setEditable(false);
        textArea.setWrapText(true);

        BorderPane pane = new BorderPane();
        pane.setTop(paneForTextField);
        pane.setCenter(textArea);
        pane.setBottom(paneForButtons);

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                list.addLast(Integer.parseInt(textField.getText()));
                printText();
            }
        });

        btnSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.sort(list);
                printText();
            }
        });

        btnShuffle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.shuffle(list);
                printText();
            }
        });

        btnReverse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                list.sort(Collections.reverseOrder());
                printText();
            }
        });

        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setTitle("HelloApplication");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void printText() {
        StringBuilder output = new StringBuilder();
        for (Integer num: list){
            output.append(num).append(" ");
        }
        textArea.setText(output.toString());
        textField.setText("");
    }
}