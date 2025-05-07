package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
	private final List<Book> borrowedBooks = new ArrayList<>();
	private static final int MAX_BORROW_LIMIT = 3;

	public Member(String id, String name) {
		super(id, name);
	}

	@Override
	public void displayRole() {
		System.out.println("Role: Member");
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public boolean canBorrowMore() {
		return borrowedBooks.size() < MAX_BORROW_LIMIT;
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
	}

	public boolean hasBook(Book book) {
		return borrowedBooks.contains(book);
	}
}