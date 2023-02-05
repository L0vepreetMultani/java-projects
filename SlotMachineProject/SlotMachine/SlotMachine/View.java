import SlotMachineProject.SlotMachine;

import java.util.*;

/**
* Implementation of a View class to show the SlotMachines
* @Lovepreet singh(000848567)
*/
public class View{
    
    /** Function to show the data in Histogram format */
    static void showHistogram(int[] his){

        /** variable to get the max Frequency */
        int maxFreq = 0;

        /** Obtain the Max Frequency */
        for(int i = 0; i < his.length; i++){
            if(his[i] > maxFreq){
                maxFreq = his[i];
            }
        }

        /** max Freq / 50 */
        int unit = (int)maxFreq / 50;

        /** Print the Histogram */
        for(int i = 0; i < his.length; i++){
            System.out.print("\t" + i + "\t" + his[i] + "\t\t");
            int lenHis = (int) his[i] / unit;
            for(int m = 0; m < lenHis; m++){
                System.out.print("*");
            }System.out.print("\n");
        }
        return;
    }


    /** Main Method is called when this File is executed */
    public static void main(String args[]){

        /** Show Menu */
        System.out.println("Choose a machine : ");
        System.out.println("Machine 1 is colorful and has 5 wheels with 9 faces.");
        System.out.println("Machine 2 is monochrome and has 7 wheels with 7 faces.");
        
        /** option variable to store the input */
        int option = 1;
        Scanner sc= new Scanner(System.in);
        option = sc.nextInt();

        /** Instance of Slot Machine */
        SlotMachine slotMachine;
        String[] labels;

        /** Temporary Initialization of Variables */
        labels = new String[]{"Strawberry", "Banana", "Kiwi", "Apple", "Orange"};
            slotMachine = new SlotMachine(5, labels);

        /** If machine 1 is Selected */
        if(option == 1){
            labels = new String[]{"Strawberry", "Banana", "Kiwi", "Apple", "Orange", "Watermelon", "Pear", "Grape", "Nectarine"};
            slotMachine = new SlotMachine(5, labels);
        }
        /** If machine 2 is Selected */
        else if(option == 2){
            labels = new String[]{"Strawberry", "Banana", "Kiwi", "Apple", "Orange", "Pear", "Grape"};
            slotMachine = new SlotMachine(7, labels);
        }

        /** Show Spin Menu */
        System.out.println("1=spin. 2=lotsa spins. 3=no more spins.");
        option = sc.nextInt();

        /** Show Menu in infinite Mode */
        while(option != 3){
            if(option == 1){
                
                /** Single Spin and Show Payout */
                slotMachine.spinSlotMachine();
                String res = slotMachine.toString();
                System.out.println(res);
            }else if(option == 2){

                /** Spin the Machine for 1 Million times and show Histogram */
                int[] his = slotMachine.histogramMethod(1000000);
                showHistogram(his);
                String res = slotMachine.toString();
                System.out.println(res);
            }
            option = sc.nextInt();
        }

        /** Final Concluding Message */
        System.out.println("Bye!");
    }
}
