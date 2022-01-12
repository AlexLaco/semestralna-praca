package com.fiit.krizanek.people;

import com.fiit.krizanek.data.Destinations;
import com.fiit.krizanek.delivery_system.Contract;
import com.fiit.krizanek.pckg.Pckg;
import com.fiit.krizanek.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Manager extends Staff {

  private String username = "";
  private String password = "";
  public static ArrayList<Manager> managers  = new ArrayList<>();

  private static Scanner keyb = new Scanner(System.in);
  private static String opt;

  public Manager(String name, String username, String password){
    this.name = name;
    this.position = "manager";
    this.username = username;
    this.password = password;
    people.add(this);
    managers.add(this);
  }


  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }



  public static void ListOfManagers() {
    int i =0;
    for(Person x : Person.people){
      if(x.position.equals("manager")) {
        System.out.println("[" + i + "] " + x.name);
        i++;
      }
    }
  }

  public static void NewManager() {
    System.out.print("Name of new manager: ");
    String name = keyb.nextLine();
    System.out.println(name + " system setup" );
    System.out.print("username: ");
    String username = keyb.nextLine();
    System.out.print("password: ");
    String password = keyb.nextLine();

    new Manager(name, username, password);
  }

  public static void ListOfClients(){
    for(Client x: Client.clients){
      System.out.println("["+Client.clients.indexOf(x)+"] " + x.name);
      for(Pckg y: x.packages){
        System.out.println("   Title: " + y.title + " | Weight: "+y.weight + "t | Client: " + x.name + " | Destination: " + y.getDestination() + " | Hours: "+y.getTime());
      }
    }
  }

  public static void Packages() {
    for(Client x: Client.clients){
      for(Pckg y: x.packages){
        System.out.println("Title: " + y.title + " | Weight: "+y.weight + "t | Destination: " + y.getDestination() + " | Hours: "+ y.getTime());
      }
    }
  }

  public static void SendPackage() {
    int nPckg = 0;
    for(Pckg x: Pckg.packages_list) {
      if (!x.inTransit) {
        System.out.print("[" + Pckg.packages_list.indexOf(x) + "]  Client: " + x.client.name + " | Title: " + x.title + " | Weight: " + x.weight + "t | Destination: " + x.getDestination() + " | Hours: ");
        Destinations.getCorrectTime(x.destination_index);
        nPckg++;
      }
    }

    int nVeh = 0;
    for(Vehicle x : Vehicle.vehicles){
      String DN = (x.driver==null) ? "No driver" : x.driver.name;
      if(!DN.equals("No driver") && !x.SPZ.equals("No SPZ") && !x.busy){
        //System.out.println("|"+Vehicle.vehicles.indexOf(x)+"| SPZ:" +x.SPZ + " | Driver: " + DN);
        nVeh++;
      }
    }

    if(nPckg > 0 && nVeh >0) {
      System.out.print("Choose package: ");
      String package_index = keyb.nextLine();
      Pckg actualPackage = Pckg.packages_list.get(Integer.parseInt(package_index));
      actualPackage.inTransit = true;

      Vehicle.ListOfVehicles(2);
      System.out.print("Choose vehicle: ");
      String vehicle_index = keyb.nextLine();

      Vehicle actualVehicle = Vehicle.vehicles.get(Integer.parseInt(vehicle_index));
      actualVehicle.pckg = Pckg.packages_list.get(Integer.parseInt(package_index));

      //Debug pre balíček a vozidlo
      //System.out.println("Package: |" + Pckg.packages_list.get(Integer.parseInt(package_index)).title + "|  Vehicle: " + Vehicle.vehicles.get(Integer.parseInt(vehicle_index)).SPZ);
      Contract newContract = new Contract(actualVehicle);
    }
    if(nPckg == 0)
      System.out.println("No packages");
    if(nVeh == 0)
      System.out.println("\nNo free vehicles");
  }

  public static void TrackContracts() {
    for(Contract x: Contract.contracts_list){
      System.out.print("Client: " + x.vehicle.pckg.client.name + " | Package: " + x.vehicle.pckg.title + " | Destination: " + x.vehicle.pckg.getDestination() +" | Driver: " + x.vehicle.driver.name + " | Delivered: ");

      if(x.isDelivered())
        System.out.println("YES");
      else {
        System.out.print("Current on road | Delivery status: ");
        x.checkDelivered();
      }
    }
  }

}
