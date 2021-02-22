package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.repositories.CompanyRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;

@Component
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
