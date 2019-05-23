package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.AbstactDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Autor;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.GenreType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.SQLRequestConteiner;

public class BookDAOImpl extends AbstactDAO implements BookDAO {

	public BookDAOImpl() {

	}

	@Override
	public Book getById(int id) throws DaoSQLExcetion {
		Book book = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_BOOK_BY_ID)) {
			ResultSet rs = preparedStatementUser.executeQuery();
			while (rs.next()) {
				int idBook = rs.getInt("id_book");
				String bookTitle = rs.getString("book_title");
				String annotation = rs.getString("annotation");
				int idAutor = rs.getInt("id_autor");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String genre = rs.getString("genre_title");
				book = new Book(idBook, bookTitle, annotation, new Autor(idAutor, name, surname),
						GenreType.valueOf(genre));
			}
		} catch (SQLException e) {
			log.warn("Get book by Id", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return book;
	}

	@Override
	public List getALL() throws DaoSQLExcetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllFreeBook() throws DaoSQLExcetion {
		List<Book> books = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatementUser = connection
				.prepareStatement(SQLRequestConteiner.USER_GET_ALL_FREE_BOOK)) {

			ResultSet rs = preparedStatementUser.executeQuery();
			books = new ArrayList<>();
			while (rs.next()) {
				int idBook = rs.getInt("id_book");
				String bookTitle = rs.getString("book_title");
				String annotation = rs.getString("annotation");
				int idAutor = rs.getInt("id_autor");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String genre = rs.getString("genre_title");
				books.add(new Book(idBook, bookTitle, annotation, new Autor(idAutor, name, surname),
						GenreType.valueOf(genre)));
			}

		} catch (SQLException e) {
			log.warn("Get all free books", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return books;
	}

	@Override
	public void minusInstanceByDeleteUser(int idUser) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try {
			minusInstanceByDeleteUserTransaction(connection, idUser);
		} finally {
			returnConnection(connection);
		}
	}

	@Override
	public void minusInstanceByDeleteUserTransaction(Connection connection, int idUser) throws DaoSQLExcetion {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQLRequestConteiner.BOOK_MINUS_INSTANCE_FROM_ORDER_BY_USER_ID)) {
			preparedStatement.setInt(1, idUser);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("Get all free books", e);
			throw new DaoSQLExcetion(e.getCause());
		}

	}

}
