package cookie.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import cookie.repositories.SearchUsersRepository;
import cookie.repositories.SearchUsersRepositoryJdbcImpl;
import homeworks.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class AjaxSearchServlet extends HttpServlet {
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "mrroot1212";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private Connection connection;
    private SearchUsersRepository usersRepository;
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<User> users = new ArrayList<>();

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            usersRepository = new SearchUsersRepositoryJdbcImpl(connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FIRST");
        User user = objectMapper.readValue(req.getReader(), User.class);
        System.out.println("SECOND");
        String users = objectMapper.writeValueAsString(usersRepository.findAllByLoginStartingWith(user.getLogin()));
        System.out.println(users);
        resp.setContentType("application/json");
        resp.getWriter().println(users);


//        System.out.println("FIRST");
//        User user = objectMapper.readValue(req.getReader(), User.class);
//
//        System.out.println("SECOND");
//        users.add(user);
//
//        String usersAsJson = objectMapper.writeValueAsString(users);
//        resp.setContentType("application/json");
//        resp.getWriter().println(usersAsJson);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/html/search.html").forward(req, resp);
    }
}
