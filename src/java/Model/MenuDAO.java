package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class MenuDAO implements IMenuDAO {

    private static final String FIND_ALL_MENU_ITEMS = "SELECT * FROM menu";
    private DBAccessor db;

    public MenuDAO() {
    }

    public MenuDAO(DBAccessor db) {
        this.db = db;
    }

    @Override
    public void save(MenuItem menu) {
        String tableName = "menu";
        List<String> menuNames = new ArrayList<String>();
        //Fix these magic numbers
        menuNames.add("item_id");
        menuNames.add("item_name");
        menuNames.add("item_price");
        menuNames.add("cat_id");

        List menuValues = new ArrayList();
        menuValues.add(menu.getMenuId());
        menuValues.add(menu.getItemId());
        menuValues.add(menu.getItemPrice());
        menuValues.add(menu.getCatId());
        try {
            // if the id is null, it's a new record, else it's an update
            if (menu.getItemId() == null) {
                db.insertRecord(
                        tableName, menuNames,
                        menuValues, true);
            } else {
                db.updateRecords(
                        tableName, menuNames,
                        menuValues, "ID", menu.getMenuId(), true);
            }
        } catch (Exception e1) {
            try {
                throw new Exception(e1.getMessage(), e1);
            } catch (Exception ex) {
                Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public List<MenuItem> getAllMenuItems() {


        List<Map> rawData = new ArrayList<Map>();
        List<MenuItem> records = new ArrayList<MenuItem>();

        try {
            rawData = db.findRecords(FIND_ALL_MENU_ITEMS, true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuItem menuItem = null;

        // Translate List<Map> into List<MenuItem>
        for (Map m : rawData) {
            menuItem = new MenuItem();

            int id = (int) m.get("menu_id");
            menuItem.setMenuId(id);
            String itemName = m.get("item_name").toString();
            menuItem.setItemId(itemName);
            Double itemPrice = (Double) m.get("menu_price");
            menuItem.setItemPrice(itemPrice);
            int catId = (int) m.get("cat_id");
            menuItem.setCatId(catId);
            records.add(menuItem);
        }

        return records;
    }
}
