import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private JFrame frame;

    public MyFrame() {
        this.frame = new JFrame( "Puissance4" ); // change the title !
        frame.setSize(1200, 800);  // Taille de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ferme l'application à la fermeture de la fenêtre
        frame.setVisible(true);  // Rend la fenêtre visible

    }
}
