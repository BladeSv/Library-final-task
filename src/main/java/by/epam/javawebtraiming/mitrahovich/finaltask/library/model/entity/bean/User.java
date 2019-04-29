package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

public class User extends Item {
	private String name;
	private RoleType role;

	public User() {

	}

	/**
	 * @param id
	 * @param name
	 * @param role
	 */
	public User(int id, String name, RoleType role) {
		super(id);
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", name: " + name + ", role: " + role;

	}

}
