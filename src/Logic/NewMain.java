/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.ProductsList;
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
        
         JsonFiles jF = new JsonFiles();
        
//        RestaurantTables restaurantTables0 = new RestaurantTables(0, 0, 0);
//        RestaurantTables restaurantTables1 = new RestaurantTables(1, 0, 1);
//        RestaurantTables restaurantTables2 = new RestaurantTables(2, 0, 2);
//        RestaurantTables restaurantTables3 = new RestaurantTables(3, 0, 3);
//        RestaurantTables restaurantTables4 = new RestaurantTables(4, 0, 4);
//        
//        RestaurantTables restaurantTables5 = new RestaurantTables(5, 1, 0);
//        RestaurantTables restaurantTables6 = new RestaurantTables(6, 1, 1);
//        RestaurantTables restaurantTables7 = new RestaurantTables(7, 1, 2);
//        RestaurantTables restaurantTables8 = new RestaurantTables(8, 1, 3);
//        RestaurantTables restaurantTables9 = new RestaurantTables(9, 1, 4);
//        
//        RestaurantTables restaurantTables10 = new RestaurantTables(10, 2, 0);
//        RestaurantTables restaurantTables11 = new RestaurantTables(11, 2, 1);
//        RestaurantTables restaurantTables12 = new RestaurantTables(12, 2, 2);
//        RestaurantTables restaurantTables13 = new RestaurantTables(13, 2, 3);
//        RestaurantTables restaurantTables14 = new RestaurantTables(14, 2, 4);
//        
//        RestaurantTables restaurantTables15 = new RestaurantTables(15, 3, 0);
//        RestaurantTables restaurantTables16 = new RestaurantTables(16, 3, 1);
//        RestaurantTables restaurantTables17 = new RestaurantTables(17, 3, 2);
//        RestaurantTables restaurantTables18 = new RestaurantTables(18, 3, 3);
//        RestaurantTables restaurantTables19 = new RestaurantTables(19, 3, 4);
//        
//        RestaurantTables restaurantTables20 = new RestaurantTables(20, 4, 0);
//        RestaurantTables restaurantTables21 = new RestaurantTables(21, 4, 1);
//        RestaurantTables restaurantTables22 = new RestaurantTables(22, 4, 2);
//        RestaurantTables restaurantTables23 = new RestaurantTables(23, 4, 3);
//        RestaurantTables restaurantTables24 = new RestaurantTables(24, 4, 4);
//        
//        ArrayList<RestaurantTables> restaurantTables = new ArrayList();
//        
//        restaurantTables.add(restaurantTables0);
//        restaurantTables.add(restaurantTables1);
//        restaurantTables.add(restaurantTables2);
//        restaurantTables.add(restaurantTables3);
//        restaurantTables.add(restaurantTables4);
//        
//        restaurantTables.add(restaurantTables5);
//        restaurantTables.add(restaurantTables6);
//        restaurantTables.add(restaurantTables7);
//        restaurantTables.add(restaurantTables8);
//        restaurantTables.add(restaurantTables9);
//        
//        restaurantTables.add(restaurantTables10);
//        restaurantTables.add(restaurantTables11);
//        restaurantTables.add(restaurantTables12);
//        restaurantTables.add(restaurantTables13);
//        restaurantTables.add(restaurantTables14);
//        
//        restaurantTables.add(restaurantTables15);
//        restaurantTables.add(restaurantTables16);
//        restaurantTables.add(restaurantTables17);
//        restaurantTables.add(restaurantTables18);
//        restaurantTables.add(restaurantTables19);
//        
//        restaurantTables.add(restaurantTables20);
//        restaurantTables.add(restaurantTables21);
//        restaurantTables.add(restaurantTables22);
//        restaurantTables.add(restaurantTables23);
//        restaurantTables.add(restaurantTables24);
//  
//        jF.writeRestaurantJsonFile(restaurantTables);
        
//
//        ProductsList productsList0 = new ProductsList(0, "Coca cola", 1000);
//        ProductsList productsList1 = new ProductsList(1, "Fanta", 1000);
//        ProductsList productsList2 = new ProductsList(2, "Refresco natural", 800);
//        ProductsList productsList3 = new ProductsList(3, "Café", 800);
//        ProductsList productsList4 = new ProductsList(4, "Té", 800);
//        
//        ProductsList productsList5 = new ProductsList(5, "Ensalada de lechuga", 1000);
//        ProductsList productsList6 = new ProductsList(6, "Ensalada de caracolitos", 1000);
//        ProductsList productsList7 = new ProductsList(7, "Puré de papa", 1000);
//        ProductsList productsList8 = new ProductsList(8, "Sopa negra", 2000);
//        ProductsList productsList9 = new ProductsList(9, "Sopa de Verduras", 2000);
//        
//        ProductsList productsList10 = new ProductsList(10, "Arroz con carne", 2500);
//        ProductsList productsList11 = new ProductsList(11, "Arroz con pollo", 2500);
//        ProductsList productsList12 = new ProductsList(12, "Chicharrones", 4000);
//        ProductsList productsList13 = new ProductsList(13, "Pasta", 3000);
//        ProductsList productsList14 = new ProductsList(14, "Pescado frito", 5000);
//        
//        ProductsList productsList15 = new ProductsList(15, "Hamburguesa con papas", 2000);
//        ProductsList productsList16 = new ProductsList(16, "Papas fritas", 1500);
//        ProductsList productsList17 = new ProductsList(17, "Nuggets de pollo", 2000);
//        ProductsList productsList18 = new ProductsList(18, "Chalupa", 1500);
//        ProductsList productsList19 = new ProductsList(19, "Pollo frito", 2000);
//        
//        ProductsList productsList20 = new ProductsList(20, "Pastel de chocolate", 1200);
//        ProductsList productsList21 = new ProductsList(21, "Tres leches", 1500);
//        ProductsList productsList22 = new ProductsList(22, "Helado", 2000);
//        ProductsList productsList23 = new ProductsList(23, "Arroz con leche", 1500);
//        ProductsList productsList24 = new ProductsList(24, "Postre de manzana", 2500);
//        
//        ArrayList<ProductsList> productsLists = new ArrayList();
//        
//        productsLists.add(productsList0);
//        productsLists.add(productsList1);
//        productsLists.add(productsList2);
//        productsLists.add(productsList3);
//        productsLists.add(productsList4);
//        
//        productsLists.add(productsList5);
//        productsLists.add(productsList6);
//        productsLists.add(productsList7);
//        productsLists.add(productsList8);
//        productsLists.add(productsList9);
//        
//        productsLists.add(productsList10);
//        productsLists.add(productsList11);
//        productsLists.add(productsList12);
//        productsLists.add(productsList13);
//        productsLists.add(productsList14);
//        
//        productsLists.add(productsList15);
//        productsLists.add(productsList16);
//        productsLists.add(productsList17);
//        productsLists.add(productsList18);
//        productsLists.add(productsList19);
//        
//        productsLists.add(productsList20);
//        productsLists.add(productsList21);
//        productsLists.add(productsList22);
//        productsLists.add(productsList23);
//        productsLists.add(productsList24);
//        
//        jF.writeProductsListJsonFile(productsLists);
        
        
        
    }
    
}
