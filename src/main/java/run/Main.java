package run;

import dao.CompanyDAO;
import dao.CompanyDBDAO;
import entities.Company;
import exceptions.NotExistException;

import java.sql. *;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDBDAO();
        Company company1 = new Company("Apple", "Steve Jobs");
        
        try {
            Company a = companyDAO.getByID(1);
            System.out.println(a);
        } catch (NotExistException e) {
            e.printStackTrace();
        }

        List<Company> a = companyDAO.getAll();
        System.out.println(a);
    }
}
