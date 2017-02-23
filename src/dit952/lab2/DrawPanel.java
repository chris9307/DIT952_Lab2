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
    Point[] vehiclePoints = new Point[10];

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, int index){
        vehiclePoints[index].x =x;
        vehiclePoints[index].y =y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.model = model;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        for(int i = 0; i<vehiclePoints.length;i++) {
            vehiclePoints[i] = new Point(1,1);
        }
        vehicleImages.add(saabImage);
        vehicleImages.add(scaniaImage);
        vehicleImages.add(volvoImage);


    }



    public void addImage(Car car) {
        if(car instanceof Volvo240) {
            vehicleImages.add(volvoImage);
        } else if(car instanceof Saab95) {
            vehicleImages.add(saabImage);
        } else {
            vehicleImages.add(scaniaImage);
        }
    }

    public void removeImage(){
        vehicleImages.remove(vehicleImages.size()-1);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i<vehicleImages.size();i++) {
            g.drawImage(vehicleImages.get(i), vehiclePoints[i].x, vehiclePoints[i].y, null); // see javadoc for more info on the parameters
        }
    }
}
