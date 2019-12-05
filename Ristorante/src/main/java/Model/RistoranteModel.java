/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.RistoranteController;
import static Model.RistoranteModel.TavoliList;
import View.AddPietanzaFrame;
import View.SceltaDisponibilitaTav;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carmine Annunziata
 */
public class RistoranteModel implements Serializable {

    public static ArrayList PietanzeList = new ArrayList();
    public static ArrayList TavoliList = new ArrayList();
    private AddPietanzaFrame Rview;

    public final RistoranteController Rc;
    public SceltaDisponibilitaTav SDT;
    public static int NumTav2P = 1;
    public static int NumTav4P = 1;
    public static int NumTav6P = 1;
    public static int NumTav8P = 1;
    private final String nome = "Tavolo N. ";
    private static Integer y;

    // Metodi get e set
    public RistoranteModel(){
        Rc = new RistoranteController(SDT, this);
    }
    public ArrayList getPietanzeList() {
        return PietanzeList;
    }

    public void setPietanzeList(ArrayList PietanzeList) {
        RistoranteModel.PietanzeList = PietanzeList;
    }

    public String setScelta(String a) {
        return a;
    }

    /**
     * Il metodo prende in input una stringa e la confronta con tutti i nomi dei
     * tavoli dell'ArrayList, quando trova il tavolo lo restituisce in output
     *
     * @param nome stringa passata dall'utente ed usata per il conrollo
     * all'interno dell'ArrayList
     * @return un tavolo nel caso in cui ci sia almeno un oggetto con nome
     * uguale alla stringa passata, null nel caso in cui non ci sia nessun
     * oggetto con nome uguale(il programma viene chius per non compromettere i
     * salvataggi)
     */
    public Tavoli getAllData(String nome) {
        String a;
        int index = 0;
        System.out.println(nome);
        if (nome.contains("(6People)")) {
            for (;;) {
                if (nome.contains(String.valueOf(index))) {
                    String cont = String.valueOf(index);
                    a = nome.substring(nome.indexOf("T"), nome.indexOf(".") + 1) + nome.substring(nome.indexOf(".") + 1, nome.indexOf(cont) + 1) + nome.substring(nome.indexOf("(") - 1, nome.lastIndexOf(")") + 1);
                    for (int i = 0; i < TavoliList.size(); i++) {
                        Tavoli tavol = (Tavoli) TavoliList.get(i);
                        if (tavol.getNome().trim().equals(a.trim())) {
                            return tavol;
                        }
                    }
                    break;
                }
                index++;

            }
        }
        if (nome.contains("(2 People)")) {
            for (;;) {
                if (nome.substring(nome.indexOf(".") + 1, nome.indexOf(".") + 2).equals(String.valueOf(index))) { 
                    String cont = String.valueOf(index);
                    a = nome.substring(nome.indexOf("T"), nome.indexOf(".") + 1)+" " + nome.substring(nome.indexOf(".") + 1, nome.indexOf(cont) + 1) + nome.substring(nome.indexOf("(") - 1, nome.lastIndexOf("2") + 1)+nome.substring(nome.lastIndexOf("2") +2,nome.lastIndexOf(")")+1);                         
                    System.out.println(a);
                    for (int i = 0; i < TavoliList.size(); i++) {
                        Tavoli tavol = (Tavoli) TavoliList.get(i);
                        System.out.println(tavol.getNome());
                        if (tavol.getNome().equals(a)) {
                            return tavol;
                        }
                    }
                    break;
                }
                if (nome.substring(nome.indexOf(".") + 2, nome.indexOf(".") + 3).equals(String.valueOf(index))) { 
                    String cont = String.valueOf(index);
                    a = nome.substring(nome.indexOf("T"), nome.indexOf(".") + 1)+ nome.substring(nome.indexOf(".") + 1, nome.indexOf(cont) + 1) + nome.substring(nome.indexOf("(") - 1, nome.lastIndexOf("2") + 1)+nome.substring(nome.lastIndexOf("2") +2,nome.lastIndexOf(")")+1);                         
                    System.out.println(a);
                    for (int i = 0; i < TavoliList.size(); i++) {
                        Tavoli tavol = (Tavoli) TavoliList.get(i);
                        System.out.println(tavol.getNome());
                        if (tavol.getNome().equals(a)) {
                            return tavol;
                        }
                    }
                    break;
                }
                index++;

            }
        }
        if (nome.contains("(4 People)")) {
            for (;;) {
                if (nome.contains(String.valueOf(index))) {
                    String cont = String.valueOf(index);
                    a = nome.substring(nome.indexOf("T"), nome.indexOf(".") + 1)+" " + nome.substring(nome.indexOf(".") + 1, nome.indexOf(cont) + 1) + nome.substring(nome.indexOf("(") - 1, nome.lastIndexOf("4") + 1)+nome.substring(nome.lastIndexOf("4") +2,nome.lastIndexOf(")")+1);  
                    for (int i = 0; i < TavoliList.size(); i++) {
                        Tavoli tavol = (Tavoli) TavoliList.get(i);
                        System.out.println(a);
                        if (tavol.getNome().trim().equals(a.trim())) {
                            return tavol;
                        }
                    }
                    break;
                }
                index++;

            }
        }
        if (nome.contains("(8 People)")) {
            for (;;) {
                if (nome.contains(String.valueOf(index))) {
                    String cont = String.valueOf(index);
                    a = nome.substring(nome.indexOf("T"), nome.indexOf(".") + 1)+" " + nome.substring(nome.indexOf(".") + 1, nome.indexOf(cont) + 1) + nome.substring(nome.indexOf("(") - 1, nome.lastIndexOf("8") + 1)+nome.substring(nome.lastIndexOf("8") +2,nome.lastIndexOf(")")+1);  
                    for (int i = 0; i < TavoliList.size(); i++) {
                        Tavoli tavol = (Tavoli) TavoliList.get(i);
                        if (tavol.getNome().trim().equals(a.trim())) {
                            return tavol;
                        }
                    }
                    break;
                }
                index++;

            }
        }

        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a Antipasti
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a Antipasti, null se la
     * sua tipologia e diversa
     */
    public Pietanze getPietanzeAntipasti(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Antipasti")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a PrimiPiatti
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a PrimiPiatti, null se
     * la sua tipologia e diversa
     */
    public Pietanze getPietanzePrimipiatti(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Primi piatti")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a Secondi
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a Secondi, null se la
     * sua tipologia e diversa
     */
    public Pietanze getPietanzeSecondi(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Secondi")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a Contorni
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a Contorni, null se la
     * sua tipologia e diversa
     */
    public Pietanze getPietanzeContorni(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Contorni")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a Pizze
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a Pizze, null se la sua
     * tipologia e diversa
     */
    public Pietanze getPietanzePizze(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Pizze")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a Frutta
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a Frutta, null se la
     * sua tipologia e diversa
     */
    public Pietanze getPietanzeFrutta(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Frutta")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo controlla che la tipologia del piatto sia uguale a Dessert
     *
     * @param i index dell' ArrayList che viene controllato
     * @return una pietanza se la sua tipologia e uguale a Dessert, null se la
     * sua tipologia e diversa
     */
    public Pietanze getPietanzeDessert(int i) {
        Pietanze piet = (Pietanze) PietanzeList.get(i);
        if (piet.getTipologia().equalsIgnoreCase("Dessert")) {
            return piet;
        }
        return null;
    }

    /**
     * Il metodo aggiunge un ogggetto pietaza all'ArrayList
     *
     * @param nome Indica il nome che si vuole assegnare alla portata
     * @param prezzo Indica il prezzo che si vuole assegnare alla portata
     * @param descrizione Indica la descizione che si vuole asseegnare alla
     * portata
     * @param tipologia Indica la tipologia di portata(antipasto,primo
     * piatto,secondo...)
     */
    public void AddPietanza(String nome, float prezzo, String descrizione, String tipologia) {
        Pietanze pietanza = new Pietanze(nome, prezzo, descrizione, tipologia);
        PietanzeList.add(pietanza);
    }

    /**
     * Il metodo crea un oggetto tavolo da 2 persone e lo aggiunge all'ArrayList
     *
     * @param num Numero di persone presenti al tavolo
     * @param disp Parametro di disponibilita del tavolo(libero,occupato,in
     * attesa di conto...)
     */
    public void addTav2People(String num, String disp) {

        Tavoli a = new Tavoli(Integer.parseInt(num), disp, nome + NumTav2P + " " + "(2People)", Float.parseFloat("0"));
        TavoliList.add(a);
        NumTav2P++;

    }

    /**
     * Il metodo crea un oggetto tavolo da 4 persone e lo aggiunge all'ArrayList
     *
     * @param num Numero di persone presenti al tavolo
     * @param disp Parametro di disponibilita del tavolo(libero,occupato,in
     * attesa di conto...)
     */
    public void addTav4People(String num, String disp) {

        Tavoli a = new Tavoli(Integer.parseInt(num), disp, nome + NumTav4P + " " + "(4People)", Float.parseFloat("0"));
        TavoliList.add(a);
        NumTav4P++;

    }

    /**
     * Il metodo crea un oggetto tavolo da 6 persone e lo aggiunge all'ArrayList
     *
     * @param num Numero di persone presenti al tavolo
     * @param disp Parametro di disponibilita del tavolo(libero,occupato,in
     * attesa di conto...)
     */
    public void addTav6People(String num, String disp) {

        Tavoli a = new Tavoli(Integer.parseInt(num), disp, nome + NumTav6P + " " + "(6People)", Float.parseFloat("0"));
        TavoliList.add(a);
        NumTav6P++;

    }

    /**
     * Il metodo crea un oggetto tavolo da u persone e lo aggiunge all'ArrayList
     *
     * @param num Numero di persone presenti al tavolo
     * @param disp Parametro di disponibilita del tavolo(libero,occupato,in
     * attesa di conto...)
     */
    public void addTav8People(String num, String disp) {

        Tavoli a = new Tavoli(Integer.parseInt(num), disp, nome + NumTav8P + " " + "(8People)", Float.parseFloat("0"));
        TavoliList.add(a);
        NumTav8P++;
    }
    
    /**
     * Il seguente metodo ci permette di stampare uno scontrino in pdf 
     * contenente il nome del ristorante,l'orario,le pietanze ordinate 
     * dal cliente e il conto totale
     * @param filename nome assegnamo al file pdf che viene creato
     * @param ordini passaggio di un arrayList di (Ordini) che ci serverà a stampare gli ordini fatti dal cliente 
     */
    public void stampaScontrino(String filename,ArrayList ordini){
        float PrezzoTotale = 0;
        try{
            Document document = new Document(PageSize.B6, 10, 10, 10, 10);
            PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
            document.open();
            document.newPage();
            document.add(new Paragraph(""));
            LocalTime ora = LocalTime.now();
            String[] oraString;
            oraString = ora.toString().split(":");
            String orario = oraString[0]+":"+oraString[1];
            document.add(new Paragraph("Bar Ristorante Pizzeria Alle Palme"+" "+" "+"Ore:"+orario));
            document.add(new Paragraph("Qt."+" "+"Nome"+" "+"Prezzo"));
            document.add(new Paragraph("                    "));
            for(int i = 0; i < ordini.size(); i++){
               Ordini ord = (Ordini) ordini.get(i);
               String a ="X"+ord.getQuantità()+" "+ord.getNome()+" "+ord.getPrezzo()*ord.getQuantità();
               document.add(new Paragraph(a));
            }
            for(int i = 0; i < ordini.size(); i++){
                Ordini ord = (Ordini) ordini.get(i);
                float Prezzo = ord.getQuantità()*ord.getPrezzo();
                System.out.println(Prezzo);
                PrezzoTotale += Prezzo;
            }
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("Conto Totale:"+" "+PrezzoTotale));
            document.close();
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(filename + ".pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                    JOptionPane.showMessageDialog(null, "Il file pdf e' gia aperto o utilizzato da un altro programma");
                }
        }
        }
        catch(DocumentException | FileNotFoundException e){
        }
        
        
    }
    /**
     * Il seguente metodo ci permette di stampare in un file txt tutte le 
     * pietanze ordinate che siano però diverse da quelle già inserite
     * @param nomeTavolo nome che assegnamo al file che conterà le informazioni del tavolo
     * @param ordini arrayList che contiene gli ordini fatti fino a quel momento dal tavolo
     */
    public void salvaPietanze(String nomeTavolo,ArrayList ordini){
        BufferedWriter a = null;
        try {
            File file = new File(nomeTavolo);
            a = new BufferedWriter(new FileWriter(file,true));
            for(int i = 0; i < ordini.size(); i++){
                Ordini ord = (Ordini) ordini.get(i);
                a.write(ord.getNome());
                a.write(ord.getQuantità());
                a.write(String.valueOf(ord.getPrezzo()));
            }
        } catch (IOException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                a.close();
            }catch (IOException ex) {
                Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    /**
     * Il seguente metodo ci permette di stampare in un file txt tutte le 
     * pietanze ordinate che siano però uguali ad almeno una delle pietanze già inserite
     * @param nomeTavolo nome che assegnamo al file che conterà le informazioni del tavolo
     * @param ordini arrayList che contiene gli ordini fatti fino a quel momento dal tavolo
     */
    public void salvaPietanzeUguali(String nomeTavolo,ArrayList ordini){
        BufferedWriter a = null;
        try {
            File file = new File(nomeTavolo);
            file.delete();
            file.createNewFile();
            a = new BufferedWriter(new FileWriter(file,true));
            for(int i = 0; i < ordini.size(); i++){
                Ordini ord = (Ordini) ordini.get(i);
                a.write(ord.getNome());
                a.write(" ");
                a.write(String.valueOf(ord.getQuantità()));
                a.write(" ");
                a.write(String.valueOf(ord.getPrezzo()));
                a.write(System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                a.close();
            }catch (IOException ex) {
                Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void saveTavoli() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("SalvataggioTavoli.dat");
            ObjectOutputStream s = new ObjectOutputStream(out);
            s.writeObject(TavoliList);
            JOptionPane.showMessageDialog(null, "Salvataggio tavoli avvenuto con successo");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void ricaricaTavoli(){
        FileInputStream in = null;
                try {
                    in = new FileInputStream("SalvataggioTavoli.dat");
                    ObjectInputStream s = new ObjectInputStream(in);
                    TavoliList = (ArrayList) s.readObject();
                    JOptionPane.showMessageDialog(null,"Salvataggio tavoli ricaricato con successo");
                } catch (FileNotFoundException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void savePietanze() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("SalvataggioPietanze.dat");
            ObjectOutputStream s = new ObjectOutputStream(out);
            s.writeObject(PietanzeList);
            JOptionPane.showMessageDialog(null, "Salvataggio Pietanze avvenuto con successo");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void riccaricaPietanze(){
        FileInputStream in = null;
                try {
                    in = new FileInputStream("SalvataggioPietanze.dat");
                    ObjectInputStream s = new ObjectInputStream(in);
                    PietanzeList = (ArrayList) s.readObject();
                    JOptionPane.showMessageDialog(null,"Salvataggio Pietanze ricaricato con successo");
                } catch (FileNotFoundException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RistoranteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getTavoliListSize(){
        return TavoliList.size();
    }
    public int getPietanzeListSize(){
        return PietanzeList.size();
    }

}