package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.GregorianCalendar;

public interface Observer {
	public void confirmOrder(int idOrder, GregorianCalendar takenDate);

	public void removeOrder(int idOrder);

}
