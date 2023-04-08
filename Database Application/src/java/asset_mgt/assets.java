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
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}