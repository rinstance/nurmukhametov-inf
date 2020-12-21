package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dto.UserDto;
import models.Item;
import models.Order;
import models.Transaction;
import services.companies.CompaniesService;
import services.detail_item.DetailItemService;
import services.items.ItemService;
import services.orders.OrderService;
import services.sign_in.SignInService;
import services.tx.TxService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/detail_item")
public class DetailItemServlet extends HttpServlet {
    private DetailItemService detailItemService;
    private TxService txService;
    private SignInService signInService;
    private CompaniesService companiesService;
    private OrderService orderService;
    private ItemService itemService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String type = null;
    private Integer itemId = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.detailItemService = (DetailItemService) context.getAttribute("detailItemService");
        this.txService = (TxService) context.getAttribute("txService");
        this.signInService = (SignInService) context.getAttribute("signInService");
        this.companiesService = (CompaniesService) context.getAttribute("companiesService");
        this.itemService = (ItemService) context.getAttribute("itemService");
        this.orderService = (OrderService) context.getAttribute("orderService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemId = Integer.parseInt(req.getSession().getAttribute("item").toString());
        Item item = detailItemService.getDetailItemById(itemId);
        List<Item> list = new ArrayList<>();
        list.add(item);
        req.setAttribute("itemBuy", list);
        req.getRequestDispatcher("WEB-INF/jsp/detail_item.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("order") != null) {
            if (type == null) {
                resp.sendRedirect("/test");
            } else {
                if (req.getParameter("calendar") == null) {
                    System.out.println("calendar null");
                } else {
                    if (req.getParameter("calendar").equals("") ||
                            req.getParameter("card_input").equals("") ||
                            req.getParameter("month_input").equals("") ||
                            req.getParameter("code_input").equals("")) {
                        resp.sendRedirect("/test");
                    } else {
                        if (isBefore(req.getParameter("calendar"))) {
                            resp.sendRedirect("/test");
                        } else {
                            addTx();
                            incUserCount(req.getSession().getAttribute("user"));
                            incCompanyCount();
                            updateOrDeleteById();
                            try {
                                addOrder(req.getSession().getAttribute("user"), req.getParameter("calendar"));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            resp.sendRedirect("/orders");
                        }
                    }
                }
            }
        } else {
            Transaction transaction = objectMapper.readValue(req.getReader(), Transaction.class);
            String s = objectMapper.writeValueAsString(transaction);
            resp.setContentType("application/json");
            resp.getWriter().println(s);
            type = new Gson().fromJson(s, Transaction.class).getType();
        }
    }

    private boolean isBefore(String calendar) {
        LocalDate localDate = LocalDate.parse(calendar);
        LocalDate today = LocalDate.now();
        return localDate.isBefore(today);
    }

    private void addOrder(Object userProfile, String calendar) throws ParseException {
        Order order = new Order();

        Transaction transaction = txService.getLast();
        order.setTx_id(transaction.getId());
        System.out.println("tx " + transaction.getId());

        UserDto user = (UserDto) userProfile;
        order.setUser_id(user.getId());
        System.out.println("user " + user.getId());

        LocalDate localDate = LocalDate.parse(calendar);
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        order.setGetDate(sqlDate);
        System.out.println("sqlDate " + sqlDate.toString());

        Calendar c = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = Timestamp.valueOf(dateFormat.format(c.getTime()));
        order.setOrder_time(timestamp);
        System.out.println("timestamp " + timestamp);


        Item item = detailItemService.getDetailItemById(itemId);
        order.setItemName(item.getName());

        orderService.save(order);
    }

    private void updateOrDeleteById() {
        Item item = detailItemService.getDetailItemById(itemId);
        detailItemService.updateOrDeleteById(item);
    }

    private void incCompanyCount() {
        Integer companyId = detailItemService.getDetailItemById(itemId).getCompany_id();
        companiesService.incCount(companyId);
    }

    private void incUserCount(Object userProfile) {
        UserDto user = (UserDto) userProfile;
        signInService.incCount(user.getId());
    }

    private void addTx() {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        txService.add(transaction);
    }
}
