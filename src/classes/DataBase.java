package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

    public Connection conn = null;
    
    public void createConnection () {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lpp_project", "postgres", "#rootPOSTGRES12");
            
            if (conn == null) {
                System.out.println("Connection Failed");
            } else {
                System.out.println("Connection Established");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery (String query, String... variavels) {
        ResultSet result = null;
                        
        try {
     
            for (String var : variavels) {
                // Check string is not a SQL Query
                if (!var.matches("^(?!.*(SELECT|FROM|CREATE|DROP|UPDATE|INSERT|ALTER|DELETE|ATTACH|DETACH)).*$")) { throw new Error ("Invalid string comming");} 
                query = query.replaceFirst("(?:[?])+", var);
            }
            
            Statement statement = conn.createStatement();
            result = statement.executeQuery(query);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return result;
    }
}
