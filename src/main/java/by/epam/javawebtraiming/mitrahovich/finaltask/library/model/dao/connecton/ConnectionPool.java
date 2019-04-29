package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.connecton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.connecton.exception.ConnectionPoolException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class ConnectionPool {

	private static ConnectionPool connectionPool = new ConnectionPool();

	private static Logger log;

	static {

		log = Logger.getLogger("ConnectionPool");
	}

	private BlockingQueue<Connection> releaseConnection;
	private BlockingQueue<Connection> useConnection;
	private String driverName;
	private String url;
	private String user;
	private String password;
	private int connectionCount;

	private ConnectionPool() {
		driverName = ManagerConfig.get("jdbc.driver");
		url = ManagerConfig.get("jdbc.url");
		user = ManagerConfig.get("jdbc.user");
		password = ManagerConfig.get("jdbc.pass");
		connectionCount = Integer.parseInt(ManagerConfig.get("jdbc.connction.count"));

		releaseConnection = new ArrayBlockingQueue<Connection>(connectionCount);
		useConnection = new ArrayBlockingQueue<Connection>(connectionCount);
	}

	public void creatConnectionPool() throws ConnectionPoolException {

		if (releaseConnection.remainingCapacity() != connectionCount
				&& useConnection.remainingCapacity() != connectionCount) {
			releaseConnection = new ArrayBlockingQueue<Connection>(connectionCount);
			useConnection = new ArrayBlockingQueue<Connection>(connectionCount);

		}

		try {
			Class.forName(driverName);

			for (int i = 0; i < connectionCount; i++) {
				releaseConnection.add(createConnection());

			}
		} catch (ClassNotFoundException e) {
			log.warn("create ConnectionPool", e);
			throw new ConnectionPoolException(e.getCause());

		}
	}

	public static ConnectionPool getInstanse() {

		return connectionPool;
	}

	public Connection getConnertion() throws ConnectionPoolException {
		Connection connection = null;
		try {
			connection = releaseConnection.take();
			if (connection.isClosed()) {
				connection = createConnection();
			}
			useConnection.add(connection);
		} catch (InterruptedException | SQLException e) {
			log.warn("get Connection", e);
			throw new ConnectionPoolException(e.getCause());
		}

		return connection;
	}

	public void returnConnerction(Connection connection) throws ConnectionPoolException {
		if (connection != null) {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				log.warn("return AutoCommit", e);
				throw new ConnectionPoolException(e.getCause());
			}
			if (useConnection.contains(connection)) {
				useConnection.remove(connection);
			}
			releaseConnection.add(connection);
		}
	}

	private Connection createConnection() throws ConnectionPoolException {

		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			log.warn("create Connection", e);
			throw new ConnectionPoolException(e.getCause());

		}
	}

	public void closeAllConnection() throws ConnectionPoolException {
		if (releaseConnection != null && !releaseConnection.isEmpty()) {
			for (Connection con : releaseConnection) {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						log.warn("close Connection", e);
						throw new ConnectionPoolException(e.getCause());
					}
				}
			}
			releaseConnection.clear();

		}
		if (useConnection != null && !useConnection.isEmpty()) {
			for (Connection con : useConnection) {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						log.warn("close Connection", e);
						throw new ConnectionPoolException(e.getCause());
					}
				}
			}
			useConnection.clear();

		}
	}

}
