package dao;

import entities.Company;
import exceptions.AlreadyExistException;
import exceptions.NotExistException;

import java.util.List;

public interface CompanyDAO {
    Company getByID(long CompanyID) throws NotExistException;

    List<Company> getAll();

    Company createCompany(Company company) throws AlreadyExistException;

    Company updateCompany(Company company) throws NotExistException;

    void deleteCompany(long CompanyID) throws NotExistException;
}
