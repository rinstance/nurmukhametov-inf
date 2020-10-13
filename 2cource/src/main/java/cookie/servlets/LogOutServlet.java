package cookie.servlets;


import cookie.repositories.AuthorizationTemplate;

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

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "mrroot1212";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cookie[] cookies = req.getCookies();
       String uuid = null;
       for (Cookie cookie : cookies) {
           if(cookie.getName().equals("myCookie")) {
               uuid = cookie.getValue();
               cookie.setMaxAge(0);
           }
       }

       try {
           Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
           AuthorizationTemplate authorizationTemplate = new AuthorizationTemplate(connection);
           authorizationTemplate.deleteUUIDForUser(uuid);
       } catch (SQLException e) { e.printStackTrace(); }
    }
}
