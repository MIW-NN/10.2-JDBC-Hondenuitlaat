package JDBC_Hondenuitlaat.project.controller;

import JDBC_Hondenuitlaat.project.database.CustomerDAO;
import JDBC_Hondenuitlaat.project.database.DBAccess;
import JDBC_Hondenuitlaat.project.database.DogDAO;
import JDBC_Hondenuitlaat.project.model.Customer;
import JDBC_Hondenuitlaat.project.model.Dog;

import java.util.ArrayList;

public class HondenUitlaatLauncher {

    public static void main(String[] args) {
        DBAccess dBaccess = new DBAccess("UitlaatService", "userUitlaatService", "pwUitlaatService");
        dBaccess.openConnection();


        dBaccess.closeConnection();
    }
}
