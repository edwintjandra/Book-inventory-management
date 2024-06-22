package model;

public class Book {
	private Integer id;
	private String name;
	private String author;
	private Integer pages;
	private String description;
	private Integer price;
	
	public Book(Integer id, String name, String author, Integer pages, String description, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.pages = pages;
		this.description = description;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	 
	
	

}
