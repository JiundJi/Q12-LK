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

public class Vokabeleingabe extends JDialog {
  // Anfang Attribute
  private Canvas canvas1 = new Canvas();
  private JLabel lVokabeleingabe = new JLabel();
  private JLabel lEnglisch1 = new JLabel();
  private JLabel lDeutsch1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JButton bSpeichern = new JButton();
  private JButton bZurueck = new JButton();
  private Vokabelkasten vk;
  // Ende Attribute
  
  public Vokabeleingabe(JFrame owner, boolean modal, Vokabelkasten vk) { 
    // Dialog-Initialisierung
    super(owner, modal);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 330; 
    int frameHeight = 420;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Vokabeleingabe");
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    this.vk = vk;
    canvas1.setBounds(22, 64, 270, 250);
    canvas1.setBackground(Color.GRAY);
    cp.add(canvas1);
    lVokabeleingabe.setBounds(16, 16, 278, 36);
    lVokabeleingabe.setText("Vokabeleingabe");
    lVokabeleingabe.setFont(new Font("Dialog", Font.BOLD, 18));
    lVokabeleingabe.setForeground(Color.WHITE);
    lVokabeleingabe.setHorizontalAlignment(SwingConstants.CENTER);
    lVokabeleingabe.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lVokabeleingabe);
    cp.setBackground(new Color(0x404040));
    lEnglisch1.setBounds(35, 74, 240, 32);
    lEnglisch1.setText(" Englisch:");
    lEnglisch1.setHorizontalTextPosition(SwingConstants.LEFT);
    lEnglisch1.setHorizontalAlignment(SwingConstants.LEFT);
    lEnglisch1.setBackground(new Color(0x404040));
    lEnglisch1.setOpaque(true);
    lEnglisch1.setFont(new Font("Dialog", Font.BOLD, 14));
    lEnglisch1.setForeground(Color.WHITE);
    cp.add(lEnglisch1);
    lDeutsch1.setBounds(34, 176, 240, 32);
    lDeutsch1.setText(" Deutsch:");
    lDeutsch1.setFont(new Font("Dialog", Font.BOLD, 14));
    lDeutsch1.setForeground(Color.WHITE);
    cp.add(lDeutsch1);
    jTextField1.setBounds(34, 115, 240, 36);
    cp.add(jTextField1);
    jTextField2.setBounds(34, 218, 240, 36);
    cp.add(jTextField2);
    bSpeichern.setBounds(181, 275, 99, 33);
    bSpeichern.setText("Speichern");
    bSpeichern.setMargin(new Insets(2, 2, 2, 2));
    bSpeichern.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSpeichern_ActionPerformed(evt);
      }
    });
    cp.add(bSpeichern);
    bZurueck.setBounds(174, 335, 123, 33);
    bZurueck.setText("Zur�ck");
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
  } // end of public Vokabeleingabe
  
  // Anfang Methoden
  public void bSpeichern_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    if (!vk.addVokabel(new Vokabel(jTextArea2.getText(), jTextArea1.getText()))){
      System.out.println("Error");
    }
  } // end of bSpeichern_ActionPerformed

  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    this.dispose();
  } // end of bZurueck_ActionPerformed

  // Ende Methoden
  
} // end of class Vokabeleingabe
