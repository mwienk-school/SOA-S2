package myapp;

import java.sql.*;

public class CreateTable 
{
    public static void main(String[] args) 
    {
        DB db = new DB();
        Connection conn=db.dbConnect("jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB","dimas","dimas");
        //db.createLabReport(conn);
        //db.createPatientRecord(conn);
        //db.createRadiologyRecord(conn);
        System.out.println("connected!!!!");
    }
}

class DB
{
    public DB() {}

    public Connection dbConnect(String db_connect_string, String db_userid, String db_password)
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn = DriverManager.getConnection(
    db_connect_string, db_userid, db_password);
            System.out.println("connected");
            return conn;
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void createPatientRecord(Connection conn)
    {
        String query;
        Statement stmt;
        
        try
        {
                query="create table patient_record" +
                "(id varchar(9), " +
                "name varchar(50), " +
                "street varchar(50), " +
                "zip_code int, " +
                "city varchar(30), " +
                "birthday date)";
                
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void createRadiologyRecord(Connection conn)
    {
        String query;
        Statement stmt;
        
        try
        {
                query="create table radiology_record" +
                "(patient_id varchar(9), " +
                "radiology_order_id varchar(9), " +
                "date_of_exam date, " +
                "report_text varchar(255))";
                
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void createLabReport(Connection conn)
    {
        String query;
        Statement stmt;
        
        try
        {
                query="create table lab_record" +
                "(patient_id varchar(9), " +
                "lab_order_id varchar(9), " +
                "sample_id varchar(9), " +
                "lab_parameter varchar(30), " +
                "lab_value float, " +
                "index int)";
                
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
};