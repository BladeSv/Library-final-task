package by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties;

import java.util.ResourceBundle;

public class ManagerConfig {

	public static final ResourceBundle rb;

	static {
		rb = ResourceBundle.getBundle("config.config");
	}

	public ManagerConfig() {

	}

	public static String get(String key) {

		return rb.getString(key);
	}
}
