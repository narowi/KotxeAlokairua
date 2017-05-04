package kodea;
import java.sql.*;
import java.util.Calendar;

import admin.DatubaseaInprimatu;
import bezeroa.KrediturikGabe;
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
	public boolean loginKonprobaketa(String erabiltzaile,String pasahitza){
		this.mySQLKonektatu();
		try{
			Statement s=konexioa.createStatement();
			ResultSet rs=s.executeQuery("select * from Bezeroa where kodea='"+erabiltzaile+"'and pasahitza='"+pasahitza+"';");
			return rs.next();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
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
				if(egoera.equals("Alta")){
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
	public void kotxeBerria(String pMatrikula , String pMarka,float prezioa,int pAteKopurua,String aireEgokitua,float pDeposituTam,String pKarbuMota){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from Kotxe where matrikula='" +pMatrikula+"';");
			java.util.Date d=new java.util.Date();
			if (!rs.next()){
				s.executeUpdate("insert into kotxe values ('"+pMatrikula+"','"+pMarka+"',"+prezioa+",'Libre',"+pAteKopurua+",'"+new java.sql.Date(d.getTime())+"',"+pDeposituTam+","+pDeposituTam+",'"+pKarbuMota+"','"+aireEgokitua+"');");
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
			ResultSet rs = s.executeQuery ("select egoera from Kotxe where matrikula='" +pMatrikula+"';");
			if (rs.next()){
				String egoera=rs.getString(1);
				if(egoera.equals("Libre")){
					s.executeUpdate("delete from kotxe where matrikula='"+pMatrikula+"';");
				}
				else if(egoera.equals("Alokatuta")){
					s.executeUpdate("update kotxe set Egoera='Deskatalogatuta' where matrikula='" +pMatrikula+"';");
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
	public void karburanteGutxikoKotxeak(){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from kotxe where karbKop<DeposTam*0.20;");
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getDate(6)+" "+rs.getFloat(7)+" "+rs.getFloat(8)+" "+rs.getString(9)+" "+rs.getString(10));
				
				new DatubaseaInprimatu((rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getFloat(3)+"    "+rs.getString(4)+"    "+rs.getInt(5)+"    "+rs.getDate(6)+"    "+rs.getFloat(7)+"    "+rs.getFloat(8)+"    "+rs.getString(9)+"    "+rs.getString(10))).main((rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getFloat(3)+"    "+rs.getString(4)+"    "+rs.getInt(5)+"    "+rs.getDate(6)+"    "+rs.getFloat(7)+"    "+rs.getFloat(8)+"    "+rs.getString(9)+"    "+rs.getString(10)));				
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
			ResultSet rs = s.executeQuery ("select deposTam from kotxe where matrikula='" +pMatrikula+"';");
			if(rs.next()){
				s.executeUpdate("update kotxe set karbKop="+rs.getFloat(1)+"where matrikula='"+pMatrikula+"';");
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
				float kreditua=rs.getFloat(1)+pKreditua;
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
			ResultSet rs = s.executeQuery ("select prezioa,kreditua,deposTam,karbKop,matrikula from Alokatu A,KarbMota KM,Kotxe K where A.kodea='" +pKodea+"' and KM.izena=K.izena and A.noiztik<="+new java.sql.Date(d.getTime())+"A.itzuli>="+new java.sql.Date(d.getTime())+";");
		    float prezioa=rs.getFloat(1);
		    float kreditua=rs.getFloat(2);
		    float tamaina=rs.getFloat(3);
		    float depositua=rs.getFloat(4);
		    String matrikula=rs.getString(5);
		    if(tamaina<pLitro+depositua){
		    	pLitro=tamaina-depositua;
		    }
			if (pLitro*prezioa<=kreditua){
				this.kotxeaGasolindegiraEraman(matrikula);
				kreditua=kreditua-pLitro*prezioa;
				s.executeUpdate("update Kotxe set kreditua="+kreditua+" where kodea='" +pKodea+"';");
				}
				
			else{
				new ErroreMezua("Ez dago kreditu nahikorik hori egiteko");
			}
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void kotxeaAlokatu(String pKodea,String pMatrikula,int pEgunak){
		this.mySQLKonektatu();
		java.util.Date d=new java.util.Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(calendar.DAY_OF_YEAR, pEgunak);
		java.util.Date dItzuli=calendar.getTime();
		try{
			Statement s = konexioa.createStatement(); 
			ResultSet rs= s.executeQuery("select prezio from kotxe K,bezeroa where K.egoera='Libre' and kreditua>=prezio*"+pEgunak+";");
			if(rs.next()){
				s.executeUpdate("insert alokatu values('"+pMatrikula+"','"+pKodea+"','"+new java.sql.Date(d.getTime())+"',"+pEgunak+",'"+new java.sql.Date(dItzuli.getTime())+"');");
				s.executeUpdate("update kotxe set egoera='Alokatuta' where matrikula='"+pMatrikula+"';");
				s.executeUpdate("update bezeroa set kreditua=kreditua-"+rs.getInt(1)*pEgunak+";");
			}
			else{
				new ErroreMezua("Ezin da kotxe hori alokatu");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void kotxeaItzuli(String pKodea,String pMatrikula,java.util.Date noizAlokatuDen){
		this.mySQLKonektatu();
		try{
			Statement s = konexioa.createStatement();
			ResultSet rs= s.executeQuery("select itzuli from alokatu,kotxe where matrikula='"+pMatrikula+"' and kodea='"+pKodea+"' and egoera='Alokatuta' and noiztik='"+noizAlokatuDen+"';");
			if(rs.next()){
				java.util.Date itzuli=rs.getDate(1);
				Calendar itzuliCalendar=Calendar.getInstance();
				itzuliCalendar.setTime(itzuli);
				long diff = Math.abs(Calendar.getInstance().getTimeInMillis()-itzuliCalendar.getTimeInMillis());
				long diffDays = diff / (24 * 60 * 60 * 1000);
				if(diffDays>0){
					ResultSet rs1= s.executeQuery("select prezio from alokatu,kotxe where matrikula='"+pMatrikula+"' and kodea='"+pKodea+"' and egoera='Alokatuta' and noiztik='"+noizAlokatuDen+"';");
					float kotxePrezioa=rs1.getFloat(1);
					ResultSet rs2= s.executeQuery("select kreditua from bezeroa where kodea='"+pKodea+"';");
					float kreditua = rs2.getFloat(1);
					if ((long)(kreditua)>=(long)(kotxePrezioa*1.5*diffDays)){
						s.executeUpdate("update kotxe set egoera='Libre' where matrikula='"+pMatrikula+"';");
						s.executeUpdate("update bezeroa set kreditua=kreditua-"+kreditua+";");
					}
					else{
						new KrediturikGabe(pKodea).main(pKodea);
					}
				}
				ResultSet rs3= s.executeQuery("select KarbKop,egunak from alokatu,kotxe where matrikula='"+pMatrikula+"' and kodea='"+pKodea+"' and egoera='Alokatuta' and noiztik='"+noizAlokatuDen+"';");
				float karbKop = rs3.getFloat(1);
				float egunak=(float)rs3.getInt(2)+(float)diffDays;
				karbKop=karbKop-10*egunak;
				if(karbKop<=0){
					ResultSet rs2= s.executeQuery("select kreditua from bezeroa where kodea='"+pKodea+"';");
					float kreditua = rs2.getFloat(1);
					ResultSet rs4=s.executeQuery("select prezio from kotxe natural join karbMota where matrikula='"+pMatrikula+"';");
					if(rs.getFloat(1)*10>kreditua){
						new KrediturikGabe(pKodea).main(pKodea);
					}
					
				}
				
				
			}
		}
		catch(Exception e){
			
		}
	}

	
	
}
