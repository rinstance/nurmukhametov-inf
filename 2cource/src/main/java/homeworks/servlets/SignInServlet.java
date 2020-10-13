package homeworks.servlets;

import homeworks.storage.Variables;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.UUID;

//@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/html/signin.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String login = req.getParameter("login_input");
            String password = req.getParameter("password_input");
            
            if (isInDatabase(login, password)) {
                String uuid = getUUID(login, password);
                resp.addCookie(new Cookie("cookie", uuid));
                resp.sendRedirect("/profile");
                sendCookie();
            } else {
                String uuid = UUID.randomUUID().toString();
                Cookie cookie = new Cookie("cookieExample", uuid);
                resp.addCookie(cookie);
                addCookie(login, password, uuid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUUID(String login, String password) throws SQLException {
        //language=SQL
        String sql = "select uuid_cookie from users where login = " + login + "and password = " + password;
        ResultSet result = statement.executeQuery(sql);
        return result.getString(result.findColumn("uuid"));
    }

    private void addCookie(String login, String password, String uuid) throws SQLException {
        //language=SQL
        String sqlInsertUser = "insert into users(login, password, uuid_cookie) values (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, uuid);
    }

    private void sendCookie() {

    }

    private boolean isInDatabase(String login, String password) throws Exception {
        System.out.println("HERE");
        Class.forName("org.postgresql.Driver");
        connection =
                DriverManager.getConnection(
                        Variables.DB_URL,
                        Variables.DB_USERNAME,
                        Variables.DB_PASSWORD
                );
        statement = connection.createStatement();

        //language=SQL
        String sql = "select * from users where login = '" + login + "' and password = '" + password + "'";
        ResultSet result = statement.executeQuery(sql);
        System.out.println(result != null);
        return (result != null);
    }
}
