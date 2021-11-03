package ua.lviv.lgs.magazineShop.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.magazineShop.domain.AccessLevel;

public class FilterService {

	private static FilterService filterService;

	private FilterService() {
	}

	public static FilterService getFilterService() {
		if (filterService == null) {
			filterService = new FilterService();
		}

		return filterService;
	}

	public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain,
			List<AccessLevel> accessLevelList) throws IOException, ServletException {

		try {
			HttpSession session = ((HttpServletRequest) request).getSession();
			AccessLevel accessLevel = AccessLevel.valueOf((String) session.getAttribute("accessLevel"));

			if (accessLevel != null && accessLevelList.contains(accessLevel)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletRequest) request).getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			((HttpServletRequest) request).getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
}