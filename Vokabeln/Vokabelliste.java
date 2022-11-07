import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2022
 * @author 
 */

public class Vokabelliste extends JDialog {
  // Anfang Attribute
  private JLabel lVokabelliste = new JLabel();
  private Canvas canvas1 = new Canvas();
  private JTextField jTextField1 = new JTextField();
  private JButton bZurueck = new JButton();
  // Ende Attribute
  
  public Vokabelliste(JFrame owner, boolean modal) { 
    // Dialog-Initialisierung
    super(owner, modal);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 560; 
    int frameHeight = 498;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Vokabelliste");
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lVokabelliste.setBounds(145, 27, 270, 52);
    lVokabelliste.setText("Vokabelliste");
    lVokabelliste.setHorizontalAlignment(SwingConstants.CENTER);
    lVokabelliste.setHorizontalTextPosition(SwingConstants.CENTER);

    lVokabelliste.setFont(new Font("Dialog", Font.BOLD, 18));
    lVokabelliste.setForeground(Color.WHITE);
    cp.add(lVokabelliste);
    cp.setBackground(new Color(0x404040));
    canvas1.setBounds(54, 80, 452, 300);
    canvas1.setBackground(Color.GRAY);
    cp.add(canvas1);
    jTextField1.setBounds(93, 115, 374, 228);
    cp.add(jTextField1);
    bZurueck.setBounds(327, 408, 203, 33);
    bZurueck.setText("Zurück");
    bZurueck.setMargin(new Insets(2, 2, 2, 2));
    bZurueck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck_ActionPerformed(evt);
      }
    });
    cp.add(bZurueck);
    // Ende Komponenten
    
    setResizable(false);
    setVisible(true);
  } // end of public Vokabelliste
  
  // Anfang Methoden
  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    this.dispose();
  } // end of bZurueck_ActionPerformed

  // Ende Methoden
  
} // end of class Vokabelliste

