package com.jobhub.service;

import com.jobhub.dao.CustomerDAO;
import com.jobhub.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
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