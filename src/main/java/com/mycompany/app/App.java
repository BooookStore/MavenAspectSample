package com.mycompany.app;

import com.mycompany.app.model.Person;
import com.mycompany.app.topview.TopviewController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    /**
     * アプリケーションのスタートポイント
     *
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        initializeContext();

        TopviewController tc = new TopviewController(personList);

        Pane root = null;
        FXMLLoader loader = new FXMLLoader(App.class.getResource("./fxml/topview.fxml"));
        loader.setController(tc);

        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void initializeContext() {
        for (int i = 0; i < 10; i++) {
            Person e = new Person.PersonBuilder(Integer.toString(i), Integer.toString(i)).build();
            personList.add(e);
        }
    }

}
