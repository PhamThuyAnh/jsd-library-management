package a1_2001040008;

import common.Genre;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private Genre genre;
	private int publicationYear;
	private int copiesAvailable;

	public Book(String title, String author, Genre genre, int publicationYear, int copiesAvailable) {
		this.ISBN = generateISBN(author, genre, publicationYear);
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publicationYear = publicationYear;
		this.copiesAvailable = copiesAvailable;
	}

	private String generateISBN(String author, Genre genre, int publicationYear) {
		String[] nameParts = author.split(" ");
		StringBuilder initials = new StringBuilder();
		for (String part : nameParts) {
			initials.append(part.substring(0, 1).toUpperCase());
		}
		String genreCodeStr = String.format("%02d", genre.ordinal() + 1);
		return initials + "-" + genreCodeStr + "-" + publicationYear;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public void setIsbn(String isbn) {
		this.ISBN = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getPublicationYear() {
		return this.publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getCopiesAvailable() {
		return this.copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}


	@Override
	public String toString() {
		return "Book{"
		       + "ISBN='"
		       + ISBN
		       + '\''
		       + ", title='"
		       + title
		       + '\''
		       + ", author='"
		       + author
		       + '\''
		       + ", genre="
		       + genre
		       + ", publicationYear="
		       + publicationYear
		       + ", copiesAvailable="
		       + copiesAvailable
		       + '}';
	}
}