
// https://www.baeldung.com/java-hashmap

import java.util.*;

public class Main {
    
    public static void main(String[] args){

        Map<String, Product> productsByName = new HashMap<>();

        Product eBike = new Product("E-Bike", "A bike with battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        
        //  Ideja je da provježbaš pozivanje metode "put" ..
            /*
            *  Znači da bi u mapu(HashMap) dodao par {ključ, vrijednost}
            *  KORISTIĆEŠ METODU IMENA 'put()'!!
            */
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);
        
        // Ideja je da provježbaš pozivanje metode "get" ..
            /*
            *  Korištenjem metode 'get' kojoj kao argument predaješ 'ključ'         //  ZAPAMTI!!
            *  nazad iz mape dobijaš vrijednost koju taj ključ mapira!!             //  get(NAZIV-KLJUČA)!!
            */
        Product nextPurchase = productsByName.get("E-Bike");
        // asserEquals("A bike with a baterry", nextPurchase.getDescription());
        // assertEquals nije standardna bibliotečka metoda Java programskog jezika! 
        // Pripada JUnit biblioteci..
        System.out.println(nextPurchase);
        nextPurchase = productsByName.get("Car");
        System.out.println(nextPurchase);
        
        //  HashMap also allows us to have null as a key:
        Product defaultProduct = new Product("Chocolate", "At least buy chocolate");
        productsByName.put(null, defaultProduct);
        System.out.println(nextPurchase);
        
        // Furthermore, we can insert the same object twice with a different key:
        productsByName.put(defaultProduct.getName(), defaultProduct);
        
        // Ideja je da provježbaš pozivanje metode "get" ..
        productsByName.remove("E-Bike");
        System.out.println(nextPurchase);
        
        // To check if a key is present in the map, we can use the containsKey() method:
        System.out.println(productsByName.containsKey("E-Bike"));
        System.out.println(productsByName.containsValue(eBike));

        //  1. We can iterate over the set of all keys
        for(String key : productsByName.keySet()){                              //  ZAMAPTI DA IMAŠ METODU keyset()!!       
            Product product = productsByName.get(key);
            System.out.println(product);
        }

        // 2. we can iterate over the set of all entries:
        for(Map.Entry<String, Product> entry : productsByName.entrySet()){      //  ZAPAMTI DA IMAŠ METODU entryset()!!
            String key = entry.getKey();
            Product product = entry.getValue();                                 //  ZAPAMTI DA IMAŠ METODU getValue()!!
            //  entry -> [[key[i]][value[i]]]                                   odlično sam ovo zamislio!!
            System.out.println(key + " -- " + product);
        }

        // Finally, we can iterate over all values:
        List<Product> products = new ArrayList<>(productsByName.values());
        products.stream().forEach(System.out::println);

        /*
         *  Using the getOrDefault() method, 
         *  we can get a value from the map or return a default element in case there is no mapping for the given key:
        */
        Product chocolate = new Product("chocolate", "something sweet");
        defaultProduct = productsByName.getOrDefault("horse carriage", chocolate);      //  chocolate je default vrijednost
        Product bike = productsByName.getOrDefault("E-Bike", chocolate);                //  ovde isto..
        
        // With this method, we can add a new mapping, but only if there is not yet a mapping for the given key:
        productsByName.putIfAbsent("E-bBike", chocolate);

        /* 
            And with merge(), we can modify the value for a given key if a mapping exists, or add a new value otherwise:

            Product eBike2 = new Product("E-Bike", "A bike with a battery");
            eBike2.getTags().add("sport");
            productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProduct);
        */
    }
}
