package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        /*
            The Program based on State Design Pattern
            https://en.wikipedia.org/wiki/State_pattern

         */
        System.out.println("prints the example");
        System.out.println("\t**********************************");
        AirConditioner ac = new AirConditioner();
        boolean PlayGame=true;
        ac.on();
        ac.setR_temp(27);
        ac.setC_temp(33);
        ac.off();
        System.out.println("\t**********************************\n\n");
        System.out.println("Thank you for choosing Torrrrnado!");
        Scanner in = new Scanner(System.in);
        int temp;
        int option;
        while(PlayGame) {
            printMenu();
            option = in.nextInt();
            switch (option){
                case 1:
                    ac.on();
                    break;
                case 2:
                    System.out.println("insert Temperture (int type)");
                    temp = in.nextInt();
                    ac.setR_temp(temp);
                    break;
                case 3:
                    System.out.println("insert Temperture (int type)");
                    temp = in.nextInt();
                    ac.setC_temp(temp);
                    break;
                case 4:
                    ac.off();
                    break;
                case 5:
                    ac.setElectricity(false);
                    break;
                case 6:
                    ac.setElectricity(true);
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    PlayGame = false;
                    break;
                case 10:
                    System.out.println("Chosen temp"+ac.C_temp);
                    System.out.println("Room temp"+ac.R_temp);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    public static void printMenu() {
        System.out.println("\n\n\n\n\nwhat would you like to do?");
        System.out.println("\t1. Turn on the AirConditioner");
        System.out.println("\t2. setR_temp");
        System.out.println("\t3. setC_temp");
        System.out.println("\t4. turn off ac");
        System.out.println("\t5. Electricity fall off");
        System.out.println("\t6. Turn on electricity");
        System.out.println("\t7. close program");
    }
}
