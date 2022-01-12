package com.fiit.krizanek.vehicle;

import com.fiit.krizanek.people.Driver;

public class Truck extends Vehicle {
    protected String materialType;
    public int trailers = 2;

    public Truck(Driver driver, String SPZ, int STK){
        super(driver, SPZ,STK);
        vehicles.add(this);
    }

    public Truck(Driver driver){
        super(driver);
        vehicles.add(this);
    }

    public Truck(Driver driver, String SPZ){
        super(driver, SPZ);
        vehicles.add(this);
    }

    public Truck(String SPZ){
        super(SPZ);
        vehicles.add(this);
    }

    @Override
    public void SetKmPrice(int price) {
        this.kmPrice = 20;
    }
}
