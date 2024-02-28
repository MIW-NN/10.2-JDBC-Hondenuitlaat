package JDBC_Hondenuitlaat.project.database;

import JDBC_Hondenuitlaat.project.model.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerDAOTest {
    @Test
    public void whenCallingStoreCustomer_expectRightQueryToBeMade(){
        var prepairedStatement = new MockPreparedStatement();
        var cdao = new CustomerDAO(new MockDBAccess(prepairedStatement));

        var customer = new Customer(1,"P","van der","Veen", "0612345678910");

        cdao.storeCustomer(customer);

        Assert.assertTrue(prepairedStatement.sql.contains("INSERT INTO Klant VALUES (?,?,?,?,?)"));
        Assert.assertTrue(prepairedStatement.setValues.contains("1=1"));
        Assert.assertTrue(prepairedStatement.setValues.contains("2=P"));
        Assert.assertTrue(prepairedStatement.setValues.contains("3=van der"));
        Assert.assertTrue(prepairedStatement.setValues.contains("4=Veen"));
        Assert.assertTrue(prepairedStatement.setValues.contains("5=0612345678910"));
    }

    @Test
    public void whenCallingGetCustomerById_expectRightQueryToBeMade(){
        var prepairedStatement = new MockPreparedStatement();
        var cdao = new CustomerDAO(new MockDBAccess(prepairedStatement));

        var customer = cdao.getCustomerById(1);

        Assert.assertTrue(prepairedStatement.sql.contains("SELECT * FROM Klant WHERE klantnr = ?"));
        Assert.assertTrue(prepairedStatement.setValues.contains("1=1"));
        Assert.assertEquals(1, customer.getCustomerNumber());
        Assert.assertEquals("A", customer.getInitials());
        Assert.assertEquals("van", customer.getPrefix());
        Assert.assertEquals("Doorn", customer.getSurname());
        Assert.assertEquals("0606060606", customer.getPhoneNumber());
    }

    @Test
    public void whenCallingGetAllCustomers_expectRightQueryToBeMade(){
        var prepairedStatement = new MockPreparedStatement();
        var cdao = new CustomerDAO(new MockDBAccess(prepairedStatement));

        var customers = cdao.getAllCustomers();

        Assert.assertTrue(prepairedStatement.sql.contains("SELECT * FROM Klant"));
        Assert.assertTrue(prepairedStatement.setValues.isEmpty());

        Assert.assertEquals(1, customers.size());
        Assert.assertEquals(2, customers.get(0).getCustomerNumber());
        Assert.assertEquals("A", customers.get(0).getInitials());
        Assert.assertEquals("van", customers.get(0).getPrefix());
        Assert.assertEquals("Doorn", customers.get(0).getSurname());
        Assert.assertEquals("0606060606", customers.get(0).getPhoneNumber());
    }
}