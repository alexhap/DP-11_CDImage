import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by alex on 02.07.2015.
 *
 */

public class CDImages extends JFrame {
    private ImageComponent imageComponent;

    public CDImages(String title) throws HeadlessException, MalformedURLException {
        super(title);
        Map<String, String> cds = loadURLs();
        URL initialURL = new URL(cds.get("Karma"));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Favourite CDs");
        menuBar.add(menu);
        setJMenuBar(menuBar);

        for (Map.Entry<String, String> cd : cds.entrySet()) {
            JMenuItem menuItem = new JMenuItem(cd.getKey());
            menu.add(menuItem);
            menuItem.addActionListener(e -> {
                try {
                    imageComponent.setIcon(new ImageProxy(new URL(cds.get(e.getActionCommand()))));
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            });
        }

        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        getContentPane().add(imageComponent);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setVisible(true);
    }

    private Map<String, String> loadURLs() {
        Map<String, String> lst = new TreeMap<>();
        lst.put("Ambient: Music for Airports","http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
        lst.put("Buddha Bar","http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        lst.put("Ima","http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        lst.put("Karma","http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        lst.put("MCMXC A.D.", "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        lst.put("Northern Exposure", "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        lst.put("Selected Ambient Works, Vol. 2","http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
        return lst;
    }

    public static void main(String args[]) throws MalformedURLException {
        new CDImages("CD Images");
    }
}
