package a1_2001040008;

import common.DateUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class LibraryManager {
	// Attributes
	private final List<Book> books;
	public final List<LibraryTransaction> transactions;

	public LibraryManager() {
		books = new ArrayList<>();
		transactions = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		if (book == null) {
			System.out.println("Invalid book");
			return;
		}

		for (Book b : books) {
			if (b.getISBN().equals(book.getISBN())) {
				System.out.println("Book already exists in the library");
				return;
			}
		}
		books.add(book);
		System.out.println("Book added successfully");
	}

	public List<LibraryTransaction> getCheckedOutBooks(Patron patron) {
		if (patron == null) {
			System.out.println("Invalid patron!");
			return null;
		}

		List<LibraryTransaction> checkedOutBooks = new ArrayList<>();
		for (LibraryTransaction t : transactions) {
			if (t.getPatron().getPatronID().equals(patron.getPatronID()) && t.getReturnDate() == null) {
				checkedOutBooks.add(t);
			}
		}
		return checkedOutBooks;
	}

	public void checkoutBook(Patron patron, Book book, Date checkoutDate, Date dueDate) {
		if (patron == null || book == null || checkoutDate == null || dueDate == null) {
			System.out.println("Invalid input!");
			return;
		}

		int limit;
		switch (patron.getPatronType()) {
			case REGULAR:
				limit = 3;
				break;
			case PREMIUM:
				limit = 5;
				break;
			default:
				System.out.println("Unknown patron type");
				return;
		}

		List<LibraryTransaction> checkedOutBooks = getCheckedOutBooks(patron);
		if (checkedOutBooks.size() >= limit) {
			System.out.println("Checkout limit exceeded");
			return;
		}
		if (book.getCopiesAvailable() <= 0) {
			System.out.println("No copies available");
			return;
		}

		LibraryTransaction transaction = new LibraryTransaction(patron, book, checkoutDate, dueDate);
		transactions.add(transaction);
		book.setCopiesAvailable(book.getCopiesAvailable() - 1);
		System.out.println("Book checked out successfully");
	}

	public void returnBook(LibraryTransaction transaction, Date returnDate) {
		if (transaction == null || returnDate == null) {
			System.out.println("Invalid input");
			return;
		}
		transaction.setReturnDate(returnDate);
		transaction.setFineAmount(transaction.calculateFine());
		Book book = transaction.getBook();
		book.setCopiesAvailable(book.getCopiesAvailable() + 1);
		System.out.println("Book returned successfully");
	}

	public List<LibraryTransaction> getOverdueBooks() {
		List<LibraryTransaction> overdueBooks = new ArrayList<>();
		Date currentDate = new DateUtils().getCurrentDate();
		for (LibraryTransaction t : transactions) {
			if (t.getReturnDate() == null && t.getDueDate().before(currentDate)) {
				overdueBooks.add(t);
			}
		}
		return overdueBooks;
	}

	public void sort() {
		transactions.sort(new Comparator<LibraryTransaction>() {
			@Override
			public int compare(LibraryTransaction t1, LibraryTransaction t2) {
				return t1.getPatron().getPatronID().compareTo(t2.getPatron().getPatronID());
			}
		});
	}

}
