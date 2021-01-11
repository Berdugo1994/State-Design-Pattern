package com.company;
import com.company.SystemStatus.Off;
import com.company.SystemStatus.On;
import com.company.SystemStatus.Wait;

public class AirConditioner {
    /*
    Modes are Off , Wait
                ON-Cool
                ON-Heat
     */
    public double C_temp;
    public double R_temp;
    private State currentState;
    private final State stateOff = new Off(this);
    private final State stateWait = new Wait(this);
    private final State stateOn = new On(this);
    private boolean electricity;


    public AirConditioner() {
        electricity=true;
        currentState = stateOff;
        currentState.entry();
    }
    public State getCurrentState() {
        return currentState;
    }

    public void on(){
        /*
        This is an external command,
        if system is on - it will turn off !
        if system is off - it will turn on !
         */

        if(electricity)
        {
            currentState.exit();
        }
        else{
            System.out.println("can't do nothing when electricity is off...");
        }
    }
    public void off(){
        /*
        This is an external command
         */
        if (currentState == stateOff) {
            System.out.println("System already off...");
        }
        else{
            currentState = stateOff;
            currentState.entry();
        }
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        currentState.entry();
    }

    public double getC_temp() {
        return C_temp;
    }

    public void setC_temp(double c_temp) {
        if(!electricity ){
            System.out.println("cant change Choose temp while electricity is off...");
            return;
        }
        else if( currentState==stateOff){
            System.out.println("cant change temp while ac is off..");
            return;
        }
        C_temp = c_temp;
        System.out.println("set c_temp to "+c_temp);
        currentState.TempChanged(getR_temp(), c_temp);
    }

    public double getR_temp() {
        return R_temp;
    }

    public void setR_temp(double r_temp) {
        if(!electricity ){
            System.out.println("cant change Room temp while electricity is off...");
            return;
        }
        else if( currentState==stateOff){
            System.out.println("cant change temp while ac is off..");
            return;
        }
        R_temp = r_temp;
        System.out.println("set r_temp to "+r_temp);
        currentState.TempChanged(r_temp, this.getC_temp());
    }





    public State getStateOff() {
        return stateOff;
    }

    public State getStateWait() {
        return stateWait;
    }

    public State getStateOn() {
        return stateOn;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        if (!this.electricity) { // was no
            if (electricity) {//and now yes
                this.electricity = electricity;
                currentState = stateOff;
                currentState.entry();
            } else {//was no and still no
                System.out.println("electricity was already off...");
            }
        }
        else{//was electricity
            if(electricity){//and still on
                System.out.println("electricity was already on...");
            }
            else{//now electricity is off
                this.electricity=electricity;
                currentState = stateOff;
            }

        }
    }



//    public void on(){
//        if (!electricity){
//            System.out.println("The electricity is still off, cant turn the ac..");
//            return;
//        }
//
//        else{
//            currentState.onClicked();
//        }
//    }
//
//    public void off(){
//        if (!electricity){
//            System.out.println("The electricity is still off, cant do nothing...");
//            return;
//        }
//        if (currentState != states[0]){
//            currentState.exit();
//            currentState = states[0];
//            currentState.entry();
//        }
//    }
//
//
//    public void setR_temp(double temp){
//        if(currentState== states[2]) {
//            System.out.println("set r_temp to " + temp);
//            this.R_temp = temp;
//            ((On) states[2]).tempChanged();
//        }
//        else{
//            System.out.println("You must turn the ac before changing the temps..");
//        }
////        R_temp=temp;//If we would like to set room temp always to choosen
//    }
//
//    public void setC_temp(double temp) {
//        if (currentState == states[2]) {
//            System.out.println("set c_temp to " + temp);
//            this.C_temp = temp;
//            ((On) states[2]).tempChanged();
//        }
//        else {
//            System.out.println("You must turn the ac before changing the temps..");
//        }
//    }
//    public void ElectricityOff(){
//        off();
//        electricity=false;
//    }
//
//    public void ElectricityOn() {
//        if(electricity){
//            System.out.println("Electricity is already on...");
//        }
//        electricity=true;
//        currentState=states[0];
//        currentState.entry();
//    }
}