package com.company.SystemStatus;
import com.company.AirConditioner;
import com.company.Modes.Mode;
import com.company.State;
public class On implements State {


    AirConditioner owner;
    private final Mode stateMode = new Mode(this);
    private final State stateOperation = new com.company.Operations.Operation(this);

    public On(AirConditioner owner) {
        this.owner = owner;
    }

    @Override
    public void entry() {
        System.out.println("ON");
        stateMode.entry();
        stateOperation.entry();
    }

    @Override
    public void exit() {
        owner.setCurrentState(owner.getStateOff());
    }

    @Override
    public void tm(int x) {

    }

    @Override
    public void TempChanged(double r, double c){
        stateMode.TempChanged(r,c);
        stateOperation.TempChanged(r,c);
    }
    public AirConditioner getOwner() {
        return owner;
    }
    public boolean isCool(){
       return stateMode.isCool();
    };
}