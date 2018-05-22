/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Product;
import Domain.ProductsList;
import Domain.RestaurantTables;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author fabian
 */
public class JsonFiles {
    
    
    public void writeRestaurantJsonFile(ArrayList<RestaurantTables> restaurantTablesList) {
        
        JSONArray arrayRestaurantTables = new JSONArray();
        for (int i = 0; i < restaurantTablesList.size(); i++) {
            JSONObject tempObj = new JSONObject();
            tempObj.put("ID",restaurantTablesList.get(i).getId());
            tempObj.put("X",restaurantTablesList.get(i).getX());
            tempObj.put("Y",restaurantTablesList.get(i).getY());
           
            arrayRestaurantTables.add(tempObj);
        }
        
        try {
            FileWriter file = new FileWriter("restaurantTables.json");
            file.write(arrayRestaurantTables.toJSONString());
            file.flush();
            file.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
     
    }
    
    public ArrayList readRestaurantJsonFile() throws Exception {
        
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("restaurantTables.json"));
        JSONArray jsonArray = (JSONArray) obj;
        ArrayList restaurantTablesArray = new ArrayList<>(); 
        for (int i = 0; i <jsonArray.size(); i++) {
            RestaurantTables restaurantTables = new RestaurantTables();
            JSONObject tempJsonObject = (JSONObject) jsonArray.get(i);
            restaurantTables.setId(Integer.parseInt(tempJsonObject.get("ID").toString()));
            restaurantTables.setX(Integer.parseInt(tempJsonObject.get("X").toString()));
            restaurantTables.setY(Integer.parseInt(tempJsonObject.get("Y").toString()));
            restaurantTablesArray.add(restaurantTables);
        }
        return restaurantTablesArray;
    }

     public void writeProductsListJsonFile(ArrayList<ProductsList> productsList) {
        
        JSONArray arrayProductsList = new JSONArray();
        for (int i = 0; i < productsList.size(); i++) {
            JSONObject tempObj = new JSONObject();
            tempObj.put("ID",productsList.get(i).getId());
            tempObj.put("Name",productsList.get(i).getName());
            tempObj.put("Price",productsList.get(i).getPrice());
           
            arrayProductsList.add(tempObj);
        }
        
        try {
            FileWriter file = new FileWriter("productsList.json");
            file.write(arrayProductsList.toJSONString());
            file.flush();
            file.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }
     
    }
    
    public ArrayList readProductsListJsonFile() throws Exception {
        
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("productsList.json"));
        JSONArray jsonArray = (JSONArray) obj;
        ArrayList ProductsListArray = new ArrayList<>(); 
        for (int i = 0; i <jsonArray.size(); i++) {
            Product productsList = new Product();
            JSONObject tempJsonObject = (JSONObject) jsonArray.get(i);
            productsList.setId((String) tempJsonObject.get("ID"));
            productsList.setName(tempJsonObject.get("Name").toString());
            productsList.setPrice(Integer.parseInt(tempJsonObject.get("Price").toString()));
            ProductsListArray.add(productsList);
        }
        return ProductsListArray;
    }

     
    
}
