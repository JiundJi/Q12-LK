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

public class Vokabelstatistik extends JDialog {
  // Anfang Attribute
  private JLabel lStatistik = new JLabel();
  private Canvas canvas1 = new Canvas();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JButton bZurueck = new JButton();
  // Ende Attribute
  
  public Vokabelstatistik(JFrame owner, boolean modal) { 
    // Dialog-Initialisierung
    super(owner, modal);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 340; 
    int frameHeight = 260;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Vokabelstatistik");
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lStatistik.setBounds(36, 16, 270, 36);
    lStatistik.setText("Statistik");
    lStatistik.setHorizontalAlignment(SwingConstants.CENTER);
    lStatistik.setFont(new Font("Dialog", Font.BOLD, 18));
    lStatistik.setForeground(Color.WHITE);
    cp.add(lStatistik);
    cp.setBackground(new Color(0x404040));
    canvas1.setBounds(25, 56, 290, 120);
    canvas1.setBackground(Color.GRAY);
    cp.add(canvas1);
    jTextArea1ScrollPane.setBounds(38, 64, 264, 100);
    cp.add(jTextArea1ScrollPane);
    bZurueck.setBounds(187, 186, 123, 25);
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
  } // end of public Vokabelstatistik
  
  // Anfang Methoden
  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    this.dispose();
  } // end of bZurueck_ActionPerformed

  // Ende Methoden
  
} // end of class Vokabelstatistik

