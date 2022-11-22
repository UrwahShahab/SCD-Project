package DataAccess_Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

import BussinessLogic_Layer.BussinessLogic;

public class DataGetter {
	
	Queue Q2 = new LinkedList();

	public Queue Data_Getter_FUN1() {
			  
			
		    Queue Q1 = new LinkedList();
			
			
			try {
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spell_checker","root","");
		    	
		    	if (!con.isClosed())
		    	   {
		    		PreparedStatement ps = con.prepareStatement("SELECT * from word");
		          
		            ResultSet rs = ps.executeQuery();
		    	      
		    	      while (rs.next())
		    	      {
		    	    	 
		    	        Q2.add((Integer)rs.getObject("word_id"));
		    	        Q1.add((String) rs.getObject("words"));
		    	        
		    	      }
		    	     
		    	      con.close();
		    	   }
		    	   else
		    		   JOptionPane.showMessageDialog(null,"Connection Fail");
		    	}
		    catch(SQLException e) {
		    	System.out.println(e);
		    }
	          return(Q1);
		}
	public Queue Data_Getter_key() {
		
		return Q2;
		
	}
	public Queue Data_Getter_word() {
		
		return Data_Getter_FUN1();
	}
	
}
