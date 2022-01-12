package com.fiit.krizanek.delivery_system;

import com.fiit.krizanek.buildings.Economics;
import com.fiit.krizanek.data.Destinations;
import com.fiit.krizanek.vehicle.Vehicle;

import javax.print.attribute.standard.Destination;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Contract {
  final public long startTime;
  public int deliver_time;
  public Vehicle vehicle;
  public static ArrayList<Contract> contracts_list  = new ArrayList<Contract>();

  public Contract(Vehicle vehicle){
    startTime = System.currentTimeMillis();
    this.vehicle = vehicle;
    vehicle.busy = true;
    deliver_time = vehicle.pckg.getTime();
    contracts_list.add(this);
  }

  public void checkDelivered(){
    long currTime = (System.currentTimeMillis() - this.startTime)/1000;

    System.out.println(Math.floor( ((double)currTime / (double)this.deliver_time )*100) + "%");
  }

  public boolean isDelivered() {
    long currTime = (System.currentTimeMillis() - this.startTime)/1000;
    //System.out.println("Curr: " + currTime + " | Delivery time: " + this.deliver_time);

    if (currTime  > this.deliver_time) {
      vehicle.pckg.delivered = true;
      vehicle.busy = false;
      if(vehicle.pckg.inTransit){
        Economics.newMoney(Destinations.getValue(this.vehicle.pckg.destination_index));
        vehicle.pckg.inTransit = false;
      }
      return true;
    }
    return false;
  }
}
