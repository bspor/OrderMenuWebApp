/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author bspor
 */
public interface IMenuDAO {

    List<MenuItem> getAllMenuItems();

    void save(MenuItem menu);
    
}
