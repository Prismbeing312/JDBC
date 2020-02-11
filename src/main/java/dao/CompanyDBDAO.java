package dao;

import entities.Company;
import exceptions.AlreadyExistException;
import exceptions.NotExistException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDBDAO implements CompanyDAO{
    Connection connection;

    public CompanyDBDAO() {
        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db" + "?user=root"
                    + "&password=root" + "&useUnicode=true" + "&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false" + "&serverTimezone=UTC"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company getByID(long CompanyID) throws NotExistException {
        Company company = null;
        String sql = "SELECT * FROM COMPANY WHERE ID = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setLong(1, CompanyID);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                String firstname = resultSet.getString(2);
                String password = resultSet.getString(3);
                company = new Company(CompanyID, firstname, password);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (company == null){
            throw new NotExistException(String.format("The Company with the ID: %d doesnt exist", CompanyID));
        }
        return company;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM COMPANY";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                companies.add(new Company(id, name, password));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public Company getByName(String name){
        Company company = null;
        String sql = "SELECT * FROM WHERE name = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, name);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name1 = resultSet.getString(2);
                String password = resultSet.getString(3);
                company = new Company(id, name1, password);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public Company createCompany(Company company) throws AlreadyExistException {
        if (getByName(company.getName()) != null){
            throw new AlreadyExistException(String.format("The company with the name: %s already exists", company.getName()));
        }
        String sql = "INSERT INTO company (id, name, password) VALUES (?, ?)";
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, company.getName());
            pstm.setString(2, company.getPassword());
            pstm.executeUpdate();
            ResultSet resultSet = pstm.getGeneratedKeys();
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                company.setId(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }

    @Override
    public Company updateCompany(Company company) throws NotExistException {
        return null;
    }

    @Override
    public void deleteCompany(long CompanyID) throws NotExistException {

    }
}
