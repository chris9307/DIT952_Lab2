package dit952.lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0,0));
        cc.cars.add(new Saab95(0,100));
        cc.cars.add(new Scania(0,200));


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        //cc.frame.drawPanel.addVehicle(new Volvo240(40,40));
        // Start the timer
        cc.timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if(checkCollision(car)) {
                    System.out.println(car.getCurrentSpeed());
                    car.stopEngine();
                    car.turnRight();
                    car.turnRight();
                    car.startEngine();
                }
                car.move();
                System.out.println(car.currentSpeed);
                int x = (int) Math.round(car.getXPos());
                int y = (int) Math.round(car.getYPos());
                frame.drawPanel.moveit(x,y,cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void liftPlatform() {
        for(Car car :cars) {
            if(car.modelName.equals("Scania")) {
                ((Scania) car).increaseAngle();
            }
        }
    }

    void lowerPlatform() {
        for(Car car : cars) {
            if(car.modelName.equals("Scania")) {
                ((Scania) car).decreaseAngle();
            }
        }
    }

    void turboOn() {
        for(Car car : cars) {
            if(car.modelName.equals("Volvo240")){
                ((Volvo240) car).turboOn=true;
            }
        }
    }

    void turboOff() {
        for(Car car : cars) {
            if(car.modelName.equals("Volvo240")){
                ((Volvo240) car).turboOn=false;
            }
        }
    }

    void startButton() {
        for(Car car : cars) {
            car.startEngine();
        }
    }

    void stopButton() {
        for(Car car : cars) {
            car.stopEngine();
        }
    }

    boolean checkCollision(Car car) {
        if(car.dir == Vehicle.Direction.RIGHT){
            return car.currentSpeed + car.getXPos() > 700;
        } else if(car.dir == Vehicle.Direction.LEFT) {
            return -car.currentSpeed + car.getXPos() <= 0;
        }else if(car.dir == Vehicle.Direction.UP) {
            return -car.currentSpeed + car.getYPos() <= 0;
        } else {
            return car.currentSpeed + car.getYPos() > 700;
        }
    }
}
