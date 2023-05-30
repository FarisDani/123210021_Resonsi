/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdata;
import DAOimplement.ImplementDAO;
import model.databuku;
import java.sql.*;
import java.util.*;

import koneksi.connector;
import model.*;
import controller.databukucontroller;
import java.swing.JOptionPane;
import java.util.longing.Level;
import java.util.longing.Logger;
import view.Perpus;

/**
 *
 * @author Lab Informatika
 */
public class databukuDAO implements ImplementDAO{
    Connection connection;
    final String select = "select * from data;";
    final String insert = "INSERT INTO dataperpus (judul, genre, penulis, penerbit, lokasi, stock) VALUES (?, ?, ?, ?, ?, ?);";
    final String delete = "delete from dataperpus where no_tiket=?";
    final String update= "update `dataperpus` set `judul=?`, `genre=?`, `penulis=?`, `penerbit=?`, `lokasi=?`, `stock=?` WHERE `dataperpus`.`id` = ?";
    
    
    
    
    @Override
    public void insert(databuku p) {
     PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            int notikett = 0;
            while(rs.next()){
                p.setId(rs.getInt(1));
                notikett = rs.getInt(1);
            }
           
           // JOptionPane.showMessageDialog(null, "Nomor Tiket Anda : "+notikett+"", "berhasil", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Input Kosong !", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }   
    }

    @Override
    public void update(databuku p) {
        PreparedStatement statement = null;
        
      }

    @Override
    public void delete(databuku p) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, p.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Mohon Click Data !", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        } 
        
    }

    @Override
    public void search(databuku p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<databuku> getAll() {
       List<databuku> dp = null;
        try{
            dp = new ArrayList<databuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                databuku hp = new databuku();
                hp.setId(rs.getInt("id"));
                hp.setJudul(rs.getString("judul"));
                hp.setPenulis(rs.getString("penulis"));
                hp.setPenerbit(rs.getString("penerbit"));
                hp.setLokasi(rs.getString("lokasi"));
                hp.setStock(rs.getInt("stock"));
                dp.add(hp);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(databukuDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dp;  
    }

    
    
}
