/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdata.databukuDAO;
import model.*;
import view.Perpus;
import DAOimplement.ImplementDAO;
/**
 *
 * @author Lab Informatika
 */
public class databukucontroller {
    Perpus frame;
    ImplementDAO impldatabuku;
    List<databuku> db;

    public databukucontroller(Perpus frame) {
        this.frame = frame;
        impldatabuku = new databukuDAO();
        db = impldatabuku.getAll();
    }
    
    public void isitabel(){
    db = impldatabuku.getAll();
    tabelmodel mt = new tabelmodel(db);
    frame.getjTable1().setModel(mt);
    }
    
    public void insert(){
    databuku db = new databuku();
    db.setJudul(frame.getJtfjudul().getText());
    db.setGenre(frame.getJtfgenre().getText());
    db.setPenulis(frame.getJtfpenulis().getText());
    db.setPenerbit(frame.getJtfpenerbit().getText());
    db.setLokasi(frame.getJtflokasi().getText());
    db.setStock(Integer.parseInt(frame.getJtfstock().getText()));
    impldatabuku.insert(db);
    }
    
    public void delete(){
    int id = Integer.parseInt(frame.getJlid().getText());
    impldatabuku.delete(id);
    }
    
     public void update(){
    databuku db = new databuku();

    db.setId(Integer.valueOf(frame.getJlid().getText()));
    db.setJudul(String.valueOf(frame.getJtfjudul().getText()));
    db.setGenre(String.valueOf(frame.getJtfgenre().getText()));
    db.setPenulis(String.valueOf(frame.getJtfpenulis().getText()));
    db.setLokasi(String.valueOf(frame.getJtflokasi().getText()));
    db.setStock(Integer.valueOf(frame.getJtfstock().getText()));
    impldatabuku.update(db);
     }
}
