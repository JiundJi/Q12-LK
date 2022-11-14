import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 14.11.2022                                              * @author 
 */

public class Vokabeleingabe extends JDialog {
  // Anfang Attribute
  private JPanel jPanel1 = new JPanel(null, true);
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JLabel lDeutsch = new JLabel();
    private JLabel lEnglisch = new JLabel();
    private JButton bSpeichern = new JButton();
    private Vokabelkasten vk;
    private JButton bZurueck = new JButton();
  // Ende Attribute
  
  public Vokabeleingabe(JFrame owner, boolean modal, Vokabelkasten vk) { 
    // Dialog-Initialisierung
    super(owner, modal);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 380; 
    int frameHeight = 480;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Vokabeleingabe");
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jPanel1.setBounds(28, 40, 308, 372);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    jTextField1.setBounds(22, 93, 262, 28);
    jPanel1.add(jTextField1);
    jTextField2.setBounds(21, 193, 262, 28);
    jPanel1.add(jTextField2);
    lDeutsch.setBounds(22, 56, 110, 20);
    lDeutsch.setText("Deutsch");
    jPanel1.add(lDeutsch);
    lEnglisch.setBounds(21, 160, 110, 20);
    lEnglisch.setText("Englisch");
    jPanel1.add(lEnglisch);
    bSpeichern.setBounds(208, 267, 75, 25);
    bSpeichern.setText("Speichern");
    bSpeichern.setMargin(new Insets(2, 2, 2, 2));
    bSpeichern.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSpeichern_ActionPerformed(evt);
      }
    });
    jPanel1.add(bSpeichern);
    this.vk = vk;
    bZurueck.setBounds(192, 334, 107, 33);
    bZurueck.setText("Zurueck");
    bZurueck.setMargin(new Insets(2, 2, 2, 2));
    bZurueck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck_ActionPerformed(evt);
      }
    });
    jPanel1.add(bZurueck);
    // Ende Komponenten
    
    setResizable(false);
    setVisible(true);
  } // end of public Vokabeleingabe
  
  // Anfang Methoden
  public void bSpeichern_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf?gen
    if (jTextField1.getText() == null || jTextField2.getText() == null) {
      System.out.println("ist null");
    }
    else {
      Vokabel v = new Vokabel(jTextField1.getText(), jTextField2.getText());
      if (vk.addVokabel(v)) {
        jTextField1.setText("");
        jTextField2.setText("");
        return;
      } else {System.out.println("fehler beim speichern");}
    }
  } // end of bSpeichern_ActionPerformed

  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    this.dispose();
  } // end of bZurueck_ActionPerformed

  // Ende Methoden
  
} // end of class Vokabeleingabe
