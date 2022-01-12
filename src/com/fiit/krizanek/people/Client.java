package com.fiit.krizanek.people;

import com.fiit.krizanek.data.Destinations;
import com.fiit.krizanek.pckg.Pckg;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Clients {

  //Composition
  public ArrayList<Pckg> packages = new ArrayList<>();
  public static ArrayList<Client> clients  = new ArrayList<Client>();

  private static Scanner keyb = new Scanner(System.in);


  public Client(String name){
    this.name = name;
    this.position = "client";
    people.add(this);
    clients.add(this);
  }


  public void AddNewPackage(String title, int weight, int destination){
    packages.add(new Pckg(title, weight, destination,this));
  }


  public void MyPackages(Client currClient) {
    for(Pckg x: currClient.packages){
      System.out.print("Title: " + x.title + " | Weight: "+x.weight + "t | Destination: " + x.getDestination() + "Price : " + Destinations.getValue(x.destination_index) + "€ | Delivered: ");
      if(x.delivered)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
    if(currClient.packages.size() == 0){
      System.out.println("No packages \n");
    }
  }


  public void NewPackage(Client currClient) {
    System.out.print("\nSend new package\n Package Title: ");
    String title = keyb.nextLine();
    System.out.print(" Weight [T]: ");
    int weight = Integer.parseInt(keyb.nextLine());
    System.out.println(" |Destination|");

    int dest = 0;
    do {
      for (int i = 0; i < Destinations.getLength(); i++) {
        System.out.print("[" + i + "] " + Destinations.getCity(i) + " | Price : " + Destinations.getValue(i) + " | Hours: ");
        Destinations.getCorrectTime(i);
      }
      dest = Integer.parseInt(keyb.nextLine());
    }while (dest >= Destinations.getLength());

    currClient.AddNewPackage(title, weight, dest);
    System.out.println("New package was added to system.");
  }


}
