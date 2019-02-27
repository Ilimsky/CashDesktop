package CreateTableMSSQL;

import java.sql.*;

public class JDBCExample {

    String connectURL = "jdbc:sqlserver://sql6005.site4now.net;" + "databasename = DB_A44BEF_ilimsky; user = DB_A44BEF_ilimsky_admin; password = P@ssw0rd";

    /*static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:jtds:sqlserver://sql6005.site4now.net/DB_A44BEF_ilimsky";
    static final String USER = "DB_A44BEF_ilimsky_admin";
    static final String PASS = "P@ssw0rd";*/

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:jtds:sqlserver://sql7001.site4now.net/DB_A4448C_hanzo95";
    static final String USER = "DB_A4448C_hanzo95_admin";
    static final String PASS = "yfpuekm197316";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connection to a selecting database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE ComWomen" +
                    "(id INTEGER not NULL, " +
                    "login VARCHAR (255), " +
                    "password VARCHAR (255)," +
                    "PRIMARY KEY (id))";

            /*String sql = "CREATE TABLE Swimmers" +
                    "(ID INTEGER not NULL, " +
                    "First_Name VARCHAR (255), " +
                    "Last_Name VARCHAR (255), " +
                    "School VARCHAR (255)," +
                    "PRIMARY KEY (ID))";*/
            /*String sql = "CREATE TABLE Product " +
                    "(code INTEGER NOT NULL IDENTITY , " +
                    "description VARCHAR (200), " +
                    "why DECIMAL (10, 8), " +
                    "amount DECIMAL (10, 8)" +
                    "PRIMARY KEY (code))";*/





            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null){conn.close();}
            }catch (SQLException se){}
            try {
                if (conn != null){conn.close();}
            }catch (SQLException se){}
        }
        System.out.println("Goodbye!");
    }
}
