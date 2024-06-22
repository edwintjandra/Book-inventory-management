package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;

public class DatabaseQueryController {
	private Connection con;

	public DatabaseQueryController() {
		con=new Connect().getConnection();
	}
	
	public void storeBook(String name,String author,String pages,String description,String price) {
		int priceInteger=Integer.parseInt(price);
		int pagesInteger=Integer.parseInt(pages);
		
		String query="INSERT INTO books(name,author,pages,description,price) VALUES(?,?,?,?,?)";
		try (PreparedStatement preparedStatement=con.prepareStatement(query)){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, pagesInteger);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, priceInteger);
			
			preparedStatement.executeUpdate();
			
			System.out.println("book inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ObservableList<Book> indexBook() {
		ObservableList<Book> books=FXCollections.observableArrayList();
		String query="SELECT * FROM books";
		try (PreparedStatement preparedStatement=con.prepareStatement(query)){
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Integer id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String author=resultSet.getString("author");
				Integer pages=resultSet.getInt("pages");
				String description=resultSet.getString("description");
				Integer price=resultSet.getInt("price");
				
				books.add(new Book(id,name,author,pages,description,price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public void updateBarang(String name,String author,String pages,String description,String price) {
		int priceInteger=Integer.parseInt(price);
		int pagesInteger=Integer.parseInt(pages);
		
		String query="UPDATE books SET name=?, author=?,pages=?,description=?,price=? WHERE name=?";
		try(PreparedStatement preparedStatement=con.prepareStatement(query)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, pagesInteger);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, priceInteger);
			preparedStatement.setString(6, name);
			
			preparedStatement.executeUpdate();
			System.out.println("books edited");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteBarang(String name) {
		String query="DELETE FROM books WHERE name=?";
		try(PreparedStatement preparedStatement=con.prepareStatement(query)) {
			preparedStatement.setString(1, name);
			
			preparedStatement.executeUpdate();
			System.out.println("book deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deleted error");
			e.printStackTrace();
		}
	}

	

}
