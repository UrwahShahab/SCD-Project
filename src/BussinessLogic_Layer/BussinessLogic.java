package BussinessLogic_Layer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataAccess_Layer.Data_Setter;
import DataAccess_Layer.DataGetter;



public class BussinessLogic {
	static Queue<String> new_dbword_Li = new LinkedList<String>();
	static Queue<String> DBWord = new LinkedList<String>();
	static Queue<Integer> DBKey = new LinkedList<Integer>();
	static Queue<Integer> new_dbkey_Li = new LinkedList<Integer>();

	
	  static DataGetter DB1=new DataGetter();
	  Data_Setter DB2=new Data_Setter();
       
	  
	
	
	public static void MUtants_GN() {
		
				
		String[][] Same_W=Same_Word();

		
		DBKey=DBKEy();
		DBWord=DBWords();
			
		System.out.println(DBWord.size());
		
		for(int count=0;count<DBWord.size();count++)
		{
			
			
			String[] Word_LIST=Spilter((String) DBWord.remove());
		
		int key_Val=(int) DBKey.remove();
		List<String> Charactlist=new ArrayList<String>();  
		
		for(int i=0;i<Word_LIST.length;i++) {
			Charactlist.add(Word_LIST[i]);
		}
		int length=Word_LIST.length;
		Generator(Same_W,Charactlist,length,key_Val);
		
		
		
	}
		
		
	}
	
public static String[][] Same_Word() {
		
		String[][] Same_Word = new String[18][2];
		
		  
		 
		Same_Word[0][0]=("گ");
		Same_Word[1][0]=("غ");  
		Same_Word[0][1]=("غ");
		Same_Word[1][1]=("گ");
		  
		  
		Same_Word[2][0]=("ح");   
		Same_Word[3][0]=("ہ"); 
		Same_Word[2][1]=("ہ");
		Same_Word[3][1]=("ح");
		  
		Same_Word[4][0]=("ض");
		Same_Word[5][0]=("ظ");
		Same_Word[4][1]=("ظ");
		Same_Word[5][1]=("ض");
		
		Same_Word[6][0]=("ڈ");  
		Same_Word[7][0]=("ڑ");
		Same_Word[6][1]=("ڑ");
		Same_Word[7][1]=("ڈ");
		
		Same_Word[8][0]=("ت");  
		Same_Word[9][0]=("ط");
		Same_Word[8][1]=("ط");
		Same_Word[9][1]=("ت");
		
		   
		Same_Word[10][0]=("ع"); 
		Same_Word[11][0]="ا";
		Same_Word[10][1]=("ا");
		Same_Word[11][1]=("ع");
		
		Same_Word[12][0]=("س");   
		Same_Word[13][0]=("ص");
		Same_Word[12][1]=("ص");
		Same_Word[13][1]=("س");
		
		Same_Word[14][0]=("ک");  
		Same_Word[15][0]=("ق");
		Same_Word[14][1]=("ق");
		Same_Word[15][1]=("ک");
		
		  
		Same_Word[16][0]=("ذ");
		Same_Word[17][0]=("ز"); 
		Same_Word[16][1]=("ز");
		Same_Word[17][1]=("ذ");
		
		
		return Same_Word;
		
		   
	}
    public static void Generator(String SameWord[][],List<String> CharacterWord,int length,int DBKey) {
	
	String NewWord="";
	for(int Sam=0;Sam<18;Sam++) {
		
		for(int c=0;c<CharacterWord.size();c++) {
			String C=(String) CharacterWord.get(c);
			String S1=SameWord[Sam][0];
		if(C.equals(S1) ){
			
			for(int S11=0;S11<length;S11++) {
				
				if(S11!=c) {
					
					String ST=(String) CharacterWord.get(S11);
					NewWord+=ST;
				}
				else {
					String ST=SameWord[Sam][1];
					NewWord+=ST;
				}
			}
		}
	}
	
	    if(NewWord!="") {
	    	new_dbword_Li.add(NewWord);
	    	new_dbkey_Li.add(DBKey);
	    	
		NewWord="";
		
	    }
	    
		}
	
}
	public static Queue<String> DBWords() {
		
		
		  return DB1.Data_Getter_word();
	}
	
	
	
	public Queue<String> NewList() {
		
		return new_dbword_Li;
	}
	
	
	
	
	public Queue<Integer> ForignKey() {
		return new_dbkey_Li;
	}
	
	
	
	public static Queue<Integer> DBKEy() {
		
		 return DB1.Data_Getter_key();
	}
	
	
	
	
	public static String[] Spilter(String Word) {
		String st=Word;
		String[] CH = st.split("(?!^)");
		return CH;
		
	}
	
	
	public void InsertData() {
		  DB2.Data_Setter_Fun();
}
}
