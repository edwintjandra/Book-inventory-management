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

public class Edit {
	Stage primaryStage;
	DatabaseQueryController db;
	public Edit(Stage primaryStage) {
		this.primaryStage=primaryStage;
		db=new DatabaseQueryController();
	}
	
	public void initialize() {
		BorderPane bp=new BorderPane();
		GridPane gp=new GridPane();
		
		Label nameLbl=new Label("Name: ");
	    Label authorLbl=new Label("Author: ");
	    Label pagesLbl=new Label("Pages: ");
	    Label descriptionLbl=new Label("Description: ");
	    Label priceLbl=new Label("Price:");
	    
	    TextField nameTxt=new TextField();
	    TextField authorTxt=new TextField();
	    TextField pagesTxt=new TextField();
	    TextField descriptionTxt=new TextField();
	    TextField priceTxt=new TextField();
	    
	    Button editBtn=new Button("Edit");
	    editBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				db.updateBarang(nameTxt.getText(),authorTxt.getText(),pagesTxt.getText(),descriptionTxt.getText(),priceTxt.getText());
			}
	    });
	    
	    gp.add(nameLbl, 0, 0);
	    gp.add(nameTxt, 1, 0);
	    gp.add(authorLbl, 0, 1);
	    gp.add(authorTxt, 1, 1);
	    gp.add(pagesLbl, 0, 2);
	    gp.add(pagesTxt, 1, 2);
	    gp.add(descriptionLbl, 0, 3);
	    gp.add(descriptionTxt, 1, 3);
	    gp.add(priceLbl, 0, 4);
	    gp.add(priceTxt, 1, 4);
	    gp.add(editBtn, 0, 5);
		
		bp.setCenter(gp);
		Scene scene=new Scene(bp,650,500);
		primaryStage.setTitle("create book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
