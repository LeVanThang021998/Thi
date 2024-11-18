/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {
      Connection conn;
    PreparedStatement ps;
    ResultSet rs;
   
     public ArrayList<SanPham> getTop5() {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select top 5 * from sanpham order by dongia asc";
        conn =new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), (int) rs.getFloat(3),
                        rs.getString(4),rs.getInt(5) , rs.getBoolean(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }    
       public ArrayList<SanPham> laySanPhamTheoTL(int macd) {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from sanpham where masp=?";
        conn =new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, macd);
            rs = ps.executeQuery();
            while (rs.next()) {
               ds.add(new SanPham(rs.getInt(1), rs.getString(2), (int) rs.getFloat(3),
                       rs.getString(4),rs.getInt(5) , rs.getBoolean(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }

    public Object getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object laySachTheoCD(int macd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
