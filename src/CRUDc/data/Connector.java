package CRUDc.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    
    public Connector(){
        
    }

    static String url = "jdbc:mysql://localhost:3306/simpleDB";
    static String username = "root" ;
    static String password = "";
    static String jdbc_driver = "com.mysql.jdbc.Driver";
    
    public static void insertData(String firstName,String lastName,String emailAddress) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO workers VALUES('"+firstName+"','"+lastName+"','"+emailAddress+"')";
        Class.forName(jdbc_driver);
        Connection con = DriverManager.getConnection(url,username,password);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stmt.executeUpdate(sql);
    }
    
    public static ArrayList viewData1(String firstName) throws ClassNotFoundException{
        ArrayList al1=new ArrayList();
           try{
            //String sql="SELECT firstName, lastName FROM workers WHERE firstName='"+firstName+"'";
            String sql="SELECT firstName,lastName FROM workers WHERE firstName='"+firstName+"'";
            Class.forName(jdbc_driver);
            Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            
                while(rs.next()){
                    al1.add(rs.getString("firstName"));
                }
            }catch(SQLException e){
              e.printStackTrace();
            }
        return al1;
    }
    
    public static ArrayList viewData2(String firstName) throws ClassNotFoundException{
        ArrayList al2=new ArrayList();
           try{
                //String sql="SELECT firstName, emailAddress FROM workers WHERE firstName='"+firstName+"'";
                String sql="SELECT firstname,emailAddress FROM workers WHERE firstName='"+firstName+"'";
                Class.forName(jdbc_driver);
                Connection con = DriverManager.getConnection(url,username,password);
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery(sql);
            
                    while(rs.next()){ 
                        al2.add(rs.getString("firstName"));
                    }
            }catch(SQLException e){
              e.printStackTrace();
            }
        return al2;
    }
    
    public static void editData(String firstName,String lastName,String emailAddress) throws ClassNotFoundException,SQLException,Exception{
        String sql = "UPDATE workers SET lastName ='"+lastName+"',emailAddress = '"+emailAddress+"' WHERE firstName='"+firstName+"'";
        Class.forName(jdbc_driver);
        Connection con = DriverManager.getConnection(url,username,password);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stmt.executeUpdate(sql);
    }
    
    public static void deleteData(String firstName) throws ClassNotFoundException,SQLException,Exception{
        String sql ="DELETE FROM workers WHERE firstName ='"+firstName+"'";
        Class.forName(jdbc_driver);
        Connection con = DriverManager.getConnection(url,username,password);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        stmt.executeUpdate(sql);
    }
}