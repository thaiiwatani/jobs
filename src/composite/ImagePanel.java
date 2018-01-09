package composite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel(String url) {
       try {                
          image = ImageIO.read(new File(url));
       } catch (IOException ex) {
            // handle exception...
    	   System.out.println("aaaaaaaaaa");
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 1, 0, this); // see javadoc for more info on the parameters            
    }

}