package org.food.service;

import org.food.exception.CustomerExistsException;
import org.food.exception.CustomerNotFoundException;
import org.food.model.Customer;
import org.food.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;


public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private Customer currentLoggedInCustomer;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent())
            throw new CustomerExistsException("Customer Already Exists with this Id  :" + customer.getId());
        return this.customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getCustomersList();
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id : " + id);
        return customerById.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id : " + customer.getId());
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id : " + id);
        this.customerRepository.deleteCustomer(customerById.get());
    }

    @Override
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findByEmailAndPassword(email,password);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Invalid Email or Password");
        return customerById.get();
    }

    @Override
    public void setCurrentLoggedInCustomer(Customer customer) {
        this.currentLoggedInCustomer = customer;
    }

    @Override
    public Customer getCurrentLoggedInCustomer() {
        return this.currentLoggedInCustomer;
    }
}

