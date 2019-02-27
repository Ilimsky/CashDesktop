package CRUDf;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDataBase {
    public static final Connection getConect() {
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //String database = "jdbc:sqlserver://sql6005.site4now.net;\" + \"databasename = DB_A44BEF_ilimsky; user = DB_A44BEF_ilimsky_admin; password = P@ssw0rd";
            String url = "jdbc:sqlserver://sql6005.site4now.net;\" + \"databasename = DB_A44BEF_ilimsky; user = DB_A44BEF_ilimsky_admin; password = P@ssw0rd";
            //url = url + database;

            conn = DriverManager.getConnection(url);
            if (conn != null){
                System.out.println("Success");
            }
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bank error :"+e);
        }
        return conn;
    }
}
