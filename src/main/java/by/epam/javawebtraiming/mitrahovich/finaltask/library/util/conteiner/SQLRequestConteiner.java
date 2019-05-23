package by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner;

public class SQLRequestConteiner {

	public SQLRequestConteiner() {
	}

	public static final String USER_GET_BY_ID = "SELECT user.name, user.surname, role FROM user WHERE id_user=?";
	public static final String USER_BOOK_BY_ID = "SELECT id_book, book.title AS book_title, annotation,book.id_autor, autor.name, autor.surname, genre.title AS genre_title FROM book INNER JOIN autor ON autor.id_autor=book.id_autor\r\n"
			+ "INNER JOIN genre ON book.id_genre=genre.id_genre WHERE book.id_book=?";
	public static final String USER_GET_BY_LOGIN_AND_PASS = "SELECT id_user, user.name, user.surname, role FROM user WHERE login=? AND user.PASSWORD=?";
	public static final String USER_REGISTRATION = "INSERT INTO user (login, user.password, user.name, user.surname, role) VALUES (?,?,?,?,?) ";
	public static final String USER_GET_ALL_USER = "SELECT id_user, user.name, user.surname, role FROM user";
	public static final String USER_DELETE_BY_ID = "DELETE FROM user WHERE id_user=?";

	public static final String USER_GET_ALL_FREE_BOOK = " SELECT id_book, book.title AS book_title, annotation,book.id_autor, autor.name, autor.surname, genre.title AS genre_title\r\n"
			+ "FROM book\r\n" + "INNER JOIN autor ON autor.id_autor=book.id_autor\r\n"
			+ "INNER JOIN genre ON book.id_genre=genre.id_genre\r\n" + " WHERE book.instances >\r\n"
			+ "  (SELECT COUNT(subscription.id_book)\r\n"
			+ "  FROM subscription WHERE subscription.id_book=book.id_book)\r\n" + " \r\n" + " ";
	public static final String BOOK_MINUS_INSTANCE_FROM_ORDER_BY_USER_ID = "UPDATE book SET book.instances=book.instances-(SELECT COUNT(subscription.id_book) FROM subscription WHERE subscription.id_user=? AND subscription.id_book=book.id_book)";

	public static final String ADD_ORDER = "SELECT order_book(?,?,?)";
	public static final String ORDER_GET_ALL_BY_USER_ID = "SELECT id_subscription, subscription.id_book, book.title AS book_title, book.annotation, genre.title AS genre_title, autor.id_autor, autor.NAME AS autor_name , autor.surname, subscription.id_user,user.NAME AS user_name, user.role, taken_date, place FROM subscription\r\n"
			+ " INNER JOIN book ON subscription.id_book=book.id_book\r\n"
			+ " INNER JOIN autor ON book.id_autor=autor.id_autor \r\n"
			+ " INNER JOIN genre ON book.id_genre=genre.id_genre \r\n"
			+ " INNER JOIN user ON subscription.id_user=user.id_user \r\n" + " WHERE subscription.id_user=?";

	public static final String ORDER_GET_BY_ID = "SELECT id_subscription, subscription.id_book, book.title AS book_title, book.annotation, genre.title AS genre_title, autor.id_autor, autor.NAME AS autor_name , autor.surname, subscription.id_user,user.NAME AS user_name, user.role, taken_date, place FROM subscription\r\n"
			+ " INNER JOIN book ON subscription.id_book=book.id_book\r\n"
			+ " INNER JOIN autor ON book.id_autor=autor.id_autor \r\n"
			+ " INNER JOIN genre ON book.id_genre=genre.id_genre \r\n"
			+ " INNER JOIN user ON subscription.id_user=user.id_user \r\n" + " WHERE subscription.id_subscription=?";

	public static final String ORDER_DELETE_BY_ID = "DELETE FROM subscription WHERE id_subscription=?";
	public static final String ORDER_DELETE_BY_USER_ID = "DELETE FROM subscription WHERE id_user=?";
	public static final String ORDER_UPDATE_TAKEN_DATE_BY_ID = "UPDATE subscription SET taken_date=? WHERE subscription.id_subscription=?";
}
