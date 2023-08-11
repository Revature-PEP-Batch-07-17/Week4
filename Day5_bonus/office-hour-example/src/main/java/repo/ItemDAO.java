package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;
import util.ConnectionUtility;

public class ItemDAO {
	public Item selectItemById(Integer id) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lecture.items WHERE item_id=?");
			// set methods on prepared statements take 2 arguments:
			// first is the placeholder position (starting at 1)
			// second is the data to insert into the statement
			ps.setInt(1, id);
			
			/*
			 * PreparedStatements have 3 different methods which can be used to execute
			 * the query to the database:
			 * 	executeQuery (SELECT)
			 * 	executeUpdate (INSERT, UPDATE, DELETE)
			 * 	execute (INSERT, SELECT, UPDATE, DELETE)
			 */
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return new Item(
						rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getDouble("item_price")
						);
			}
			
		} catch (SQLException e) {
			// What happens when the query fails
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean InsertItem(Item item) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO lecture.items VALUES(?,?,?)");
			ps.setInt(1, item.getItem_id());
			ps.setString(2, item.getItem_name());
			ps.setDouble(3, item.getItem_price());

			if(ps.executeUpdate() > 0)
				return true;
			else
				return false;
		
		} catch (SQLException e) {
			// What happens when the query fails
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Item> selectAllItems() {
		try {
			Connection conn = ConnectionUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lecture.items");

			ResultSet rs = ps.executeQuery();
			
			ArrayList<Item> list = new ArrayList<Item> ();
			
			while (rs.next()) {
				Item toAdd = new Item(
						rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getDouble("item_price")
						);
				
				list.add(toAdd);
				
			}
			
			// return a list of items....
			return list;
			
		} catch (SQLException e) {
			// What happens when the query fails
			e.printStackTrace();
		}
		
		return null;
	}
}
