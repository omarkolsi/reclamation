/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;





public class Reclamation {

    private int id;
    private Date dateAjout;
    private String description;
   
   
    public Reclamation() {
    }

    public Reclamation(int id,Date dateAjout , String description) {
        this.id = id;
        this.dateAjout = dateAjout;
        this.description = description;
       // this.numberetoil = numberetoil;
      //this.numberchambre = numberchambre;
        //this.visibilite = visibilite;
          //this.aime = aime;
    }
//
//    public Reclamation(Date dateAjout, String description) {
//        this.dateAjout = dateAjout;
//        this.description = description;
//    }
       public Reclamation(Date dateAjout) {
        this.dateAjout = dateAjout;
        
    }
    
    
//....................

    public Reclamation(String description) {
        this.description = description;
    }
    
    
//.......................
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getdateAjout() {
        return dateAjout;
    }

    public void setdateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    /*public int getNumberetoil() {
        return numberetoil;
    }

    public void setNumberetoil(int numberetoil) {
        this.numberetoil = numberetoil;
    }

    public int getNumberchambre() {
        return numberchambre;
    }

    public void setNumberchambre(int numberchambre) {
        this.numberchambre = numberchambre;
    }

    public int getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(int visibilite) {
        this.visibilite = visibilite;
    }

    public int getAime() {
        return aime;
    }

    public void setAime(int aime) {
        this.aime = aime;
    }*/

    @Override
    public  String toString() {
        return "Reclamation{" + "\nid=" + id + ", \ndateAjout=" + dateAjout + ", \ndescription=" + description + '}';
    }
    
    

   
}