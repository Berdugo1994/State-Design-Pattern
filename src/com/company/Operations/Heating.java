package com.company.Operations;
import com.company.Action;
import com.company.State;

public class Heating implements State, Action {
    Operation containerOperator;
    public Heating(Operation containerOperator) {
        this.containerOperator = containerOperator;
    }

    @Override
    public void entry() {
        System.out.println("OPERATION-HEATING");
        Do();
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
        if(!containerOperator.isCool() &&  r>=c+2 )exit(); // did more than you should..
        if(containerOperator.isCool())exit();//Shouldnt be here ! we suppose to cool
    }

    @Override
    public void Do() {

    }
}
