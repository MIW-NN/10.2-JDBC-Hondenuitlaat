package JDBC_Hondenuitlaat.project.database;

import JDBC_Hondenuitlaat.project.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {

    private DBAccess dBaccess;

    public CustomerDAO(DBAccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void storeCustomer(Customer mpCustomer) {
        String sql = "INSERT INTO Klant VALUES (?,?,?,?,?) ;";
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, mpCustomer.getCustomerNumber());
            preparedStatement.setString(2, mpCustomer.getInitials());
            preparedStatement.setString(3, mpCustomer.getPrefix());
            preparedStatement.setString(4, mpCustomer.getSurname());
            preparedStatement.setString(5, mpCustomer.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlFout) {
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
    }

    public Customer getCustomerById(int customerNumber) {
        String sql = "SELECT * FROM Klant WHERE klantnr = ?";
        Customer result = null;
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, customerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String initials = resultSet.getString("voorletters");
                String prefix = resultSet.getString("voorvoegsels");
                String surname = resultSet.getString("achternaam");
                String phoneNumber = resultSet.getString("telefoon");
                result = new Customer(customerNumber, initials, prefix, surname,  phoneNumber);
            } else {
                System.out.println("Klant met dit klantnummer bestaat niet");
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return result;
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> resultList = new ArrayList<>();
        String sql = "SELECT * FROM Klant";
        Customer customer;
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int klantnummer = resultSet.getInt("klantnr");
                String initials = resultSet.getString("voorletters");
                String prefix = resultSet.getString("voorvoegsels");
                String surname = resultSet.getString("achternaam");
                String phoneNumber = resultSet.getString("telefoon");
                customer = new Customer(klantnummer, initials, prefix, surname,  phoneNumber);
                resultList.add(customer);
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return resultList;
    }
}
