/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author fabian
 */
public class Reservation {
    private int ID;
    private Table table;
    private Date date;
    private String time;
    Client ciente = new Client();
    
    public Reservation() {
    }

    public Reservation(int ID, Table table, Date date, String time) {
        this.ID = ID;
        this.table = table;
        this.date = date;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Table getTable() {
        return table;
    }

    public void setIdTable(Table table) {
        this.table = table;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Client getCiente() {
        return ciente;
    }

    public void setCiente(Client ciente) {
        this.ciente = ciente;
    }

    
}
