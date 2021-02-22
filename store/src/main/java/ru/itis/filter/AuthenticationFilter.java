package ru.itis.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        // преобразуем запросы к нужному виду
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // берем сессию у запроса
        // берем только существующую, если сессии не было - то вернет null
        HttpSession session = request.getSession(false);
        // флаг, аутентифицирован ли пользователь
        Boolean isAuthenticated = false;
        Boolean isAdmin = false;
        // существует ли сессия вообще?
        Boolean sessionExists = session != null;
        // идет ли запрос на страницу входа или регистрации?
        Boolean isRequestOnOpenPage = request.getRequestURI().equals("/sign_in") ||
                request.getRequestURI().equals("/sign_up");
        Boolean isRequestOnAdminPage = request.getRequestURI().equals("/admin");

        Boolean isRequestOnAuthPage = request.getRequestURI().equals("/signIn") ||
                request.getRequestURI().equals("/signUp");
        // если сессия есть
        if (sessionExists) {
            isAuthenticated = session.getAttribute("user") != null;
            isAdmin = session.getAttribute("admin") != null;
        }

        if ((isAuthenticated && !isRequestOnAuthPage && !isRequestOnAdminPage)
                || (!isAuthenticated && isRequestOnOpenPage)
                || (isAdmin && isRequestOnAdminPage)) {
            filterChain.doFilter(request, response);
        } else if (isAuthenticated && isRequestOnAuthPage) {
            // пользователь аутенцифицирован и запрашивает страницу входа
            // - отдаем ему профиль
            response.sendRedirect("/profile");
        } else {
            // если пользователь не аутенцицицирован и запрашивает другие страницы
            response.sendRedirect("/sign_in ");
        }

    }

    @Override
    public void destroy() {

    }
}
