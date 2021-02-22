package ru.itis.servlets;

import ru.itis.models.entities.Item;
import ru.itis.services.items.ItemService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {
    private ItemService itemService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.itemService = (ItemService) context.getAttribute("itemService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemService.getItems();
        request.setAttribute("itemsBuy", items);
        request.getRequestDispatcher("WEB-INF/jsp/items.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        HttpSession session = req.getSession();
        session.setAttribute("item", s.split("=")[0]);
        resp.sendRedirect("/detail_item");
    }
}
