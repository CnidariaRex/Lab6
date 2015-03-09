/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derbyconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author alexander.barrick638
 */
public class DerbyConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String host = "jdbc:derby://localhost:1527/TeamMembers";
            String uName = "student";
            String uPass = "student";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Members";
            ResultSet rs = stmt.executeQuery( SQL );
            
            rs.next( );
            int id_col = rs.getInt("ID");
            String first_name = rs.getString("First_Name");
            String last_name = rs.getString("Last_Name");
            String job = rs.getString("Job_Title");
            
            System.out.println( id_col + " " + first_name + " " + last_name + " " + job );
            while(rs.next())
            {
                id_col = rs.getInt("ID");
                first_name = rs.getString("First_Name");
                last_name = rs.getString("Last_Name");
                job = rs.getString("Job_Title");
                System.out.println( id_col + " " + first_name + " " + last_name + " " + job );
            }
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }

        // TODO code application logic here
    }
    
}
