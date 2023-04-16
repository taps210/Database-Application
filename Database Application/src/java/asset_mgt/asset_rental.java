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
    public int asset_id;
    public int resident_id;
    public String reservation_date;
    public String rental_date;
    public float rental_amount;
    public float discount;
    public String status = "R";
    public String inspection_details = "Mananapak na talaga ako";
    public float assessed_value = 50;
    public int accept_hoid;
    public String accept_position;
    public String accept_electiondate;
    public String return_date;
    public ArrayList<Integer> assetIdList = new ArrayList<>();
    public ArrayList<String> assetNameList = new ArrayList<>();

    public ArrayList<Integer> residentIdList = new ArrayList<>();
    // will not include hoa_officer since generated siya sa jsp

    public int recordRental() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id,resident_id FROM asset_rentals");
            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                residentIdList.add(rst.getInt("resident_id"));
            }
          
           

            
            pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, asset_id);
            pstmt.setString(2, rental_date);
            pstmt.setString(3, reservation_date);
            pstmt.setInt(4, resident_id);
            pstmt.setFloat(5, rental_amount);
            pstmt.setFloat(6, discount);
            pstmt.setString(7, status);
            pstmt.setString(8, inspection_details);
            pstmt.setFloat(9, assessed_value);
            pstmt.setInt(10, accept_hoid);
            pstmt.setString(11, accept_position);
            pstmt.setString(12, accept_electiondate);
            pstmt.setString(13, return_date);
            pstmt.executeUpdate();


            pstmt.close();
            conn.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int returnRental() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("");
            ResultSet rst = pstmt.executeQuery();


            while (rst.next()) {

            }

            pstmt = conn.prepareStatement("");

            pstmt.close();
            conn.close();

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int updateRental() {

        try {

            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id FROM asset_rental WHERE status = ?");

            ResultSet rst = pstmt.executeQuery();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int availableAssets() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id, asset_name FROM assets WHERE status != 'x' AND forrent = 1");
            ResultSet rst = pstmt.executeQuery();

            assetIdList.clear();
            assetNameList.clear();

            while (rst.next()) {
                assetIdList.add(rst.getInt("asset_id"));
                assetNameList.add(rst.getString("asset_name"));
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
        asset_rental A_R = new asset_rental();
        A_R.recordRental();
        
        System.out.println(A_R.asset_id);
    }
    
}
