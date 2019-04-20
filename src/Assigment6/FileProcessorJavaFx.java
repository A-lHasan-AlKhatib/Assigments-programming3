package Assigment6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class FileProcessorJavaFx extends Application{
    private File selectedFile;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane flowPane = new FlowPane();
        Scene container = new Scene(flowPane,420,470);
        primaryStage.setScene(container);
        primaryStage.setResizable(true);
        primaryStage.setTitle("File Viewer");

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");

        MenuItem file_Open = new MenuItem("Open");
        MenuItem file_Save = new MenuItem("Save");
        MenuItem file_Close = new MenuItem("Close");
        MenuItem file_Exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(file_Open,file_Save,file_Close,file_Exit);

        MenuItem edit_Font = new MenuItem("Font");
        MenuItem edit_Color = new MenuItem("Color");
        editMenu.getItems().addAll(edit_Font,edit_Color);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.prefHeightProperty().bind(primaryStage.heightProperty());
        textArea.prefWidthProperty().bind(primaryStage.widthProperty());

        menuBar.getMenus().addAll(fileMenu,editMenu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());


        FileChooser fileChooser = new FileChooser();
        EventHandler file_OpenHandler = (EventHandler) new EventHandler() {
            @Override
            public void handle(Event event) {
                selectedFile = fileChooser.showOpenDialog(primaryStage);
                textArea.setText("");
                
                if (selectedFile!=null){
                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(selectedFile);
                    } catch (FileNotFoundException e) {
                    }
                    if (scanner==null) throw new AssertionError();
                    while(scanner.hasNext()){
                        textArea.setText(textArea.getText()+"\n" + scanner.nextLine());
                    }
                    textArea.setText(textArea.getText().trim());
                    textArea.setEditable(true);
                }
            }
        };
        file_Open.setOnAction(file_OpenHandler);

        EventHandler file_closeHandler = (EventHandler) (Event event) -> {
            textArea.setText("");
            textArea.setEditable(false);
            selectedFile = null;
        };
        file_Close.setOnAction(file_closeHandler);

        file_Exit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        file_Save.setOnAction((ActionEvent event) -> {
            if (selectedFile!=null){
                String textHolder="";
                String newLine = System.getProperty("line.separator");
                Scanner scanner = new Scanner(textArea.getText());
                while (scanner.hasNext()){
                    textHolder = textHolder.concat(scanner.nextLine()+newLine);
                }
                String path = selectedFile.getPath();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(path);
                } catch (FileNotFoundException e) {
                }
                PrintWriter pw = new PrintWriter(fos);
                pw.write(textHolder);
                pw.flush();
                pw.close();
            }
        });

        List<String> myColors = new ArrayList<>();
        myColors.add("Red");
        myColors.add("Green");
        myColors.add("Blue");
        myColors.add("Black");


        ChoiceDialog<String> colorPicker = new ChoiceDialog<>("Black", myColors);
        colorPicker.setTitle("Color Selection");
        colorPicker.setHeaderText("Please Select A Color");
        colorPicker.setContentText("Choose The Color:");

        edit_Color.setOnAction((ActionEvent event) -> {
            Optional<String> selectedColor = colorPicker.showAndWait();
            
            if (selectedColor.isPresent()){
                switch (selectedColor.get()) {
                    case "Red":
                        textArea.setStyle("-fx-text-fill:red");
                        break;
                    case "Green":
                        textArea.setStyle("-fx-text-fill:green");
                        break;
                    case "Blue":
                        textArea.setStyle("-fx-text-fill:blue");
                        break;
                    case "Black":
                        textArea.setStyle("-fx-text-fill:black");
                        break;
                }
            }
        });


        List<String> myFonts = new ArrayList<>();
        myFonts.add("Arial");
        myFonts.add("Times New Roman");
        myFonts.add("Georgia");
        myFonts.add("Verdana");



        ChoiceDialog<String> fontPicker = new ChoiceDialog<>("Verdana", myFonts);
        fontPicker.setTitle("Font Selection");
        fontPicker.setHeaderText("Please Select A Font");
        fontPicker.setContentText("Choose The Font:");


        edit_Font.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Optional<String> selectedFont = fontPicker.showAndWait();
                if (selectedFont.isPresent()){
                    switch (selectedFont.get()) {
                        case "Arial":
                            textArea.setFont(Font.font("Arial"));
                            break;
                        case "Georgia":
                            textArea.setFont(Font.font("Georgia"));
                            break;
                        case "Times New Roman":
                            textArea.setFont(Font.font("Times New Roman"));
                            break;
                        case "Verdana":
                            textArea.setFont(Font.font("Verdana"));
                            break;
                    }
                }
            }
        });


//        menuBar.setStyle("-fx-background-color: gray");
        textArea.setWrapText(true);
        flowPane.getChildren().addAll(menuBar,textArea);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}