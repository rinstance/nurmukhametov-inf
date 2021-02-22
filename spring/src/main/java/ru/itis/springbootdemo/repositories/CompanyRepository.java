package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.models.User;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
