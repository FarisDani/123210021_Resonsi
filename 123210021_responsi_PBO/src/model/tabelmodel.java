/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lab Informatika
 */
public class tabelmodel extends AbstractTableModel{
  List<databuku> db;

    public tabelmodel(List<databuku> db) {
        this.db = db;
    }
  @Override
  public int getRowCount(){
  return db.size();
}
  @Override
  public int getColumnCount(){
  return 7;
  }
  @Override
        public String getColumnName(int column){
  if (column ==0) {return "Id";}
  else if (column ==1) {return "Judul";}
   else if (column ==2) {return "Genre";}
   else if (column ==3) {return "Penulis";}
   else if (column ==4) {return "Penerbit";}
   else if (column ==5) {return "Lokasi";}
   else if (column ==6) {return "Stock";}
   else {return null;}
  }
  @Override
        public Object getValueAt(int row, int column){
  if (column ==0) {return db.get(row).getId();}
  else if (column ==1) {return db.get(row).getJudul();}
   else if (column ==2) {return db.get(row).getGenre();}
   else if (column ==3) {return db.get(row).getPenulis();}
   else if (column ==4) {return db.get(row).getPenerbit();}
   else if (column ==5) {return db.get(row).getLokasi();}
   else if (column ==6) {return db.get(row).getStock();}
   else {return null;}
  }
  
  
}
