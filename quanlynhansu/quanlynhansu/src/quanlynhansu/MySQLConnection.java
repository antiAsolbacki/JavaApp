/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlynhansu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author HOME STORE
 */
public class MySQLConnection {
   public static void main(String[] args) {
        Connection conn = null;
        try {
            // Thông tin kết nối
            String url = "jdbc:mysql://localhost:3306/QuanLyNhanSu"; // Thay tên database nếu cần
            String user = "root"; // Thay username nếu cần
            String password = "long2009_"; // Thay password nếu cần

            // Kết nối
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");

            // Thực hiện truy vấn
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM NhanVien");

            // Hiển thị kết quả
            while (rs.next()) {
                System.out.println("MaNV: " + rs.getInt("MaNV") + ", HoTen: " + rs.getString("HoTen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } 
}
