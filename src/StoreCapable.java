import java.util.ArrayList;



 public interface StoreCapable {
     public void storeCDProduct(String type,String name,int price, int size);
     public ArrayList<String> getAllProduct();
     public void storeBookProduct(String type,String name, int price, int size);
 }

