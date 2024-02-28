package JDBC_Hondenuitlaat.project.database;

import JDBC_Hondenuitlaat.project.model.Customer;
import JDBC_Hondenuitlaat.project.model.Dog;
import org.junit.Assert;
import org.junit.Test;

public class DogDAOTest {
    @Test
    public void whenCallingStoreDog_expectRightQueryToBeMade(){
        var prepairedStatement = new MockPreparedStatement();
        var ddao = new DogDAO(new MockDBAccess(prepairedStatement));

        var customer = new Customer(1,"P","van der","Veen", "0612345678910");
        var dog = new Dog("1","Poedels","poedel",customer);

        ddao.storeDog(dog);

        Assert.assertTrue(prepairedStatement.sql.contains("INSERT INTO Hond VALUES (?,?,?,?)"));
        Assert.assertTrue(prepairedStatement.setValues.contains("1=1"));
        Assert.assertTrue(prepairedStatement.setValues.contains("2=Poedels"));
        Assert.assertTrue(prepairedStatement.setValues.contains("3=poedel"));
        Assert.assertTrue(prepairedStatement.setValues.contains("4=1"));
    }

    @Test
    public void whenCallingGetCustomerById_expectRightQueryToBeMade(){
        var prepairedStatement = new MockPreparedStatement();
        var ddao = new DogDAO(new MockDBAccess(prepairedStatement));

        var dog = ddao.getDogById("1");

        Assert.assertTrue(prepairedStatement.sql.contains("SELECT * FROM Hond WHERE chipnr = ?"));
        Assert.assertTrue(prepairedStatement.setValues.contains("1=1"));
        Assert.assertEquals("1", dog.getChipnumber());
        Assert.assertEquals("Doedie", dog.getName());
        Assert.assertEquals("pitbull", dog.getBreed());
    }

    @Test
    public void whenCallingGetAllCustomers_expectRightQueryToBeMade(){
        var prepairedStatement = new MockPreparedStatement();
        var ddao = new DogDAO(new MockDBAccess(prepairedStatement));

        var dogs = ddao.getAllDogs();

        Assert.assertTrue(prepairedStatement.sql.contains("SELECT * FROM Hond"));
        Assert.assertEquals(1, dogs.size());
        Assert.assertEquals("1", dogs.get(0).getChipnumber());
        Assert.assertEquals("Doedie", dogs.get(0).getName());
        Assert.assertEquals("pitbull", dogs.get(0).getBreed());
    }
}