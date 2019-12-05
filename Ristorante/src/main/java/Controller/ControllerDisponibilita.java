/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RistoranteModel;
import View.OrdinazioneTavoli;
import View.RistoranteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Carmine AnnunziataAbstractButton src = (AbstractButton) ae.getSource();
 */
public class ControllerDisponibilita implements ActionListener {
    private final RistoranteModel Rmod;
    private OrdinazioneTavoli ordTav;
    public static RistoranteView RView;
    
    public ControllerDisponibilita(JFrame a, RistoranteModel r) {
        if (a instanceof RistoranteView) {
            RView = (RistoranteView) a;
        }
        if (a instanceof OrdinazioneTavoli) {
            this.ordTav = (OrdinazioneTavoli) a;
        }
        this.Rmod = r;
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        JComboBox src = (JComboBox) ae.getSource();
        
        System.out.println(src.getSelectedItem());
        
        if(src.getSelectedItem().equals("Libero")){
            
            ordTav.cambiaDisponibilita("Libero");
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.stampaTavoli();
            RView.setTextFieldNumTav();
            RView.updateView();
            
        }
        if(src.getSelectedItem().equals("libero")){
            
            ordTav.cambiaDisponibilita("libero");
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.stampaTavoli();
            RView.setTextFieldNumTav();
            RView.updateView();
            
        }
        if(src.getSelectedItem().equals("Occupato")){
            
            ordTav.cambiaDisponibilita("Occupato");
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.stampaTavoli();
            RView.setTextFieldNumTav();
            RView.updateView();
            
        }
        if(src.getSelectedItem().equals("occupato")){
            
            ordTav.cambiaDisponibilita("Occupato");
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.stampaTavoli();
            RView.setTextFieldNumTav();
            RView.updateView();
            
        }
        if(src.getSelectedItem().equals("in attesa di pagamento")){
            
            ordTav.cambiaDisponibilita("<html>In attesa<br>di pagamento</html>");
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.stampaTavoli();
            RView.setTextFieldNumTav();
            RView.updateView();
            
        }
        if(src.getSelectedItem().equals("in attesa di conto")){
            
            ordTav.cambiaDisponibilita("<html>In attesa di conto</html>");
            RView.pulisciPanelTavoli();
            RView.resettaNumeroTavoli();
            RView.stampaTavoli();
            RView.setTextFieldNumTav();
            RView.updateView();
            
        }
        
        
        
        
    }


    
    
}
