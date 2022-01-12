package com.fiit.krizanek.vehicle;

import com.fiit.krizanek.pckg.Pckg;
import com.fiit.krizanek.people.Driver;
import com.fiit.krizanek.people.Person;

import java.util.*;

public abstract class Vehicle{
    public String SPZ;
    protected int loadCapacity = 200;
    public boolean busy = false;
    protected int stkExpiration = -1;
    public Pckg pckg;
    protected int kmPrice = 10;
    public Driver driver;
    static public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    static public int nVehicle;
    private static Scanner keyb = new Scanner(System.in);

    public abstract void SetKmPrice(int price);

    //Overloading
    public Vehicle(Driver driver, String SPZ, int STK){
        newID();
        driver.vehicle = this;
        this.driver = driver;
        this.SPZ = SPZ;
        this.stkExpiration = STK;
    }

    public Vehicle(Driver driver){
        newID();
        driver.vehicle = this;
        this.driver = driver;
        this.SPZ = "No SPZ";
        this.stkExpiration = -1;
    }

    public Vehicle(Driver driver, String SPZ){
        newID();
        driver.vehicle = this;
        this.driver = driver;
        this.SPZ = SPZ;
        this.stkExpiration = 2020;
    }

    public Vehicle(String SPZ){
        newID();
        this.driver = null;
        this.SPZ = SPZ;
        this.stkExpiration = -1;
    }

    public static void destroy(int opt){
        if(Vehicle.vehicles.get(opt).driver != null)
            Vehicle.vehicles.get(opt).driver.vehicle = null;
        Vehicle.vehicles.remove(opt);
        nVehicle--;
    }

    void newID(){
        nVehicle++;
    }

    final static public boolean validSTK(Vehicle vhc){
        Date date = new Date(); // your date
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        calendar.setTime(date);

        if(vhc.stkExpiration < calendar.get(Calendar.YEAR))
            return false;
        return true;
    }

    final public static void ListOfVehicles(int opt) {
        // opt == 0 All vehicles.
        // opt == 1 Vehicle only with SPZ
        // opt == 2 Vehicle with SPZ and driver

            for(Vehicle x : Vehicle.vehicles){
            String DN = (x.driver==null) ? "No driver" : x.driver.name;
            if(opt == 0)
                System.out.println("|"+Vehicle.vehicles.indexOf(x)+"| SPZ:" +x.SPZ + " | Driver: " + DN);
            if(opt == 1 && !x.SPZ.equals("No SPZ"))
            //if(opt != 1 || x.SPZ != "No SPZ" )
                System.out.println("|"+Vehicle.vehicles.indexOf(x)+"| SPZ:" +x.SPZ + " | Driver: " + DN);
            if(opt == 2 && !DN.equals("No driver") && !x.SPZ.equals("No SPZ") && !x.busy){
                System.out.println("|"+Vehicle.vehicles.indexOf(x)+"| SPZ:" +x.SPZ + " | Driver: " + DN);
            }
        }
    }

    final public static void NewVehicle() {
        System.out.println("Truck or Van?");
        String vehType = keyb.nextLine();
        System.out.print("Enter the license plate of the new vehicle: ");
        String SPZ = keyb.nextLine();

        Vehicle newVehicle;
        if(vehType.equals("Truck") || vehType.equals("truck"))
            newVehicle = new Truck(SPZ);
        else
            newVehicle = new Van(SPZ);

        boolean driverExist = false;

        for( Driver x : Driver.drivers)
        {
            if (x.vehicle != null) {
                driverExist = true;
                break;
            }
        }

        if(!driverExist){
            System.out.println("Any driver isn't free.");
        }else{
            Driver.SetVehicle(newVehicle);
        }
        System.out.println("New vehicle created");
    }

    final public static void DeleteVehicle() {
        if(Vehicle.nVehicle != 0) {
            for (Vehicle x : Vehicle.vehicles) {
                String DN = (x.driver == null) ? "No driver" : x.driver.name;
                System.out.println("|" + Vehicle.vehicles.indexOf(x) + "| SPZ:" + x.SPZ + " | Driver: " + DN);
            }
            System.out.print("Select vehicle: ");
            int opt = keyb.nextInt();
            if (opt <= Vehicle.nVehicle - 1)
                Vehicle.destroy(opt);
            String buff = keyb.nextLine();
        }else
            System.out.println("No vehicles");
    }
}
