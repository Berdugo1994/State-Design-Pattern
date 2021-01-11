package com.company.Operations;
import com.company.State;
import com.company.SystemStatus.On;

public class  Operation implements State {
    On containerOn;
    State stateFanning = new Fanning(this);
    State stateCooling = new Cooling(this);
    State stateHeateing = new Heating(this);
    State currentOperation;

    public Operation(On containerOn) {
        this.containerOn = containerOn;
    }

    public void entry(){
        currentOperation = stateFanning;
        currentOperation.entry();
    }
    public void exit(){

    }
    public Boolean isCool(){
        return containerOn.isCool();
    }

    public On getContainerOn() {
        return containerOn;
    }

    public State getStateFanning() {
        return stateFanning;
    }

    public void setStateFanning(State stateFanning) {
        this.stateFanning = stateFanning;
    }

    public State getStateCooling() {
        return stateCooling;
    }

    public void setStateCooling(State stateCooling) {
        this.stateCooling = stateCooling;
    }

    public State getStateHeateing() {
        return stateHeateing;
    }

    public void setStateHeateing(State stateHeateing) {
        this.stateHeateing = stateHeateing;
    }

    public State getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(State currentOperation) {
        this.currentOperation = currentOperation;
        currentOperation.entry();
    }

    @Override
    public void tm(int x) {

    }

    @Override
    public void TempChanged(double r, double c) {
        currentOperation.TempChanged(r,c);
    }
//    public void Do(){//Func name not available with do - kept word.
//        System.out.println("error");
//    }
//    public void tempChanged(int option){
//        if (currentOperation == operationStates[option]){return;}// if its already in this case
//        if (currentOperation!= null){
//            if(currentOperation==operationStates[0] && ((Fanning) currentOperation).waitOver && option!=0)
//            {
//                currentOperation.exit();
//                currentOperation = operationStates[option];
//                currentOperation.entry();
//            }
//            else if (currentOperation == operationStates[1] || currentOperation == operationStates[2] && currentOperation != operationStates[option]){
//                // we are heating/cooling and we asked for the opposit !
//                currentOperation.exit();
//                currentOperation=operationStates[0]; // fanning
//                currentOperation.entry();
//                if(option != 0 ) { // if its not setted to fanning just now
//                    currentOperation.exit();
//                    currentOperation = operationStates[option];
//                    currentOperation.entry();
//                }
//            }
//        }
//        else{
//            currentOperation=operationStates[option];
//            currentOperation.entry();
//        }
//    }
}
