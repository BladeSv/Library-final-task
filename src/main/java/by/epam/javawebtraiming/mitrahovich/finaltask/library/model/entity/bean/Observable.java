package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.Date;

public interface Observable {
	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void NotifyConfirmOrder(int idOrder, Date takenDate);

	public void NotifyRemoveOrder(int idOrder);
}
