package Model;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bspor
 */
public class MenuItem extends Menu  {
    private Menu menu;
    private String menuID, menuName, menuPrice;
    private int qty;

    public MenuItem(String menuName, int qty) throws SQLException{
        this.menuID = menuID;
        this.qty = qty;
        menu.getMenuItemByName(menuName);
    }
}
