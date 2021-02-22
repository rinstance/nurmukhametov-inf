package ru.itis.servlets;

import ru.itis.models.dto.UserForm;
import ru.itis.services.sign_up.SignUpService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign_up")
public class SignUpServlet extends HttpServlet {
    private SignUpService signUpService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.signUpService = (SignUpService) context.getAttribute("signUpService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/html/sign_up.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("signup") != null) {
            if (!request.getParameter("login_input").equals("") &&
                    !request.getParameter("password_input").equals("") &&
                    !request.getParameter("firstName_input").equals("") &&
                    !request.getParameter("lastName_input").equals("")) {
                System.out.println("OK");
                UserForm userForm = new UserForm(
                        request.getParameter("firstName_input"),
                        request.getParameter("lastName_input"),
                        request.getParameter("login_input"),
                        request.getParameter("password_input"));
                response.sendRedirect("/profile");
                signUpService.signUp(userForm);
            }
        } else if (request.getParameter("log") != null) {
            response.sendRedirect("/sign_in");
        }
    }
}
