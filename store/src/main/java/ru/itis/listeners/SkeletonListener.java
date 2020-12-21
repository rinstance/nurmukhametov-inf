package listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.companies.CompaniesRepository;
import repositories.companies.CompaniesRepositoryImpl;
import repositories.items.ItemRepository;
import repositories.items.ItemRepositoryImpl;
import repositories.orders.OrderRepository;
import repositories.orders.OrderRepositoryImpl;
import repositories.tx.TxRepository;
import repositories.tx.TxRepositoryImpl;
import repositories.user.UserRepository;
import repositories.user.UserRepositoryImpl;
import services.companies.CompaniesService;
import services.companies.CompaniesServiceImpl;
import services.detail_item.DetailItemService;
import services.detail_item.DetailItemServiceImpl;
import services.items.ItemService;
import services.items.ItemServiceImpl;
import services.orders.OrderService;
import services.orders.OrderServiceImpl;
import services.sign_in.SignInService;
import services.sign_in.SignInServiceImpl;
import services.sign_up.SignUpService;
import services.sign_up.SignUpServiceImpl;
import services.tx.TxService;
import services.tx.TxServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SkeletonListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/store");
        dataSource.setUsername("postgres");
        dataSource.setPassword("mrroot1212");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserRepository usersRepository = new UserRepositoryImpl(dataSource);
        ItemRepository itemRepository = new ItemRepositoryImpl(dataSource);
        CompaniesRepository companiesRepository = new CompaniesRepositoryImpl(dataSource);
        TxRepository txRepository = new TxRepositoryImpl(dataSource);
        OrderRepository orderRepository = new OrderRepositoryImpl(dataSource);

        SignUpService signUpService = new SignUpServiceImpl(usersRepository, passwordEncoder);
        SignInService signInService = new SignInServiceImpl(usersRepository, passwordEncoder);
        ItemService itemService = new ItemServiceImpl(itemRepository);
        DetailItemService detailItemService = new DetailItemServiceImpl(itemRepository);
        CompaniesService companiesService = new CompaniesServiceImpl(companiesRepository);
        TxService txService = new TxServiceImpl(txRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository);

        servletContext.setAttribute("signUpService", signUpService);
        servletContext.setAttribute("signInService", signInService);
        servletContext.setAttribute("itemService", itemService);
        servletContext.setAttribute("detailItemService", detailItemService);
        servletContext.setAttribute("companiesService", companiesService);
        servletContext.setAttribute("txService", txService);
        servletContext.setAttribute("orderService", orderService);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
