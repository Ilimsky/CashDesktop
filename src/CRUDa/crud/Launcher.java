package CRUDa.crud;

import CRUDa.db.DB;
import CRUDa.tools.Utils;

import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;

public class Launcher {
    private static DB databaseConnection;
    public static DB getDatabaseConnection() {
        return databaseConnection;
    }
    
    private static MainFrame frame;
    public static MainFrame getFrame(){
        return frame;
    }
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            
        }
        
        // database connection information
        Map<String, String> dbInfo = new HashMap<String, String>();
        
        //dbInfo.put("dbHost", "localhost");
        //dbInfo.put("dbPort", "3306");
        //dbInfo.put("dbUser", "root");
        //dbInfo.put("dbPass", "");
        dbInfo.put("dbName", "cruddemo");
        
        databaseConnection = new DB(dbInfo);
        if(!databaseConnection.connectDB()){
            Utils.alert("Failed to connect to the database. Application can not be started");
            return;
        }
        
        frame = new MainFrame();
        frame.setVisible(true);
        
        frame.setContent(new MemberList(), "Data Member");
    }
}
