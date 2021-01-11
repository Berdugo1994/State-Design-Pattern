package com.company.Operations;
import com.company.Action;
import com.company.State;

public class Fanning implements State, Action {
    Operation containerOperator;
    boolean waitOver;

    public Fanning(Operation containerOperator) {
        this.containerOperator = containerOperator;
    }

    @Override
    public void Do() {
        waitOver=true;
    }

    @Override
    public void entry() {
        System.out.println("OPERATION-FANNING (120 SECONDS AT LEAST)");
        waitOver=false;
        tm(120);
        Do();
        this.TempChanged(containerOperator.getContainerOn().getOwner().getR_temp(),containerOperator.getContainerOn().getOwner().getC_temp());
    }

    @Override
    public void exit() {
        if(containerOperator.isCool())startCooling();
        else startHeating();
    }

    private void startHeating() {
        containerOperator.setCurrentOperation(containerOperator.getStateHeateing());
    }

    private void startCooling() {
        containerOperator.setCurrentOperation(containerOperator.getStateCooling());
    }

    @Override
    public void tm(int x) {
        System.out.println("\tWAITING "+x+" SECONDS...");
    }

    @Override
    public void TempChanged(double r, double c) {
        if(waitOver) {
            if (containerOperator.isCool() && r >= c + 2) {
                exit();
            } else if (!containerOperator.isCool() && r <= c - 2) {
                exit();
            }
        }

    }

}
