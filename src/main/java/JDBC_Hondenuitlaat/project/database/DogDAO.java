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
    }

    public Dog getDogById(String mpChipnummer) {
        return new Dog("","","",new Customer(0,"","","",""));
    }

    public ArrayList<Dog> getDogsByCustomer(Customer mpCustomer) {
        return new ArrayList<>();
    }

    public ArrayList<Dog> getAllDogs() {
        return new ArrayList<>();
    }
}
