package Model;

import java.util.List;

/**
 *
 * @author bspor
 */
public class MenuService {
    private IMenuDAO menuDAO;

    public MenuService() {
        DBAccessor db = new LocalSQLDB();
        menuDAO = new MenuDAO(db);
    }
    
    public List <MenuItem> getAllMenuItems () {
        return menuDAO.getAllMenuItems();
    }
}
