package com.jobhub.controller;

import com.jobhub.model.Customer;
import com.jobhub.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customer")
    public String handlePostRequest(@RequestParam("action") String action,
                                    @RequestParam(value = "id", required = false) Integer id,
                                    @RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "email", required = false) String email,
                                    Model model) {
        switch (action) {
            case "add":
                Customer newCustomer = new Customer(name, email);
                customerService.addCustomer(newCustomer);
                break;
            case "update":
                Customer customerToUpdate = new Customer(id, name, email);
                boolean updated = customerService.updateCustomer(customerToUpdate);
                if (!updated) {
                    model.addAttribute("errorMessage", "Error updating customer");
                    return "addEditCustomer";
                }
                break;
            case "delete":
                customerService.deleteCustomer(id);
                break;
            default:
                break;
        }
        return "redirect:/customer?action=list";
    }

    @GetMapping("/customer")
    public String handleGetRequest(@RequestParam(value = "action", defaultValue = "list") String action,
                                   @RequestParam(value = "id", required = false) Integer id,
                                   Model model) {
        switch (action) {
            case "list":
                model.addAttribute("customers", customerService.getAllCustomers());
                return "customerList";
            case "add":
                return "addEditCustomer";
            case "edit":
                Customer existingCustomer = customerService.getCustomerById(id);
                model.addAttribute("customer", existingCustomer);
                return "addEditCustomer";
            case "delete":
                break;
            default:
                break;
        }
        return "customerList";
    }
}
