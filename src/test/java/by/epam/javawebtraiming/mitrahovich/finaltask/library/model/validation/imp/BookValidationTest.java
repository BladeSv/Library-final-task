package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

@ExtendWith(MockitoExtension.class)

public class BookValidationTest {
	private BookValidation bookValidation;

	public BookValidationTest() {

	}

	@BeforeEach
	public void BeforeTest() {
		bookValidation = new BookValidation();

	}

	@Test
	public void testValidateNull() {

		assertFalse(bookValidation.vadidate(null));
	}

	@Test
	public void testValidateBookCreateRequest() {
		HttpServletRequest request = mock(HttpServletRequest.class);

		request = createMockBookHttpServletRequest(request, "Пикник на обочине", "1", "2", "4",
				"В этот том вошло одно из самых прославленных произведений братьев Стругацких - роман \"Пикник на обочине\"");
		assertTrue(bookValidation.vadidate(request));
	}

	private HttpServletRequest createMockBookHttpServletRequest(HttpServletRequest request, String bookTitle,
			String idAuthor, String idGenre, String bookNumber, String bookAnnotation) {

		when(request.getParameter(ConstConteiner.BOOK_TITLE)).thenReturn(bookTitle);
		when(request.getParameter(ConstConteiner.BOOK_AUTHOR)).thenReturn(idAuthor);
		when(request.getParameter(ConstConteiner.BOOK_GENRE)).thenReturn(idGenre);
		when(request.getParameter(ConstConteiner.BOOK_NUMBER)).thenReturn(bookNumber);
		when(request.getParameter(ConstConteiner.BOOK_ANNOTATION)).thenReturn(bookAnnotation);

		return request;

	}
}
