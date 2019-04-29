package by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner;

public class SQLRequestConteiner {

	public SQLRequestConteiner() {
	}

	public static final String USER_GET_BY_ID = "SELECT user.name, role FROM user WHERE id_user=?";
	public static final String USER_GET_BY_LOGIN_AND_PASS = "SELECT id_user, user.name, role FROM user WHERE login=? AND user.PASSWORD=?";
	public static final String USER_REGISTRATION = "INSERT INTO user (login, user.password, user.name, role) VALUES (?,?,?,?) ";

	public static final String USER_GET_ALL_USER = "SELECT id_user,user.name, role FROM user";

	public static final String USER_GET_ALL_FREE_BOOK = " SELECT id_book, book.title AS book_title, annotation,book.id_autor, autor.name, autor.surname, genre.title AS genre_title\r\n"
			+ "FROM book\r\n" + "INNER JOIN autor ON autor.id_autor=book.id_autor\r\n"
			+ "INNER JOIN genre ON book.id_genre=genre.id_genre\r\n" + " WHERE book.INSTANCE >\r\n"
			+ "  (SELECT COUNT(subscription.id_book)\r\n"
			+ "  FROM subscription WHERE subscription.id_book=book.id_book)\r\n" + " \r\n" + " ";

//	SELECT id_user FROM user WHERE login=? && user.PASSWORD=?
}
