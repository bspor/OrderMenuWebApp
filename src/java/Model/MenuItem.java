package Model;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Needs re-design
 * @author bspor
 */
public class MenuItem extends Menu  {
    private Menu menu = new Menu();
    private String menuID, menuName, menuPrice;
    private int qty;

    public MenuItem(String menuName, int qty) throws SQLException{
        this.menuID = menuID;
        this.menuName = menuName;
        this.qty = qty;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPrice() {
        System.out.println("this is my menu name:" + menuName);
        System.out.println(menu.getMenuItemByID(1).get("item_price").toString());
        String price = Double.toString( (Double)menu.getMenuItemByID(1).get("item_price"));
        return price;
    }

 
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
}
