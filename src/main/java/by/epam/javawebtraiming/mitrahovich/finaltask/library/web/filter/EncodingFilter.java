package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = ConstConteiner.CHARACTERS_ENCODING, value = ConstConteiner.CHARACTERS_ENCODING_VALUE) })
public class EncodingFilter implements Filter {

	private String code;

	public EncodingFilter() {

	}

	public void destroy() {
		code = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String codeRequest = request.getCharacterEncoding();
		if (code != null && code.equalsIgnoreCase(codeRequest)) {
			request.setCharacterEncoding(code);
			response.setCharacterEncoding(code);

		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		code = fConfig.getInitParameter(ConstConteiner.CHARACTERS_ENCODING);
	}

}
