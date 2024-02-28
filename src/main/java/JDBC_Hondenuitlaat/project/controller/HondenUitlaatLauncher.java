package JDBC_Hondenuitlaat.project.controller;

import JDBC_Hondenuitlaat.project.database.CustomerDAO;
import JDBC_Hondenuitlaat.project.database.DBAccess;
import JDBC_Hondenuitlaat.project.database.DogDAO;
import JDBC_Hondenuitlaat.project.model.Customer;
import JDBC_Hondenuitlaat.project.model.Dog;

import java.util.ArrayList;

public class HondenUitlaatLauncher {

    public static void main(String[] args) {
        DBAccess dBaccess =  new DBAccess("UitlaatService", "root", "45HQDAZpUuyqrL");
        CustomerDAO customerDAO = new CustomerDAO(dBaccess);
        DogDAO dogDAO = new DogDAO(dBaccess);

        dBaccess.openConnection();

        // Klant testen
        System.out.println("Testen van klantDAO methodes: ");
        customerDAO.storeCustomer(new Customer(6, "O.B.", null, "Bommel", "098712345"));
        Customer customer = customerDAO.getCustomerById(2);
        System.out.println("Klant ophalen: " + customer);
        System.out.println();
        System.out.println("Alle klanten ophalen: ");
        ArrayList<Customer> customerList = customerDAO.getAllCustomers();
        for (Customer customer1 : customerList) {
            System.out.println(customer1);
        }
        // Hond testen
        System.out.println();
        System.out.println("Testen van hondDAO methods: ");
        Dog dog = dogDAO.getDogById("3");
        System.out.println("Hond ophalen: " + dog);
        ArrayList<Dog> dogList = dogDAO.getDogByKlant(customer);
        System.out.println();
        System.out.println("Hond van klant ophalen");
        for (Dog dog1 : dogList) {
            System.out.println(dog1);
        }
        System.out.println();
        System.out.println("Alle honden ophalen: ");
        dogList = dogDAO.getAllDogs();
        for (Dog dog1 : dogList) {
            System.out.println(dog1);
        }
    }
}
