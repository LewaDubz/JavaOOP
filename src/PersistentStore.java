
import java.util.ArrayList;


public class PersistentStore extends Store {
    public static ArrayList persistentStorage = new ArrayList<>();
    public PersistentStore() {
    }  
    
        public static void storeProduct(Product product)
        {Product persiproduct = product;
        persistentStorage.add(persiproduct.type + ";" + persiproduct.name + ";" + persiproduct.price + ";" + persiproduct.size + "\n");}

}
