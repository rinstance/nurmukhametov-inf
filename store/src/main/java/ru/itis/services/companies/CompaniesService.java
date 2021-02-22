package ru.itis.services.companies;

import ru.itis.models.entities.Company;

import java.util.List;

public interface CompaniesService {
    List<Company> getCompanies();
    void incCount(Integer id);
}
