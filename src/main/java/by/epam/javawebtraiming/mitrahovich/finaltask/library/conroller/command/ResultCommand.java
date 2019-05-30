package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

public class ResultCommand {
	public enum Do {
		REDIRECT, FORWARD
	}

	private String page;
	private Do action;

	public Do getAction() {
		return action;
	}

	public void setAction(Do action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
