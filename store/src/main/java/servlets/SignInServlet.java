package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserDto;
import dto.UserForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import services.sign_in.SignInService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign_in")
public class SignInServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private SignInService signInService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.signInService = (SignInService) context.getAttribute("signInService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/html/sign_in.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("reg") != null) {
            response.sendRedirect("/sign_up");
        } else {
            UserForm userForm = new UserForm(
                    request.getParameter("login_input"),
                    request.getParameter("password_input"));
            UserDto userDto = signInService.signIn(userForm);

            if (userDto != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userDto);
                response.sendRedirect("/profile");
            } else {
                if (userDto == null)
                    System.out.println("NULL");
                response.sendRedirect("/signIn");
            }
        }
    }
}
