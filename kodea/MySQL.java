package kodea;
import java.sql.*;
import java.*;

public class MySQL {
	
	private static Connection konexioa;
	
	public void mySQLKonektatu(){
        try {
            konexioa = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "root");
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
	public void mySQLDeskonektatu(){
		try{
			konexioa.close();
		}
		catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	public void bezeroBerria(String pKodea , String pPasahitza){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from bezeroa where kodea=" + pKodea);
			if (rs==null){
				s.executeQuery("insert into Bezeroa(kodea, pasahitza, noiztik, kred, egoera) values ("+pKodea+","+pPasahitza+",25/04/2017,0,Alta)");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

