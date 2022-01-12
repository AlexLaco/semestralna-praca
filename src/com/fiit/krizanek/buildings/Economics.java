package com.fiit.krizanek.buildings;

import com.fiit.krizanek.people.Manager;

public class Economics extends BuildignBase implements BuildingParam{

  private static long balance = 0;

  @Override
  public void setManager(Manager mng) {
    this.manager = mng;
  }

  @Override
  public void setAddress(String address) {
    this.address = address;

  }


  public static long getBalance() {
    return balance;
  }

  public static void newMoney(long money){
    balance += money;
  }
}
