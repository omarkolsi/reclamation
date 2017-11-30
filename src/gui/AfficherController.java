/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Reclamation;
import Technique.Connexion;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import Technique.Connexion;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import Service.ReclamationServices;
import gui.FXMLAjoutReclaController;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Entities.Reclamation;

/**
 * FXML Controller class
 *
 * @author rayen-sat
 */
public class AfficherController implements Initializable {
private ReclamationServices tc=new ReclamationServices();
private Reclamation t=new Reclamation();
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, Integer> columnId;
    @FXML
    private TableColumn<Reclamation, String> colomnDate;
    @FXML
    private TableColumn<Reclamation, String> colomnDescription;
    @FXML
    private Button btnSupp;
    private ObservableList<Reclamation> data;
    @FXML
    private Button affichier;
    
    ReclamationServices ser=new ReclamationServices();
        List<Reclamation>listcommontaire = ser.findAll();
         ObservableList<Reclamation> datat;
    @FXML
    private TextField messager;
    @FXML
    private Label affilabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO
    List<Reclamation> listForm;
    listForm = new ArrayList<>();
          data =
        FXCollections.observableArrayList();
        
        listForm = tc.findAll();
        System.out.println(listForm);
        System.out.println("***********");
        for(Reclamation c:listForm){
            System.out.println("aaa"+c);
            data.add(c);
            
        }
//        Reclamation rec;
//                messager.setText("N° réclamation : " + Integer.toString(rec.getId()) + "\nLe client:" + " "+ " " + " "  + "\nLa date de la réclamation : " + String.valueOf(rec.getdateAjout()) + "\nDescription : " + rec.getdescription());
    int i;

        //messager.setText();
       messager.setText(listForm.toString());    
          
            
            
        
    columnId.setCellValueFactory( new PropertyValueFactory<>("id"));
    colomnDate.setCellValueFactory( new PropertyValueFactory<>("dateAjout"));
    colomnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    
   
    
        System.out.println("55555555555555555555555");
        System.out.println(data);
//        ObservableList<commentaire> data = FXCollections.observableArrayList(listForm);
        System.out.println(data);
        table.setItems(data);
 
        
         
    }    
public void resetTableData(List<Reclamation> list){
    List<Reclamation> myResult = tc.findAll();
    System.out.println("controller.Commentaire_ajoutController.resetTableData()");
    System.out.println(myResult);
       
        ObservableList<Reclamation> data = FXCollections.observableArrayList(myResult);
         
 columnId.setCellValueFactory( new PropertyValueFactory<>("id"));
    colomnDate.setCellValueFactory( new PropertyValueFactory<>("dateAjout"));
    colomnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));  
    //table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> afficheDeta(newValue));


       
        table.setItems(data);
        
        
    }   
  private void afficheDeta(Reclamation rec) {

        messager.setText("N° réclamation : " + Integer.toString(rec.getId()) + "\nLe client:" + " "+ " " + " "  + "\nLa date de la réclamation : " + String.valueOf(rec.getdateAjout()) + "\nDescription : " + rec.getdescription());
        //emailtf.setText(rec.getUser().getEmail());
        messager.setVisible(true);
        affilabel.setVisible(true);
        messager.setEditable(false);

    }


    @FXML
    private void supprimer(ActionEvent event) {
                t=table.getSelectionModel().getSelectedItem();
       tc.supprimerReclam(t);
        List<Reclamation> listForm = new ArrayList<>();
        
        listForm = tc.findAll();
        
        resetTableData(listForm);
    }

    @FXML
    private void affichierr(ActionEvent event) {
        
    }
    
    
}
