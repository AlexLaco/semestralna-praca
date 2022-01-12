package com.fiit.krizanek;

import com.fiit.krizanek.buildings.Depo;
import com.fiit.krizanek.buildings.Economics;
import com.fiit.krizanek.interfc.Login;
import com.fiit.krizanek.people.Client;
import com.fiit.krizanek.people.Clients;
import com.fiit.krizanek.people.Driver;
import com.fiit.krizanek.people.Manager;
import com.fiit.krizanek.vehicle.Truck;
import com.fiit.krizanek.vehicle.Van;
import com.fiit.krizanek.vehicle.Vehicle;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {

        //Stop gui
        //launch(args);

        //New manager
        Manager PavTok = new Manager("Pavol Tokaček","PavTok","123");
        Manager KubFuk = new Manager("Kubo Fuka", "KubFuk","123");

        //New Client with package
        Client INA = new Client("INA");
        //INA.newPackage("Palletes", 200, 2);

        //New Drivers with vehicles
        new Driver("Jozef Andul", "Mallého 12");


        //New building
        Depo depo1 = new Depo();
        depo1.setAddress("Kovačičová 10, Podebrady");
        depo1.setManager(PavTok);
        depo1.loadVehicle(new Truck(new Driver("Anastazia Kuzma"),"SI-324KF",2024));
        depo1.loadVehicle(new Van(new Driver("Fero Induch")));
        depo1.loadVehicle(new Truck("KA-874KF"));

        Vehicle Renault = new Truck("KA-874KF");

        Economics economics_section = new Economics();
        economics_section.setAddress("Janošiková 12");
        economics_section.setManager(KubFuk);



        new Login();
    }
}
