package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
    }

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("insert into employees (name, role) values (?, ?)", employee.getName(), employee.getRole());
    }

    @Override
    public int update(Employee employee, Long id) {
        return jdbcTemplate.update("update employees set name=?, role=? where id = ?", employee.getName(), employee.getRole(), id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from employees where id = ?", id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employees", (rs, rowNum) -> new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role")
        ));
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jdbcTemplate.queryForObject("select * from employees where id = ?", new Object[]{id}, (rs, rowNum) -> Optional.of(
                new Employee(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("role")
                )
        ));
    }

    ;

}