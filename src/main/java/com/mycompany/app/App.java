package com.mycompany.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
* Hello world!
*
 */
public class App extends Application
{
	/**
	 *アプリケーションのスタートポイント
	 *
	 */
	public static void main( String[] args )
	{
		Logger.getGlobal().log(Level.INFO, "Lunch JavaFX and AspectJ Application.");
		launch(args);
	}

	/**
	 * javaFXスタートポイント
	 *
	 */
	@Override
	public void start(Stage primaryStage){
		
		Button btn = new Button();
		btn.setText("Say,Hello World");
		btn.setOnAction(e -> {
			System.out.println("Hello World");
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);

		primaryStage.setTitle("Hello,World");
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

}
