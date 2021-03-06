package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao;

import java.sql.Connection;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.connecton.ConnectionPool;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.connecton.exception.ConnectionPoolException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;

public class AbstactDAO {

	protected static Logger log;

	static {
		log = Logger.getLogger("AbstactDAO");
	}

	public Connection getConnection() throws DaoSQLExcetion {

		try {
			Connection connection = ConnectionPool.getInstanse().getConnertion();
			if (connection != null) {

				return connection;
			} else {

				throw new ConnectionPoolException();
			}

		} catch (ConnectionPoolException e) {
			log.warn("get connection from pool", e);
			throw new DaoSQLExcetion(e.getCause());

		}
	}

	public void returnConnection(Connection connection) throws DaoSQLExcetion {
		try {
			ConnectionPool.getInstanse().returnConnerction(connection);
		} catch (ConnectionPoolException e) {
			log.warn("return connection to pool", e);
			throw new DaoSQLExcetion(e.getCause());
		}

	}

}
