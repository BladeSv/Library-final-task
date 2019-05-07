package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.GregorianCalendar;

public interface Observable {
	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void NotifyConfirmOrder(int idOrder, GregorianCalendar takenDate);

	public void NotifyRemoveOrder(int idOrder);
}
