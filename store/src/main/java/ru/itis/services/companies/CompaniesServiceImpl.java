package services.companies;

import models.Company;
import repositories.companies.CompaniesRepository;

import java.util.List;

public class CompaniesServiceImpl implements CompaniesService {
    CompaniesRepository companiesRepository;

    public CompaniesServiceImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public List<Company> getCompanies() {
        return companiesRepository.findAll();
    }

    @Override
    public void incCount(Integer id) {
        companiesRepository.incCount(id);
    }
}
