import java.io.*;
public class Main {

	public static void main(String[] args) {
			StoreManager storemanager = new StoreManager();
                        storemanager.addCDProduct("CD","BlackEyedPeas", 40, 10);
                        Product product = Store.createProduct("Book","Game Of Thrones",7000,530);
                        Store.store(product);                        
	}

}

