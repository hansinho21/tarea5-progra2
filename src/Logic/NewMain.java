/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.RestaurantTables;
import java.util.ArrayList;

/**
 *
 * @author fabian
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        RestaurantTables restaurantTables0 = new RestaurantTables(0, 0, 0);
        RestaurantTables restaurantTables1 = new RestaurantTables(1, 0, 1);
        RestaurantTables restaurantTables2 = new RestaurantTables(2, 0, 2);
        RestaurantTables restaurantTables3 = new RestaurantTables(3, 0, 3);
        RestaurantTables restaurantTables4 = new RestaurantTables(4, 0, 4);
        
        RestaurantTables restaurantTables5 = new RestaurantTables(5, 1, 0);
        RestaurantTables restaurantTables6 = new RestaurantTables(6, 1, 1);
        RestaurantTables restaurantTables7 = new RestaurantTables(7, 1, 2);
        RestaurantTables restaurantTables8 = new RestaurantTables(8, 1, 3);
        RestaurantTables restaurantTables9 = new RestaurantTables(9, 1, 4);
        
        RestaurantTables restaurantTables10 = new RestaurantTables(10, 2, 0);
        RestaurantTables restaurantTables11 = new RestaurantTables(11, 2, 1);
        RestaurantTables restaurantTables12 = new RestaurantTables(12, 2, 2);
        RestaurantTables restaurantTables13 = new RestaurantTables(13, 2, 3);
        RestaurantTables restaurantTables14 = new RestaurantTables(14, 2, 4);
        
        RestaurantTables restaurantTables15 = new RestaurantTables(15, 3, 0);
        RestaurantTables restaurantTables16 = new RestaurantTables(16, 3, 1);
        RestaurantTables restaurantTables17 = new RestaurantTables(17, 3, 2);
        RestaurantTables restaurantTables18 = new RestaurantTables(18, 3, 3);
        RestaurantTables restaurantTables19 = new RestaurantTables(19, 3, 4);
        
        RestaurantTables restaurantTables20 = new RestaurantTables(20, 4, 0);
        RestaurantTables restaurantTables21 = new RestaurantTables(21, 4, 1);
        RestaurantTables restaurantTables22 = new RestaurantTables(22, 4, 2);
        RestaurantTables restaurantTables23 = new RestaurantTables(23, 4, 3);
        RestaurantTables restaurantTables24 = new RestaurantTables(24, 4, 4);
        
        
        ArrayList<RestaurantTables> restaurantTables = new ArrayList();
        
        restaurantTables.add(restaurantTables0);
        restaurantTables.add(restaurantTables1);
        restaurantTables.add(restaurantTables2);
        restaurantTables.add(restaurantTables3);
        restaurantTables.add(restaurantTables4);
        
        restaurantTables.add(restaurantTables5);
        restaurantTables.add(restaurantTables6);
        restaurantTables.add(restaurantTables7);
        restaurantTables.add(restaurantTables8);
        restaurantTables.add(restaurantTables9);
        
        restaurantTables.add(restaurantTables10);
        restaurantTables.add(restaurantTables11);
        restaurantTables.add(restaurantTables12);
        restaurantTables.add(restaurantTables13);
        restaurantTables.add(restaurantTables14);
        
        restaurantTables.add(restaurantTables15);
        restaurantTables.add(restaurantTables16);
        restaurantTables.add(restaurantTables17);
        restaurantTables.add(restaurantTables18);
        restaurantTables.add(restaurantTables19);
        
        restaurantTables.add(restaurantTables20);
        restaurantTables.add(restaurantTables21);
        restaurantTables.add(restaurantTables22);
        restaurantTables.add(restaurantTables23);
        restaurantTables.add(restaurantTables24);
        
        
        JsonFiles jF = new JsonFiles();
        
        jF.writeRestaurantJsonFile(restaurantTables);
        
    }
    
}
