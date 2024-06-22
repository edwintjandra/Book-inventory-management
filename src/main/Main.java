package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new Index(primaryStage).initialize();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
