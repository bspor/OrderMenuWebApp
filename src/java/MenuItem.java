/**
 *
 * @author bspor
 */
public class MenuItem {
    private String menuID, menuName, menuPrice;

    public MenuItem(String menuID, String menuName, String menuPrice) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
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
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }
}
