package services.companies;

import models.Company;

import java.util.List;

public interface CompaniesService {
    List<Company> getCompanies();
    void incCount(Integer id);
}
