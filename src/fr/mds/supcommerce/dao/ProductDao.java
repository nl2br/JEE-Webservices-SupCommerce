package fr.mds.supcommerce.dao;
import java.util.List;
import fr.mds.supcommerce.model.Product;
import java.util.ArrayList;

// Data Access Object
public class ProductDao {
	
	private static List<Product> productList = new ArrayList<Product>();
	private static Long idCounter = (long) 0;
	
	public static List<Product> getAllProducts(){
		return productList;
	}
	
	public static void addProduct(Product product) {
		System.out.println("ProductDao - addProduct : product: " + product);
		product.setId(idCounter++);
		productList.add(product);
	}
	
	public static Product findProduct(Long id) {
		for(Product product : productList) {
			System.out.println("ProductDao - findProduct : product: " + product);
			if(product.getId().equals(id)) {
				System.out.println("ProductDao - findProduct : product Finded: " + product);
				return product;
			}
		}
		return null;
	}
	
	public static void removeProduct(Long id) {
		for(int i = 0 ; i < productList.size(); i++) {
			System.out.println("ProductDao - removeProduct : product: " + productList.get(i));
			if(productList.get(i).getId().equals(id)) {
				System.out.println("ProductDao - findProduct : product removed: " + productList.get(i));
				productList.remove(i);
				return;
			}
		}
	}
	
}
