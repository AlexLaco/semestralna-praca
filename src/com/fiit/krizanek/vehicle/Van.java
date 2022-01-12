package com.fiit.krizanek.vehicle;

import com.fiit.krizanek.people.Driver;

public class Van extends Vehicle{

    public Van(Driver driver, String SPZ, int STK){
        super(driver, SPZ, STK);
        vehicles.add(this);
    }

    public Van(Driver driver){
        super(driver);
        vehicles.add(this);
    }

    public Van(Driver driver, String SPZ){
        super(driver, SPZ);
        vehicles.add(this);
    }

    public Van(String SPZ){
        super(SPZ);
        vehicles.add(this);
    }

    @Override
    public void SetKmPrice(int price) {
        this.kmPrice = 10;
    }
}
