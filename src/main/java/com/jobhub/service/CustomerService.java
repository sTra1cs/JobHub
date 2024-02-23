package com.jobhub.service;

import com.jobhub.dao.CustomerDAO;
import com.jobhub.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // Добавление нового заказчика
    public boolean addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    // Получение списка всех заказчиков
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    // Получение заказчика по ID
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    // Обновление данных заказчика
    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    // Удаление заказчика по ID
    public boolean deleteCustomer(int id) {
        return customerDAO.deleteCustomer(id);
    }
}