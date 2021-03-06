package cookie.servlets;

import cookie.repositories.AuthCookieTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "mrroot1212";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/signin.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie mycookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("myCookie"))
                mycookie = cookie;
        }

        try {
            if (mycookie == null) {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                AuthCookieTemplate authCookieTemplate = new AuthCookieTemplate(connection);
                Cookie cookie = authCookieTemplate.setCookieForUser(
                        req.getParameter("login"),
                        req.getParameter("password")
                );
                resp.addCookie(cookie);
            }
            resp.sendRedirect("/account");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


