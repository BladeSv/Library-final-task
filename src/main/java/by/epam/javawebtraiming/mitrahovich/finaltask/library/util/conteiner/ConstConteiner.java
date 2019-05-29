package by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner;

public class ConstConteiner {

	public ConstConteiner() {
	}

	public static final String ID = "id";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	public static final String USER = "user";
	public static final String ROLE = "role";
	public static final String ROLE_ANDMIN = "admin";
	public static final String ROLE_USER = "user";
	public static final String ROLE_GUEST = "guest";
	public static final String COMMAND = "command";
	public static final String SEARCH = "search";
	public static final String SEARCH_VALUE = "searchValue";
	public static final String PAGE = "page";

	public static final String PAGINATION_NUMBER_PAGE = "numberPage";
	public static final String PAGINATION_NUMBER_MAX_PAGE = "maxPage";
	public static final String PAGINATION_URL = "paginationUrl";

	public static final String LIBRARY_OBSERVER = "libraryObserver";

	public static final String TABLE_BOOKS = "tableBooks";
	public static final String TABLE_BOOKS_CHECK = "checkBookOrder";
	public static final String TABLE_BOOKS_PLACE_PREFIX = "place-";

	public static final String BOOK_VIEW = "viewBook";
	public static final String BOOK_TITLE = "bookTitle";
	public static final String BOOK_AUTHOR = "bookAutor";
	public static final String BOOK_GENRE = "bookGenre";
	public static final String BOOK_NUMBER = "bookNumber";
	public static final String BOOK_ANNOTATION = "bookAnnotation";
	public static final String BOOK_UPDATE = "changeBook";
	public static final String BOOK_UPDATE_NUMBER = "changeBookNumber";

	public static final String TABLE_USERS = "tableUsers";

	public static final String ORDER_DELETE_CHECK = "checkOrderDelete";
	public static final String ORDER_USER = "orderUser";
	public static final String ORDER_ADMIN_RETURN_CHECK = "checkBookReturn";
	public static final String ORDER_ADMIN_NOT_CONFIRM_CHECK = "notConfirmOrder";
	public static final String ORDER_ADMIN_DELETE_CHECK_PREFIX = "checkOrderDelete-";
	public static final String ORDER_ADMIN_CONFIRM_CHECK_PREFIX = "checkOrderConfirm-";

	public static final String GENRE_LIST_TABLE = "tableGenre";
	public static final String GENRE_TITLE = "genreTitle";
	public static final String GENRE_UPDATE = "changeGenre";

	public static final String AUTHOR_LIST_TABLE = "tableAuthor";
	public static final String AUTHOR_UPDATE = "changeAuthor";
	public static final String AUTHOR_NAME = "authorName";
	public static final String AUTHOR_SURNAME = "authorSurname";

	public static final String LANG = "lang";
	public static final String DEFAULT_LOCALE = "ru";
	public static final String RU_LOCALE = "ru";
	public static final String EN_LOCALE = "en";

	public static final String WRONG_DATE_LOGIN = "wronglogin";
	public static final String WRONG_DATE_SINGUP = "wrongsingup";
	public static final String WRONG_DATE_GENRE = "wrongGenre";
	public static final String WRONG_DATE_AUTHOR = "wrongAuthor";
	public static final String WRONG_DATE_BOOK = "wrongBook";

	public static final String COMMAND_PAGE_LOGIN = "login";
	public static final String COMMAND_PAGE_LOGOUT = "logout";
	public static final String COMMAND_PAGE_SINGUP = "singup";
	public static final String COMMAND_PAGE_SEARCH = "search";
	public static final String COMMAND_PAGE_SEARCH_USER = "userSearch";
	public static final String COMMAND_PAGE_DELETE_USER = "deteteUser";

	public static final String COMMAND_PAGE_DELETE_BOOK = "deteteBook";

	public static final String COMMAND_PAGE_CREATE_ORDER = "createOrder";
	public static final String COMMAND_PAGE_DELETE_ORDER = "deleteOrder";
	public static final String COMMAND_PAGE_ADMIN_ORDER = "adminOrder";

	public static final String COMMAND_PAGE_TO_ORDER = "toOrder";
	public static final String COMMAND_PAGE_TO_BOOK = "toBook";
	public static final String COMMAND_PAGE_TO_GENRE = "toGenre";
	public static final String COMMAND_PAGE_TO_AUTHOR = "toAuthor";
	public static final String COMMAND_PAGE_TO_CREATE_BOOK = "toCreateBook";
	public static final String COMMAND_PAGE_TO_CREATE_GENRE = "toCreateGenre";
	public static final String COMMAND_PAGE_TO_CREATE_AUTHOR = "toCreateAuthor";

	public static final String COMMAND_PAGE_CREATE_BOOK = "createBook";
	public static final String COMMAND_PAGE_CREATE_GENRE = "createGenre";
	public static final String COMMAND_PAGE_CREATE_AUTHOR = "createAuthor";

	public static final String COMMAND_PAGE_TO_UPDATE_BOOK = "toUpdateBook";
	public static final String COMMAND_PAGE_TO_UPDATE_GENRE = "toUpdateGenre";
	public static final String COMMAND_PAGE_TO_UPDATE_AUTHOR = "toUpdateAuthor";
	public static final String COMMAND_PAGE_UPDATE_BOOK = "updateBook";
	public static final String COMMAND_PAGE_UPDATE_GENRE = "updateGenre";
	public static final String COMMAND_PAGE_UPDATE_AUTHOR = "updateAuthor";

	public static final String COMMAND_PAGE_DELETE_GENRE = "deteteGenre";
	public static final String COMMAND_PAGE_DELETE_AUTHOR = "deteteAuthor";

	public static final String SEARCH_BOOK_REQUEST_SPLIT_REGEX = "[. ,;:\"'!?]";
	public static final String SEARCH_USER_REQUEST_SPLIT_REGEX = "[ ]";
	public static final String SINGUP_LOGIN_REGEX = "[a-zA-Z0-9_].";
	public static final String RUSSIAN_WORD_REGEX = "[А-Яа-я].";
	public static final String NUMBER_REGEX = "[\\d].";

	public static final String CHANGE_LANGUAGE = "changeLang";

	public static final String CHARACTERS_ENCODING = "encoding";
	public static final String CHARACTERS_ENCODING_VALUE = "UTF-8";

	public static final int LOGIN_LENGTH_MIN = 3;
	public static final int LOGIN_LENGTH_MAX = 16;
	public static final int PASSWORD_LENGTH_MIN = 4;
	public static final int PASSWORD_LENGTH_MAX = 200;

	public static final int ANNOTATION_LENGTH_MAX = 16;

}
