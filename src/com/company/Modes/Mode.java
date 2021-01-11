package com.company.Modes;
import com.company.State;

public class Mode implements State {
    State containerOn;
    State currentMode;
    private State stateCool = new Cool(this);
    private State stateHeat = new Heat(this);

    public Mode(State onstate) {
        this.containerOn = onstate;
    }

    @Override
    public void entry() {
        currentMode = stateCool;
        currentMode.entry();
    }

    @Override
    public void exit() {

    }

    @Override
    public void tm(int x) {

    }

    public State getStateCool() {
        return stateCool;
    }

    public State getStateHeat() {
        return stateHeat;
    }

    public State getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(State currentMode) {
        this.currentMode = currentMode;
        currentMode.entry();
    }

    @Override
    public void TempChanged(double r, double c) {
        currentMode.TempChanged(r,c);
    }

    public boolean isCool(){
        return currentMode==stateCool;
    }
}

//
//    /**
//     * @param modeNum : can be 0-Cool mode or 1-Heat mode
//     */
//    public void setMode(int modeNum){
//        currentMode = modeStates[modeNum];
//    }
//
//
//
////    @Override
////    public void entry() {
////        currentMode=modeStates[0];
////        currentMode.entry();
////    }
////    public void tempChanged(){
////        if((currentMode == modeStates[0]) && (containerOn.getC_Temp()>containerOn.getR_Temp()+5)){//Cooling mode
////            currentMode.exit();
////            currentMode=modeStates[1];
////            currentMode.entry();
////        }
////        else if((currentMode == modeStates[1] && containerOn.getC_Temp()<containerOn.getR_Temp()+5)){
////            currentMode.exit();
////            currentMode=modeStates[0];
////            currentMode.entry();
////        }
////        ChangeByOn=false;
////    }
////
////    @Override
////    public void exit() {
////    }
//}
