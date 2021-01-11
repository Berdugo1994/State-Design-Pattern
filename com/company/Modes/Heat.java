package com.company.Modes;
import com.company.State;

public class Heat implements State {
    Mode containerMode;
    public Heat(Mode containerMode) {
        this.containerMode = containerMode;
    }


    @Override
    public void entry() {
        System.out.println("MODE-HEAT");
    }

    @Override
    public void exit() {
        containerMode.setCurrentMode(containerMode.getStateCool());
    }

    @Override
    public void tm(int x) {
    }

    @Override
    public void TempChanged(double r, double c) {
        if (r>c+5){
            exit();
        }
    }
}
