package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.AbstactDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.SQLRequestConteiner;

public class AuthorDAOImpl extends AbstactDAO implements AuthorDAO {

	public AuthorDAOImpl() {

	}

	@Override
	public Author getById(int id) throws DaoSQLExcetion {
		Author author = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.AUTHOR_GET_BY_ID)) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				String authorName = rs.getString("name");
				String authorSurname = rs.getString("surname");
				author = new Author(id, authorName, authorSurname);

			}
		} catch (SQLException e) {
			log.warn("Get author by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return author;
	}

	@Override
	public List<Author> getALL() throws DaoSQLExcetion {
		List<Author> authorList = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.AUTHOR_GET_ALL)) {

			ResultSet rs = preparedStatement.executeQuery();
			authorList = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id_author");
				String authorName = rs.getString("name");
				String authorSurname = rs.getString("surname");
				authorList.add(new Author(id, authorName, authorSurname));

			}
		} catch (SQLException e) {
			log.warn("Get all author by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return authorList;
	}

	@Override
	public void update(Author author) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQLRequestConteiner.AUTHOR_UPDATE_BY_ID)) {

			preparedStatement.setString(1, author.getName());
			preparedStatement.setString(2, author.getSurname());
			preparedStatement.setInt(3, author.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("update author by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

	@Override
	public void removeById(int id) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQLRequestConteiner.AUTHOR_DELETE_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("remove author by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

	@Override
	public void add(String name, String surname) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.AUTHOR_CREATE)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("create author", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

}
