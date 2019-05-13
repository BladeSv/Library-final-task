package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.Date;
import java.util.List;

public class User extends Item implements Observer {
	private String name;
	private RoleType role;
	private List<Order> takenOrder;

	public User() {

	}

	/**
	 * @param id
	 * @param name
	 * @param role
	 * @param takenOrder
	 */
	public User(int id, String name, RoleType role, List<Order> takenOrder) {
		super(id);
		this.name = name;
		this.role = role;
		this.takenOrder = takenOrder;
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

	public List<Order> getTakenOrder() {
		return takenOrder;
	}

	public void setTakenOrder(List<Order> takenOrder) {
		this.takenOrder = takenOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((takenOrder == null) ? 0 : takenOrder.hashCode());
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
		if (takenOrder == null) {
			if (other.takenOrder != null)
				return false;
		} else if (!takenOrder.equals(other.takenOrder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", name: " + name + ", role: " + role + ", taken order: " + takenOrder;

	}

	@Override
	public void confirmOrder(int idOrder, Date takenDate) {
		for (Order order : takenOrder) {

			if (order.getId() == idOrder) {

				order.setTakenDate(takenDate);
			}
		}
	}

	@Override
	public void removeOrder(int idOrder) {
		for (Order order : takenOrder) {

			if (order.getId() == idOrder) {

				takenOrder.remove(order);
			}
		}

	}

}
