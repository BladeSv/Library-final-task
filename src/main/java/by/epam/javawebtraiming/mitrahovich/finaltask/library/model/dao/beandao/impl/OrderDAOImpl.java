package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.AbstactDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Autor;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.GenreType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Order;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.PlaceType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.SQLRequestConteiner;

public class OrderDAOImpl extends AbstactDAO implements OrderDAO {

	public OrderDAOImpl() {

	}

	@Override
	public int add(int userId, int bookId, PlaceType place) throws DaoSQLExcetion {
		int idOrder = -1;
		Connection connection = getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.ADD_ORDER)) {
			preparedStatement.setInt(1, bookId);
			preparedStatement.setInt(2, userId);
			preparedStatement.setString(3, place.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				idOrder = rs.getInt(1);

			}

		} catch (SQLException e) {
			log.warn("Add order", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}
		return idOrder;

	}

	@Override
	public Order getById(int id) throws DaoSQLExcetion {
		Order order = null;
		Connection connection = getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequestConteiner.ORDER_GET_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idOrder = rs.getInt("id_subscription");
				int idBook = rs.getInt("id_book");
				String bookTitle = rs.getString("book_title");
				String annotation = rs.getString("annotation");
				GenreType genre = GenreType.valueOf(rs.getString("genre_title"));

				int idAutor = rs.getInt("id_autor");
				String autorName = rs.getString("autor_name");
				String autorSurname = rs.getString("surname");

				PlaceType place = PlaceType.valueOf(rs.getString("place"));
				Date takenDateSQL = rs.getDate("taken_date");
				java.util.Date takenDate = null;
				if (takenDateSQL != null) {

					takenDate = new java.util.Date(takenDateSQL.getTime());
				}

				Autor autor = new Autor(idAutor, autorName, autorSurname);
				Book book = new Book(idBook, bookTitle, annotation, autor, genre);

				order = new Order(idOrder, book, place, takenDate);

			}

		} catch (SQLException e) {
			log.warn("Add order", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return order;
	}

	@Override
	public List getALL() throws DaoSQLExcetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrderUserById(int userId) throws DaoSQLExcetion {
		List<Order> orders = new ArrayList<>();
		Connection connection = getConnection();
		try (PreparedStatement preparedStatement = connection
				.prepareStatement(SQLRequestConteiner.ORDER_GET_ALL_BY_USER_ID)) {
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idOrder = rs.getInt("id_subscription");
				int idBook = rs.getInt("id_book");
				String bookTitle = rs.getString("book_title");
				String annotation = rs.getString("annotation");
				GenreType genre = GenreType.valueOf(rs.getString("genre_title"));

				int idAutor = rs.getInt("id_autor");
				String autorName = rs.getString("autor_name");
				String autorSurname = rs.getString("surname");

				PlaceType place = PlaceType.valueOf(rs.getString("place"));
				Date takenDateSQL = rs.getDate("taken_date");
				System.out.println("taken_date-" + takenDateSQL);
				java.util.Date takenDate = null;
				if (takenDateSQL != null) {
					takenDate = new java.util.Date(takenDateSQL.getTime());

				}

				Autor autor = new Autor(idAutor, autorName, autorSurname);
				Book book = new Book(idBook, bookTitle, annotation, autor, genre);

				Order order = new Order(idOrder, book, place, takenDate);
				orders.add(order);

			}

		} catch (SQLException e) {
			log.warn("Add order", e);
			throw new DaoSQLExcetion(e.getCause());
		} finally {
			returnConnection(connection);
		}

		return orders;
	}

}