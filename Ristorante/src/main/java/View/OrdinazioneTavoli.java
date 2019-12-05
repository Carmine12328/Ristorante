/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerDisponibilita;
import Controller.RistoranteController;
import Model.Ordini;
import Model.RistoranteModel;
import Model.Tavoli;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Carmine Annunziata
 */
public class OrdinazioneTavoli extends javax.swing.JFrame {

    /**
     * Creates new form OrdnazioneTavoli
     */
    public static ArrayList Ordinazione = new ArrayList();
    
    
    private static String title;
    private ControllerDisponibilita Cdisp;
    private RistoranteModel Rmod;
    private RistoranteController Rc;
    private int posizioneLaterale = 10;
    private int posizionehigh = 10;
    private static int cont = 0;
    private int posizioneLatQt = 0;
    private int posizioneHigh = 30;
    private int posizioneLatName = 29;
    private int posizioneLatPrezzo = 148;

    public OrdinazioneTavoli() {
    }

    public OrdinazioneTavoli(String title) {
        this.setResizable(false);
        this.title = title;
        super.setTitle(title);
        this.setBounds(450, 100, 878, 793);
        initComponents();
        Cdisp = new ControllerDisponibilita(this, Rmod);
        Rmod = new RistoranteModel();
        Rc = new RistoranteController(this, Rmod);
        LocalTime ora = LocalTime.now();
        String[] oraString;
        oraString = ora.toString().split(":");
        TextOraOrdinazione.setText(oraString[0] + ":" + oraString[1]);
        TextOraOrdinazione.setEditable(false);
        TextOraOrdinazione.setHorizontalAlignment(JTextField.CENTER);
        String NomTav = title.substring(title.indexOf("T"),title.length());
        for(int i = 0; i < RistoranteModel.TavoliList.size(); i++){
            Tavoli Tav = (Tavoli) RistoranteModel.TavoliList.get(i);
            if(Tav.getNome().equals(NomTav)){
               setDispOnTavolo(Tav.getSitAttuale()); 
            }
        }
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setEditable(false);
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        jTextField2.setText(title);
        jTextField2.setFont(font1);
        jTextField2.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setEditable(false);
        jTextField2.setBackground(Color.yellow);
        jTextField1.setBackground(Color.yellow);
        TextOraOrdinazione.setBackground(Color.yellow);

        jTextField3.setHorizontalAlignment(JTextField.CENTER);
        jTextField3.setEditable(false);
        jTextField3.setBackground(Color.yellow);

        jTextField4.setHorizontalAlignment(JTextField.CENTER);
        jTextField4.setEditable(false);
        jTextField4.setBackground(Color.red);

        jTextField5.setHorizontalAlignment(JTextField.CENTER);
        jTextField5.setEditable(false);
        jTextField5.setBackground(Color.orange);


        jButton1.addActionListener(Rc);
        jButton2.addActionListener(Rc);
        jButton3.addActionListener(Rc);
        jButton4.addActionListener(Rc);
        jButton5.addActionListener(Rc);
        jButton6.addActionListener(Rc);
        jButton7.addActionListener(Rc);
        jButton8.addActionListener(Rc);
        Disponibilita.addActionListener(Cdisp);
        
        
         try {
            ImageIcon antipasti = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/icona-antipasti_resized.png")));
            jButton6.setIcon(antipasti);
            ImageIcon firstDishes = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/first_dish_resized.png")));
            jButton1.setIcon(firstDishes);
            ImageIcon secondDishes = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/entrees_Resized.png")));
            jButton2.setIcon(secondDishes);
            ImageIcon sideDishes = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/side_dishes_resized.png")));
            jButton3.setIcon(sideDishes);
            ImageIcon pizzas = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/pizzas_resized.png")));
            jButton4.setIcon(pizzas);
            ImageIcon fruit = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/frutta_resized.png")));
            jButton5.setIcon(fruit);
            ImageIcon desserts = new ImageIcon(ImageIO.read(new File("src/main/java/View/ImagesOrdinazioneTavoli/desserts_resized.png")));
            jButton7.setIcon(desserts);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Il seguente programma ci permette di creare i bottoni all'interno del menù per ogni 
     * pietanza che abbiamo immesso precedentemente
     * @param NomePietanza Stringa passata dal programma e usata per assegnare il nome al bottone
     */
    public void creaBottoniPietanze(String NomePietanza) {
        JButton c = new JButton(NomePietanza);
        c.setBounds(posizioneLaterale, posizionehigh, 130, 70);
        Font font1 = new Font("Segoe UI Semilight", Font.BOLD, 14);
        c.setFont(font1);
        PanelPietanze.add(c);
        c.setVisible(true);
        PanelPietanze.repaint();
        c.addActionListener(Rc);
        if (cont == 2) {
            posizionehigh += 60;
            posizioneLaterale = -130;
            cont = -1;
        }
        posizioneLaterale += 130;
        cont++;
    }
    /**
     * Il seguente metodo viene utilizzato per cancellare tutti gli elementi del pannello delle pietanze
     */
    public void pulisciPanelPietanze() {
        PanelPietanze.removeAll();
        PanelPietanze.revalidate();
        PanelPietanze.repaint();
        posizioneLaterale = 10;
        posizionehigh = 10;
        cont = 0;
    }
    /**
     * Il seguente metodo ci permette di creare le textfield che ci fanno vedere il 
     * prezzo,il nome e la quantià delle pietanze ordinate dalla persona
     * @param name nome della pietanza
     * @param Qt quantità della stessa pietanza ordinata
     * @param Prezzo prezzo della pietanza
     */
    public void SceltaPietanze(String name, String Qt, String Prezzo) {
        JTextField jtQt;
        JTextField jtName;
        JTextField jtPrezzo;
        Boolean bool = true;
        for (int i = 0; i < Ordinazione.size(); i++) {
            Ordini ord = (Ordini) Ordinazione.get(i);
            if (ord.getNome().equals(name)) {
                ord.setQuantità(ord.getQuantità() + 1);
                bool = false;
            }
        }
        if (bool == false) {
            SceltaPietanzePanel.removeAll();
            SceltaPietanzePanel.repaint();
            Rmod.salvaPietanzeUguali(this.title, Ordinazione);
            for (int i = 0; i < Ordinazione.size(); i++) {
                Ordini a = (Ordini) Ordinazione.get(i);
                if (a.getQuantità() != 0) {
                    jtQt = new JTextField();
                    jtName = new JTextField();
                    jtPrezzo = new JTextField();
                    jtQt.setText(String.valueOf(a.getQuantità()));
                    jtName.setText(a.getNome());
                    jtPrezzo.setText(String.valueOf(a.getPrezzo()));

                    SceltaPietanzePanel.add(jtQt);
                    SceltaPietanzePanel.add(jtName);
                    SceltaPietanzePanel.add(jtPrezzo);

                    jtQt.setBounds(posizioneLatQt, i * 30, 27, 25);
                    jtName.setBounds(posizioneLatName, i * 30, 117, 25);
                    jtPrezzo.setBounds(posizioneLatPrezzo, i * 30, 80, 25);

                    jtName.setEditable(false);
                    jtPrezzo.setEditable(false);
                    jtQt.setEditable(false);

                    jtQt.setBackground(Color.orange);
                    jtName.setBackground(Color.orange);
                    jtPrezzo.setBackground(Color.orange);
                }
            }
        }
        if (bool == true) {
            Ordini a = new Ordini(name, Float.parseFloat(Prezzo), Integer.parseInt(Qt));
            Ordinazione.add(a);
            Rmod.salvaPietanze(this.title, Ordinazione);
            for (int i = 0; i < Ordinazione.size(); i++) {
                a = (Ordini) Ordinazione.get(i);
                if (a.getQuantità() != 0) {
                    jtQt = new JTextField();
                    jtName = new JTextField();
                    jtPrezzo = new JTextField();
                    jtQt.setText(String.valueOf(a.getQuantità()));
                    jtName.setText(a.getNome());
                    jtPrezzo.setText(String.valueOf(a.getPrezzo()));

                    SceltaPietanzePanel.add(jtQt);
                    SceltaPietanzePanel.add(jtName);
                    SceltaPietanzePanel.add(jtPrezzo);

                    jtQt.setBounds(posizioneLatQt, i * 30, 27, 25);
                    jtName.setBounds(posizioneLatName, i * 30, 117, 25);
                    jtPrezzo.setBounds(posizioneLatPrezzo, i * 30, 80, 25);

                    jtName.setEditable(false);
                    jtPrezzo.setEditable(false);
                    jtQt.setEditable(false);

                    jtQt.setBackground(Color.orange);
                    jtName.setBackground(Color.orange);
                    jtPrezzo.setBackground(Color.orange);
                }
            }
        }
    }
    /**
     * Il seguente metodo richiama un metodo presente nel model che ci permette di 
     * stampare in Pdf una copia dello scontrino delle portate ordinate
     */
    public void stampaScontrinoFrame(){
        Rmod.stampaScontrino(this.title, Ordinazione);
    }
    
    public static void setDispOnTavolo(String i) {
        int index = 0;
        if (i.equalsIgnoreCase("libero")) {
            index = 0;
        }
        if (i.equalsIgnoreCase("Libero")) {
            index = 0;
        }
        if (i.equalsIgnoreCase("Occupato")) {
            index = 1;
        }
        if (i.equalsIgnoreCase("occupato")) {
            index = 1;
        }
        if (i.equalsIgnoreCase("in attesa di conto")) {
            index = 2;
        }
        if (i.equalsIgnoreCase("<html>In attesa di conto</html>")) {
            index = 2;
        }
        if (i.equalsIgnoreCase("in attesa di pagamento")) {
            index = 3;
        }
        if (i.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
            index = 3;
        }
        
        OrdinazioneTavoli.Disponibilita.setSelectedIndex(index);
        
        }

    
    public String getNomeFrame(){
        return title;
    }
    public String getDisponibilitaTav(){
        for(int i = 0; i < RistoranteModel.TavoliList.size(); i++){
            Tavoli a = (Tavoli) RistoranteModel.TavoliList.get(i);
            String NomTav = title.substring(title.indexOf("T"),title.length());
            if(title.contains(a.getNome())){
                return a.getSitAttuale();
            }
        }
        return null;
    }
    public void cambiaDisponibilita(String Diponibilita){
        for(int i = 0; i < RistoranteModel.TavoliList.size();i++){
            Tavoli a = (Tavoli) RistoranteModel.TavoliList.get(i);
            String NomTav = title.substring(title.indexOf("T"),title.length());
            System.out.println(NomTav);
            if(NomTav.equals(a.getNome())){
                a.setSitAttuale(Diponibilita);
                break;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextOraOrdinazione = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelPietanze = new javax.swing.JPanel();
        PanelSceltaPietanze = new javax.swing.JScrollPane();
        SceltaPietanzePanel = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        Disponibilita = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordini Tavoli");
        setPreferredSize(new java.awt.Dimension(873, 791));

        jTextField1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 10)); // NOI18N
        jTextField1.setText("Ora Ordinazione");

        jTextField2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N

        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton6.setText("Antipasti");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton1.setText("Primi Piatti");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.setMaximumSize(new java.awt.Dimension(76, 25));

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton2.setText("Secondi");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton3.setText("Contorni");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton4.setText("Pizze");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setText("Frutta");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton7.setText("Dessert");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 455, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout PanelPietanzeLayout = new javax.swing.GroupLayout(PanelPietanze);
        PanelPietanze.setLayout(PanelPietanzeLayout);
        PanelPietanzeLayout.setHorizontalGroup(
            PanelPietanzeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        PanelPietanzeLayout.setVerticalGroup(
            PanelPietanzeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(PanelPietanze);

        PanelSceltaPietanze.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        PanelSceltaPietanze.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout SceltaPietanzePanelLayout = new javax.swing.GroupLayout(SceltaPietanzePanel);
        SceltaPietanzePanel.setLayout(SceltaPietanzePanelLayout);
        SceltaPietanzePanelLayout.setHorizontalGroup(
            SceltaPietanzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        SceltaPietanzePanelLayout.setVerticalGroup(
            SceltaPietanzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        PanelSceltaPietanze.setViewportView(SceltaPietanzePanel);

        jButton8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton8.setText("Stampa Scontrino");

        jTextField3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jTextField3.setText("Qt.");
        jTextField3.setAlignmentX(0.0F);
        jTextField3.setAlignmentY(0.0F);

        jTextField4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jTextField4.setText("Nome Pietanza");
        jTextField4.setAlignmentX(0.0F);
        jTextField4.setAlignmentY(0.0F);

        jTextField5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jTextField5.setText("Prezzo");

        Disponibilita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "libero", "occupato", "in attesa di conto", "in attesa di pagamento" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TextOraOrdinazione, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelSceltaPietanze, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(Disponibilita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextOraOrdinazione, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(PanelSceltaPietanze, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Disponibilita, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdinazioneTavoli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdinazioneTavoli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdinazioneTavoli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdinazioneTavoli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OrdinazioneTavoli().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Disponibilita;
    private javax.swing.JPanel PanelPietanze;
    private javax.swing.JScrollPane PanelSceltaPietanze;
    private javax.swing.JPanel SceltaPietanzePanel;
    private javax.swing.JTextField TextOraOrdinazione;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
