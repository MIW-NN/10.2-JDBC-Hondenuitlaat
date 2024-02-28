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
    }

    public Customer getCustomerById(int customerNumber) {
        return new Customer(0,"","","","");
    }

    public ArrayList<Customer> getAllCustomers() {
        return new ArrayList<>();
    }
}
