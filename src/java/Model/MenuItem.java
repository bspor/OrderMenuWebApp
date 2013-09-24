/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author bspor
 */
public class MenuItem {
    private int menuId;
    private String itemId;
    private Double itemPrice;
    private int catId;

    public MenuItem() {
    }

    public MenuItem(int menuId, String itemId, Double itemPrice, int catId) {
        this.menuId = menuId;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.catId = catId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.menuId;
        hash = 73 * hash + Objects.hashCode(this.itemId);
        hash = 73 * hash + Objects.hashCode(this.itemPrice);
        hash = 73 * hash + this.catId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.menuId != other.menuId) {
            return false;
        }
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        if (this.catId != other.catId) {
            return false;
        }
        return true;
    }
}
