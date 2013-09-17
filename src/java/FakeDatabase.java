/**
 *
 * @author bspor
 */
public class FakeDatabase {
     private MenuItem[] menuItems = {
        new MenuItem("001", "Steak", "12.99"),
        new MenuItem("002","Hamburger", "3.99"),
        new MenuItem("003","Milk Shake", "1.99")
    };
     
     public final MenuItem findItem(final String menuId) {
        // validation is needed
        MenuItem menuItem = null;
        for (MenuItem m : menuItems) {
            if (menuId.equals(m.getMenuName())) {
                menuItem = m;
                break;
            }
        }
        return menuItem;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}
