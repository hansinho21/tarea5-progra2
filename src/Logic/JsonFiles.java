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
    
    public ArrayList readAgentJsonFile() throws Exception {
        
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

    
     
    
}
