package dit952.lab2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    CarModel model;
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    ArrayList<BufferedImage> vehicleImages = new ArrayList<>();
    //Point[] vehiclePoints = new Point[10];
    ArrayList<Point> vehiclePoint = new ArrayList<>(10);


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.model = model;
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(new File("DIT952_Lab2\\src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("DIT952_Lab2\\src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("DIT952_Lab2\\src\\pics\\Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        /*
        for(int i = 0; i<vehiclePoints.length;i++) {
            vehiclePoints[i] = new Point(1,1);
        }

        for(int i = 0; i<3;i++) {
            vehiclePoint.add(new Point(model.cars.get(i).x, model.cars.get(i).y));
        }

        */

        //vehicleImages.add(saabImage);
        //vehicleImages.add(scaniaImage);
        //vehicleImages.add(volvoImage);

        for(Car car : model.cars) {
            addImage(car);
            vehiclePoint.add(new Point(car.x,car.y));
            System.out.println(car.modelName);
        }
    }

    void moveit(int x, int y, int index){
        //vehiclePoint.get(index).setLocation(new Point(x,y));
        System.out.println("hello");
        vehiclePoint.get(index).setLocation(new Point(model.cars.get(index).getXPos(),model.cars.get(index).getYPos()));
    }

    public void addImage(Car car) {
        if(vehicleImages.size()<=10) {
            if (car instanceof Volvo240) {
                vehicleImages.add(volvoImage);
            } else if (car instanceof Saab95) {
                vehicleImages.add(saabImage);
            } else {
                vehicleImages.add(scaniaImage);
            }
        }
    }

    public void removeImage(){
        if(vehicleImages.size()>0) {
            vehicleImages.remove(vehicleImages.size() - 1);
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i<vehicleImages.size()-1;i++) {
            g.drawImage(vehicleImages.get(i), vehiclePoint.get(i).x, vehiclePoint.get(i).y, null); // see javadoc for more info on the parameters
        }
    }
}
