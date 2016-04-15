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
import javafx.stage.WindowEvent;

public class App extends Application {

    /**
     * アプリケーションが持つ人々のデータです。
     */
    private final ObservableList<Person> personList = FXCollections.observableArrayList();

    /**
     * アプリケーションのスタートポイント
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        //コントローラー作成
        TopviewController tc = new TopviewController(personList);

        //メインビューをロード
        Pane root = null;
        FXMLLoader loader = new FXMLLoader(App.class.getResource("./fxml/topview.fxml"));
        loader.setController(tc);
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        //終了処理
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            closeProccess(event);
        });

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private void closeProccess(WindowEvent event) {
        System.out.println("Close Proccess.");
    }
}
