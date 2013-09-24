package Model;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bspor
 */
public class Receipt {

    public Receipt() throws SQLException {
        MenuBad menu = new MenuBad();
    }

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

    // Loop through all items to get a total. There is no applied discount.
    private double getTotalBeforeDiscount() {
        double grandTotal = 0.0;
        for (MenuItem item : menuItems) {
            grandTotal += Double.valueOf(item.getMenuPrice());
        }
        //grandTotal = (double)Math.round(grandTotal * 100) / 100;
        return roundDoubles(grandTotal);
    }

    //Made a quick rounding function 
    private double roundDoubles(double x) {
        x = (double) Math.round(x * 100) / 100;
        return x;
    }

    //Made a quick date function
    private String todaysDateAndTime() {
        Date myDate = new Date();
        //
        //yyyy-MM-dd:HH-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a   dd-MMM-yyyy");
        String myCurrtentDateAndTime = sdf.format(myDate);
        return myCurrtentDateAndTime;
    }

    public String finalizeSaleAndPrintReceipt() {
//        int countItems = 0;
//        StringBuilder sb = new StringBuilder("Thanks for Shopping With Us\n");
//        sb.append("#   Description").append("\t\tPrice").append("\n");
//        sb.append("===================================").append("\n");
//        //Loop through each item
//        for (MenuItem item : menuItems) {
//            //Create my string
//            sb.append(item.getQty()).append("   ")
//                    .append(item.getMenuName()).append("\t$")
//                    .append(roundDoubles(Double.valueOf(item.getMenuPrice()))).append("\n");
//            countItems += item.getQty();
//            //Add the price to get a total            
//        }
//        sb.append("===================================").append("\n");
//        sb.append("    Sub Total:").append("\t\t").append("$");
//        sb.append("    Discount:").append("\t\t").append("$");

        //Calculate total due
        double totalDue;
        totalDue = roundDoubles(getTotalBeforeDiscount());
//        sb.append("    Total Due:").append("\t\t").append("$")
//                .append(totalDue).append("\n");
//        sb.append("  Total number of items sold  = ").append(countItems)
//                .append("\n");
//        sb.append(" Purchased @ ").append(todaysDateAndTime())
//                .append("\n");
        System.out.println(totalDue);
        return "WAAAT";
    }
    
    public static void main(String[] args) throws SQLException {
        
        CashRegister cr = new CashRegister();
        MenuBad menu = new MenuBad();
            cr.startNewSale();
            cr.addItemToSale("Big MacBurger", 1);
            cr.addItemToSale("Fries", 1);
            cr.finalizeSale();
    }
}