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
public class RestaurantTables {
    
    int id;
    int x;
    int y;

    public RestaurantTables(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public RestaurantTables() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", x=" + x + ", y=" + y + '}';
    }
    
    
    
}
