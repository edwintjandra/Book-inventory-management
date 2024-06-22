package main;

import database.DatabaseQueryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Delete {
	Stage primaryStage;
	DatabaseQueryController db;
	public Delete(Stage primaryStage) {
		this.primaryStage=primaryStage;
		db=new DatabaseQueryController();
	}
	
	public void initialize() {
		BorderPane bp=new BorderPane();
		GridPane gp=new GridPane();
		
		Label nameLbl=new Label("Name");
		TextField nameTxt=new TextField();
		
		Button deleteBtn=new Button("Delete");
		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				db.deleteBarang(nameTxt.getText());
			}
		});
		
		gp.add(nameLbl, 0, 0);
		gp.add(nameTxt, 1, 0);
		gp.add(deleteBtn, 0, 1);
		
		bp.setCenter(gp);
		Scene scene=new Scene(bp,650,500);
		primaryStage.setTitle("create book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
