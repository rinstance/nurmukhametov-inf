package ru.itis.repositories.companies;

import ru.itis.models.entities.Company;
import ru.itis.repositories.CrudRepository;

public interface CompaniesRepository extends CrudRepository<Company> {
    void incCount(Integer id);
}
