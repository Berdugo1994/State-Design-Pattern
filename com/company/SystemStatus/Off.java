package com.company.SystemStatus;

import com.company.AirConditioner;
import com.company.State;

public class Off implements State {
    AirConditioner owner;
    public Off(AirConditioner ac) {
        this.owner = ac;
    }

    @Override
    public void entry() {
        System.out.println("OFF");
    }

    @Override
    public void exit() {
        owner.R_temp=25;
        owner.C_temp=25;
        owner.setCurrentState(owner.getStateWait());
    }

    @Override
    public void tm(int x) {

    }
    public void TempChanged(double r, double c){

    }
}
