package Model;


import java.util.Map;



        
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brandon
 */
public class Menu {
    private int menuID;
    private String itemName;
    private double itemPrice;
    private int catID;
    private List menuList;
    private DBAccessor dba;
    DB_Generic db = new DB_Generic();
    public Menu() throws SQLException {
        try {
            
            db.openConnection("com.mysql.jdbc.Driver", 
                    "jdbc:mysql://localhost:3306/restraunt", 
                    "root", "admin");
            this.menuList = db.findRecords("SELECT * FROM menu", true);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }   
    
    public HashMap getMenuItemByName (String itemName){      
        int j = 0;
	while (j < menuList.size()) {
            HashMap<String, Object> map = (HashMap<String, Object>) menuList.get(j);
            if (map.get("item_name").equals(itemName)  ) { //magic number
                
              //System.out.println(map.get("item_name"));
                return map;
            }  
            j++;
	}
        return null;
    }
    
    public HashMap getMenuItemByID (int itemID){      
        int j = 0;
	while (j < menuList.size()) {
            HashMap<String, Object> map = (HashMap<String, Object>) menuList.get(j);
            if (map.get("item_id") == (itemID)  ) { //magic number
                
              //System.out.println(map.get("item_name"));
                return map;
            }  
            j++;
	}
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        //HashMap map = menu.getMenuItemByName("Big MacBurger");
        HashMap map = menu.getMenuItemByID(1);
        System.out.println(map);
        
    }
}