package com.library.service;

import com.library.model.Book;
import com.library.model.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private final List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added: " + book.getTitle());
	}

	public void listBooks() {
		System.out.println("Book list:");
		books
			.forEach(book ->
				System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable())
			);
	}

	public Book findBookById(String id) {
		for (Book book : books) {
			if (book.getId().equalsIgnoreCase(id)) {
				return book;
			}
		}
		return null;
	}

	public void borrowBook(Member member, String bookId) {
		Book book = findBookById(bookId);
		if (book == null) {
			System.out.println("Book not found.");
			return;
		}
		if (!book.isAvailable()) {
			System.out.println("Book is currently borrowed.");
			return;
		}
		if (!member.canBorrowMore()) {
			System.out.println("Borrow limit reached.");
			return;
		}

		book.setAvailable(false);
		member.borrowBook(book);
		System.out.println(member.getName() + " borrowed \"" + book.getTitle() + "\"");
	}

	public void returnBook(Member member, String bookId) {
		Book book = findBookById(bookId);
		if (book == null || !member.hasBook(book)) {
			System.out.println("Book not found in member's borrowed list.");
			return;
		}

		book.setAvailable(true);
		member.returnBook(book);
		System.out.println(member.getName() + " returned \"" + book.getTitle() + "\"");
	}
}
