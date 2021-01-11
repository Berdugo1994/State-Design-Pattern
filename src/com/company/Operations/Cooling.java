package com.company.Operations;
import com.company.Action;
import com.company.State;

public class Cooling implements State, Action {
    Operation containerOperator;

    public Cooling(Operation containerOperator) {
        this.containerOperator = containerOperator;
    }

    @Override
    public void entry() {
        System.out.println("OPERATION-COOLING");
    }

    @Override
    public void exit() {
        containerOperator.setCurrentOperation(containerOperator.getStateFanning());
    }

    @Override
    public void tm(int x) {

    }

    @Override
    public void TempChanged(double r, double c) {
        if(containerOperator.isCool() &&  r<=c-2 )exit();
        if(!containerOperator.isCool())exit();
    }

    @Override
    public void Do() {
        System.out.println("Show2");
    }
}
