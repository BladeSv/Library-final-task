package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

public class Genre extends Item {
	private String title;

	public Genre() {

	}

	/**
	 * @param id
	 * @param title
	 */
	public Genre(int id, String title) {
		super(id);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Genre other = (Genre) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " title: " + title;
	}

}
