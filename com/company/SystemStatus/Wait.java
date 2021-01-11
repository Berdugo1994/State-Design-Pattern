package com.company.SystemStatus;

import com.company.AirConditioner;
import com.company.State;

public class Wait implements State {
    AirConditioner owner;
    public Wait(AirConditioner ac) {
        this.owner = ac;
    }

    @Override
    public void entry() {
        exit();
    }

    @Override
    public void exit() {
        this.tm(30);
        owner.setCurrentState(owner.getStateOn());
    }

    @Override
    public void tm(int x) {
        System.out.println("\tWAITING "+x+" SECONDS...");
    }

    @Override
    public void TempChanged(double r, double c) {

    }
}
