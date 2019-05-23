package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.AbstactDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.WrongLoginDateException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Order;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.RoleType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.SQLRequestConteiner;

public class UserDAOImpl extends AbstactDAO implements UserDAO {

	public UserDAOImpl() {

	}

	@Override
	public User getById(int id) throws DaoSQLExcetion {

		Connection connection = getConnection();
		User user = null;

		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_GET_BY_ID)) {
			preparedStatementUser.setInt(1, id);
			ResultSet rs = preparedStatementUser.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				String surname = rs.getString("surname");
				RoleType role = RoleType.valueOf(rs.getString("role").toUpperCase());
				List<Order> takeOrder = DaoManager.getInstance().getOrderDAO().getAllOrderUserById(id);
				user = new User(id, name, surname, role, takeOrder);
			}

		} catch (SQLException e) {

			log.warn("Get all users", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}
		return user;
	}

	@Override
	public List<User> getALL() throws DaoSQLExcetion {
		Connection connection = getConnection();
		List<User> users = null;

		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_GET_ALL_USER)) {
			ResultSet rs = preparedStatementUser.executeQuery();
			users = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id_user");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				RoleType role = RoleType.valueOf(rs.getString("role").toUpperCase());
				List<Order> takeOrder = DaoManager.getInstance().getOrderDAO().getAllOrderUserById(id);
				users.add(new User(id, name, surname, role, takeOrder));
			}

		} catch (SQLException e) {

			log.warn("Get all users", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}
		return users;
	}

	@Override
	public User registration(String login, String pass, String name, String surname, RoleType role)
			throws DaoSQLExcetion, WrongLoginDateException {
		User user = null;
		Connection connection = getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			log.warn("setAutoCommit(false) ", e);
			throw new DaoSQLExcetion(e.getCause());
		}

		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_GET_BY_LOGIN_AND_PASS)) {

			preparedStatementUser.setString(1, login);
			preparedStatementUser.setString(2, pass);
			ResultSet rs = preparedStatementUser.executeQuery();
			if (rs.next()) {

				log.info("User exist with login: " + login + ", password:" + pass);
				throw new WrongLoginDateException();
			}
		} catch (SQLException e) {

			log.warn("User registration check login and pass", e);
			throw new DaoSQLExcetion(e.getCause());
		}

		try (PreparedStatement preparedStatementRegustration = connection
				.prepareStatement(SQLRequestConteiner.USER_REGISTRATION)) {

			preparedStatementRegustration.setString(1, login);
			preparedStatementRegustration.setString(2, pass);
			preparedStatementRegustration.setString(3, name);
			preparedStatementRegustration.setString(4, surname);
			preparedStatementRegustration.setString(5, role.name());

			if (preparedStatementRegustration.executeUpdate() == 1) {
				user = login(login, pass);
				connection.commit();
			} else {
				log.info("Cant registration with login: " + login + ", password:" + pass);
				throw new WrongLoginDateException();

			}

		} catch (SQLException e) {

			log.warn("User registration", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return user;

	}

	@Override
	public User login(String login, String pass) throws WrongLoginDateException, DaoSQLExcetion {
		Connection connection = getConnection();

		User user = null;
		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_GET_BY_LOGIN_AND_PASS)) {
			preparedStatementUser.setString(1, login);
			preparedStatementUser.setString(2, pass);
			ResultSet rs = preparedStatementUser.executeQuery();
			if (!rs.next()) {
				log.info("Cant Login with login: " + login + ", password:" + pass);
				throw new WrongLoginDateException();
			} else {
				int userId = rs.getInt("id_user");
				String userName = rs.getString("name");
				String userSurname = rs.getString("surname");
				RoleType userRole = RoleType.valueOf(rs.getString("role").toUpperCase());
				List<Order> takeOrder = DaoManager.getInstance().getOrderDAO().getAllOrderUserById(userId);
				user = new User(userId, userName, userSurname, userRole, takeOrder);
			}
		} catch (SQLException e) {
			log.warn("User login", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return user;
	}

	@Override
	public void deteteUser(int id) throws DaoSQLExcetion {

		Connection connection = getConnection();

		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			log.warn("Detete User setAutoCommit(false)", e);
			throw new DaoSQLExcetion(e.getCause());
		}

		BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
		bookDAO.minusInstanceByDeleteUserTransaction(connection, id);
		OrderDAO orderDAO = DaoManager.getInstance().getOrderDAO();
		orderDAO.remoteByUserIdTransaction(connection, id);

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.USER_DELETE_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			log.warn("Detete User", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}
}
