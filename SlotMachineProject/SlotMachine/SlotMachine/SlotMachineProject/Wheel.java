package SlotMachineProject;

/**
* Implementation of a Wheel class
* @Lovepreet singh(000848567)
*/
public class Wheel {

    /**
    * Variables to store faces and currentFaceIndex
    */
    private String[] faces;
    private int currentFaceIndex;
    private String currentFace;

    /**
    * Constructor to initialize the Wheel Class
    */
    public Wheel(String[] face){
        faces = face;
    }

    /**
    * spin Wheel method to spin the wheel
    * Returns the random index
    */
    public int spinWheel(){
        int min = 0;
        int max = faces.length-1;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        currentFaceIndex = random_int;
        currentFace = faces[random_int];
        return random_int;
    }

    /**
    * get number of faces in wheels
    */
    public int numFaces(){
        return faces.length;
    }

    /**
    * Get the Current Face Number
    */
    public int currentFaceNumber(){
        return currentFaceIndex;
    }

    /**
    * to String method to get the current Face of wheels
    */
    public String toString(){
        return currentFace;
    }


    
}