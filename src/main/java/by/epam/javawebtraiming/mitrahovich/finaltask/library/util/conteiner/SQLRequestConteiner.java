package by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner;

public class SQLRequestConteiner {

	public SQLRequestConteiner() {
	}

	public static final String USER_GET_BY_ID = "SELECT user.name, user.surname, role FROM user WHERE id_user=?";
	public static final String USER_BOOK_BY_ID = "SELECT id_book, book.title AS book_title, annotation,book.id_author, author.name, author.surname, genre.id_genre, genre.title AS genre_title FROM book INNER JOIN author ON author.id_author=book.id_author\r\n"
			+ "INNER JOIN genre ON book.id_genre=genre.id_genre WHERE book.id_book=?";
	public static final String USER_GET_BY_LOGIN_AND_PASS = "SELECT id_user, user.name, user.surname, role FROM user WHERE login=? AND user.PASSWORD=?";
	public static final String USER_REGISTRATION = "INSERT INTO user (login, user.password, user.name, user.surname, role) VALUES (?,?,?,?,?) ";
	public static final String USER_GET_ALL_USER = "SELECT id_user, user.name, user.surname, role FROM user";
	public static final String USER_DELETE_BY_ID = "DELETE FROM user WHERE id_user=?";

	public static final String USER_GET_ALL_FREE_BOOK = " SELECT id_book, book.title AS book_title, annotation,book.id_author, author.name, author.surname, genre.id_genre, genre.title AS genre_title\r\n" + "FROM book\r\n"
			+ "INNER JOIN author ON author.id_author=book.id_author\r\n" + "INNER JOIN genre ON book.id_genre=genre.id_genre\r\n" + " WHERE book.instances >\r\n" + "  (SELECT COUNT(subscription.id_book)\r\n"
			+ "  FROM subscription WHERE subscription.id_book=book.id_book)\r\n" + " \r\n" + " ";
	public static final String BOOK_GET_ALL = " SELECT id_book, book.title AS book_title, annotation,book.id_author, author.name, author.surname, genre.id_genre, genre.title AS genre_title\r\n" + "FROM book\r\n"
			+ "INNER JOIN author ON author.id_author=book.id_author\r\n" + "INNER JOIN genre ON book.id_genre=genre.id_genre";

	public static final String BOOK_MINUS_INSTANCE_FROM_ORDER_BY_USER_ID = "UPDATE book SET book.instances=book.instances-(SELECT COUNT(subscription.id_book) FROM subscription WHERE subscription.id_user=? AND subscription.id_book=book.id_book)";
	public static final String BOOK_DELETE_BY_BOOK_ID = "DELETE FROM book WHERE id_book=?";
	public static final String BOOK_CREATE = "INSERT INTO book (title, annotation, id_author, id_genre, instances) VALUE (?, ?, ?, ?, ?)";
	public static final String BOOK_UPDATE_BY_ID = "UPDATE book SET title=?, annotation=?, id_author=?, id_genre=?,  instances=? WHERE id_book=?";
	public static final String BOOK_GEY_INSTANCE_BY_ID = "SELECT book.instances FROM book WHERE book.id_book=?";

	public static final String ADD_ORDER = "SELECT order_book(?,?,?)";
	public static final String ORDER_GET_ALL_BY_USER_ID = "SELECT id_subscription, subscription.id_book, book.title AS book_title, book.annotation, genre.id_genre, genre.title AS genre_title, author.id_author, author.NAME AS author_name , author.surname, subscription.id_user,user.NAME AS user_name, user.role, taken_date, place FROM subscription\r\n"
			+ " INNER JOIN book ON subscription.id_book=book.id_book\r\n" + " INNER JOIN author ON book.id_author=author.id_author \r\n" + " INNER JOIN genre ON book.id_genre=genre.id_genre \r\n"
			+ " INNER JOIN user ON subscription.id_user=user.id_user \r\n" + " WHERE subscription.id_user=?";

	public static final String ORDER_GET_BY_ID = "SELECT id_subscription, subscription.id_book, book.title AS book_title, book.annotation, genre.id_genre, genre.title AS genre_title, author.id_author, author.NAME AS author_name , author.surname, subscription.id_user,user.NAME AS user_name, user.role, taken_date, place FROM subscription\r\n"
			+ " INNER JOIN book ON subscription.id_book=book.id_book\r\n" + " INNER JOIN author ON book.id_author=author.id_author \r\n" + " INNER JOIN genre ON book.id_genre=genre.id_genre \r\n"
			+ " INNER JOIN user ON subscription.id_user=user.id_user \r\n" + " WHERE subscription.id_subscription=?";

	public static final String ORDER_DELETE_BY_ID = "DELETE FROM subscription WHERE id_subscription=?";
	public static final String ORDER_DELETE_BY_USER_ID = "DELETE FROM subscription WHERE id_user=?";
	public static final String ORDER_DELETE_BY_BOOK_ID = "DELETE FROM subscription WHERE id_book=?";
	public static final String ORDER_DELETE_NOT_COFIRM = "DELETE FROM subscription WHERE subscription.taken_date IS NULL";
	public static final String ORDER_UPDATE_TAKEN_DATE_BY_ID = "UPDATE subscription SET taken_date=? WHERE subscription.id_subscription=?";

	public static final String GENRE_GET_BY_ID = " SELECT title FROM genre WHERE genre.id_genre=?";
	public static final String GENRE_GET_ALL = " SELECT id_genre, title FROM genre";
	public static final String GENRE_DELETE_BY_ID = "DELETE FROM genre WHERE id_genre=?";
	public static final String GENRE_UPDATE_BY_ID = "UPDATE genre SET title=? WHERE id_genre=?";
	public static final String GENRE_CREATE = "INSERT INTO genre (title) VALUE (?)";

	public static final String AUTHOR_GET_BY_ID = "SELECT author.name, author.surname FROM author WHERE author.id_author=?";
	public static final String AUTHOR_GET_ALL = " SELECT id_author, author.name, surname FROM author";
	public static final String AUTHOR_UPDATE_BY_ID = "UPDATE author SET author.name=?, author.surname=? WHERE id_author=?";
	public static final String AUTHOR_DELETE_BY_ID = "DELETE FROM author WHERE id_author=?";
	public static final String AUTHOR_CREATE = "INSERT INTO author (name, surname) VALUE (?, ?)";
}
