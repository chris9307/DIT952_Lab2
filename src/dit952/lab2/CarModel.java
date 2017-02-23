package dit952.lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by User on 2017-02-16.
 */
public class CarModel {

    ArrayList<Car> cars = new ArrayList<>();
    Timer timer;

    public CarModel(Timer timer) {
        this.timer = timer;
        actionPerformed();
    }

    public void actionPerformed(){
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateModel();
            }
        });
    }

    public void updateModel() {
        for (Car car : cars) {
            if (checkCollision(car)) {
                car.stopEngine();
                car.turnRight();
                car.turnRight();
                car.startEngine();
            }
            car.move();
        }
    }

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
        for (Car car : cars) {
            if (car.modelName.equals("Scania")) {
                ((Scania) car).increaseAngle();
            }
        }
    }

    void lowerPlatform() {
        for (Car car : cars) {
            if (car.modelName.equals("Scania")) {
                ((Scania) car).decreaseAngle();
            }
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car.modelName.equals("Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car.modelName.equals("Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void startButton() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopButton() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    boolean checkCollision(Car car) {
        if (car.stateDirection instanceof StateRight) {
            return car.currentSpeed + car.getXPos() > 700;
        } else if (car.stateDirection instanceof StateLeft) {
            return -car.currentSpeed + car.getXPos() <= 0;
        } else if (car.stateDirection instanceof StateUp) {
            return -car.currentSpeed + car.getYPos() <= 0;
        } else {
            return car.currentSpeed + car.getYPos() > 700;
        }
    }
}

