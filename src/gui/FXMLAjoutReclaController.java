/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Reclamation;
import Service.ReclamationServices;
import gui.AfficherController;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rayen-sat
 */
public class FXMLAjoutReclaController implements Initializable {

   
    @FXML
    private TextField txtNomInput_reclam;
     @FXML
    private Button bntAjout;
    
    
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        @FXML
         private void ajouterReclamation(ActionEvent event) throws IOException {
        ReclamationServices ser=new ReclamationServices();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        
         Reclamation reclamation=new Reclamation(txtNomInput_reclam.getText());
        // ou bien Integer.valueOf(txtAge.getText()));
        ser.ajouterReclamation(reclamation);
         
         
         FXMLLoader loader  = new FXMLLoader(getClass().getResource("afficher.fxml"));
         Parent root = loader.load();
         //Parent root = (Parent) loader.load();
          AfficherController affichageController=loader.getController();
         //affichageController.setdescriptionLabel(txtNomInput_reclam.getText());
         
        List<Reclamation> listReclamation = ser.findAll();
        //affichageController.setdescriptionLabel(listReclamation.get(0).getdateAjout().toString());
        for(int i=0;i<listReclamation.size();i++){
            System.out.println(listReclamation.get(i));
        }
         // affichageController.setNomLabel(txtPrenom.getText());
           // affichageController.setNomLabel(txtAge.getText());
            txtNomInput_reclam.getScene().setRoot(root);
    }    
         private void afficheDeta(Reclamation rec) {

        txtNomInput_reclam.setText("N° réclamation : " + Integer.toString(rec.getId()) + "\nLe client:" + " "+ " " + " "  + "\nLa date de la réclamation : " + String.valueOf(rec.getdateAjout()) + "\nSubject : " + rec.getdescription());
        //emailtf.setText(rec.getUser().getEmail());
        txtNomInput_reclam.setVisible(true);
        txtNomInput_reclam.setVisible(true);
        txtNomInput_reclam.setEditable(false);

    }
    
}
