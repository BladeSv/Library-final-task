package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

public class Book extends Item {
	private String title;
	private String annotation;
	private Autor autor;
	private GenreType genre;

	public Book() {

	}

	/**
	 * @param id
	 * @param title
	 * @param annotation
	 * @param autor
	 * @param genre
	 */
	public Book(int id, String title, String annotation, Autor autor, GenreType genre) {
		super(id);
		this.title = title;
		this.annotation = annotation;
		this.autor = autor;
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public GenreType getGenre() {
		return genre;
	}

	public void setGenre(GenreType genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
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
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
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
		return super.toString() + "title: " + title + ", annotation: " + annotation + ", autor: " + autor + ", genre: "
				+ genre;

	}

}
