package repositories.companies;

import models.Company;
import repositories.CrudRepository;

public interface CompaniesRepository extends CrudRepository<Company> {
    void incCount(Integer id);
}
