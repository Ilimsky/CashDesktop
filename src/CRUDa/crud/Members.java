package CRUDa.crud;

import CRUDa.db.dbList;
import CRUDa.db.dbRow;
import CRUDa.tools.Utils;

public class Members {
    public static dbList loadData(dbRow filter){
        try {
            return Launcher.getDatabaseConnection().loadData(filter, "member", "name");
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static dbRow getMember(String id){
        try {
            return Launcher.getDatabaseConnection().fetchByID(id, "member", "id");
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static dbList searchByName(String name){
        try {
            String sql = String.format(
                    "SELECT * FROM member WHERE LOWER(%s) LIKE '%%%s%%' ORDER BY %s ASC",
                    "name",
                    Utils.escapeSQLVar(name).toLowerCase(),
                    "name"
            );
            return Launcher.getDatabaseConnection().getList(sql);
        } catch(Exception e){
            e.printStackTrace();
            return new dbList();
        }
    }
    
    public static boolean delete(String id){
        try {
            String sql = String.format("DELETE FROM member WHERE id = '%s'", 
                    Utils.escapeSQLVar(id)
            );
            return Launcher.getDatabaseConnection().nonTransactQuery(sql) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
