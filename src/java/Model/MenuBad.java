package Model;

import java.util.Map;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class MenuBad {

    private int menuID;
    private String itemName;
    private double itemPrice;
    private int catID;
    private List menuList;
    private DBAccessor dba;
    LocalSQLDB db = new LocalSQLDB();

    public MenuBad() throws SQLException {
        try {

            db.openConnection("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/restraunt",
                    "root", "admin");
            this.menuList = db.findRecords("SELECT * FROM menu", true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuBad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MenuBad.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

    public HashMap getMenuItemByName(String itemName) {
        int j = 0;
        while (j < menuList.size()) {
            HashMap<String, Object> map = (HashMap<String, Object>) menuList.get(j);
            if (map.get("item_name").equals(itemName)) { //magic number
                return map;
            }
            j++;
        }
        return null;
    }

    public HashMap getMenuItemByID(int itemID) {
        int j = 0;
        while (j < menuList.size()) {
            HashMap<String, Object> map = (HashMap<String, Object>) menuList.get(j);
            if (map.get("item_id") == (itemID)) { //magic number

                //System.out.println(map.get("item_name"));
                return map;
            }
            j++;
        }
        return null;
    }

    public List getMenuNames() {
        List fullMenu = new ArrayList();

        int j = 0;
        while (j < menuList.size()) {
            HashMap<String, Object> map = (HashMap<String, Object>) menuList.get(j);
            fullMenu.add(map.get("item_name"));//magic number

            j++;
        }
        return fullMenu;
    }

    public static void main(String[] args) throws SQLException {
        MenuBad menu = new MenuBad();
        //HashMap map = menu.getMenuItemByName("Big MacBurger");
        HashMap map = menu.getMenuItemByID(1);
        
        List recs = menu.getMenuNames();
        Iterator it = recs.iterator();
        int i = 0;
        while(it.hasNext()) {
            ++i;
            // Notice we're outputting some HTML. Is that a good idea?
            // Also, notice we do not cast the object returned by the
            // iterator to a String. Why?
            //System.out.println("<br>try: " + it.next());
            System.out.println(menu.getMenuItemByID(i).get("item_name"));
            
        }

    }
}