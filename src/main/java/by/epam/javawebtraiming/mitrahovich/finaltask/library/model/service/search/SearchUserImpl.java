package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class SearchUserImpl implements SearchUser {
	private static Logger log;
	static {
		log = Logger.getLogger("Service");
	}

	public SearchUserImpl() {

	}

	@Override
	public List<User> searchUser(String searchRequest) throws DaoSQLExcetion {

		UserDAO userDAO = DaoManager.getInstance().getUserDAO();

		List<User> findUsers = userDAO.getALL();
		if (findUsers != null) {

			String[] split = searchRequest.split(ConstConteiner.SEARCH_USER_REQUEST_SPLIT_REGEX);
			List<String> pieces = new ArrayList<>();
			pieces.add(searchRequest);
			if (split.length == 2) {
				pieces.add(split[1] + " " + split[0]);

			}
			pieces.addAll(Arrays.asList(split));

			Set<User> searchUser = new HashSet<>();

			for (String splits : pieces) {
				for (User user : findUsers) {
					String fullName = user.getSurname() + " " + user.getName();

					if (checkContains(fullName, splits)) {
						searchUser.add(user);

					}

				}

			}

			findUsers = new ArrayList<>(searchUser);
		}
		return findUsers;
	}

	private boolean checkContains(String fullName, String searchString) {
		log.trace("check contins--in--" + fullName + " piece--" + searchString);
		return fullName.toLowerCase().contains(searchString.toLowerCase());
	}
}
