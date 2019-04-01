package Assigment5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;

public class Lists extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        Scene container = new Scene(flowPane,400,180);
        primaryStage.setScene(container);

        ListView<String> list = new ListView<>();
        list.setItems(FXCollections.observableArrayList(
                "Black","Blue","Cyan","Dark Gray","Gray","Green","Yellow","Red")
        );
        list.setMaxSize(150,160);
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button copy = new Button("Copy >>>");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setMaxSize(150,160);

        EventHandler eventHandler = (EventHandler) (Event event) -> {
            List<String> selected;
            selected = list.getSelectionModel().getSelectedItems();
            String txt = "";
            for (String s:selected) {
                txt = txt.concat(s+"\n");
            }
            textArea.setText(txt);
            if (selected.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("No Items Selected");
                alert.setContentText("Please Select An Item");
                alert.showAndWait();
            }
        };

        copy.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);


        flowPane.getChildren().addAll(list,copy,textArea);
        primaryStage.setTitle("Multiple Selection List");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}