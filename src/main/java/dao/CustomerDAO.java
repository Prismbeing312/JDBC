package dao;

import entities.Customer;
import exceptions.AlreadyExistException;
import exceptions.NotExistException;

import java.util.List;

public interface CustomerDAO {
    Customer getByID(long CustomerID) throws NotExistException;

    List<Customer> getAll();

    Customer createCustomer(Customer customer) throws AlreadyExistException;

    void deleteCustomer(long CustomerID) throws NotExistException;
}
