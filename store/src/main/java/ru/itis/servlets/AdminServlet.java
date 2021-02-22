package ru.itis.servlets;


import ru.itis.models.dto.ItemDto;
import ru.itis.models.entities.Company;
import ru.itis.services.companies.CompaniesService;
import ru.itis.services.items.ItemService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private ItemService itemService;
    private CompaniesService companiesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.itemService = (ItemService) context.getAttribute("itemService");
        this.companiesService = (CompaniesService) context.getAttribute("companiesService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("admin") != null) {
            System.out.println("yes");
            List<Company> companies = companiesService.getCompanies();
            req.setAttribute("Companies", companies);
            req.getRequestDispatcher("WEB-INF/jsp/admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            ItemDto itemDto = new ItemDto(
                    request.getParameter("item_title"),
                    request.getParameter("item_image"),
                    Integer.parseInt(request.getParameter("item_count")),
                    Integer.parseInt(request.getParameter("company_id")));
            itemService.add(itemDto);
        }
    }
}
