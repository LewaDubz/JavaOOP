import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Store {
              	public static String name = "Productname";
		public static String price = "Price";
                public static String empty = " ";
	public static ArrayList<String> productlist = new ArrayList<>() ;
       
	public static void store(Product product){
        PersistentStore.storeProduct(product);
        saveToXml(product);
        storeProduct(product);
        }
        
	private static void saveToXml(Product product)
	{try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
                
                Element ProductElement = doc.createElement("Products");
                ProductElement.appendChild(doc.createTextNode("\n" + "\n"));
                
                Attr Name = doc.createAttribute(name);
                Name.setValue(product.name);
                
                Attr Price = doc.createAttribute(price);
                Price.setValue(product.price.toString());
           
                String MidText = "'<'" + Name.toString() + Price.toString() +"'/>'";
                ProductElement.appendChild(doc.createTextNode(MidText));
                ProductElement.appendChild(doc.createTextNode("\n" + "\n"));
		
              	// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(ProductElement);
		StreamResult result = new StreamResult(new File("storage.xml"));
                transformer.transform(source, result);
		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
	

	protected static void storeProduct(Product product)
	{//productlist.add(product.type + ";" + product.name + ";" + product.price + ";" + product.size + "\n");
            PersistentStore.storeProduct(product);
	}
        
	protected static Product createProduct(String type , String name , int price , int size)
        { type = type.toLowerCase();
        if (type.equals("cd")) {
           CDProduct product;
            product = new CDProduct(type,name,price,size);
            return product;
}
	
        else {BookProduct product;
            product = new BookProduct(type,name,price,size);
        return product;}
       
}
        public static ArrayList<String> loadProducts()
        {  // This is the part I lost all hope and gave up,had no idea how to do this.
            return productlist;
}
}

