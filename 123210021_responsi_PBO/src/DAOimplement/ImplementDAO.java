/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface ImplementDAO {
    public void insert(databuku p);
     public void update(databuku p);
      public void delete(databuku p);
       public void search(databuku p);
       public List <databuku> getAll();
}
