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
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.SQLRequestConteiner;

public class BookDAOImpl extends AbstactDAO implements BookDAO {

	public BookDAOImpl() {

	}

	@Override
	public Book getById(int id) throws DaoSQLExcetion {
		Book book = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.USER_BOOK_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idBook = rs.getInt("id_book");
				String bookTitle = rs.getString("book_title");
				String annotation = rs.getString("annotation");
				int idAutor = rs.getInt("id_author");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int idGenre = rs.getInt("id_genre");
				String genre = rs.getString("genre_title");

				book = new Book(idBook, bookTitle, annotation, new Author(idAutor, name, surname),
						new Genre(idGenre, genre));
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
		List<Book> books = null;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatementUser = connection.prepareStatement(SQLRequestConteiner.BOOK_GET_ALL)) {

			ResultSet rs = preparedStatementUser.executeQuery();
			books = new ArrayList<>();
			while (rs.next()) {
				int idBook = rs.getInt("id_book");
				String bookTitle = rs.getString("book_title");
				String annotation = rs.getString("annotation");
				int idAutor = rs.getInt("id_author");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int idGenre = rs.getInt("id_genre");
				String genre = rs.getString("genre_title");
				books.add(new Book(idBook, bookTitle, annotation, new Author(idAutor, name, surname),
						new Genre(idGenre, genre)));
			}

		} catch (SQLException e) {
			log.warn("Get all books", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return books;
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
				int idAutor = rs.getInt("id_author");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int idGenre = rs.getInt("id_genre");
				String genre = rs.getString("genre_title");
				books.add(new Book(idBook, bookTitle, annotation, new Author(idAutor, name, surname),
						new Genre(idGenre, genre)));
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

	@Override
	public void removeById(int id) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			log.warn("Detete Book setAutoCommit(false)", e);
			throw new DaoSQLExcetion(e.getCause());
		}

		OrderDAO orderDAO = DaoManager.getInstance().getOrderDAO();
		orderDAO.remoteByBookIdTransaction(connection, id);

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQLRequestConteiner.BOOK_DELETE_BY_BOOK_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			log.warn("Detete book", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

	@Override
	public void add(String title, String annotation, int idAuthor, int idGenre, int instance) throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.BOOK_CREATE)) {
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, annotation);
			preparedStatement.setInt(3, idAuthor);
			preparedStatement.setInt(4, idGenre);
			preparedStatement.setInt(5, instance);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("create book", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}
	}

	@Override
	public void update(int idBook, String title, String annotation, int idAuthor, int idGenre, int instance)
			throws DaoSQLExcetion {
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.BOOK_UPDATE_BY_ID)) {
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, annotation);
			preparedStatement.setInt(3, idAuthor);
			preparedStatement.setInt(4, idGenre);
			preparedStatement.setInt(5, instance);
			preparedStatement.setInt(6, idBook);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.warn("update book", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

	}

	@Override
	public int getInstanceById(int id) throws DaoSQLExcetion {
		int instanceBook = 0;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQLRequestConteiner.BOOK_GEY_INSTANCE_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				instanceBook = rs.getInt("instances");

			}

		} catch (SQLException e) {
			log.warn("Get instance books", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return instanceBook;

	}

}
