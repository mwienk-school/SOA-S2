package org.pahospital.www.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.pahospital.www.labcallbackservice.LabCallbackServiceStub.LabValues_type0;
import org.pahospital.www.labservice.LabOrder;
import org.pahospital.www.labservice.SampleMaterial_type1;
/**
 * JDBC interface for DVD Catalog application.
 *
 * @author Russell Bateman
 */
public class DB_Manager
{
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/laboratoryDB?user=test&password=test";
    private Connection conn;
    private static Statement stmt;
    public DB_Manager()
    {
    	connect();
    	//DropTables();
    	InsertTables();
    }
    private void InsertTables() {
    	 try
         {     
         	//String query3="CREATE TABLE order( orderID VARCHAR(30) NOT NULL , patientID TEXT NOT NULL,PRIMARY KEY (orderID) ); ";
         ///	stmt.executeUpdate( query3 );
         	String query1="CREATE TABLE laborder( orderID MEDIUMINT NOT NULL AUTO_INCREMENT, patientID TEXT NOT NULL, caseID TEXT NOT NULL , sampleID TEXT NOT NULL,samplematerial TEXT NOT NULL,labparameters TEXT NOT NULL,PRIMARY KEY (orderID));";//FOREIGN KEY (orderID) REFERENCES orders(orderID) ON DELETE CASCADE ); ";
         	stmt.executeUpdate( query1 );
         	String query2="CREATE TABLE labreport( orderID  MEDIUMINT NOT NULL, patientID TEXT NOT NULL, sampleID TEXT NOT NULL,labvalues TEXT NOT NULL,FOREIGN KEY (orderID) REFERENCES laborder(orderID) ON DELETE CASCADE ); ";
         	stmt.executeUpdate( query2 );
                      
         }
         catch( SQLException e )
         {
             System.out.println( "SQLException: " + e.getMessage() );
             System.out.println( "SQLState:     " + e.getSQLState() );
             System.out.println( "VendorError:  " + e.getErrorCode() );
         }

		
	}
	private void DropTables() {
		 try
         {
         	
         	
         	String query_2="DROP TABLE laborder";
         	stmt.executeUpdate( query_2 );
         	String query_4="DROP TABLE labreport; ";
         	stmt.executeUpdate( query_4 );
         	//String query_3="DROP TABLE orders; ";
         	//stmt.executeUpdate( query_3 );
         }
         catch( SQLException e )
         {
             System.out.println( "SQLException: " + e.getMessage() );
             System.out.println( "SQLState:     " + e.getSQLState() );
             System.out.println( "VendorError:  " + e.getErrorCode() );
         }

	}
	private void connect(){
    	try
        {
    		System.out.println("hello init");
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            System.out.println("after forname");
            conn = DriverManager.getConnection( CONNECTION_URL );
            System.out.println("after connection");
            stmt = conn.createStatement();
            
            System.out.println("DONE!");

                 }
        catch( Exception e )
        {
            System.out.println( "Error occured during DB connection!" );
            System.out.println( e.getMessage() );
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) throws SQLException
    {
    	try{
    		DB_Manager x= new DB_Manager();
    
    	LabOrder o=new LabOrder();
    	o.setPatientID("maryam");
    	o.setCaseID("u12");
    	o.setSampleID("123");
    	SampleMaterial_type1 y=new SampleMaterial_type1("BLOOD",true);
    	o.setSampleMaterial(y);
    	o.addLabParameter("pressure");
    	o.addLabParameter("closterol");
    	x.InsertlabOrder(o);
    	x.LogOrder();
    	}
    	 catch( SQLException e )
         {
             System.out.println( "SQLException: " + e.getMessage() );
             System.out.println( "SQLState:     " + e.getSQLState() );
             System.out.println( "VendorError:  " + e.getErrorCode() );
         }
        
    }
    public boolean Is_labOrder(String ID) throws SQLException
    {
    	 String query1= "SELECT * FROM 	laborder p WHERE p.orderID="+ID;
         ResultSet rs=stmt.executeQuery( query1 );
         System.out.println("orders:");
         System.out.println("orderID \t patientID");
         
         while (rs.next()) {
        	 String orderID =rs.getString("orderID");
             System.out.println(orderID+"\t");
             String PatientID =rs.getString("patientID");
             System.out.println(PatientID);
             return true;
         }
         return false;
    	
    }
  /*  public void InsertOrder(String Patient) throws SQLException
    {
    	
    	String query = "INSERT INTO ";

        query += "orders (patientID)";
        query += " VALUES ('";
       // query += ID;
        query +=Patient;
        query += "')";
        System.out.println( "Query: " + query );
        stmt.executeUpdate( query );
    	
    }*/
   
    public String InsertlabOrder(LabOrder  Order) throws SQLException
    {
    	int i;
    	
    	String parameters="";
    	for( i=0;i<Order.getLabParameter().length-1;i++)
    	{
    		parameters=parameters+Order.getLabParameter()[i]+";";
    	}
    	parameters=parameters+Order.getLabParameter()[i];
    	
    	String query = "INSERT INTO ";
        query += "laborder (OrderID,patientID,sampleID,caseID,samplematerial,labparameters)";
        query += " VALUES (NULL , '";
        query += Order.getPatientID()+"' , '"+Order.getSampleID()+"' , '"+Order.getCaseID()+"' , '"+Order.getSampleMaterial()+"' , '"+parameters;
        query += "')";
        System.out.println( "Query: " + query );
        stmt.executeUpdate( query );
        String query1= "SELECT LAST_INSERT_ID()";
        ResultSet rs =stmt.executeQuery( query1 );
        int ID;
        if ( rs.next() )
		{
        	ID = rs.getInt(1);
        	String orderId="TEST"+ID;
        	return orderId;
		}
        return "";
        
    	
    }
    public LaboratoryOrder GetLabOrder(int ID) throws SQLException
    {
    	  
    		  
    	  String query1= "SELECT * FROM laborder l WHERE l.orderID="+ID;
          ResultSet rs=stmt.executeQuery( query1 );
          LaboratoryOrder order= new LaboratoryOrder();
          System.out.println("labOrders:");
          System.out.println("PatientID"+ "\t" + "sampleID" +
                 "\t" +"CaseID" + "\t" + "labParameters"+"\t"+"OrderID");
          while (rs.next()) {
              String PatientID =
                  rs.getString("patientID");
              order.setPatientID(PatientID);
              String sampleID = rs.getString("sampleID");
              order.setSampleID(sampleID);
              String CaseID = rs.getString("CaseID");
              order.setCaseID( rs.getString("CaseID"));
              String labParameters = rs.getString("labParameters");
              int lastIndex = 0;
              int count =1;
              String txt= labParameters;
              while(lastIndex != -1){

                     lastIndex = txt.indexOf(";",lastIndex);
                     if( lastIndex != -1){
                           count ++;
                           txt=txt.substring(lastIndex);
                    }
              }
              String[] param=new String[count];
              lastIndex=0;
              int first=0;
              count=0;
              txt=labParameters;
              while(lastIndex != -1){

                  lastIndex = txt.indexOf(";",lastIndex);
                  if(lastIndex!=-1)
                  {
	                  param[count]=labParameters.substring(first, lastIndex);
	                  first=lastIndex+1;
	                  count++;
	                  txt=txt.substring(lastIndex);
                  }
                  else
                  {
                	  param[count]=labParameters.substring(first);
                  }
                 
              }
              order.setLabParameter(param);
              String orderID = rs.getString("orderID");
              order.setOrderID(orderID);
              System.out.println(
              		PatientID + "\t" + sampleID +
                  "\t" +CaseID + "\t" + labParameters+"\t"+orderID);
              
          }
         
         return order;
          
    }
    public void Insertlabreport(LaboratoryReport  report) throws SQLException
    {
    	int i;
    	String values="";
    	LabValues_type0 tmp=new LabValues_type0();
    	
    	for(i=0;i<report.getLabValues().length;i++)
    	{
    		tmp=report.getLabValues()[i];
    		values=values+tmp.getLabParameter()+":"+tmp.getLabValue();
    		if(i!=report.getLabValues().length-1)
    		{
    			values=values+";";
    		}
    	}
    	//values=values+tmp.getLabParameter()+":"+tmp.getLabValue();
    	
    	String query = "INSERT INTO ";
        query += "labreport (orderID,patientID,sampleID,labvalues)";
        query += " VALUES (";
        query += report.getOrderID()+" , '"+report.getPatientID()+"' , '"+report.getSampleID()+"' , '"+values;
        query += "')";
        System.out.println( "Query: " + query );
        stmt.executeUpdate( query );
    }

    public void LogOrder() throws SQLException
    {
    	
    	System.out.println("\n\n LOG FROM DB: \n");
       String query1= "SELECT * FROM 	laborder";
       ResultSet rs=stmt.executeQuery( query1 );
       System.out.println("labOrders:");
       System.out.println("PatientID"+ "\t" + "sampleID" +
              "\t" +"CaseID" + "\t" + "labParameters"+"\t"+"OrderID");
       while (rs.next()) {
           String PatientID =
               rs.getString("patientID");
           String sampleID = rs.getString("sampleID");
           String CaseID = rs.getString("CaseID");
           String labParameters = rs.getString("labParameters");
           String orderID = rs.getString("orderID");
           System.out.println(
           		PatientID + "\t" + sampleID +
               "\t" +CaseID + "\t" + labParameters+"\t"+orderID);
       }
    }
    public void Logreport() throws SQLException
    {
    	System.out.println("\n\n LOG FROM DB: \n");
        String query1= "SELECT * FROM 	labreport";
        ResultSet rs=stmt.executeQuery( query1 );
        System.out.println("labreports:");
        System.out.println("PatientID"+ "\t" + "sampleID" +
               "\t" + "labvalues"+"\t"+"OrderID");
        while (rs.next()) {
            String PatientID =
                rs.getString("patientID");
            String sampleID = rs.getString("sampleID");
            String labvalues = rs.getString("labvaluess");
            String orderID = rs.getString("orderID");
            System.out.println(
            		PatientID + "\t" + sampleID +
             "\t" + labvalues+"\t"+orderID);
        }
    }
}
