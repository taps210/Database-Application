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
            conn.setAutoCommit(false);
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id,resident_id FROM asset_rentals");
            ResultSet rst = pstmt.executeQuery();


          
            pstmt = conn.prepareStatement("INSERT INTO asset_transactions VALUE(?,?,?,?,?,?,null,null,null,null,?)");
            // INSERT SETTERS HERE AND EXECUTE UPDATE
            pstmt.setInt(1, asset_id);
            pstmt.setString(2, rental_date);
            pstmt.setInt(3, 9011);
            pstmt.setString(4, "Auditor");
            pstmt.setString(5, "2022-12-01");
            pstmt.setInt(6, 0);
            pstmt.setString(7, "R");
            pstmt.executeUpdate();
            


            pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, null, null, null, ?)");
            pstmt.setInt(1, asset_id);
            pstmt.setString(2, rental_date);
            pstmt.setString(3, reservation_date);
            pstmt.setInt(4, resident_id);
            pstmt.setFloat(5, 50);
            pstmt.setFloat(6, discount);
            
            if(rental_date.equals(reservation_date)) {
                status = "O";
            }
            pstmt.setString(7, status);
            pstmt.setString(8, "Mukhang Ok naman");
            pstmt.setFloat(9, 500);
            pstmt.setString(10, return_date);
            pstmt.executeUpdate();
            
            conn.commit();


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
            conn.setAutoCommit(false);


            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset_rentals WHERE status = 'R' OR status = 'O'");
            ResultSet rst = pstmt.executeQuery();
/*
            while(rst.next()){
                if (inspection_details == "")
                    inspection_details = rst.getString(inspection_details);
                if (assessed_value == "")
                    assessed_value = rst.getString(assessed_value);
                if (accept_hoid == "")
                    accept_hoid = rst.getString(accept_hoid);
                if (accept_position == "")
                    accept_position = rst.getString(accept_position);
                if (accept_electiondate == "")
                    accept_electiondate = rst.getString(accept_electiondate);
                if (return_date == "")
                    return_date = rst.getString(return_date);
            }
*/          
            
            pstmt = conn.prepareStatement("UPDATE asset_rentals SET status = ?, inspection_details = ?, assessed_value = ?, accept_hoid = ?, accept_position = ?, accept_electiondate = ?, return_date = ? WHERE asset_id = ?");
            pstmt.setString(1, "N");
            pstmt.setString(2, inspection_details);
            pstmt.setFloat(3, assessed_value);
            pstmt.setInt(4, 9004);
            pstmt.setString(5, "President");
            pstmt.setString(6, "2022-12-01");
            pstmt.setString(7, return_date);
            pstmt.setInt(8, asset_id);


            pstmt.executeUpdate();

            conn.commit();

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
