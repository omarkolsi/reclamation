/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Reclamation;
import Technique.Connexion;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.swing.UIManager.getString;


public class ReclamationServices {
    private Statement st;
         private ResultSet rs;

    public static ReclamationServices getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Statement ste;
    Connection connexion;
    private PreparedStatement ps;
    private Connection connection;

    public ReclamationServices() {

 try {
            connexion = Connexion.getIstanceConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

public ObservableList<Reclamation> displayAll() {
         
        String req="select * from reclamation ";
        ObservableList<Reclamation> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Reclamation p=new Reclamation(rs.getInt("id"),rs.getDate("dateAjout"),rs.getString("description"));
                System.out.println("11"+p);
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


    public void ajouterReclamation(Reclamation r) throws FileNotFoundException {
        try {
            PreparedStatement st = connexion.prepareStatement("INSERT INTO `reclamation` ( `description`)  VALUES (?)");
          // InputStream is = new FileInputStream(new File(p.getPath()));
               
           
            
            st.setString(1, r.getdescription());
            
            
              
            
            
            System.out.println("sql request" + st);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("yesss" + ex);
        }


    }
    
    
    
      public void modifierReclamation(Reclamation r) {
        try {
            PreparedStatement st = connexion.prepareStatement("UPDATE `reclamation` SET `dateajout`=?,`description`=? WHERE `id`=?");
               
            st.setDate(1, r.getdateAjout());
           
            st.setString(2, r.getdescription());
       
            st.setInt(3, r.getId());
            
            
           
           
        
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("yesss" + ex);
        }
    }

    public void supprimerReclam(Reclamation r) {
        try {
            PreparedStatement st = connexion.prepareStatement("Delete from `reclamation` where `id`=?");
            st.setInt(1, r.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     public List<Reclamation> findAll() {
        List<Reclamation> listReclamation = new ArrayList<>();
        String requete = "select * from reclamation";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
                     //  rs=st.executeQuery(req);

        
            while (resultat.next()) {
                               // Reclamation p=new Reclamation(rs.getInt("id"),rs.getDate("dateAjout"),rs.getString("description"));

                Reclamation p = new Reclamation();

                p.setId(resultat.getInt(1));
                p.setdateAjout(resultat.getDate(2));
              p.setdescription(resultat.getString(3));
                
              listReclamation.add(p);
              
            }
            
            return listReclamation;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
            return null;
        }
    }
     

//    public void ajouterReclamation(Reclamation r, int i, String hjhjh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
  
public List<Reclamation> getAlltout() {
               String req = "select * from reclamation";
        List<Reclamation> reclamations = new ArrayList<>();
        try {
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Reclamation r= new Reclamation (rs.getInt(1), rs.getDate(2),getString(3));
                reclamations.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reclamations;
    }

}
