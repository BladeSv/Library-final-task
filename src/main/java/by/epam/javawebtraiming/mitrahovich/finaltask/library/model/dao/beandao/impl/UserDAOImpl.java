package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.AbstactDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.WrongLoginDateException;
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
				RoleType role = RoleType.valueOf(rs.getString("role").toUpperCase());
				user = new User(id, name, role);
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
				RoleType role = RoleType.valueOf(rs.getString("role").toUpperCase());
				users.add(new User(id, name, role));
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
	public User registration(String login, String pass, String name, RoleType role)
			throws DaoSQLExcetion, WrongLoginDateException {
		User user = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_GET_BY_LOGIN_AND_PASS);
				PreparedStatement preparedStatementRegustration = connection
						.prepareStatement(SQLRequestConteiner.USER_REGISTRATION)) {

			preparedStatementUser.setString(1, login);
			preparedStatementUser.setString(2, pass);
			ResultSet rs = preparedStatementUser.executeQuery();
			if (rs.next()) {
				System.out.println("rs.next()");
				log.info("User exist with login: " + login + ", password:" + pass);
				throw new WrongLoginDateException();

			} else {

				preparedStatementRegustration.setString(1, login);
				preparedStatementRegustration.setString(2, pass);
				preparedStatementRegustration.setString(3, name);
				preparedStatementRegustration.setString(4, role.name());

				if (preparedStatementRegustration.executeUpdate() == 1) {
					user = login(login, pass);

				} else {
					log.info("Cant registration with login: " + login + ", password:" + pass);
					throw new WrongLoginDateException();

				}

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
				RoleType userRole = RoleType.valueOf(rs.getString("role").toUpperCase());
				user = new User(userId, userName, userRole);
			}
		} catch (SQLException e) {
			log.warn("User login", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return user;
	}

}
