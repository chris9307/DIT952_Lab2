package dit952.lab2;

import javax.swing.*;

/**
 * Created by chrba on 2017-02-20.
 */
public class Application {
    public static void main(String[] args) {
        // Instance of this class
        final int delay = 50;
        Timer timer = new Timer(delay, new TimerListener());
        CarModel model = new CarModel(timer);
        CarView view = new CarView("CarSim 1.0", model, timer);
        CarController cc = new CarController(view, model);


        model.cars.add(CarFactory.createVolvo240(100,100));
        model.cars.add(CarFactory.createSaab95(0,0));
        model.cars.add(CarFactory.createScania(200,200));
        timer.start();
    }
}
