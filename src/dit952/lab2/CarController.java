package dit952.lab2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    CarView view;
    CarModel model;

    public CarController(CarView view,CarModel model) {
        this.view = view;
        this.model = model;
        addActionListnerToButtons();
    }
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    CarView frame;

    //methods:
    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarView view = new CarView("CarSim 1.0",model);
        CarController cc = new CarController(view, model);

        model.cars.add(new Volvo240(0,0));
        model.cars.add(new Saab95(0,100));
        model.cars.add(new Scania(0,200));
        // Start a new view and send a reference of self
        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.updateModel();
            view.updateView();
        }
    }

    private void addActionListnerToButtons() {
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        view.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(view.gasAmount);
            }
        });

        view.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.brake(view.gasAmount);
            }
        });

        view.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftPlatform();
            }
        });


        view.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerPlatform();
            }
        });

        view.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOn();
            }
        });

        view.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });

        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startButton();
            }
        });

        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopButton();
            }
        });

        view.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                view.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }
}
