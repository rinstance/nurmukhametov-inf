package ru.itis.servlets;

import ru.itis.models.entities.Company;
import ru.itis.models.entities.Item;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/companies")
public class CompaniesServlet extends HttpServlet {
    private CompaniesService companiesService;
    private ItemService itemService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.companiesService = (CompaniesService) context.getAttribute("companiesService");
        this.itemService = (ItemService) context.getAttribute("itemService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = companiesService.getCompanies();
        List<Item> items = itemService.getItems();
        HashMap<Company, List<Item>> map = new HashMap<>();
        for (Company company : companies) {
            List<Item> list = new ArrayList<>();
            for (Item item : items) {
                if (item.getCompany_id() == company.getId()) {
                    list.add(item);
                }
            }
            map.put(company, list);
        }

        req.setAttribute("companiesLook", map);
        req.getRequestDispatcher("WEB-INF/jsp/companies.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


















