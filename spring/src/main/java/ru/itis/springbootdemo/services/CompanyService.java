package ru.itis.springbootdemo.services;

import ru.itis.springbootdemo.models.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();
}
