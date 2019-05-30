package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.AbstactDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.SQLRequestConteiner;

public class GenreDAOImpl extends AbstactDAO implements GenreDAO {

	public GenreDAOImpl() {

	}

	@Override
	public Genre getById(int id) throws DaoSQLExcetion {
		Genre genre = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.GENRE_GET_BY_ID)) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				String genreTitle = rs.getString("title");
				genre = new Genre(id, genreTitle);

			}
		} catch (SQLException e) {
			log.warn("Get genre by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return genre;

	}

	@Override
	public List<Genre> getALL() throws DaoSQLExcetion {
		List<Genre> genreList = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.GENRE_GET_ALL)) {

			ResultSet rs = preparedStatement.executeQuery();
			genreList = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id_genre");
				String genreTitle = rs.getString("title");
				genreList.add(new Genre(id, genreTitle));

			}
		} catch (SQLException e) {
			log.warn("Get all genre by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return genreList;

	}

	@Override
	public void removeById(int id) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.GENRE_DELETE_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("remove genre by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

	@Override
	public void update(Genre genre) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.GENRE_UPDATE_BY_ID)) {
			preparedStatement.setString(1, genre.getTitle());
			preparedStatement.setInt(2, genre.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("update genre by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}
	}

	@Override
	public void add(String title) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.GENRE_CREATE)) {
			preparedStatement.setString(1, title);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("create genre", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

}
