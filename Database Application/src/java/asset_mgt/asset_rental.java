/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_mgt;

/**
 *
 * @author ccslearner
 */

import java.util.*;
import java.sql.*;

public class asset_rental {
    public int asset_rentalid;
    public ArrayList<Integer> rentalidList = new ArrayList<>();

    public int recordRental() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_rentalid) + 1 AS newID FROM asset_rental");
            ResultSet rst = pstmt.executeQuery();
           
            
            while (rst.next()) {
                rentalidList.add(asset_rentalid)
                // asset_rentalid = rst.getInt("newID");
            }
            
            pstmt.close();
            conn.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public static void main (String args[]) {
        asset_rental A = new asset_rental();
        A.recordRental();
        for(int i = 0; i<A.rentalidList.size(); i++){
            System.out.println(A.rentalidList(i)));
        }
    }
    
    
}