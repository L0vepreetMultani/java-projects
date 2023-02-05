package SlotMachineProject;



/**
 *
* Implementation of a Slotmachine class to show the Wheels
* lovepreet singh(000848567)
*/
public class SlotMachine {

    /** Variables to store Wheels */
    private Wheel[] wheels;
    private int numWheels;

    /** Variable to store faces in the wheels */
    private String[] faces;
    private int numFaces;

    /** Variable to store the Output of the wheels */
    private int[] output;
    private int currentPayOut;

    /**
    * Method to initialize the SlotMachine Class
    */
    public SlotMachine(int numWheel, String[] fac){
        // Assign the face and numWheels
        faces = fac;
        numWheels = numWheel;
        numFaces = faces.length;

        // Instanciate the wheels
        wheels = new Wheel[numWheels];
        for(int j = 0; j < numWheels; j++){
            wheels[j] = new Wheel(faces);
        }

        // Initiate the Wheels
        spinSlotMachine();
    }

    /**
    * Method to get random spins in the wheels
    */
    public int spinSlotMachine(){
        output = new int[numWheels];
        int[] frequency = new int[numFaces];
        for(int j = 0; j<numFaces; j++){
            frequency[j] = 0;
        }

        for(int i = 0; i<numWheels; i++){
            output[i] = wheels[i].spinWheel();
            
            // update the frequency array
            frequency[output[i]] += 1;
        }

        int maxFreq = 0;
        for(int i = 0; i<numFaces; i++){
            if(maxFreq < frequency[i]){
                maxFreq = frequency[i];
            }
        }
        currentPayOut = maxFreq-1;
        return maxFreq-1;
    }

    /**
    * toString Method to show the state of SlotMachine 
    */
    public String toString(){
        // number of wheels
        String ret = "SlotMachine! (" + numWheels + " Wheels, " + numFaces + " faces)\n";
        ret += "wheels = [";
        // current State of each wheel
        for(int i = 0; i < numWheels; i++){
            if(i != 0){
                ret += ", ";
            }
            ret += faces[output[i]];
        }

        // current payout 
        ret += "]\nPayout = " + currentPayOut + "\n";
        return ret;
    }

    /**
    * Method to spin the slot machine multiple times
    * to the number of time
    * returns the Frequency Array
    */
    public int[] histogramMethod(int numChances){
        int[] freq = new int[numWheels];

        for(int i = 0; i<numWheels; i++){
            freq[i] = 0;
        }

        for(int count = 0; count < numChances; count++){
            freq[spinSlotMachine()] += 1;
        }

        return freq;
    }
}
