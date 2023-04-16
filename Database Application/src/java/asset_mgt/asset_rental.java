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
    public int renter_residentid;
    public String reservation_date;
    public String rental_date;
    public float discount;
    public String status = "OR";
    public String return_details;
    // will not include hoa_officer since generated siya sa jsp
    
    public ArrayList<Integer> rentalidList = new ArrayList<>();

    public int recordRental() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_rentalid) + 1 AS newID FROM asset_rental");
            ResultSet rst = pstmt.executeQuery();
           
            
            while (rst.next()) {
               asset_rentalid = rst.getInt("newID");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO asset_rental VALUE(?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, asset_rentalid);
            pstmt.setInt(2, renter_residentid);
            pstmt.setString(3, reservation_date);
            pstmt.setString(4, rental_date);
            pstmt.setFloat(5, discount);
            pstmt.setString(6, status);
            pstmt.setInt(7,1002);
            pstmt.setInt(8,1000005);

            pstmt.close();
            conn.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public static void main (String args[]) {
        asset_rental A_R = new asset_rental();
        A_R.recordRental();
        
        System.out.println(A_R.asset_rentalid);
    }
    
}
