package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;
import java.sql.SQLException;
import modelo.Producto;

public class ProductoDAO {

    int r;
    Producto pro = new Producto();

    public int actualizarStock(int cant, int idp) {
        String sql = "update producto set Stock=? where idProducto=?";
        try {
            PreparedStatement pst;
            try (Connection conn = Conexion.ConectarDB()) {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, cant);
                pst.setInt(2, idp);
                pst.executeUpdate();
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }

    public static Producto listarID(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto=?";
        try {
            PreparedStatement ps;
            ResultSet rs;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    p.setId(rs.getInt(1));
                    p.setNom(rs.getString(2));
                    p.setPre(rs.getDouble(3));
                    p.setStock(rs.getInt(4));
                    p.setEstado(rs.getString(5));
                }
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return p;
    }

    //*************MANTENIMIENTO CRUD**************
    public List listarProducto() {
        String sql = "select * from producto";
        List<Producto> listaprod = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement ps;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Producto p = new Producto();
                    p.setId(rs.getInt(1));
                    p.setNom(rs.getString(2));
                    p.setPre(rs.getDouble(3));
                    p.setStock(rs.getInt(4));
                    p.setEstado(rs.getString(5));
                    listaprod.add(p);
                }   
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return listaprod;
    }

    public int agregar(Producto p) {
        String sql = "insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try {
            PreparedStatement ps;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNom());
                ps.setDouble(2, p.getPre());
                ps.setInt(3, p.getStock());
                ps.setString(4, p.getEstado());
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }

//    public int actualizarStock(int cant, int id) {
//        String sql = "update producto set Stock=? where IdProducto=?";
//        try {
//            con = acceso.Conectar();
//            ps = con.prepareStatement(sql);          
//            ps.setInt(1, cant);           
//            ps.setInt(2, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//        return r;
//    }
    public int actualizar(Producto p) {
        String sql = "update producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try {
            PreparedStatement ps;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNom());
                ps.setDouble(2, p.getPre());
                ps.setInt(3, p.getStock());
                ps.setString(4, p.getEstado());
                ps.setInt(5, p.getId());
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }

    public int delete(int id) {
        String sql = "delete from producto where IdProducto=?";
        try {
            PreparedStatement ps;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }
}
