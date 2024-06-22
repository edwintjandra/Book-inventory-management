package main;

import database.DatabaseQueryController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Book;
import javafx.scene.control.ListCell;

public class Create {
	Stage primaryStage;
	DatabaseQueryController db;

	public Create(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		this.primaryStage=primaryStage;
		db=new DatabaseQueryController();
	}
	
	public void initialize() {
		BorderPane bp=new BorderPane();
		GridPane gp=new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10));
		
		
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
	    
	    Button saveBtn=new Button("Save");
	    Button backBtn=new Button("Back");
	    saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				db.storeBook(nameTxt.getText(),authorTxt.getText(),pagesTxt.getText(),descriptionTxt.getText(),priceTxt.getText());
			}
	    });
	    backBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Index(primaryStage).initialize();;
			}
	    });
	    
	    ComboBox<Book> comboBox=new ComboBox<>();
	    ObservableList<Book> books=db.indexBook();
	    comboBox.setItems(books);
	    comboBox.setCellFactory(param -> new ListCell<Book>() {
    	   @Override
	        protected void updateItem(Book item, boolean empty) {
	            super.updateItem(item, empty);

	            if (empty || item == null) {
	                setText(null);
	            } else {
	                setText(item.toString());  // You may replace this with how you want to display the item
	            }
		   }	
	    });
	    gp.add(comboBox, 0, 0);
	    gp.add(nameTxt, 1, 0);
	    gp.add(authorLbl, 0, 1);
	    gp.add(authorTxt, 1, 1);
	    gp.add(pagesLbl, 0, 2);
	    gp.add(pagesTxt, 1, 2);
	    gp.add(descriptionLbl, 0, 3);
	    gp.add(descriptionTxt, 1, 3);
	    gp.add(priceLbl, 0, 4);
	    gp.add(priceTxt, 1, 4);
	    gp.add(saveBtn, 0, 5);
	    gp.add(backBtn, 1, 5);
		 
		bp.setCenter(gp);
		Scene scene=new Scene(bp,650,500);
		primaryStage.setTitle("create book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
