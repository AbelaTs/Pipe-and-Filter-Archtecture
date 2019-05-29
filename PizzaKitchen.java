/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza.kitchen;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PizzaKitchen {
     static String chopped_vegitables = "";
     static String prepared_souce = "";
     static String P_Ingredients = "";
     static String Cooked = "";
    public static String chopVegitables(ArrayList<String> vegitable_list){
        
        Thread CV = new Thread(new Runnable(){
        public void run(){
            System.out.println("Chopping...");
            for (String vegitable : vegitable_list){
            chopped_vegitables = chopped_vegitables + "Chopped " +  vegitable + ", ";
        }
        
        }});
        CV.setPriority(Thread.MAX_PRIORITY);
        CV.start();
        return chopped_vegitables;
        
    }
    public static String make_souce(ArrayList<String> Soucelist){
       Thread MS = new Thread(new Runnable(){
        public void run(){
        System.out.println("Preparing Souce..");
        for(String souce : Soucelist){
         prepared_souce = prepared_souce + "Prepared " + souce + ", ";
        }
        }
        
        });
       MS.setPriority(Thread.MAX_PRIORITY);
       MS.start();
        return prepared_souce;
        }
    public static String makePizzaBase(ArrayList<String> Ingredients) throws InterruptedException{
        Thread MPB = new Thread(new Runnable(){
        public void run(){
        System.out.println("Adding ingredients...");  
       for(String ingredient : Ingredients){
        P_Ingredients =  P_Ingredients + "Added " + ingredient + ", " ;
        }
        }
        });
        MPB.setPriority(Thread.MAX_PRIORITY);
        MPB.start();
        MPB.join();
        
        return P_Ingredients;
    }
    public static String Cook(String Vegitable, String Souce, String Ingredient){
            System.out.println("Cooking..");
            Cooked = Vegitable + Souce + Ingredient;
            return Cooked;
    }
    public static String addCheese(String Assembled){
        return "On " + Assembled + " cheese is added.\n";
    }
    public static String addBake(String Assembled){
        return "On " + Assembled + " bake is added.\n";
    }
    public static void main(String[] args) throws InterruptedException {
         try {
             ArrayList<String> Vegitables = new ArrayList();
             Vegitables.add("Onion");
             Vegitables.add("Carrots");
             Vegitables.add("Potatoes");
             ArrayList<String> Souces = new ArrayList();
             Souces.add("Tomato Souce");
             Souces.add("Vinto");
             Souces.add("Pinach Souce");
             ArrayList<String> Ingredients = new ArrayList();
             Ingredients.add("Meat");
             Ingredients.add("Flour");
             Ingredients.add("Olive oil");
             Ingredients.add("Water");
             chopVegitables(Vegitables);
             make_souce(Souces);
             makePizzaBase(Ingredients);
             System.out.println(P_Ingredients);
             System.out.println(chopped_vegitables );
             System.out.println(prepared_souce);
             Cook(chopped_vegitables,prepared_souce,P_Ingredients);
             System.out.println(Cooked);
             System.out.println(addCheese(Cooked));
             System.out.println(addBake(Cooked));
             
             
         } catch (InterruptedException ex) {
             Logger.getLogger(PizzaKitchen.class.getName()).log(Level.SEVERE, null, ex);
         }

       
    }
}
