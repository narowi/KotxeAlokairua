package kodea;
import java.sql.*;
import java.util.Calendar;

import hasierakoUi.ErroreMezua;

import java.*;
import java.util.*;

public class MySQL {
	
	private static Connection konexioa;
	private static MySQL nireSQL;
	
	private MySQL(){
		
	}
	public static MySQL getMySQL(){
		if(nireSQL==null){
			nireSQL = new MySQL();
		}
		return nireSQL;
	}
	
	public void mySQLKonektatu(){
        try {
            konexioa = DriverManager.getConnection("jdbc:mysql://localhost/enpresa" , "root",null);
            
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
			ResultSet rs = s.executeQuery ("select * from Bezeroa where kodea='" +pKodea+"';");
			java.util.Date d=new java.util.Date();
			if (!rs.next()){
				s.executeUpdate("insert into Bezeroa (kodea, pasahitza, noiztik, kreditua, egoera) values ('"+pKodea+"','"+pPasahitza+"','"+new java.sql.Date(d.getTime())+"',0.0,'Alta');");
			}
			else{
				new ErroreMezua("Bezeroa sortua dago jadanik");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void bezeroEgoeraAldatu(String pKodea){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select Egoera from Bezeroa where kodea='" +pKodea+"';");
			java.util.Date d=new java.util.Date();
			if (!rs.next()){
				String egoera=rs.getString(1);
				if(egoera="Alta"){
					s.executeUpdate("update Bezeroa set Egoera='Baja' where kodea='" +pKodea+"';");
				}
				else{
					s.executeUpdate("update Bezeroa set Egoera='Alta' where kodea='" +pKodea+"';");
				}
			}
			else{
				new ErroreMezua("Bezeroa sortua dago jadanik");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
