package com.jobhub.controller;
import com.jobhub.model.Customer;
import com.jobhub.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerController extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() {
        this.customerService = new CustomerService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Обрабатываем добавление и обновление заказчика в одном методе
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addCustomer(request, response);
        } else if ("update".equals(action)) {
            updateCustomer(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                listCustomers(request, response);
                break;
            case "add":
                // Передаем управление на JSP файл для добавления нового заказчика
                request.getRequestDispatcher("/WEB-INF/views/addEditCustomer.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                listCustomers(request, response);
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Customer newCustomer = new Customer(name, email); // Создаем нового заказчика только с именем и email
        customerService.addCustomer(newCustomer);
        response.sendRedirect("customer?action=list");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Customer customer = new Customer(id, name, email);
        boolean updated = customerService.updateCustomer(customer);
        if (updated) {
            response.sendRedirect("customer?action=list");
        } else {
            request.setAttribute("errorMessage", "Error updating customer");
            request.getRequestDispatcher("/WEB-INF/views/addEditCustomer.jsp").forward(request, response);
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/WEB-INF/views/customerList.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.getCustomerById(id);
        request.setAttribute("customer", existingCustomer);
        request.getRequestDispatcher("/WEB-INF/views/addEditCustomer.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        response.sendRedirect("customer?action=list");
    }
}
