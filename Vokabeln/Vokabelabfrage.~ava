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

public class Vokabelabfrage extends JDialog {
  // Anfang Attribute
  private JLabel lVokabelabfrage = new JLabel();
  private Canvas canvas1 = new Canvas();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JTextField jTextField1 = new JTextField();
  private JButton bUeberpruefen = new JButton();
  private JButton bZurueck = new JButton();
  private JTextArea jTextArea2 = new JTextArea("");
    private JScrollPane jTextArea2ScrollPane = new JScrollPane(jTextArea2);
  private Vokabelkasten vk;
  // Ende Attribute
  public Vokabelabfrage(JFrame owner, boolean modal, Vokabelkasten vk) { 
    // Dialog-Initialisierung
    super(owner, modal);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 390; 
    int frameHeight = 493;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Vokabelabfrage");
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lVokabelabfrage.setBounds(52, 20, 286, 44);
    lVokabelabfrage.setText("Vokabelabfrage");
    lVokabelabfrage.setFont(new Font("Dialog", Font.BOLD, 18));
    lVokabelabfrage.setForeground(Color.WHITE);
    lVokabelabfrage.setHorizontalAlignment(SwingConstants.CENTER);
    lVokabelabfrage.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lVokabelabfrage);
    cp.setBackground(new Color(0x404040));
    canvas1.setBounds(41, 73, 308, 292);
    canvas1.setBackground(Color.GRAY);
    cp.add(canvas1);
    jTextArea1ScrollPane.setBounds(55, 86, 280, 120);
    jTextArea1.setEditable(false);
    jTextArea1.setFont(new Font("Dialog", Font.BOLD, 12));
    jTextArea1.setForeground(Color.WHITE);
    cp.add(jTextArea1ScrollPane);
    jTextField1.setBounds(55, 224, 280, 36);
    cp.add(jTextField1);
    bUeberpruefen.setBounds(198, 268, 139, 33);
    bUeberpruefen.setText("Ueberpruefen");
    bUeberpruefen.setMargin(new Insets(2, 2, 2, 2));
    bUeberpruefen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bUeberpruefen_ActionPerformed(evt);
      }
    });
    cp.add(bUeberpruefen);
    bZurueck.setBounds(218, 386, 131, 33);
    bZurueck.setText("Zurueck");
    bZurueck.setMargin(new Insets(2, 2, 2, 2));
    bZurueck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck_ActionPerformed(evt);
      }
    });
    cp.add(bZurueck);
    jTextArea2ScrollPane.setBounds(57, 313, 280, 36);
    cp.add(jTextArea2ScrollPane);
    // Ende Komponenten

    this.vk = vk;
    setResizable(false);
    setVisible(true);
  } // end of public Vokabelabfrage
  
  // Anfang Methoden
  public void bUeberpruefen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf?gen
    
  } // end of bUeberpruefen_ActionPerformed

  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf?gen
    this.dispose();
  } // end of bZurueck_ActionPerformed

  // Ende Methoden
  
} // end of class Vokabelabfrage

