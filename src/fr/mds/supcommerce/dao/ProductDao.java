package fr.mds.supcommerce.dao;
import java.util.List;
import fr.mds.supcommerce.model.Product;
import java.util.ArrayList;

public class ProductDao {
	
	protected static List<Product> productList = new ArrayList<Product>();
	
	public static List<Product> getAllProducts(){
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product(new Long(1), "product1", "desc1", 10.90f));
		productList.add(new Product(new Long(2), "product2", "desc1", 11.90f));
		productList.add(new Product(new Long(3), "product3", "desc1", 12.90f));
		productList.add(new Product(new Long(4), "product4", "desc1", 13.90f));

		return productList;
	}
	
	public static void addProduct(Product product) {
		System.out.println("ProductDao - addProduct : product: " + product);
		productList.add(product);
	}
	
	public static Product findProduct(Long id) {
		Product toReturn = null;
		for(Product product : productList) {
			System.out.println("ProductDao - findProduct : product: " + product);
			if(product.getId() == id) {
				System.out.println("ProductDao - findProduct : product Finded: " + product);
				toReturn = product;
			}
		}
		return toReturn;
	}
	
	public static void removeProduct(Long id) {
		for(int i = 0 ; i < productList.size(); i++) {
			System.out.println("ProductDao - removeProduct : product: " + productList.get(i));
			if(productList.get(i).getId() == id) {
				System.out.println("ProductDao - findProduct : product removed: " + productList.get(i));
				productList.remove(i);
			}
		}
	}
	
}
