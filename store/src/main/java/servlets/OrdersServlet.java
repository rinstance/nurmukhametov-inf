package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserDto;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {
    private OrderService orderService;
    private TxService txService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.orderService = (OrderService) context.getAttribute("orderService");
        this.txService = (TxService) context.getAttribute("txService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) (req.getSession().getAttribute("user"));
        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        List<HashMap<Order, String>> list = new ArrayList<>();
        for (Order order : orders) {
            HashMap<Order, String> map = new HashMap<>();
            map.put(order, txService.getById(order.getTx_id()).getType());
            System.out.println(map);
            list.add(map);
        }
        req.setAttribute("ordersLook", list);
        req.getRequestDispatcher("WEB-INF/jsp/orders.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
