/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ordini;
import Model.Pietanze;
import Model.RistoranteModel;
import Model.Tavoli;
import View.OrdinazioneTavoli;
import View.AddPietanzaFrame;
import View.ModificaPietanzaFrame;
import View.PaginaDiLogin;
import View.RistoranteView;
import View.SceltaDisponibilitaTav;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  
 * @author Carmine Annunziata
 */

public class RistoranteController implements ActionListener{
    
    public JFrame a;
    public AddPietanzaFrame adf;
    public static RistoranteView RView;
    public SceltaDisponibilitaTav b;
    public RistoranteModel Rmod;
    public ModificaPietanzaFrame MpF;
    public SceltaDisponibilitaTav Sdt;
    public PaginaDiLogin Pgl;
    
    private OrdinazioneTavoli ordTav;
    private Tavoli tav;
    private Pietanze piet;
    private String disp;
    private String num;
    private boolean dispb = false;
    private boolean numb = false;
    private int cont = 0;
    
    
    public RistoranteController(JFrame a, RistoranteModel r) {
        if (a instanceof RistoranteView) {
            RView = (RistoranteView) a;
        }
        if (a instanceof SceltaDisponibilitaTav) {
            this.Sdt = (SceltaDisponibilitaTav) a;
        }
        if (a instanceof AddPietanzaFrame) {
            this.adf = (AddPietanzaFrame) a;
        }
        if (a instanceof OrdinazioneTavoli) {
            this.ordTav = (OrdinazioneTavoli) a;
        }
        if (a instanceof ModificaPietanzaFrame) {
            this.MpF = (ModificaPietanzaFrame) a;
        }
        if (a instanceof PaginaDiLogin){
            this.Pgl = (PaginaDiLogin) a;
        }
        this.Rmod = r;
        

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String NomePietanza = null;
        String PrezzoPortata = null;
        String TipoPortata = null;
        String DescrizionePietanza = null;
        AbstractButton src = (AbstractButton) ae.getSource();
        System.out.println(src.getText());
        if(src.getText().equals("LOGIN")){
            String nome = Pgl.getNomeLogin();
            String password = Pgl.getPasswordLogin();
            if(nome.equals("admin") && password.equals("admin")){
                Pgl.setVisible(false);
                RistoranteView a = new RistoranteView();
                a.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(Pgl, "Errore inserimento dati di login");
            }
        }
        
        if (src.getText().equalsIgnoreCase("save")) {
            Boolean bool = true;
            Boolean bool2 = true;
            try {
                NomePietanza = adf.getNamePietanza();
                System.out.println(NomePietanza);

                if (adf.getNamePietanza().length() == 0) {
                    throw new Exception();

                }
                bool = true;
            } catch (Exception ex) {
                if (NomePietanza == null) {
                    JOptionPane.showMessageDialog(adf, "Errore in Nome Pietanza");
                }
                if (adf.getNamePietanza().length() == 0) {
                    JOptionPane.showMessageDialog(adf, "Aggiungere un Nome alla Portata ");
                }
                bool = false;
            }

            try {
                DescrizionePietanza = adf.getDescrizionePietanza();
                PrezzoPortata = adf.getPrezzoPietanza();
                Float.parseFloat(PrezzoPortata);
                if (adf.getPrezzoPietanza().length() == 0) {
                    throw new NumberFormatException();
                }
                if (adf.getDescrizionePietanza().length() == 0) {
                    throw new NumberFormatException();
                }
                TipoPortata = adf.getTipoPortata();

                bool2 = true;
            } catch (NumberFormatException e) {
                if (PrezzoPortata == null) {
                    JOptionPane.showMessageDialog(adf, "Errorore in Prezzo Pietanza");
                }
                if (adf.getPrezzoPietanza().length() == 0) {
                    JOptionPane.showMessageDialog(adf, "Aggiungere un prezzo alla portata");
                }
                if (DescrizionePietanza == null) {
                    JOptionPane.showMessageDialog(adf, "Errorore in Descrizione Pietanza");
                }
                if (adf.getDescrizionePietanza().length() == 0) {
                    JOptionPane.showMessageDialog(adf, "Aggiungere un descrizione alla portata");
                }
                bool2 = false;
                JOptionPane.showMessageDialog(adf, "Errore in dati inseriti");
                
            }
            if (bool == true && bool2 == true) {
                Rmod.AddPietanza(NomePietanza, Float.parseFloat(PrezzoPortata), DescrizionePietanza, TipoPortata);
                adf.setVisible(false);
                JOptionPane.showMessageDialog(RView, "Pietanza salvata nel Menu");
            }
        }
        if (src.getText().equalsIgnoreCase("Resetta Tavoli")) {
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.resetTextField();
            for(int i = 0; i < RistoranteModel.TavoliList.size(); i++){
                RistoranteModel.TavoliList.remove(i);
            }
            
        }
        
        if (src.getText().equalsIgnoreCase("Salva Tavoli")) {
            Rmod.saveTavoli();
        }
        if (src.getText().equalsIgnoreCase("Salva Pietanze")) {
            Rmod.savePietanze();
        }
        
        if (src.getText().equalsIgnoreCase("Ricarica Tavoli")) {
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            for(int i = 0; i < RistoranteModel.TavoliList.size(); i++){
                RistoranteModel.TavoliList.remove(i);
            }
            Rmod.ricaricaTavoli();
            RView.stampaTavoli();
            RView.updateView();  
            RView.setTextFieldNumTav();
        }
        if (src.getText().equalsIgnoreCase("Ricarica Pietanze")) {
            Rmod.riccaricaPietanze();
        }
        if (src.getText().equalsIgnoreCase("Cerca Pietanza")) {
            Boolean bool = true;
            try {
                NomePietanza = MpF.getNamePietanza();
                System.out.println(MpF.getNamePietanza());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MpF, "Inserire il nome della pietanza che si vuole ricercare");
            }
            for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                piet = (Pietanze) RistoranteModel.PietanzeList.get(i);
                if (piet.getNome().equals(NomePietanza)) {
                    bool = false;
                }
            }
            if (bool == true) {
                JOptionPane.showMessageDialog(MpF, "Non sono presenti nel menu pietanze con il seguente nome");
            }
            if (bool == false) {
                MpF.setDescrizionePortata(piet.getDescrizione());
                MpF.setPrezzoPortata(String.valueOf(piet.getPrezzo()));
                MpF.setTipoPortata(piet.getTipologia());
            }
        }
        if (src.getText().equalsIgnoreCase("ANNULLA")) {
            adf.dispose();
        }
        if (src.getText().equalsIgnoreCase("ANNULLA.")) {
            MpF.dispose();
        }
        if (src.getText().equalsIgnoreCase("RIMUOVI")) {
            Boolean bool = true;
            try {
                NomePietanza = MpF.getNamePietanza();
                System.out.println(MpF.getNamePietanza());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MpF, "Inserire il nome della pietanza che si vuole rimuovere");
            }
            for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                piet = (Pietanze) RistoranteModel.PietanzeList.get(i);
                if (piet.getNome().equals(NomePietanza)) {
                    bool = false;
                }
            }
            if (bool == true) {
                JOptionPane.showMessageDialog(MpF, "Non sono presenti nel menu pietanze con il seguente nome");
            }
            if (bool == false) {
                RistoranteModel.PietanzeList.remove(piet);
                MpF.dispose();
            }
        }

        if (src.getText().equals("Stampa Scontrino")) {
            ordTav.stampaScontrinoFrame();
        }
        
        
        if (src.getText().equalsIgnoreCase("MODIFICA")) {
            Boolean bool = true;
            Boolean bool2 = true;
            Boolean bool3 = true;
            try {
                NomePietanza = MpF.getNamePietanza();
                System.out.println(MpF.getNamePietanza());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MpF, "Inserire il nome di una pietanza");
            }
            for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                piet = (Pietanze) RistoranteModel.PietanzeList.get(i);
                if (piet.getNome().equals(NomePietanza)) {
                    bool = false;
                }
            }
            if (bool == true) {
                JOptionPane.showMessageDialog(MpF, "Non sono presenti nel menu pietanze con il seguente nome");
            }
            if (bool == false) {
                try {
                    MpF.getDescrizionePietanza();
                    if (MpF.getDescrizionePietanza().length() == 0) {
                        throw new Exception();
                    }
                    piet.setDescrizione(MpF.getDescrizionePietanza());
                    bool2 = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(MpF, "Inserire una descrizione alla portata");
                }
                try {
                    MpF.getPrezzoPietanza();
                    if (MpF.getPrezzoPietanza().length() == 0) {
                        throw new Exception();
                    }
                    piet.setPrezzo(Float.parseFloat(MpF.getPrezzoPietanza()));
                    bool3 = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(MpF, "Inserire un Prezzo alla portata");
                }
                try {
                    piet.setTipologia(MpF.getTipoPortata());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(MpF, "Error");
                }
            }
            if (bool2 == false && bool3 == false) {
                JOptionPane.showMessageDialog(MpF, "Dati della Pietanza Modificati");
                MpF.dispose();
            }
        }
        if (src.getText().equalsIgnoreCase("Aggiungi Tavolo")) {
            if (dispb == false && numb == false) {
                Sdt = new SceltaDisponibilitaTav();
                Sdt.setTitle("Scelta Disponibilita");
                Sdt.setVisible(true);
            }
        }
        if (src.getText().equalsIgnoreCase("Aggiungi Pietanza")) {
            adf = new AddPietanzaFrame();
            adf.setVisible(true);
        }

        if (src.getText().equals("Modifica/Rimuovi Pietanza")) {
            MpF = new ModificaPietanzaFrame();
            MpF.setVisible(true);
        }

        if (src.getText().trim().equalsIgnoreCase("libero") || src.getText().trim().equalsIgnoreCase("occupato") || src.getText().equalsIgnoreCase("<html>In attesa di conto</html>") || src.getText().equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
            disp = src.getText();
            dispb = true;
            if (dispb == true && numb == true) {
                if (num.equals("2")) {

                    Rmod.addTav2People(num, disp);
                    JButton button = RView.Tav2Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();

                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }

                }
                if (num.equals("4")) {
                    Rmod.addTav4People(num, disp);
                    JButton button = RView.Tav4Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                if (num.equals("6")) {
                    Rmod.addTav6People(num, disp);
                    JButton button = RView.Tav6Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equals("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                if (num.equals("8")) {
                    Rmod.addTav8People(num, disp);
                    JButton button = RView.Tav8Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                Sdt.setVisible(false);
                RView.updateView();
            }
        }
        if (src.getText().trim().equalsIgnoreCase("2") || src.getText().trim().equalsIgnoreCase("4") || src.getText().trim().equalsIgnoreCase("6") || src.getText().trim().equalsIgnoreCase("8")) {
            num = src.getText();
            numb = true;
            if (dispb == true && numb == true) {
                if (num.equals("2")) {
                    Rmod.addTav2People(num, disp);
                    JButton button = RView.Tav2Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                if (num.equals("4")) {
                    Rmod.addTav4People(num, disp);
                    JButton button = RView.Tav4Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                if (num.equals("6")) {
                    Rmod.addTav6People(num, disp);
                    JButton button = RView.Tav6Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                if (num.equals("8")) {
                    Rmod.addTav8People(num, disp);
                    JButton button = RView.Tav8Pers();
                    if (disp.equalsIgnoreCase("libero")) {
                        RView.setLibero(button);
                        RView.TavLiberi();
                    } else if (disp.equalsIgnoreCase("occupato")) {
                        RView.setOccupato(button);
                        RView.TavOccupati();
                    } else if (disp.equalsIgnoreCase("<html>In attesa di conto</html>")) {
                        RView.setChiestoConto(button);
                        RView.TavChiestoConto();
                    } else if (disp.equalsIgnoreCase("<html>In attesa<br>di pagamento</html>")) {
                        RView.setAttesaDiPagamento(button);
                        RView.TavAttesaPagameno();
                    }
                }
                Sdt.setVisible(false);
                RView.updateView();
            }
        }

        if (src.getText().contains("Tavolo N.")) {
            String Nomtavolo = src.getText();
             Tavoli tav = Rmod.getAllData(Nomtavolo);
             ordTav = new OrdinazioneTavoli("Ordinazione"+" "+tav.getNome());
             ordTav.setVisible(true); 
             
                for(int i = 0; i < OrdinazioneTavoli.Ordinazione.size(); i++){
                    Ordini ord = (Ordini) OrdinazioneTavoli.Ordinazione.get(i);
                    ord.setQuantità(0);
                    
                }

        }
        if (src.getText().equalsIgnoreCase("Antipasti") || src.getText().equalsIgnoreCase("Primi Piatti") || src.getText().equalsIgnoreCase("Secondi") || src.getText().equalsIgnoreCase("Contorni") || src.getText().equalsIgnoreCase("Pizze") || src.getText().equalsIgnoreCase("Frutta") || src.getText().equalsIgnoreCase("Dessert")) {
            Boolean bool = true;
            Boolean bool2 = false;
            //Chiamata di un ciclo che stampa i bottoni dei piatti al click su un pulsante(es. Antipasti)
            if (RistoranteModel.PietanzeList.isEmpty()) {
                JOptionPane.showMessageDialog(ordTav, "Aggiungere almeno una pietanza al menu");
            }
            if (src.getText().equalsIgnoreCase("Antipasti")) {
                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzeAntipasti(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;
                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono Antipasti");
                    ordTav.pulisciPanelPietanze();
                }
            } else if (src.getText().equalsIgnoreCase("Primi piatti")) {
                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzePrimipiatti(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;
                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono Primi piatti");
                    ordTav.pulisciPanelPietanze();
                }
            } else if (src.getText().equalsIgnoreCase("Secondi")) {

                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzeSecondi(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;
                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono Secondi");
                    ordTav.pulisciPanelPietanze();
                }
            } else if (src.getText().equalsIgnoreCase("Contorni")) {
                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzeContorni(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;
                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono Contorni");
                    ordTav.pulisciPanelPietanze();
                }
            } else if (src.getText().equalsIgnoreCase("Pizze")) {
                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzePizze(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;
                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono Pizze");
                    ordTav.pulisciPanelPietanze();
                }
            } else if (src.getText().equalsIgnoreCase("Frutta")) {
                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzeFrutta(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;

                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono piatti di Frutta");
                    ordTav.pulisciPanelPietanze();
                }
            } else if (src.getText().equalsIgnoreCase("Dessert")) {
                ordTav.pulisciPanelPietanze();
                for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
                    // ciclo che stampa bottoni per ogni piatto di tipologia Antipasto(metodo in OrdinazzioneTavoli)
                    Pietanze t = Rmod.getPietanzeDessert(i);
                    // Ciclo richiamato dalla view ch crrea n. bottoni di minimo 20 di pietanza tpo Antipasto
                    try {
                        t.getNome();
                        ordTav.creaBottoniPietanze(t.getNome());
                        bool2 = true;
                    } catch (Exception e) {
                        bool = false;
                    }
                }
                if (bool == false && bool2 == false) {
                    JOptionPane.showMessageDialog(ordTav, "Non ci sono Dessert");
                    ordTav.pulisciPanelPietanze();
                }
            }

        }
        for (int i = 0; i < RistoranteModel.PietanzeList.size(); i++) {
            /* Al click su uno dei pulsanti cliccata all'interno del PanelPietanze verra controllato se il return del bottone 
                 e uguale al nome del piatto presente all'interno dell' arrayList */
            Pietanze t = (Pietanze) RistoranteModel.PietanzeList.get(i);
            if (src.getText().equals(t.getNome())) {
                /*Metodo che al click del bottone crea nel PanelSceltaPietanze delle textfield indicanti la quantita/tipo di 
                     pietanze scelte, il prezzo e il tempo inetro il quale verrano servite queste*/
                ordTav.SceltaPietanze(t.getNome(), "1", String.valueOf(t.getPrezzo()));
            }
        }
    }
}