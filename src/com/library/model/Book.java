package com.library.model;

public class Book {
	private final String id;
	private final String title;
	private final String author;
	private boolean isAvailable;

	public Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() { return author; }

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
}