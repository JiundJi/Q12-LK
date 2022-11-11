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

public class Main extends JFrame {
  // Anfang Attribute
  private JLabel lVokabeltrainer = new JLabel();
  private JButton bVokabellisteanzeigen = new JButton();
  private JButton bVokabelhinzufuegen = new JButton();
  private JButton bVokabelabfragestarten = new JButton();
  private JButton bStatistik = new JButton();
  private JLabel lVerwaltung = new JLabel();
  private JLabel lVokabelabfrage = new JLabel();
  private Vokabelkasten vk;
  // Ende Attribute
  
  public Main() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 474; 
    int frameHeight = 429;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Vokabelprogramm");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lVokabeltrainer.setBounds(132, 13, 211, 68);
    lVokabeltrainer.setText("Vokabeltrainer");
    lVokabeltrainer.setHorizontalTextPosition(SwingConstants.CENTER);
    lVokabeltrainer.setHorizontalAlignment(SwingConstants.CENTER);
    lVokabeltrainer.setForeground(Color.WHITE);
    lVokabeltrainer.setBackground(new Color(0x404040));
    lVokabeltrainer.setOpaque(true);
    lVokabeltrainer.setFont(new Font("Calibri", Font.BOLD, 24));
    cp.add(lVokabeltrainer);
    cp.setBackground(new Color(0x404040));
    bVokabellisteanzeigen.setBounds(144, 122, 187, 33);
    bVokabellisteanzeigen.setText("Vokabelliste anzeigen");
    bVokabellisteanzeigen.setMargin(new Insets(2, 2, 2, 2));
    bVokabellisteanzeigen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVokabellisteanzeigen_ActionPerformed(evt);
      }
    });
    cp.add(bVokabellisteanzeigen);
    bVokabelhinzufuegen.setBounds(144, 170, 187, 33);
    bVokabelhinzufuegen.setText("Vokabel hinzufuegen");
    bVokabelhinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    bVokabelhinzufuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVokabelhinzufuegen_ActionPerformed(evt);
      }
    });
    cp.add(bVokabelhinzufuegen);
    bVokabelabfragestarten.setBounds(144, 242, 187, 33);
    bVokabelabfragestarten.setText("Vokabelabfrage starten");
    bVokabelabfragestarten.setMargin(new Insets(2, 2, 2, 2));
    bVokabelabfragestarten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bVokabelabfragestarten_ActionPerformed(evt);
      }
    });
    cp.add(bVokabelabfragestarten);
    bStatistik.setBounds(144, 290, 187, 33);
    bStatistik.setText("Statistik");
    bStatistik.setMargin(new Insets(2, 2, 2, 2));
    bStatistik.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bStatistik_ActionPerformed(evt);
      }
    });
    cp.add(bStatistik);
    lVerwaltung.setBounds(78, 80, 318, 28);
    lVerwaltung.setText("Verwaltung");
    lVerwaltung.setFont(new Font("Dialog", Font.BOLD, 14));
    lVerwaltung.setForeground(Color.WHITE);
    cp.add(lVerwaltung);
    lVokabelabfrage.setBounds(78, 210, 318, 28);
    lVokabelabfrage.setText("Vokabelabfrage");
    lVokabelabfrage.setFont(new Font("Dialog", Font.BOLD, 14));
    lVokabelabfrage.setForeground(Color.WHITE);
    cp.add(lVokabelabfrage);
    vk = new Vokabelkasten(10);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Main
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Main();
  } // end of main
  
  public void bVokabellisteanzeigen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    Vokabelliste dialog = new Vokabelliste(this, true, vk);
  } // end of bVokabellisteanzeigen_ActionPerformed

  public void bVokabelhinzufuegen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    Vokabeleingabe dialog = new Vokabeleingabe(this, true, vk);
  } // end of bVokabelhinzufuegen_ActionPerformed

  public void bVokabelabfragestarten_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    Vokabelabfrage dialog = new Vokabelabfrage(this, true, vk);
  } // end of bVokabelabfragestarten_ActionPerformed

  public void bStatistik_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    Vokabelstatistik dialog = new Vokabelstatistik(this, true, vk);
  } // end of bStatistik_ActionPerformed

  // Ende Methoden
} // end of class Main

