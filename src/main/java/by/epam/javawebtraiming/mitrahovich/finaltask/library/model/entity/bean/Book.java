package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

public class Book extends Item {
	private String title;
	private String annotation;
	private Author author;
	private Genre genre;

	public Book() {

	}

	/**
	 * @param id
	 * @param title
	 * @param annotation
	 * @param author
	 * @param genre
	 */
	public Book(int id, String title, String annotation, Author author, Genre genre) {
		super(id);
		this.title = title;
		this.annotation = annotation;
		this.author = author;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (annotation == null) {
			if (other.annotation != null)
				return false;
		} else if (!annotation.equals(other.annotation))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre != other.genre)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "title: " + title + ", annotation: " + annotation + ", author: " + author
				+ ", genre: " + genre;

	}

}
