package com.jobhub.dao;

import com.jobhub.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CustomerDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Customer> rowMapper = (rs, rowNum) -> {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        return customer;
    };

    public boolean addCustomer(Customer customer) {
        String SQL = "INSERT INTO customers (name, email) VALUES (?, ?)";
        int affectedRows = jdbcTemplate.update(SQL, customer.getName(), customer.getEmail());
        return affectedRows > 0;
    }

    public List<Customer> getAllCustomers() {
        String SQL = "SELECT id, name, email FROM customers";
        return jdbcTemplate.query(SQL, rowMapper);
    }

    public Customer getCustomerById(int id) {
        String SQL = "SELECT id, name, email FROM customers WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, rowMapper);
    }

    public boolean updateCustomer(Customer customer) {
        String SQL = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
        int affectedRows = jdbcTemplate.update(SQL, customer.getName(), customer.getEmail(), customer.getId());
        return affectedRows > 0;
    }

    public boolean deleteCustomer(int id) {
        String SQL = "DELETE FROM customers WHERE id = ?";
        int affectedRows = jdbcTemplate.update(SQL, id);
        return affectedRows > 0;
    }
}

