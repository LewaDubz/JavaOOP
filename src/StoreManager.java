
import java.util.ArrayList;


public class StoreManager implements StoreCapable {
    public String name;
    public String type;
    public int price;
    public int size;
    public ArrayList<String> storedproducts = new ArrayList<>();
 
	public StoreManager() {
	}
	public void addCDProduct (String type,String name,int price,int size)
	{this.type = type;
         this.name = name;
         this.price = price;
         this.size =size;
         storeCDProduct(type,name,price,size);
        }
	public void addBookProduct(String type,String name,int price,int size)
	{this.type = type;
         this.name = name;
         this.price = price;
         this.size =size;
         storeBookProduct(type,name,price,size);
	}
	public void listProducts()
	{
	}
	public void addStorage(StoreManager storemanager){
		
	}
        public void storeCDProduct(String type,String name, int price, int size){
        storedproducts.add(type +name + price + size);
        }
    @Override
        public ArrayList<String> getAllProduct(){
        return storedproducts;}
    @Override
        public void storeBookProduct(String type,String name, int price, int size){
        storedproducts.add(type + name + price + size);
        }
}

