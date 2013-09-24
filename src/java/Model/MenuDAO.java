package Model;

import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brandon
 */
public class MenuDAO {    
    private static final String FIND_ALL_MENU_ITEMS =
            "SELECT * FROM menu";
    private static final String EMP_BY_DEPT_ID =
            "SELECT e.lastname, e.firstname, d.dept_name "
            + "FROM Employee e, Department d "
            + "WHERE e.dept_id = d.dept_id and d.dept_id = ";
    private DBAccessor db;

    public MenuDAO() {
    }
       
    public MenuDAO(DBAccessor db) {
        this.db = db;
    }
    
    
   
}
