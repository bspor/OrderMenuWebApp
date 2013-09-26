package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    Connection conn;
    private static final String FIND_ALL_MENU_ITEMS = "SELECT * FROM menu";
    private static final String FIND_MENU_ITEM_BY_ID = "select * from employee where item_id = ?";
    private static final String TABLE_NAME = "menu";
    private DBAccessor db;

    public MenuDAO() {
    }

    public MenuDAO(DBAccessor db) {
        this.db = db;
    }

    @Override
    public void save(MenuItem menu) {

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
                        TABLE_NAME, menuNames,
                        menuValues, true);
            } else {
                db.updateRecords(
                        TABLE_NAME, menuNames,
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

    public MenuItem getMenuItemById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // The ? symbol is a placeholder (parameter) for data
        // You can have as many as you need
        String sql = FIND_MENU_ITEM_BY_ID;
        Map rawData = null;
        try {
            rawData = db.getRecordByID(TABLE_NAME, "item_id", id, true);

        } catch (Exception e) {
        }
        MenuItem menuItem = new MenuItem();
        int id2 = (int) rawData.get("item_id");
        menuItem.setMenuId(id2);
        String itemName = rawData.get("item_name").toString();
        menuItem.setItemId(itemName);
        Double itemPrice = (Double) rawData.get("item_price");
        menuItem.setItemPrice(itemPrice);
        int catId = (int) rawData.get("cat_id");
        menuItem.setCatId(catId);

        return null;
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

            int id = (int) m.get("item_id");
            menuItem.setMenuId(id);
            String itemName = m.get("item_name").toString();
            menuItem.setItemId(itemName);
            Double itemPrice = (Double) m.get("item_price");
            menuItem.setItemPrice(itemPrice);
            int catId = (int) m.get("cat_id");
            menuItem.setCatId(catId);
            records.add(menuItem);
        }

        return records;
    }
}
