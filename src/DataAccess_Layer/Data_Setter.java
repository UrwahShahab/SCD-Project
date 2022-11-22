package DataAccess_Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import BussinessLogic_Layer.BussinessLogic;


public class Data_Setter {
	

	public void Data_Setter_Fun() {
		BussinessLogic Middle=new BussinessLogic();
		
		 List words=(List) Middle.NewList();
		 List keys=(List) Middle.ForignKey();
		 
		  
	try { 
		  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/spell_checker","root","");
		  
			  int Length=0;
			  while( Length<=(keys.size()-1)) {
			 			  
	      PreparedStatement st = con.prepareStatement("insert into Mutants values("+null+",'"+(String) words.get(Length)+"',"+(int) keys.get(Length)+")");
	      st.execute();
	     Length++;
	} 
		  con.close(); 
	 
	} 
	catch(SQLException e) 
	{ System.out.println(e); 
	}
	}

}
