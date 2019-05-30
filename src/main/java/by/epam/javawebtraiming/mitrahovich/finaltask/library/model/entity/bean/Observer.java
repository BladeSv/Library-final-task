package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.Date;

public interface Observer {
	public void confirmOrder(int idOrder, Date takenDate);

	public void removeOrder(int idOrder);

	public void removeNotConfirOrder();

}
