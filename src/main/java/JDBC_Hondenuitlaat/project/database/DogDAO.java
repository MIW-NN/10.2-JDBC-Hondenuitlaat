package JDBC_Hondenuitlaat.project.database;

import JDBC_Hondenuitlaat.project.model.Customer;
import JDBC_Hondenuitlaat.project.model.Dog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DogDAO {

    DBAccess dBaccess;

    public DogDAO(DBAccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void storeDog(Dog mpHond) {
        String sql = "INSERT INTO Hond VALUES (?,?,?,?) ;";
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, mpHond.getChipnumber());
            preparedStatement.setString(2, mpHond.getName());
            preparedStatement.setString(3, mpHond.getBreed());
            preparedStatement.setInt(4, mpHond.getOwner().getCustomerNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlFout) {
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
    }

    public Dog getDogById(String mpChipnummer) {
        String sql = "SELECT * FROM Hond WHERE chipnr = ?";
        Dog result = null;
        CustomerDAO klantDAO = new CustomerDAO(dBaccess);
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, mpChipnummer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String dogName = resultSet.getString("hondnaam");
                String breed = resultSet.getString("ras");
                int customerId = resultSet.getInt("klantnr");
                Customer customer = klantDAO.getCustomerById(customerId);
                result = new Dog(mpChipnummer, dogName, breed, customer);
            } else {
                System.out.println("Hond met dit chipnr bestaat niet");
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return result;
    }

    public ArrayList<Dog> getDogsByCustomer(Customer mpCustomer) {
        String sql = "SELECT chipnr, hondnaam, ras FROM Hond WHERE klantnr = ?";
        ArrayList<Dog> resultList = new ArrayList<>();
        Dog tempResult = null;
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, mpCustomer.getCustomerNumber());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String dogId = resultSet.getString("chipnr");
                String dogName = resultSet.getString("hondnaam");
                String breed = resultSet.getString("ras");
                tempResult = new Dog(dogId, dogName, breed, mpCustomer);
                resultList.add(tempResult);
            }
            if (resultList.isEmpty()) {
                System.out.println("Voor klant " + mpCustomer + " zijn geen honden geregistreerd.");
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return resultList;
    }

    public ArrayList<Dog> getAllDogs() {
        CustomerDAO klantDAO = new CustomerDAO(dBaccess);
        String sql = "SELECT * FROM Hond";
        ArrayList<Dog> resultList = new ArrayList<>();
        Dog tempResult = null;
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String dogId = resultSet.getString("chipnr");
                String dogName = resultSet.getString("hondnaam");
                String breed = resultSet.getString("ras");
                int customerId = resultSet.getInt("klantnr");
                Customer customer = klantDAO.getCustomerById(customerId);
                tempResult = new Dog(dogId, dogName, breed, customer);
                resultList.add(tempResult);
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return resultList;
    }
}
