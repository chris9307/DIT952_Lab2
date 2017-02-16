package dit952.lab2;

import java.util.ArrayList;

/**
 * Created by User on 2017-02-16.
 */
public class CarModel {

    ArrayList<Car> cars = new ArrayList<>();

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
        if (car.dir == Car.Direction.RIGHT) {
            return car.currentSpeed + car.getXPos() > 700;
        } else if (car.dir == Car.Direction.LEFT) {
            return -car.currentSpeed + car.getXPos() <= 0;
        } else if (car.dir == Car.Direction.UP) {
            return -car.currentSpeed + car.getYPos() <= 0;
        } else {
            return car.currentSpeed + car.getYPos() > 700;
        }
    }
}

