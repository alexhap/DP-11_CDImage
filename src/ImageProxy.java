/**
 * Created by alex on 02.07.2015.
 *
 */

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    private ImageIcon imageIcon;
    private URL imageURL;
    boolean downloadActive;

    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null)
            imageIcon.paintIcon(c, g, x, y);
        else {
            g.drawString("Loading image...", x + 100, y + 100);
            if (!downloadActive) {
                downloadActive = true;
                Thread imageDownloaderThread = new Thread(() -> {
                    imageIcon = new ImageIcon(imageURL, "CD cover");
                    c.repaint();
                });
                imageDownloaderThread.start();
            }
        }
    }

    public int getIconWidth() {
        if (imageIcon != null) return imageIcon.getIconWidth();
        else return 800;
    }

    public int getIconHeight() {
        if (imageIcon != null) return imageIcon.getIconHeight();
        else return 600;
    }
}
