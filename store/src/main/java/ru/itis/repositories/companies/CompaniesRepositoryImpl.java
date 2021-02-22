package ru.itis.repositories.companies;

import ru.itis.models.entities.Company;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class CompaniesRepositoryImpl implements CompaniesRepository {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from companies";
    //language=SQL
    private static final String SQL_INC_COUNT =
            "UPDATE companies SET count_sold_items = count_sold_items+1 where id = ?;";

    private JdbcTemplate jdbcTemplate;

    public CompaniesRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Company> companyRowMapper = (row, rowNumber) -> {
        Company company = new Company();
        company.setId(row.getInt("id"));
        company.setName(row.getString("name"));
        company.setCountSoldItems(row.getInt("count_sold_items"));
        return company;
    };

    @Override
    public void save(Company entity) {

    }

    @Override
    public void update(Company entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Company> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Company> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, companyRowMapper);
    }

    @Override
    public void incCount(Integer id) {
        jdbcTemplate.update(SQL_INC_COUNT, id);
    }
}
