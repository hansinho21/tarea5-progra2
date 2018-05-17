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
    private String idTable;
    private Date date;
    private String time;
    Client ciente = new Client();
    
    public Reservation() {
    }

    public Reservation(int ID, String idTable, Date date, String time) {
        this.ID = ID;
        this.idTable = idTable;
        this.date = date;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
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
