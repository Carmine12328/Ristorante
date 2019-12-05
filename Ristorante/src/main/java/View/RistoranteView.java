/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerDisponibilita;
import Controller.RistoranteController;
import Model.RistoranteModel;
import Model.Tavoli;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

/**
 *
 * @author Carmine Annunziata
 */
public class RistoranteView extends javax.swing.JFrame {

    /**
     * Creates new form RistoranteView
     */
    private final RistoranteModel Rmod;
    private final RistoranteController Rc;
    private AddPietanzaFrame adf;
    private ControllerDisponibilita Cdisp;
    private int N2tav = 1;
    private int N4tav = 1;
    private int N6tav = 1;
    private int N8tav = 1;
    private int posizionehighT2 = 0;
    private int posizionelateraleT2 = 0;
    private int posizionehighT4 = 0;
    private int posizionelateraleT4 = 0;
    private int posizionehighT6 = 0;
    private int posizionelateraleT6 = 0;
    private int posizionehighT8 = 0;
    private int posizionelateraleT8 = 0;
    private int TavLib;
    private static int cont;
    private int TavOcc;
    private int TavAttPag;
    private int TavChiestoConto;
    private JButton c;

    public RistoranteView() {
        initComponents();

        this.setResizable(false);
        this.setBounds(430, 100, 1090, 850);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        Rmod = new RistoranteModel();
        Rc = new RistoranteController(this, Rmod);
        Cdisp = new ControllerDisponibilita(this, Rmod);
        jButton1.addActionListener(Rc);
        jButton2.addActionListener(Rc);
        jButton3.addActionListener(Rc);
        jButton4.addActionListener(Rc);
        jButton5.addActionListener(Rc);
        jButton6.addActionListener(Rc);
        jButton7.addActionListener(Rc);
        jButton8.addActionListener(Rc);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jTextField1.setEditable(false);
        jTextField1.setBackground(Color.green);
        jTextField1.setText("     " + TavLib + " " + "Tavoli liberi");
        jTextField2.setEditable(false);
        jTextField2.setBackground(Color.yellow);
        jTextField2.setText("     " + TavChiestoConto + " " + "Tavoli Chiesto Conto");
        jTextField3.setEditable(false);
        jTextField3.setBackground(Color.orange);
        jTextField3.setText("     " + TavAttPag + " " + "Tavoli Attesa Pagamento");
        jTextField4.setEditable(false);
        jTextField4.setBackground(Color.red);
        jTextField4.setText("     " + TavOcc + " " + "Tavoli Occupato");

        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        try {
            //Si aggiungono le icone ai rispettivi bottoni
            ImageIcon table = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/table.png")));
            jButton1.setIcon(table);
            ImageIcon chicken = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/chicken.png")));
            jButton2.setIcon(chicken);
            ImageIcon removeTable = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/table_remove.png")));
            jButton3.setIcon(removeTable);
            ImageIcon modifyDish = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/chicken_modify.png")));
            jButton4.setIcon(modifyDish);
            ImageIcon tableSave = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/table_save.png")));
            jButton5.setIcon(tableSave);
            ImageIcon tableReload = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/table_reload.png")));
            jButton6.setIcon(tableReload);
            ImageIcon chickenSave = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/chicken_save.png")));
            jButton7.setIcon(chickenSave);
            ImageIcon chickenReload = new ImageIcon(ImageIO.read(new File("src/main/java/View/Immagini/chicken_reload.png")));
            jButton8.setIcon(chickenReload);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Il seguente metodo ci permette di aggiornare la pagina principale in modo continuato in caso di modfica della stessa 
     */
    public void updateView() {

        jScrollPane1.revalidate();
        jScrollPane2.revalidate();
        jScrollPane3.revalidate();
        jScrollPane4.revalidate();
        jScrollPane1.repaint();
        jScrollPane2.repaint();
        jScrollPane3.repaint();
        jScrollPane4.repaint();
        jPanel1.repaint();
        jPanel3.repaint();
        jPanel4.repaint();
        jPanel5.repaint();

        int Nrig2 = N2tav / 3;
        int Altezza2 = 100 * Nrig2;
        jPanel3.setPreferredSize(new Dimension(650, Altezza2));
        jScrollPane1.setPreferredSize(new Dimension(650 - 1, Altezza2 - 1));

        int Nrig4 = N4tav / 3;
        int Altezza4 = 100 * Nrig4;
        jPanel1.setPreferredSize(new Dimension(650, Altezza4));
        jScrollPane2.setPreferredSize(new Dimension(650 - 1, Altezza4 - 1));

        int Nrig6 = N6tav / 3;
        int Altezza6 = 100 * Nrig6;
        jPanel5.setPreferredSize(new Dimension(650, Altezza6));
        jScrollPane4.setPreferredSize(new Dimension(650 - 1, Altezza6 - 1));

        int Nrig8 = N8tav / 3;
        int Altezza8 = 100 * Nrig8;
        jPanel4.setPreferredSize(new Dimension(650, Altezza8));
        jScrollPane3.setPreferredSize(new Dimension(650 - 1, Altezza8 - 1));

    }

    /**
     * Il metodo crea un bottone all'interno di un JScrollpanel, lo rende
     * visibie, gli setta le dimensioi e lo mette in ascolto
     *
     * @return il metodo ritorna un bottone
     */
    public JButton Tav2Pers() {
        c = new JButton();
        String label = "<html>" + "Tavolo N." + N2tav + "<br>" + " (2 People)" + "</html>";
        c.setText(label);
        c.setBounds(posizionelateraleT2, posizionehighT2, 110, 110);
        //c.setFont("Segoe UI Semilight");
        jPanel3.add(c);
        c.setVisible(true);
        jPanel3.repaint();
        c.addActionListener(Rc);
        if (cont == 2) {
            posizionehighT2 += 110;
            posizionelateraleT2 = -110;
            cont = -1;
        }
        posizionelateraleT2 += 110;
        cont++;
        N2tav++;

        return c;
    }

    /**
     * Il metodo crea un bottone all'interno di un jcrollpanel, lo rende
     * visibie, gli setta le dimensioi e lo mette in ascolto
     *
     * @return il metodo ritorna un bottone
     */
    public JButton Tav4Pers() {
        c = new JButton();
        String label = "<html>" + "Tavolo N." + N4tav + "<br>" + " (4 People)" + "</html>";
        c.setText(label);
        c.setBounds(posizionelateraleT4, posizionehighT4, 120, 80);
        jPanel1.add(c);
        c.addActionListener(Rc);
        c.setVisible(true);
        if (cont == 2) {
            posizionehighT4 += 80;
            posizionelateraleT4 = -120;
            cont = -1;
        }
        posizionelateraleT4 += 120;
        cont++;
        N4tav++;

        return c;
    }

    /**
     * Il metodo crea un bottone all'interno di un jcrollpanel, lo rende
     * visibie, gli setta le dimensioni e lo mette in ascolto
     *
     * @return il metodo ritorna un bottone
     */
    public JButton Tav6Pers() {
        c = new JButton("Tavolo N. " + N6tav + " (6People)");
        c.setBounds(posizionelateraleT6, posizionehighT6, 240, 60);
        jPanel4.add(c);
        c.addActionListener(Rc);
        c.setVisible(true);
        if (cont == 1) {
            posizionehighT6 += 60;
            posizionelateraleT6 = -240;
        }
        posizionelateraleT6 += 240;
        N6tav++;
        cont++;

        return c;
    }

    /**
     * Il metodo crea un bottone all'interno di un jcrollpanel, lo rende
     * visibie, gli setta le dimensioi e lo mette in ascolto
     *
     * @return il metodo ritorna un bottone
     */
    public JButton Tav8Pers() {
        c = new JButton();
        String label = "<html>" + "Tavolo N." + N8tav + "<br>" + " (8 People)" + "</html>";
        c.setText(label);
        c.setBounds(posizionelateraleT8, posizionehighT8, 320, 60);
        jPanel5.add(c);
        c.setVisible(true);
        c.addActionListener(Rc);
        posizionehighT8 += 60;
        posizionelateraleT8 = -320;
        posizionelateraleT8 += 320;
        N8tav++;

        return c;
    }

    /**
     * Il metodo ci permette di mmodificare le texfield presenti nella pagina
     * iniziale del programma
     */
    public void TavLiberi() {
        TavLib++;
        jTextField1.setText("     " + TavLib + " " + "Tavoli liberi");
    }

    /**
     * Il metodo ci permette di mmodificare le texfield presenti nella pagina
     * iniziale del programma
     */
    public void TavOccupati() {
        TavOcc++;
        jTextField4.setText("     " + TavOcc + " " + "Tavoli Occupati");
    }

    /**
     * Il metodo ci permette di mmodificare le texfield presenti nella pagina
     * iniziale del programma
     */
    public void TavAttesaPagameno() {
        TavAttPag++;
        jTextField3.setText("     " + TavAttPag + " " + "Tavoli Attesa Pagamento");
    }

    /**
     * Il metodo ci permette di mmodificare le texfield presenti nella pagina
     * iniziale del programma
     */
    public void TavChiestoConto() {
        TavChiestoConto++;
        jTextField2.setText("     " + TavChiestoConto + " " + "Tavoli Chiesto Conto");
    }

    /**
     * Il metodo midifica il colore del bottone passato
     *
     * @param a viene passato un bottone
     */
    public void setLibero(JButton a) {
        a.setBackground(Color.green);
    }

    /**
     * Il metodo midifica il colore del bottone passato
     *
     * @param a viene passato un bottone
     */
    public void setOccupato(JButton a) {
        a.setBackground(Color.red);
    }

    /**
     * Il metodo midifica il colore del bottone passato
     *
     * @param a viene passato un bottone
     */
    public void setAttesaDiPagamento(JButton a) {
        a.setBackground(Color.orange);
    }

    /**
     * Il metodo midifica il colore del bottone passato
     *
     * @param a viene passato un bottone
     */
    public void setChiestoConto(JButton a) {
        a.setBackground(Color.yellow);
    }
    /**
     * Il seguente metodo quando viene richiamato elimina tutti gli elementi presente nei panel e fa un repain della pagina
     */
    public void pulisciPanelTavoli() {
        jPanel1.removeAll();
        jPanel3.removeAll();
        jPanel4.removeAll();
        jPanel5.removeAll();

        jPanel1.repaint();
        jPanel3.repaint();
        jPanel4.repaint();
        jPanel5.repaint();
    }
    /**
     * Il seguente metodo ci permette di riazzerare i valori di posizione e numero di ogni tavolo presente nella view
     */
    public void resettaNumeroTavoli() {
        N2tav = 1;
        N4tav = 1;
        N6tav = 1;
        N8tav = 1;

        posizionehighT2 = 0;
        posizionehighT4 = 0;
        posizionehighT6 = 0;
        posizionehighT8 = 0;

        posizionelateraleT2 = 0;
        posizionelateraleT4 = 0;
        posizionelateraleT6 = 0;
        posizionelateraleT8 = 0;
    }
    
    public void resetTextField(){
        jTextField1.setText("     " + "0" + " " + "Tavoli liberi");
        jTextField4.setText("     " + "0" + " " + "Tavoli Occupati");
        jTextField3.setText("     " + "0" + " " + "Tavoli Attesa Pagamento");
        jTextField2.setText("     " + "0" + " " + "Tavoli Chiesto Conto"); 
        TavLib = 0;
        TavOcc = 0;
        TavAttPag = 0;
        TavChiestoConto = 0;
    }
    
    public void setTextFieldNumTav(){
        resetTextField();
        for(int i = 0; i < RistoranteModel.TavoliList.size(); i++){
            Tavoli tav = (Tavoli) RistoranteModel.TavoliList.get(i);
            
            if(tav.getSitAttuale().equals("libero")){
                TavLib++;
                jTextField1.setText("     " + TavLib + " " + "Tavoli liberi");
            }
            if(tav.getSitAttuale().equals("occupato")){
                TavOcc++;
                jTextField4.setText("     " + TavOcc + " " + "Tavoli Occupati");
            }
            if(tav.getSitAttuale().equals("in attesa di pagamento")){
                TavAttPag++;
                jTextField3.setText("     " + TavAttPag + " " + "Tavoli Attesa Pagamento");
            }
            if(tav.getSitAttuale().equals("in attesa di conto")){
               TavChiestoConto++;
               jTextField2.setText("     " + TavChiestoConto + " " + "Tavoli Chiesto Conto"); 
            }
            if(tav.getSitAttuale().equals("Libero")){
                TavLib++;
                jTextField1.setText("     " + TavLib + " " + "Tavoli liberi");
            }
            if(tav.getSitAttuale().equals("Occupato")){
                TavOcc++;
                jTextField4.setText("     " + TavOcc + " " + "Tavoli Occupati");
            }
            if(tav.getSitAttuale().equals("<html>In attesa<br>di pagamento</html>")){
                TavAttPag++;
                jTextField3.setText("     " + TavAttPag + " " + "Tavoli Attesa Pagamento");
            }
            if(tav.getSitAttuale().equals("<html>In attesa di conto</html>")){
               TavChiestoConto++;
               jTextField2.setText("     " + TavChiestoConto + " " + "Tavoli Chiesto Conto"); 
            }
        }
    }
    
    public void stampaTavoli(){
       
        for(int i = 0; i <  RistoranteModel.TavoliList.size(); i++){
            Tavoli a = (Tavoli) RistoranteModel.TavoliList.get(i);
            System.out.println(a.getNome());
            if(a.getNome().contains("(2People)")){
                c = new JButton();
                String label = "<html>" + " Tavolo N. " + N2tav + "<br>" + " (2 People)" + "</html>";
                c.setText(label);
                c.setBounds(posizionelateraleT2, posizionehighT2, 110, 110);
                if (a.getSitAttuale().equalsIgnoreCase("libero")) {
                    c.setBackground(Color.green);
                } 
                if (a.getSitAttuale().equalsIgnoreCase("occupato")){
                    c.setBackground(Color.red);
                }
                if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa di conto</html>")) {
                    c.setBackground(Color.yellow);
                }
                if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                    c.setBackground(Color.orange);
                }
                //c.setFont("Segoe UI Semilight");
                jPanel3.add(c);
                jPanel3.repaint();
                c.addActionListener(Rc);
                c.setVisible(true);
                if (cont == 2) {
                    posizionehighT2 += 110;
                    posizionelateraleT2 = -110;
                    cont = -1;
                }
                posizionelateraleT2 += 110;
                cont++;
                N2tav++;
            }
            else if(a.getNome().contains("(4People)")){
                c = new JButton();
                String label = "<html>" + "Tavolo N." + N4tav + "<br>" + " (4 People)" + "</html>";
                c.setText(label);
                c.setBounds(posizionelateraleT4, posizionehighT4, 120, 80);
                if (a.getSitAttuale().equalsIgnoreCase("libero")) {
                    c.setBackground(Color.green);
                } 
                else if (a.getSitAttuale().equalsIgnoreCase("occupato")){
                    c.setBackground(Color.red);
                }
                else if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa di conto</html>")) {
                    c.setBackground(Color.yellow);
                }
                else if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                    c.setBackground(Color.orange);
                }
                jPanel1.add(c);
                jPanel1.repaint();
                c.addActionListener(Rc);
                c.setVisible(true);
                if (cont == 2) {
                    posizionehighT4 += 80;
                    posizionelateraleT4 = -120;
                    cont = -1;
                }
                posizionelateraleT4 += 120;
                cont++;
                N4tav++;
            }
            else if(a.getNome().contains("(6People)")){
                c = new JButton("Tavolo N. " + N6tav + " (6People)");
                c.setBounds(posizionelateraleT6, posizionehighT6, 240, 60);
                if (a.getSitAttuale().equalsIgnoreCase("libero")) {
                    c.setBackground(Color.green);
                } 
                else if (a.getSitAttuale().equalsIgnoreCase("occupato")){
                    c.setBackground(Color.red);
                }
                else if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa di conto</html>")) {
                    c.setBackground(Color.yellow);
                }
                else if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                    c.setBackground(Color.orange);
                }
                jPanel4.add(c);
                jPanel4.repaint();
                c.addActionListener(Rc);
                c.setVisible(true);
                if (cont == 1) {
                    posizionehighT6 += 60;
                    posizionelateraleT6 = -240;
                }
                posizionelateraleT6 += 240;
                N6tav++;
                cont++;
            }
            else if(a.getNome().contains("(8People)")){
                c = new JButton();
                String label = "<html>" + "Tavolo N." + N8tav + "<br>" + " (8 People)" + "</html>";
                c.setText(label);
                c.setBounds(posizionelateraleT8, posizionehighT8, 320, 60);
                if (a.getSitAttuale().equalsIgnoreCase("libero")) {
                    c.setBackground(Color.green);
                } 
                else if (a.getSitAttuale().equalsIgnoreCase("occupato")){
                    c.setBackground(Color.red);
                }
                else if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa di conto</html>")) {
                    c.setBackground(Color.yellow);
                }
                else if (a.getSitAttuale().equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                    c.setBackground(Color.orange);
                }
                jPanel5.add(c);
                jPanel5.repaint();
                c.setVisible(true);
                c.addActionListener(Rc);
                posizionehighT8 += 60;
                posizionelateraleT8 = -320;
                posizionelateraleT8 += 320;
                N8tav++;
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Frame / Sala Principale");
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel5);

        jButton1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jButton1.setText("Aggiungi Tavolo");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(142, 24));
        jButton1.setMinimumSize(new java.awt.Dimension(142, 24));
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel3);

        jTextField1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextField2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextField3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jButton2.setText("Aggiungi Pietanza");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 3, 18)); // NOI18N
        jLabel2.setText("Tavoli da due persone:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 3, 18)); // NOI18N
        jLabel3.setText("Tavoli da quattro persone:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 3, 18)); // NOI18N
        jLabel4.setText("Tavoli da sei persone:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 3, 18)); // NOI18N
        jLabel5.setText("Tavoli da otto persone:");

        jButton3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jButton3.setText("Resetta Tavoli");
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jButton4.setText("Modifica/Rimuovi Pietanza");
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jButton5.setText("Salva Tavoli");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(142, 24));
        jButton5.setMinimumSize(new java.awt.Dimension(142, 24));
        jButton5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jButton6.setText("Ricarica Tavoli");
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(142, 24));
        jButton6.setMinimumSize(new java.awt.Dimension(142, 24));
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jButton7.setText("Salva Pietanze");
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMaximumSize(new java.awt.Dimension(142, 24));
        jButton7.setMinimumSize(new java.awt.Dimension(142, 24));
        jButton7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jButton8.setText("Ricarica Pietanze");
        jButton8.setBorderPainted(false);
        jButton8.setFocusPainted(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMaximumSize(new java.awt.Dimension(142, 24));
        jButton8.setMinimumSize(new java.awt.Dimension(142, 24));
        jButton8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(jTextField4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            java.util.logging.Logger.getLogger(RistoranteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RistoranteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RistoranteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RistoranteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        public void run() {
            new RistoranteView().setVisible(true);
        }
    }
}
