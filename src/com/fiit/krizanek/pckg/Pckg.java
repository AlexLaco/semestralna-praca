package com.fiit.krizanek.pckg;

import com.fiit.krizanek.data.Destinations;
import com.fiit.krizanek.delivery_system.Contract;
import com.fiit.krizanek.people.Client;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class Pckg {
  public String title;
  public int weight;
  public String material;
  public Client client;
  public boolean delivered = false;
  public boolean inTransit = false;
  private String destination;
  public int destination_index;
  private int Time;
  public static ArrayList<Pckg> packages_list  = new ArrayList<Pckg>();



  public Pckg(String title, int weight, int destination, Client client){
    this.title = title;
    this.weight = weight;
    this.destination = Destinations.getCity(destination);
    this.Time = Destinations.getTime(destination);
    this.client = client;
    this.destination_index = destination;

    packages_list.add(this);
  }

  public String getDestination() {
    return destination;
  }

  public int getTime() {
    return this.Time;
  }
}
