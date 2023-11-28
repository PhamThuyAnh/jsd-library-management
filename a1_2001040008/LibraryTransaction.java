package a1_2001040008;


import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryTransaction {
	private Patron patron;
	private Book book;
	private Date checkoutDate;
	private Date dueDate;
	private Date returnDate;
	private double fineAmount;

	public LibraryTransaction(Patron patron, Book book, Date checkoutDate, Date dueDate) {
		this.patron = patron;
		this.book = book;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.returnDate = null;
		this.fineAmount = 0.0;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public double calculateFine() {

		long diff = returnDate.getTime() - dueDate.getTime();
		long days = diff / (1000 * 60 * 60 * 24);

		if (days >= 1 && days <= 7)
			this.fineAmount = days * 1.00;
		if (days >= 8 && days <= 14)
			this.fineAmount = days * 2.00;
		if (days > 14)
			this.fineAmount = days * 3.00;

		return this.fineAmount;
	}


	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd yyyy");
		sb.append("Transaction Details:\n");
		sb.append("\tPatron ID: ").append(patron.getPatronID()).append("\n");
		sb.append("\tBook ISBN: ").append(book.getISBN()).append("\n");
		sb.append("\tCheckout Date: ").append(sdf.format(checkoutDate)).append("\n");
		sb.append("\tDue Date: ").append(sdf.format(dueDate)).append("\n");
		if (returnDate != null) {
			sb.append("\tReturn Date: ").append(sdf.format(returnDate)).append("\n");
		}
		if (this.fineAmount != 0) {
			sb.append("\tFine Amount: $").append(String.format("%.2f", this.fineAmount)).append("\n");
		}
		return sb.toString();
	}

}