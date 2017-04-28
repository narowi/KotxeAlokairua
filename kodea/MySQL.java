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
			if (rs.next()){
				String egoera=rs.getString(1);
				if(egoera="Alta"){
					s.executeUpdate("update Bezeroa set Egoera='Baja' where kodea='" +pKodea+"';");
				}
				else{
					s.executeUpdate("update Bezeroa set Egoera='Alta' where kodea='" +pKodea+"';");
				}
			}
			else{
				new ErroreMezua("Ez dago bezero hori");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void kotxeBerria(String pMatrikula , String pMarka,float prezioa,String pEgoera,int pAteKopurua,boolean aireEgokitua,float pDeposituTam,String pKarbuMota){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from Kotxe where matrikula='" +pMatrikula+"';");
			java.util.Date d=new java.util.Date();
			if (!rs.next()){
				s.executeUpdate("insert into kotxe values ('"+pMatrikula+"','"+pMarka+"','"+prezioa+",'"+pEgoera+"',"+pAteKopurua+","+aireEgokitua+","+pDeposituTam+",'"+pKarbuMota"',"+pDeposituTam+",'"+new java.sql.Date(d.getTime())+"');");
			}
			else{
				new ErroreMezua("Kotxea sortua dago jadanik");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void kotxeBajaEman(String pMatrikula){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select Egoera from Kotxe where matrikula='" +pMatrikula+"';");
			if (rs.next()){
				String egoera=rs.getString(1);
				if(egoera="Libre"){
					s.executeUpdate("delete from kotxe where matrikula='"+pMatrkula+"';");
				}
				else if(egoera="Alokatuta"){
					s.executeUpdate("update Bezeroa set Egoera='Deskatalogatuta' where kodea='" +pKodea+"';");
				}
			}
			else{
				new ErroreMezua("Ez dago kotxe hori");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void karburanteGutxikoKotxeak(String pMatrikula){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from Kotxea where kodea='" +pKodea+"' and karbKop<Dep-Tam*0,20;");
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getBoolean(6)+" "+rs.getFloat(7)+" "+rs.getDate(8)+" "+rs.getFloat(9)+" "+rs.getString(10));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void kotxeaGasolindegiraEraman(String pMatrikula){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select Dep-Tam from Kotxea where matrikula='" +pMatrikula+"';");
			if(rs.next()){
				s.executeUpdate("update kotxe set karbKop="+rs.getFloat(1)+"where matrikula='"+pMatrkula+"';");
			}
			else{
				new ErroreMezua("Ez dago kotxe hori");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void bezeroDatuakAldatu(String pKodea , String pPasahitza, String pIzena, String pAbizena, String pHelb ){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from Bezeroa where kodea='" +pKodea+"';");
			if (rs.next()){
				if(pPasahitza==null){
					pPasahitza=s.executeQuery("select pasahitza from Bezeroa where kodea='" +pKodea+"';").getString(1);
				}
				if(pIzena==null){
					pIzena=s.executeQuery("select izena from Bezeroa where kodea='" +pKodea+"';").getString(1);
				}
				if(pAbizena==null){
					pAbizena=s.executeQuery("select abizena from Bezeroa where kodea='" +pKodea+"';").getString(1);
				}
				if(pHelb==null){
					pHelb=s.executeQuery("select helbidea from Bezeroa where kodea='" +pKodea+"';").getString(1);
				}
				s.executeUpdate("update Bezeroa set pasahitza='"+pPasahitza+"',izena='"+pIzena+"',abizena='"+pAbizena+"',helbidea='"+pHelb+"' where kodea='" +pKodea+"';");
			}
			else{
				new ErroreMezua("Ez dago bezero hori");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void bezeroKredituaGehitu(String pKodea,Float pKreditua){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select kreditua from Bezeroa where kodea='" +pKodea+"';");
			if (rs.next()){
				String kreditua=rs.getFloat(1)+pKreditua;
				s.executeUpdate("update Bezeroa set kreditua="+kreditua+" where kodea='" +pKodea+"';");

			}
			else{
				new ErroreMezua("Ez dago bezero hori");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void bezeroKotxeaGasolindegira(String pKodea,float pLitro){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			java.util.Date d=new java.util.Date();
			ResultSet rs = s.executeQuery ("select prezioa,kreditua,matrikula from Alokatu A,KarbMota KM,Kotxe K where A.kodea='" +pKodea+"' and KM.izena=K.izena and A.noiztik<="+new java.sql.Date(d.getTime())+"A.itzuli>="+new java.sql.Date(d.getTime())+";");
		    float prezioa=rs.getFloat(1);
		    float kreditua=rs.getFloat(2);
		    String matrikula=rs.getString(3);
			if (pLitro*prezioa<=kreditua){
				this.kotxeaGasolindegiraEraman(matrikula);
				kreditua=kreditua-pLitro*prezioa
				s.executeUpdate("update Kotxe set kreditua="+kreditua+" where kodea='" +pKodea+"';");
				}
				
			}
			else{
				new ErroreMezua("Ez dago kreditu nahikorik hori");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
