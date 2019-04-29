package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.GregorianCalendar;

/**
 * @author Mitrahovich
 */
public class Order {

	private Book book;
	private PlaceType place;
	private GregorianCalendar takenDate;

	public Order() {

	}

	/**
	 * @param book
	 * @param place
	 * @param takenDate
	 */
	public Order(Book book, PlaceType place, GregorianCalendar takenDate) {

		this.book = book;
		this.place = place;
		this.takenDate = takenDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public PlaceType getPlace() {
		return place;
	}

	public void setPlace(PlaceType place) {
		this.place = place;
	}

	public GregorianCalendar getTakenDate() {
		return takenDate;
	}

	public void setTakenDate(GregorianCalendar takenDate) {
		this.takenDate = takenDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((takenDate == null) ? 0 : takenDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (place != other.place)
			return false;
		if (takenDate == null) {
			if (other.takenDate != null)
				return false;
		} else if (!takenDate.equals(other.takenDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "book: " + book + ", place: " + place + ", takenDate: " + takenDate;

	}

}
