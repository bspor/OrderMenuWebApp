package Model;


import java.sql.SQLException;

/**
 *
 * @author bspor
 */
public class CashRegister {
    private Receipt receipt;
    
    public CashRegister() {
    }

    /**
     * This method starts a new sale
     * @param custID The customer Id is needed so it can pass it to Receipt
     */
    public void startNewSale() {
        receipt = new Receipt();
    }

    /**
     * This method adds items to the sale
     * @param prodID this is needed for the lineItem to create the product  
     * @param qty  How many of the product
     */
    public void addItemToSale(String prodID, int qty) throws SQLException {
        receipt.addLineItem(prodID, qty);
    }   

    /**
     *  This method simply calls the finalizeSaleAndPrintReceipt method in Receipt
     */
    public void finalizeSale() {
        
    }
}
