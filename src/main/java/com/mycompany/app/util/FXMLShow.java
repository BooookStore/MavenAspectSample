package com.mycompany.app.util;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author honyaryousuke
 */
public class FXMLShow {

    public static void loadAndShow(URL location,Object cont) throws IOException{
        FXMLLoader loader = new FXMLLoader(location);
        loader.setController(cont);
        Pane root = loader.load();
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
