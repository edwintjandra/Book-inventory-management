package main;

import database.DatabaseQueryController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Book;

public class Index {
	Stage primaryStage;
	DatabaseQueryController db;
	
	public Index(Stage primaryStage) {
		this.primaryStage=primaryStage;
		db=new DatabaseQueryController();
	}
	
	public void initialize() {
		BorderPane bp=new BorderPane();
		GridPane gp=new GridPane();
		gp.setHgap(10);
		gp.setPadding(new Insets(10));
		
		VBox buttons=new VBox();
		Button createBtn=new Button("Create button");
		Button editBtn=new Button("Edit Button");
		Button deleteBtn=new Button("Delete Button");
		buttons.getChildren().addAll(createBtn,editBtn,deleteBtn);
		
		createBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Create(primaryStage).initialize();
			}
		});
		
		editBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Edit(primaryStage).initialize();
			}
		});		
		
		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Delete(primaryStage).initialize();
			}
		});		
		TableView<Book> tableView=new TableView();
		ObservableList<Book> books=db.indexBook();
		 
		 
		TableColumn<Book,Integer> id=new TableColumn("id");
		id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
		
		TableColumn<Book,String> name=new TableColumn("name");
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		
		TableColumn<Book,String> author=new TableColumn("author");
		author.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getAuthor()));
		
		TableColumn<Book,Integer> pages=new TableColumn("pages");
		pages.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPages()).asObject());
		
		TableColumn<Book,String> description=new TableColumn("description");
		description.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
		
		TableColumn<Book,Integer> price=new TableColumn("price");
		price.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrice()).asObject());
 		
		tableView.getColumns().addAll(id,name,author,pages,description,price);
		tableView.setItems(books);
		
		gp.add(buttons, 1, 1);
		gp.add(tableView, 0, 1);
		
		bp.setCenter(gp);
		Scene scene=new Scene(bp,650,500);
		primaryStage.setTitle("create book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
