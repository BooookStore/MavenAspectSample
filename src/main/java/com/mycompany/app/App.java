package com.mycompany.app;

import javafx.application.Application;
import javafx.stage.Stage;

<<<<<<< HEAD
public class App extends Application {

	public static void main(String[] args){
=======
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
>>>>>>> f06c125fe478c13104ff46fa335480fc8a07799c
		launch(args);
	}
	
	@Override
<<<<<<< HEAD
	public void start(Stage primaryStage) throws Exception {
=======
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
>>>>>>> f06c125fe478c13104ff46fa335480fc8a07799c
		primaryStage.show();
	}
	
}
