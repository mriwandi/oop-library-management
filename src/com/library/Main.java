package com.library;

import com.library.model.Book;
import com.library.model.Member;
import com.library.service.Library;

public class Main {
	public static void main(String[] args) {
		Library library = new Library();
		Book b1 = new Book("001", "Clean Code", "Robert Martin");
		Book b2 = new Book("002", "Effective Java", "Joshua Bloch");
		Book b3 = new Book("003", "Java Concurrency in Practice", "Brian Goetz");

		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);

		Member alice = new Member("M1", "Alice");
		library.listBooks();
		library.borrowBook(alice, "001");
		library.borrowBook(alice, "002");
		library.returnBook(alice, "001");
		library.borrowBook(alice, "003");
		library.borrowBook(alice, "001");
		library.borrowBook(alice, "004");
		library.borrowBook(alice, "002");

		System.out.println("\nBooks currently borrowed by Alice:");
		for (Book book : alice.getBorrowedBooks()) {
			System.out.println(book.getTitle());
		}
	}
}
