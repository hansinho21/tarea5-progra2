/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.RestaurantTables;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    
     
    
}
