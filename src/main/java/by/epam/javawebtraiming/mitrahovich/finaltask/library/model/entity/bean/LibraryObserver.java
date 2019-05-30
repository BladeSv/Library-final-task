package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LibraryObserver implements Observable {
	private List<Observer> observers;

	public LibraryObserver() {
		observers = new LinkedList<Observer>();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);

	}

	@Override
	public void NotifyConfirmOrder(int idOrder, Date takenDate) {

		for (Observer obs : observers) {
			obs.confirmOrder(idOrder, takenDate);
		}

	}

	@Override
	public void NotifyRemoveOrder(int idOrder) {

		for (Observer obs : observers) {
			obs.removeOrder(idOrder);
		}
	}

	@Override
	public void NotifyRemoveAllNotConfirmOrder() {
		for (Observer obs : observers) {
			obs.removeNotConfirOrder();
		}
	}

}
