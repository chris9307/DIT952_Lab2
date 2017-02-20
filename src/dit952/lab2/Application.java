package dit952.lab2;

import javax.swing.*;

/**
 * Created by chrba on 2017-02-20.
 */
public class Application {
    public static void main(String[] args) {
        // Instance of this class
        Timer timer = new Timer(50, new TimerListener());
        CarModel model = new CarModel(timer);
        CarView view = new CarView("CarSim 1.0", model, timer);
        CarController cc = new CarController(view, model);
        timer.start();

        model.cars.add(new Volvo240(0,0));
        model.cars.add(new Saab95(0,100));
        model.cars.add(new Scania(0,200));

    }
}
