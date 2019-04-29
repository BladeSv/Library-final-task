package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

public enum RoleType {
	GUEST, USER, ADMIN;

	@Override
	public String toString() {

		return name();
	}

}
