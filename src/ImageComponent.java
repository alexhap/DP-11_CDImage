/**
 * Created by alex on 02.07.2015.
 *
 */

import javax.swing.*;
import java.awt.*;

public class ImageComponent extends JComponent {
    private Icon icon;

    public ImageComponent(Icon icon) {
        this.icon = icon;
    }
    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (800 - icon.getIconWidth()) >> 1;
        int y = (600 - icon.getIconHeight()) >> 1;
        icon.paintIcon(this, g, x, y);
    }
}
