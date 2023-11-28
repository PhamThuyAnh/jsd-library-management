package a1_2001040008;

import common.Genre;
import common.PatronType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LibraryManProg {

	private static Date[] checkoutDate = new Date[] {
		  new Date(2023 - 1900, Calendar.MARCH, 25),
		  new Date(2023 - 1900, Calendar.MAY, 8),
		  new Date(2023 - 1900, Calendar.JUNE, 1),
		  new Date(2023 - 1900, Calendar.JUNE, 25),
		  new Date(2023 - 1900, Calendar.AUGUST, 10)
	};

	private static Date[] dueDate = new Date[] {
		  new Date(2023 - 1900, Calendar.APRIL, 25),
		  new Date(2023 - 1900, Calendar.MAY, 10),
		  new Date(2023 - 1900, Calendar.JUNE, 25),
		  new Date(2023 - 1900, Calendar.JULY, 25),
		  new Date(2023 - 1900, Calendar.SEPTEMBER, 20)
	};

	private static final Date[] returnDate = new Date[] {
		  new Date(2023 - 1900, Calendar.MAY, 27),
		  new Date(2023 - 1900, Calendar.MAY, 11),
		  new Date(2023 - 1900, Calendar.JULY, 28),
		  new Date(2023 - 1900, Calendar.AUGUST, 3),
		  new Date(2023 - 1900, Calendar.DECEMBER, 1)
	};

	// The main method that performs the tasks
	public static void main(String[] args) {

		// Create a new LibraryManager object
		LibraryManager libraryManager = new LibraryManager();

		// (a) Initialize at least 10 books in the library collection
		System.out.println("(a) Initialize at least 10 books in the library collection");

		Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", Genre.SCIENCE_FICTION, 1979, 5);
		Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger", Genre.FICTION, 1951, 3);
		Book book3 = new Book("The Da Vinci Code", "Dan Brown", Genre.HISTORY, 2003, 4);
		Book book4 = new Book("Pride and Prejudice", "Jane Austen", Genre.ROMANCE, 1813, 1);
		Book book5 = new Book("The Lord of the Rings", "J.R.R. Tolkien", Genre.NON_FICTION, 1954, 6);
		Book book6 = new Book("1984", "George Orwell", Genre.MYSTERY, 1949, 4);
		Book book7 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", Genre.FANTASY, 1997, 5);
		Book book8 = new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", Genre.SELF_HELP, 2005, 4);
		Book book9 = new Book("To Kill a Mockingbird", "Harper Lee", Genre.THRILLER, 1960, 5);
		Book book10 = new Book("The Hunger Games", "Suzanne Collins", Genre.BIOGRAPHY, 2008, 4);

		libraryManager.addBook(book1);
		libraryManager.addBook(book2);
		libraryManager.addBook(book3);
		libraryManager.addBook(book4);
		libraryManager.addBook(book5);
		libraryManager.addBook(book6);
		libraryManager.addBook(book7);
		libraryManager.addBook(book8);
		libraryManager.addBook(book9);
		libraryManager.addBook(book10);

		// (b) Initialize at least 3 patrons involving both regular and premium patrons
		System.out.println("\n(b) Initialize at least 3 patrons involving both regular and premium patrons");

		Patron patron1 = new Patron("Alhaitham", new Date(1968 - 1900, Calendar.MARCH, 26), "patron1@gmail.com",
		                            "1234567890", PatronType.REGULAR);
		Patron patron2 = new Patron("Wriothesley", new Date(2002 - 1900, Calendar.MAY, 2), "patron2@gmail.com",
		                            "0987654321", PatronType.PREMIUM);
		Patron patron3 = new Patron("Neuvillette", new Date(2001 - 1900, Calendar.NOVEMBER, 19), "patron3@gmail.com",
		                            "0978019974", PatronType.REGULAR);

		// (c) Initialize and use to create 5 book transactions
		System.out.println("\n(c) Initialize and use to create 5 book transactions");

		libraryManager.checkoutBook(patron1, book1, checkoutDate[0], dueDate[0]);
		libraryManager.checkoutBook(patron1, book5, checkoutDate[1], dueDate[1]);
		libraryManager.checkoutBook(patron2, book3, checkoutDate[2], dueDate[2]);
		libraryManager.checkoutBook(patron3, book4, checkoutDate[3], dueDate[3]);
		libraryManager.checkoutBook(patron3, book4, checkoutDate[4], dueDate[4]);

		// (d) Print a list of currently checked-out books
		System.out.println("\n(d) Print a list of currently checked-out books");

		List<LibraryTransaction> checkedOutBooks1 = libraryManager.getCheckedOutBooks(patron1);
		System.out.println("P1 has checked out " + checkedOutBooks1.size() + " books:");
		for (LibraryTransaction t : checkedOutBooks1) {
			System.out.println(t.getDescription());
		}

		List<LibraryTransaction> checkedOutBooks2 = libraryManager.getCheckedOutBooks(patron2);
		System.out.println("P2 has checked out " + checkedOutBooks2.size() + " books:");
		for (LibraryTransaction t : checkedOutBooks2) {
			System.out.println(t.getDescription());
		}

		List<LibraryTransaction> checkedOutBooks3 = libraryManager.getCheckedOutBooks(patron3);
		System.out.println("P3 has checked out " + checkedOutBooks3.size() + " books:");
		for (LibraryTransaction t : checkedOutBooks3) {
			System.out.println(t.getDescription());
		}

		// (f) Patron returns the book
		System.out.println("\n(f) Patron returns the book");

		try {
			libraryManager.returnBook(checkedOutBooks1.get(0), returnDate[0]);
			System.out.println(checkedOutBooks1.get(0).getDescription());

			libraryManager.returnBook(checkedOutBooks2.get(0), returnDate[2]);
			System.out.println(checkedOutBooks2.get(0).getDescription());

			libraryManager.returnBook(checkedOutBooks3.get(1), returnDate[4]);
			System.out.println(checkedOutBooks3.get(1).getDescription()); //error

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Transaction does not exist");
		}

		// (e) Print list of the overdue books that are not returned yet
		System.out.println("\n(e) Print list of the overdue books that are not returned yet");
		List<LibraryTransaction> overdueBooks = libraryManager.getOverdueBooks();
		System.out.println("There are " + overdueBooks.size() + " overdue books:");
		for (LibraryTransaction t : overdueBooks) {
			System.out.println(t.getDescription());
		}

		// (g) Sort transactions by patron ID
		System.out.println("\n(g) Sort transactions by patron ID");
		libraryManager.sort();
		for (LibraryTransaction t : libraryManager.transactions) {
			System.out.println(t.getDescription());
		}

		// (h) End the program
		System.out.println("\nProgram ended!");
		System.exit(0);
	}
}
