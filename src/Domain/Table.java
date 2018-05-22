/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author fabian
 */
public class Table {
    
    private int ID;
    private Order order;
    private StateTable status;
    

    public Table() {
        this.status = StateTable.LIBRE;
        this.order = null;
    }

    public Table(Order order, StateTable status) {
        this.order = order;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StateTable getStatus() {
        return status;
    }

    public void setStatus(StateTable status) {
        this.status = status;
    }

    
     
    
}
