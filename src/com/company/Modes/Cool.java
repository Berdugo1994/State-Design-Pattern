package com.company.Modes;
import com.company.State;

public class Cool implements State {
    Mode containerMode;
    public Cool(Mode containerMode) {
        this.containerMode = containerMode;
    }
    @Override
    public void entry() {
        System.out.println("MODE-COOL");
    }

    @Override
    public void exit() {
        containerMode.setCurrentMode(containerMode.getStateHeat());
    }

    @Override
    public void tm(int x) {

    }

    @Override
    public void TempChanged(double r, double c) {
        if(c>r+5){
            exit();
        }
    }
}
