package com.fiit.krizanek.buildings;
import com.fiit.krizanek.people.Manager;
import com.fiit.krizanek.vehicle.Vehicle;
import java.util.ArrayList;


public class Depo extends BuildignBase implements BuildingParam{

  static public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

  @Override
  public void setManager(Manager mng) {
    this.manager = mng;
  }

  @Override
  public void setAddress(String address) {
    this.address = address;
  }

  public void loadVehicle(Vehicle vehicle){
    vehicles.add(vehicle);
  }
}
