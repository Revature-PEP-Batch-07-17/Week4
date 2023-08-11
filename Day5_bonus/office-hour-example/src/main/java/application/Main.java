package application;

import java.util.ArrayList;

import model.Item;
import repo.ItemDAO;

public class Main {
	public static void main(String[] args) {
		ItemDAO idao = new ItemDAO();
		
//		Item i = idao.selectItemById(1);
//		System.out.println(i);		
//		System.out.println( new ItemDAO().selectItemById(1) );
		
//		Item item = new Item(4, "hacky sack", 4.99);
//		if (idao.InsertItem(item)) {
//			System.out.println( idao.selectItemById(4) );
//		}
		
		ArrayList<Item> result = idao.selectAllItems();
		
		for (Item r : result) {
			System.out.println( r );
		}
	}
}
