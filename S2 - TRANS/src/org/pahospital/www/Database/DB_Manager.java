package org.pahospital.www.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.pahospital.www.transportationservice.PatientOrder;
import org.pahospital.www.transportationservice.SampleOrder;
import java.util.*;
/**
 * JDBC interface for DVD Catalog application.
 *
 * @author Russell Bateman
 */
public class DB_Manager
{
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/transporDB?user=test&password=test";
    private Connection conn;
    private static Statement stmt;
    public DB_Manager()
    {
    	init();
    }
    private void init(){
    	try
        {
    		System.out.println("hello init");
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            System.out.println("after forname");
            conn = DriverManager.getConnection( CONNECTION_URL );
            System.out.println("after connection");
            stmt = conn.createStatement();
            
            System.out.println("DONE!");

            try
            {
            	
            	String query_1="DROP TABLE patienttransp";
            	//stmt.executeUpdate( query_1 );
            	String query_2="DROP TABLE sample";
            	//stmt.executeUpdate( query_2 );
            	String query_4="DROP TABLE trasppatient; ";
            	//stmt.executeUpdate( query_4 );
            	
            	String query_3="DROP TABLE patients; ";
            	//stmt.executeUpdate( query_3 );
            	
            
            	String query3="CREATE TABLE patients( patientID VARCHAR(30) NOT NULL ,PRIMARY KEY (patientID) ); ";
            	stmt.executeUpdate( query3 );
            	String query1="CREATE TABLE patienttransp( patientID VARCHAR(30), requestingUnit TEXT NOT NULL, destinationUnit TEXT NOT NULL , transDate DATETIME NOT NULL,FOREIGN KEY (patientID) REFERENCES patients(patientID) ON DELETE CASCADE ); ";
            	stmt.executeUpdate( query1 );
            	String query2="CREATE TABLE sample( patientID VARCHAR(30), requestingUnit TEXT NOT NULL, sampleID TEXT NOT NULL,FOREIGN KEY (patientID) REFERENCES patients(patientID) ON DELETE CASCADE ); ";
            	stmt.executeUpdate( query2 );
            	
//            	PatientOrder o=new PatientOrder();
//            	o.setPatientID("x");
//            	o.setRequestingUnit("u");
//            	o.setDestinationUnit("i");
//            	//DateTime date=new DateTime();
//                Calendar d=Calendar.getInstance();
//            	o.setTransportationDate(d);
//            	 String query_1= "SELECT * FROM 	patients WHERE patientID=ID";
//                 ResultSet rs=stmt.executeQuery( query_1 );
//                 System.out.println("Pateien:");
//                 System.out.println("PatientID");
//                 
//                 while (rs.next()) {
//                     String PatientID =rs.getString("patientID");
//                     System.out.println(PatientID);
//                     
//                 }
//                 
            	
//            	String query = "INSERT INTO ";
//
//                query += "patient (patientID,requestingUnit,destinationUnit,transDate)";
//                query += " VALUES ('";
//                query += " 124' , 'Labratory1' , 'Radiology1' , '2012-2-7";
//                query += "')";
//                System.out.println( "Query: " + query );
//                stmt.executeUpdate( query );
//                String query1= "SELECT * FROM 	patient";
//                ResultSet rs=stmt.executeQuery( query1 );
//                while (rs.next()) {
//                    String PatientID =
//                        rs.getString("patientID");
//                    String requestingUnit = rs.getString("requestingUnit");
//                    String destinationUnit = rs.getString("destinationUnit");
//                    java.util.Date date=rs.getDate("transDate");
//                    System.out.println(
//                    		PatientID + "\t" + requestingUnit +
//                        "\t" +destinationUnit + "\t" + date);
//                }
//                
//                
//                System.out.println("GOOD JOB!");
                
            }
            catch( SQLException e )
            {
                System.out.println( "SQLException: " + e.getMessage() );
                System.out.println( "SQLState:     " + e.getSQLState() );
                System.out.println( "VendorError:  " + e.getErrorCode() );
            }
        }
        catch( Exception e )
        {
            System.out.println( "Holy crap, Batman!" );
            System.out.println( e.getMessage() );
            e.printStackTrace();
            System.out.println( "Remember: mandatory fields include:" );
            System.out.println( "title, year, length, rating, url, stars" );
        }
    }
//    public static void main( String[] args ) throws SQLException
//    {
//    	try{
//    		DB_Manager x= new DB_Manager();
//    
//    	PatientOrder o=new PatientOrder();
//    	o.setPatientID("x");
//    	o.setRequestingUnit("u");
//    	o.setDestinationUnit("i");
//    	//DateTime date=new DateTime();
//        Calendar  d=Calendar.getInstance();
//    	o.setTransportationDate(d);
//    	x.InsertPatientOrder(o);
//    	SampleOrder s=new SampleOrder();
//    	s.setPatientID("x");
//    	s.setRequestingUnit("u");
//    	s.setSampleID("blood");
//        x.InsertSampleOrder(s);
//    	
//    	x.LogDB();
//    	}
//    	 catch( SQLException e )
//         {
//             System.out.println( "SQLException: " + e.getMessage() );
//             System.out.println( "SQLState:     " + e.getSQLState() );
//             System.out.println( "VendorError:  " + e.getErrorCode() );
//         }
//        
//    }
    public boolean Is_Patient(String ID) throws SQLException
    {
    	 String query1= "SELECT * FROM 	patients p WHERE p.patientID='"+ID+"'";
         ResultSet rs=stmt.executeQuery( query1 );
         System.out.println("Pateien:");
         System.out.println("PatientID");
         
         while (rs.next()) {
             String PatientID =rs.getString("patientID");
             System.out.println(PatientID);
             return true;
         }
         return false;
    	
    }
    public void InsertPatient(String ID) throws SQLException
    {
    	
    	String query = "INSERT INTO ";

        query += "patients (patientID)";
        query += " VALUES ('";
        query += ID;
        query += "')";
        System.out.println( "Query: " + query );
        stmt.executeUpdate( query );
    	
    }
   
    public void InsertPatientOrder(PatientOrder  Order) throws SQLException
    {
    	if(!Is_Patient(Order.getPatientID()))
    	{
    		InsertPatient(Order.getPatientID());
    	}
    	String query = "INSERT INTO ";

    	java.util.Date dt =Order.getTransportationDate().getTime();

    	java.text.SimpleDateFormat sdf = 
    	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	String currentTime = sdf.format(dt);

        query += "patienttransp (patientID,requestingUnit,destinationUnit,transDate)";
        query += " VALUES ('";
        query += Order.getPatientID()+"' , '"+Order.getRequestingUnit()+"' , '"+Order.getDestinationUnit()+"' , '"+currentTime;
        query += "')";
        System.out.println( "Query: " + query );
        stmt.executeUpdate( query );
    	
    }
    public void InsertSampleOrder(SampleOrder  Order) throws SQLException
    {
    	if(!Is_Patient(Order.getPatientID()))
    	{
    		InsertPatient(Order.getPatientID());
    	}
    	String query = "INSERT INTO ";
    	query += "sample (patientID,requestingUnit,sampleID)";
        query += " VALUES ('";
        query += Order.getPatientID()+"' , '"+Order.getRequestingUnit()+"' , '"+Order.getSampleID();
        query += "')";
        System.out.println( "Query: " + query );
        stmt.executeUpdate( query );
    	
    }
    public void LogDB() throws SQLException
    {
    	
    	System.out.println("\n\n LOG FROM DB: \n");
       String query1= "SELECT * FROM 	patienttransp";
       ResultSet rs=stmt.executeQuery( query1 );
       System.out.println("PateienOrders:");
       System.out.println("PatientID"+ "\t" + "requestingUnit" +
              "\t" +"destinationUnit" + "\t" + "date");
       while (rs.next()) {
           String PatientID =
               rs.getString("patientID");
           String requestingUnit = rs.getString("requestingUnit");
           String destinationUnit = rs.getString("destinationUnit");
           java.util.Date date=rs.getDate("transDate");
           System.out.println(
           		PatientID + "\t" + requestingUnit +
               "\t" +destinationUnit + "\t" + date);
       }
       String query2= "SELECT * FROM sample";
       ResultSet rs2=stmt.executeQuery( query2 );
       System.out.println("SampleOrders:");
       System.out.println("PatientID"+ "\t" + "requestingUnit" +
              "\t" +"SampleID" );
       while (rs2.next()) {
           String PatientID =
               rs2.getString("patientID");
           String requestingUnit = rs2.getString("requestingUnit");
           String sampleID = rs2.getString("sampleID");
           System.out.println(
           		PatientID + "\t" + requestingUnit +
               "\t" +sampleID);
       }
    	
    }
}
			