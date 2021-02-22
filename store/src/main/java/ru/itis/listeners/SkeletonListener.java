package ru.itis.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.companies.CompaniesRepository;
import ru.itis.repositories.companies.CompaniesRepositoryImpl;
import ru.itis.repositories.items.ItemRepository;
import ru.itis.repositories.items.ItemRepositoryImpl;
import ru.itis.repositories.orders.OrderRepository;
import ru.itis.repositories.orders.OrderRepositoryImpl;
import ru.itis.repositories.tx.TxRepository;
import ru.itis.repositories.tx.TxRepositoryImpl;
import ru.itis.repositories.user.UserRepository;
import ru.itis.repositories.user.UserRepositoryImpl;
import ru.itis.services.companies.CompaniesService;
import ru.itis.services.companies.CompaniesServiceImpl;
import ru.itis.services.detail_item.DetailItemService;
import ru.itis.services.detail_item.DetailItemServiceImpl;
import ru.itis.services.items.ItemService;
import ru.itis.services.items.ItemServiceImpl;
import ru.itis.services.orders.OrderService;
import ru.itis.services.orders.OrderServiceImpl;
import ru.itis.services.sign_in.SignInService;
import ru.itis.services.sign_in.SignInServiceImpl;
import ru.itis.services.sign_up.SignUpService;
import ru.itis.services.sign_up.SignUpServiceImpl;
import ru.itis.services.tx.TxService;
import ru.itis.services.tx.TxServiceImpl;

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
