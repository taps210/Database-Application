package asset_mgt;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccslearner
 */
import java.util.*;
import java.sql.*;

public class assets {
    public int assetId;
    public String assetName;
    public String assetDescription;
    public String acquisitionDate;
    public String forRent;
    public String assetValue;
    public String assetType;
    public String assetStatus;
    public String lattitudeLoc;
    public String longitureLoc;
    public String hoaName;
    public String enclosingAsset;
    
    public ArrayList<Integer> assetIdList = new ArrayList<>();
    public ArrayList<String> assetNameList = new ArrayList<>();
    
    public int availableAssets() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id, asset_name FROM assets WHERE status != 'x'");
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
    
    public int deletableAssets() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id, asset_name FROM assets WHERE asset_id NOT IN (SELECT asset_id FROM asset_rentals) AND asset_id NOT IN (SELECT asset_id FROM asset_activity) AND asset_id NOT IN (SELECT asset_id FROM asset_transfer) AND status = 'W'");
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
    
    public int registerAsset() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_id) + 1 AS newID FROM assets");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                assetId = rst.getInt("newID");
            }
            if (enclosingAsset == "")
                enclosingAsset = null;
            
            pstmt = conn.prepareStatement("INSERT INTO assets VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, assetId);
            pstmt.setString(2, assetName);
            pstmt.setString(3, assetDescription);
            pstmt.setString(4, acquisitionDate);
            pstmt.setString(5, forRent);
            pstmt.setString(6, assetValue);
            pstmt.setString(7, assetType);
            pstmt.setString(8, assetStatus);
            pstmt.setString(9, lattitudeLoc);
            pstmt.setString(10, longitureLoc);
            pstmt.setString(11, hoaName);
            pstmt.setString(12, enclosingAsset);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int updateAsset() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM assets WHERE asset_id = ?");
            pstmt.setInt(1, assetId);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                if (assetDescription == "")
                    assetDescription = rst.getString("asset_description");
                if (forRent == "")
                    forRent = rst.getString("forrent");
                if (assetValue == "")
                    assetValue = rst.getString("asset_value");
                if (assetStatus == "")
                    assetStatus = rst.getString("status");
                if (lattitudeLoc == "")
                    lattitudeLoc = rst.getString("loc_lattitude");
                if (longitureLoc == "")
                    longitureLoc = rst.getString("loc_longiture");
                if (hoaName == "")
                    hoaName = rst.getString("hoa_name");
                if (enclosingAsset == "") 
                    enclosingAsset = rst.getString("enclosing_asset");
            }
            
            pstmt = conn.prepareStatement("UPDATE assets SET asset_description = ?, forrent = ?, asset_value = ?, status = ?, loc_lattitude = ?, loc_longiture = ?, hoa_name = ?, enclosing_asset = ? WHERE asset_id = ?");
            pstmt.setString(1, assetDescription);
            pstmt.setString(2, forRent);
            pstmt.setString(3, assetValue);
            pstmt.setString(4, assetStatus);
            pstmt.setString(5, lattitudeLoc);
            pstmt.setString(6, longitureLoc);
            pstmt.setString(7, hoaName);
            pstmt.setString(8, enclosingAsset);
            pstmt.setInt(9, assetId);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int deleteAsset() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM assets WHERE asset_id = ?");
            pstmt.setInt(1, assetId);
            pstmt.executeUpdate();
            
            pstmt = conn.prepareStatement("UPDATE asset_transactions SET isdeleted = 1 WHERE asset_id = ?");
            pstmt.setInt(1, assetId);
            pstmt.executeUpdate();
            
            pstmt.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int disposeAsset() {
        try {
            Connection conn; jdbc:mysql://localhost:3306/test
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            System.out.println("Connection Successful");
            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE assets SET status = 'X' WHERE asset_id = ?");
            pstmt.setInt(1, assetId);
            pstmt.executeUpdate();
            
            pstmt.close();
            
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public static void main (String args[]) {
        assets A = new assets();
    }
}