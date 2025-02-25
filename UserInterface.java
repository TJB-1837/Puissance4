import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JButton[] buttons;
    private Engine aEngine;
    private JPanel gridPanel;
    private Grid aGrid;
    private CircleCell[][] displayedCells; // Stocke les cellules affichées

    public UserInterface(final Engine pEngine) {
        this.aEngine = pEngine;
        this.aGrid = this.aEngine.getGrid();  // Récupérer la grille de Engine
        this.displayedCells = this.aGrid.getGrid(); // Lier les cellules affichées à celles du modèle
        this.createUI();
    }

    public void createUI() {
        this.frame = new JFrame("Puissance4");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);

        JLayeredPane layeredPane = new JLayeredPane();
        frame.setContentPane(layeredPane);

        // Label
        label = new JLabel("Clique sur l'un des boutons bleus pour jouer au Puissance 4 !", SwingConstants.CENTER);
        label.setBounds(0, 20, 770, 40);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.BLUE);
        layeredPane.add(label, new Integer(2));

        // **Grille affichée**
        gridPanel = new JPanel(new GridLayout(6, 7, 10, 5));
        gridPanel.setBounds(35, 70, 700, 600);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                gridPanel.add(displayedCells[i][j]); // Utiliser les cellules de Grid
            }
        }
        gridPanel.setBackground(Color.BLUE);
        layeredPane.add(gridPanel, new Integer(1));

        // **Boutons**
        JPanel buttonPanel = new JPanel(new GridLayout(1, 7, 10, 5));
        buttonPanel.setBounds(35, 680, 700, 80);
        buttonPanel.setBackground(Color.BLACK);

        buttons = new JButton[7];

        for (int i = 0; i < 7; i++) {
            buttons[i] = new JButton("");
            buttons[i].setBackground(Color.BLUE);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        layeredPane.add(buttonPanel, new Integer(0));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource().equals(buttons[i])) {
                this.aEngine.move(i);
                refreshGrid(); // Mettre à jour l'affichage
                break;
            }
        }
    }

    public void afficheVictoire(int pId){
        this.frame = new JFrame("Puissance4");
        frame.setSize(470, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        frame.setContentPane(layeredPane);

        frame.setBackground(Color.BLACK);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\thado\\IdeaProjects\\Puissance4\\src\\victoire.jpg");
        Image image = originalIcon.getImage().getScaledInstance(470, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        // Création du JLabel contenant l'image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 470, 300); // Position (x=100, y=50) et taille (300x200)
        imageLabel.setIcon(resizedIcon);

        // Ajout de l'image au panneau
        layeredPane.add(imageLabel, new Integer(2));

        JLabel label1 = new JLabel("Le joueur "+pId+" a gagné ! ", SwingConstants.CENTER);
        label1.setBounds(0, 0, 470, 40);
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setForeground(Color.BLUE);

        layeredPane.add(label1, new Integer(1));

        frame.setVisible(true);
    }

    // **Méthode pour rafraîchir la grille après chaque coup**
    public void refreshGrid() {
        gridPanel.repaint(); // Redessine la grille
    }

    public void enable(final boolean pOnOff){
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setEnabled(pOnOff);
        }
    }
}
