package Model;


import java.sql.SQLException;

/**
 *
 * @author bspor
 */
public class Receipt {
    MenuItem[] menuItems = new MenuItem[0];
    
    public void addLineItem(String menuName, int qty) throws SQLException {
        MenuItem item = new MenuItem(menuName, qty); //change this
        addToArray(item);
    }

    //Add my items into an array
    private void addToArray(MenuItem item) {
        MenuItem[] tempItems = new MenuItem[menuItems.length + 1];
        System.arraycopy(menuItems, 0, tempItems, 0, menuItems.length);
        tempItems[menuItems.length] = item;
        menuItems = tempItems;
    }
}
