package HeadOrTail;
import java.util.Random;
/**
 * This file is for the coin model.The provides the bascic logic and algorithm behind coin flip problem by making class Coin and methods like flip Coin
 *
 * @author Lovepreet singh,000848567,13-03-2022.
 */
public class Coin {

        //the coinSide instance variable that tells if heads(0),or tails(1)
        private int coinSide;

        //constructor coin()
        public Coin(){
            coinSide=0;
        }
        //flip method to flip coin
        public void coinFlip(){
            Random flipCoin = new Random();
            coinSide = flipCoin.nextInt(2);
        }
        //get result method to give the string output of "HEAD" or "TAIL"
        public String getResult() {

            if (coinSide==0){
            return  "HEAD";

            }
            else if(coinSide==1){
            return "TAIL";

            }
            else
            {
                return "not right number" + coinSide;
            }


    }
}
