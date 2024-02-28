package JDBC_Hondenuitlaat.project.controller;

import JDBC_Hondenuitlaat.project.database.DBAccess;

public class HondenUitlaatLauncher {

    public static void main(String[] args) {
        DBAccess dBaccess = new DBAccess("UitlaatService", "userUitlaatService", "pwUitlaatService");
        dBaccess.openConnection();


        dBaccess.closeConnection();
    }
}
