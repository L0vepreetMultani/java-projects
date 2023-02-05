package HeadOrTail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


/**
 * This file act as the view for the coin model by providing graphical user interface to the coin problem as a coin object.The purpose of this is to give bascis understanding of GUI
 *
 * @author Lovepreet singh,000848567,13-03-2022.
 */
public class View extends Application {

    // TODO: Instance Variables for View Components and Model
    private Label coinFace;//face of the coin at end
    private Label numberofFlip;
    private TextField numberOfFlips;//number of flips user wants to happen
    private double headsCount = 0.0;//no of times face of the coin was heads
    private double tailsCount = 0.0;//no of times face of the coin was tails
    private Label tailCount;//the label for number of tails at last
    private Label headCount;//the label for number of Heads at last

    private Coin coin1 = new Coin();//coin1 object


    // TODO: Private Event Handlers and Helper Methods
    //one event method that happens when flip button is clicked
    private void onEvent(ActionEvent e) {
        try {
            int n = Integer.parseInt(numberOfFlips.getText());

        for (int i = 0; i < n; i++) {
            coin1.coinFlip();


            String result = coin1.getResult();
            System.out.println(result);


            if (result.compareToIgnoreCase("HEAD") == 0) {
                headsCount++;

                headCount.setStyle("-fx-text-fill: Green");
                tailCount.setStyle("-fx-text-fill: Red");

            } else if (result.compareToIgnoreCase("TAIL") == 0) {
                tailsCount++;
                tailCount.setStyle("-fx-text-fill: Green");
                headCount.setStyle("-fx-text-fill: Red");
            }
            System.out.println(headsCount + "  " + tailsCount);
            coinFace.setText("CoinFace " + result);
            tailCount.setText("Tails:" + tailsCount);
            headCount.setText("Heads" + headsCount);

        }
        numberOfFlips.requestFocus();
        numberofFlip.setText("Enter number of flips");
        numberOfFlips.setText("");}
catch (Exception exc) {
            numberofFlip.setText("write a valid " +
                    "positive integer");
        }
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 150); // set the size here
        stage.setTitle("Coin flip game"); // set the window title here
        stage.setScene(scene);

        // TODO: Add your GUI-building code here

        // 1. Create the model


        // 2. Create the GUI components
        //label  that tells the face of coin that lands on  last flip
        coinFace = new Label("coin Face: None");

        //the label that counts tails
        tailCount = new Label("Total tails : None");

       // the label that counts heads
        headCount = new Label("Total heads : None");

        // the label that asks for number of flips
        numberofFlip = new Label("Enter number of flips");

        //field that gets the number of flips
        numberOfFlips = new TextField("");

        //flip button that starts the onEvent method
        Button FlipButton = new Button("Flip");
        // 3. Add components to the root
        root.getChildren().addAll(coinFace,numberofFlip, numberOfFlips, headCount, tailCount, FlipButton);
        // 4. Configure the components (colors, fonts, size, location)

        //setting the location and the size for the label  that tells the face of coin that lands on  last flip
        coinFace.relocate(10, 90);
        coinFace.setPrefWidth(100);

        //setting the location and the size for the label that counts tails
        tailCount.setPrefWidth(100);
        tailCount.relocate(10, 110);

        //setting the location and the size for the label that counts heads
        headCount.relocate(10, 130);
        headCount.setPrefWidth(100);

        //setting the location and the size for the label that asks for number of flips
        numberofFlip.relocate(90, 4);
        numberofFlip.setPrefWidth(200);

        //setting location and size for the field that gets the number of flips
        numberOfFlips.relocate(100, 20);
        numberOfFlips.setPrefWidth(100);
        numberOfFlips.setPrefHeight(50);

        //setting location for the flip button
        FlipButton.relocate(200, 90);
        FlipButton.setPrefWidth(50);
        FlipButton.setPrefHeight(50);


        // 5. Add Event Handlers and do final setup
        FlipButton.setOnAction(this::onEvent);
        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}