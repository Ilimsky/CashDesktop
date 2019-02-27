package AddValuesToTableMSSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        //String connectURL = "jdbc:sqlserver://sql6005.site4now.net;" + "databasename = DB_A44BEF_ilimsky; user = DB_A44BEF_ilimsky_admin; password = P@ssw0rd";
        String connectURL = "jdbc:sqlserver://sql7001.site4now.net;" + "databasename = DB_A4448C_hanzo95; user = DB_A4448C_hanzo95_admin; password = yfpuekm197316";

        Connection conn = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectURL);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO ComWomen " +
                    "VALUES (1,'admin', 'p@ss')");
            //ps.setString(1, "hello");
            //ps.setString(2, "P@ss");
            ps.executeUpdate();

            PreparedStatement ps_1 = conn.prepareStatement("SELECT * FROM ComWomen");
            rs = ps_1.executeQuery();
            while (rs.next()){
                System.out.println("Login: " + rs.getString(1) + "| Password: " + rs.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs != null) try {rs.close();}catch (Exception e){};
            if (conn != null) try {conn.close();}catch (Exception e){};
        }
    }
}
