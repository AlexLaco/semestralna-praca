package com.fiit.krizanek.people;
import com.fiit.krizanek.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Staff {
    public Vehicle vehicle;
    private int hoursWorked;
    public static ArrayList<Driver> drivers  = new ArrayList<>();
    private static Scanner keyb = new Scanner(System.in);
    private static String opt;


    private void DriverArray(){
        drivers.add(this);
    }
    public Driver(String name){
        this.name = name;
        this.position = "driver";
        people.add(this);
        DriverArray();
    }


    public Driver(String name, String address){
        this.name = name;
        this.address = address;
        this.position = "driver";
        people.add(this);
        DriverArray();
    }


    public static void ListOfDrivers(){
        for(Driver x : Driver.drivers){
            System.out.print("|"+Driver.drivers.indexOf(x)+"| " + x.name);
            if(x.vehicle != null && x.position.equals("driver"))
                System.out.print(" | Vehicle SPZ: " + x.vehicle.SPZ);
            System.out.println();
        }
    }



    public static void NewDriver(){
        System.out.print("Enter the driver's name: ");
        Driver currDriver = new Driver(keyb.nextLine());
        System.out.println("Set "+currDriver.name+" address [Leave empty for empty]");
        if((opt = keyb.nextLine()).equals(""))
            currDriver.address = "No address";
        else
            currDriver.address = opt;
    }



    public static void DeleteDriver() {
        if(Driver.nPerson != 0) {
            Driver curDriver = SelectDriver();
            Driver.fire(curDriver);
            //Vyčistenie buffera
            String buff = keyb.nextLine();
        }else
            System.out.println("No drivers");
    }



    //Association
    public static void SetVehicle(Vehicle currVeh){
        Driver currDriver = SelectDriver();

        //Vykona sa keď nebol do parametra zadané vozidlo
        if(currVeh == null) {
            Vehicle.ListOfVehicles(1);
            System.out.print("Select vehicle: ");
            opt = keyb.nextLine();
            currVeh = Vehicle.vehicles.get(Integer.parseInt(opt));
        }

        if(currVeh.driver != null)
            currVeh.driver.vehicle = null;

        if(currDriver.vehicle != null)
            currDriver.vehicle.driver = null;

        currDriver.vehicle =  currVeh;
        currVeh.driver = currDriver;

    }


    public static void EditDriver() {
        Driver currDriver = SelectDriver();
        System.out.println("Leave text field empty for no change");
        System.out.print("Name ["+currDriver.name+"] : ");
        if(!(opt = keyb.nextLine()).equals(""))
            currDriver.name = opt;

        System.out.print("Address ["+currDriver.address+"] : ");
        if(!(opt = keyb.nextLine()).equals(""))
            currDriver.address = opt;
    }



    public static void DetailedInfo() {
        System.out.println("Detailed info about: ");
        Driver currDriver = SelectDriver();

        System.out.print("Name: " + currDriver.name + "| Position: " + currDriver.position + " | Address: " + currDriver.address + " | " +
                ((currDriver.vehicle == null)?"Vehicle: NO vehicle":("Vehicle: "+currDriver.vehicle.SPZ))
        );
    }



    private static Driver SelectDriver(){
        ListOfDrivers();
        System.out.print("Select driver: ");
        opt = keyb.nextLine();
        System.out.println();
        return  Driver.drivers.get(Integer.parseInt(opt));
    }


    public static void fire(Driver currDriver){
        if(currDriver.vehicle != null)
            currDriver.vehicle.driver = null;
        people.remove(currDriver);
        nPerson--;
    }



}
