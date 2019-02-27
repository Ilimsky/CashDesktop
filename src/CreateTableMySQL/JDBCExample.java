package CreateTableMySQL;

import java.sql.*;

public class JDBCExample {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql6002.site4now.net/db_a44bef_test_1";
    static final String USER = "a44bef_test_1";
    static final String PASS = "P@ssw0rd";

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

            String sql = "CREATE TABLE REGISTRATION" +
                        "(id INTEGER not NULL, " +
                        "first VARCHAR (255), " +
                        "last VARCHAR (255)," +
                        "age INTEGER," +
                        "PRIMARY KEY (id))";
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
