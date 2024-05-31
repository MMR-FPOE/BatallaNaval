package com.example.navalbattle.model;

public class AircraftCarrier extends Ship{
    private final String name = "Portaavión";
    public int amount = 1;

    public AircraftCarrier(){
        super.length = 4;
        super.available = true;
    }

    @Override
    public boolean shipStatus(){
        amount--;
        return (amount == 0);
    }
}
