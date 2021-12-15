package pis.hue1;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dieses Programm dienst zu ver- und entschluesseln von Texte
 * @author Cedric Ndong
 * version 1.0
 */

public class CodecGUI extends JFrame {
    private Codec a  = new Wuerfel("THM");
    private Codec b = new Caesar();


    public CodecGUI(){
        super("Verschluesselung und Entschluesselung ~ Cedric");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(620,700);
        this.setLocationRelativeTo(null);
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);



        JMenu history = new JMenu("Geschichte");
        menuBar.add(history);
        JMenuItem caesarItem = new JMenuItem("Caesar");
        JMenuItem wuerfelItem = new JMenuItem("Wuerfel");
        history.add(caesarItem);
        history.add(wuerfelItem);

/**
 * Contener erstellen
 */
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBackground(new Color(0xFFF3DCDF));
        contentPane.setLayout(null);

        /**
         * Label willKText gibt ein Begrueßungtext auf dem GUI
         */
        JLabel willKText = new JLabel("Willkommen bei dem ver und -entschluesselung Programm");
        willKText.setBounds(110,15,500,15);
        contentPane.add(willKText);

        /**
         * Label aktionText gibt ein AktionText auf dem GUI
         */
        JLabel aktionText = new JLabel("#--->>> Eine Aktionbitte auswaelen");
        aktionText.setBounds(10,80,500,15);
        contentPane.add(aktionText);

/**
 *  verButtonRadio erstellt ein Radiobutton auf dem GUI
 */
        JRadioButton verButtonRadio= new JRadioButton("Verschluesselung", true);
        verButtonRadio.setBounds(280,100,140,30);
        JRadioButton entButtonRadio = new JRadioButton("Entschluesselung");
        entButtonRadio.setBounds(280,140,140,30);

/**
 *  groupVerEnt dient zur Gruppierung von Schaltflaechen
 */
        ButtonGroup groupVerEnt = new ButtonGroup();
        groupVerEnt.add(verButtonRadio);
        groupVerEnt.add(entButtonRadio);
        contentPane.add(verButtonRadio);
        contentPane.add(entButtonRadio);



        JLabel klarGeheimText = new JLabel("#--->>> Ein Klartext (oder Geheimtext) bitte eingeben");
        klarGeheimText.setBounds(10,200,500,15);
        contentPane.add(klarGeheimText);

        JTextArea klartext_geheimtext = new JTextArea();
        klartext_geheimtext.setBounds(80,220,480,50);
        klartext_geheimtext.setLineWrap(true);
        contentPane.add(klartext_geheimtext);


        JLabel losungText = new JLabel("#--->>> Losungworte bitte eingeben");
        losungText.setBounds(10,300,500,15);
        contentPane.add(losungText);

        JTextField losungWort1 = new JTextField();
        losungWort1.setBounds(90,320,200,40);
        contentPane.add(losungWort1);
        JLabel losungtext1 = new JLabel("Losungwort1");
        losungtext1.setBounds(140,350,200,40);
        contentPane.add(losungtext1);

        JTextField losungWort2 = new JTextField();
        losungWort2.setBounds(350,320,200,40);
        contentPane.add(losungWort2);
        JLabel losungtext2 = new JLabel("Losungwort2");
        losungtext2.setBounds(400,350,200,40);
        contentPane.add(losungtext2);


        JLabel methodeText = new JLabel("#--->>> Die Ko(De)kodiere- Methode bitte auswaelen");
        methodeText.setBounds(10,400,500,15);
        contentPane.add(methodeText);

/**
 *  wuerfelButton und caesarButton erstellen  buttons auf dem GUI
 */
        JButton wuerfelButton = new JButton("Wuerfel");
        wuerfelButton.setBackground(new Color(0x027C227));
        wuerfelButton.setBounds(100,430,100,50);
        JButton caesarButton = new JButton("Caesar");
        caesarButton.setBackground(new Color(0x027C227));
        caesarButton.setBounds(400,430,100,50);

        ButtonGroup groupCaeWuer = new ButtonGroup();
        groupCaeWuer.add(wuerfelButton);
        groupCaeWuer.add(caesarButton);

        contentPane.add(wuerfelButton);
        contentPane.add(caesarButton);

        JTextArea ergebnis = new JTextArea();
        ergebnis.setBounds(80,520,480,50);
        ergebnis.setLineWrap(true);
        contentPane.add(ergebnis);
        JLabel ergebnisText = new JLabel("Ergebnis");
        ergebnisText.setBounds(280,560,200,40);
        contentPane.add(ergebnisText);

        JButton fertigButton = new JButton("Fertig");
        fertigButton.setBounds(490,600,80,30);
        fertigButton.setBackground(new Color(0xDE0C23));
        contentPane.add(fertigButton);

        /**
         *
         */
        caesarButton.addActionListener(new ActionListener() {
            @Override
            /**
             *Der ActionEvent -Parameter ist ein Event -Objekt, das ein Ereignis (einen Buttonklick) repraesentiert.
             */
            public void actionPerformed(ActionEvent ev) {
                if (ev.getSource() == caesarButton){
                    if (verButtonRadio.isSelected()) {
                        try {
                            String wort1 = losungWort1.getText();
                            String klarwort = klartext_geheimtext.getText();
                            b.setzeLosung(wort1);
                            String temp1 = b.kodiere(klarwort);
                            ergebnis.setText(temp1);
                        }catch (Exception exVerCB){
                                JOptionPane.showMessageDialog(null, "Klartext und Losungwort 1 bitte eingeben");
                        }

                    } else if (entButtonRadio.isSelected()){
                        try {
                            String wort1 = losungWort1.getText();
                            String geheimText = klartext_geheimtext.getText();
                            b.setzeLosung(wort1);
                            String temp1 = b.dekodiere(geheimText);
                            ergebnis.setText(temp1);
                        }catch (Exception exEntCB){
                            JOptionPane.showMessageDialog(null, "Geheimtext und Losungwort 1 bitte eingeben");
                        }
                    }
                }
            }
        });

        fertigButton.addActionListener((e)->{
            System.exit(1);
        });

        wuerfelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (ev.getSource() == wuerfelButton){
                    if (verButtonRadio.isSelected()) {


                        try {

                            String wort1 = losungWort1.getText();
                            String wort2 = losungWort2.getText();
                            String klarwort = klartext_geheimtext.getText();
                            a.setzeLosung(wort1);

                            String temp1 = a.kodiere(klarwort);
                            a.setzeLosung(wort2);
                            String temp2 = a.kodiere(temp1);
                            ergebnis.setText(temp2);
                        }
                        catch (Exception exFelht1){
                            JOptionPane.showMessageDialog(null, "Jedes Feld bitte ausfuellen");
                        }

                    }
                    else if (entButtonRadio.isSelected()){
                       try {
                           String wort1 = losungWort1.getText();
                           String wort2 = losungWort2.getText();
                           String geheimwort = klartext_geheimtext.getText();
                           a.setzeLosung(wort2);
                           String temp1 = a.dekodiere(geheimwort);
                           a.setzeLosung(wort1);
                           String temp2 = a.dekodiere(temp1);
                           ergebnis.setText(temp2);
                       }
                       catch (Exception exFelht2){
                           JOptionPane.showMessageDialog(null, "Jedes Feld bitte ausfuellen");
                        }
                    }

                }
            }
        });

    }
    /**
     * main Methode laeuft die Anwendung
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        // Look and Feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        SwingUtilities.invokeLater(()->{
                try {
                    CodecGUI codecGUI = new CodecGUI();
                    codecGUI.setVisible(true);
                } catch (Exception ex) {
                        ex.printStackTrace();
                    }
        });
    }
}
