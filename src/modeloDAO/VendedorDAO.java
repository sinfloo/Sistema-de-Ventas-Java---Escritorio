package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.EntidadVendedor;
import modelo.Vendedor;

public class VendedorDAO {

    public EntidadVendedor ValidarVendedor(String dni, String user) {
        EntidadVendedor ev = new EntidadVendedor();
        String sql = "select * from empleado where Dni=? and User=? and Estado='1'";
        try {
            PreparedStatement ps;
            ResultSet rs;
            try ( Connection con = Conexion.ConectarDB()) {
                if (con != null) {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, dni);
                    ps.setString(2, user);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        ev.setId(rs.getInt(1));
                        ev.setDni(rs.getString(2));
                        ev.setNom(rs.getString(3));
                        ev.setTel(rs.getString(4));
                        ev.setEstado(rs.getString(5).equals("1")?"ACTIVO":"INACTIVO");
                        ev.setUser(rs.getString(6));
                    }
                    ps.close();
                    rs.close();
                }else{
                    return null;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error:"+e);
        }
        return ev;
    }

    public Vendedor listarVendedorId(String dni) {
        Vendedor v = new Vendedor();
        String sql = "select * from empleado where Dni=" + dni;
        try {
            PreparedStatement ps;
            ResultSet rs;
            try ( Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    v.setId(rs.getInt(1));
                    v.setDni(rs.getString(2));
                    v.setNom(rs.getString(3));
                    v.setTel(rs.getString(4));
                    v.setEstado(rs.getString(5).equals("1")?"ACTIVO":"INACTIVO");
                    v.setUser(rs.getString(6));
                }
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + ":" + e.getMessage());
        }
        return v;
    }
    //********CRUD - Principal**************

    public List listarVendedor() {
        String sql = "select * from empleado";
        List<Vendedor> listaVendedor = new ArrayList<>();
        try {
            PreparedStatement ps;
            ResultSet rs;
            try ( Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Vendedor ven = new Vendedor();
                    ven.setId(rs.getInt(1));
                    ven.setDni(rs.getString(2));
                    ven.setNom(rs.getString(3));
                    ven.setTel(rs.getString(4));
                    ven.setEstado(rs.getString(5).equals("1")?"ACTIVO":"INACTIVO");
                    ven.setUser(rs.getString(6));
                    listaVendedor.add(ven);
                }
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
        return listaVendedor;
    }

    public int agregar(Vendedor v) {
        int r = 0;
        String sql = "insert into empleado(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            PreparedStatement ps;
            try ( Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                //ResultSet rs = ps.executeQuery();
                ps.setString(1, v.getDni());
                ps.setString(2, v.getNom());
                ps.setString(3, v.getTel());
                ps.setString(4, v.getEstado().equals("ACTIVO")?"1":"0");
                ps.setString(5, v.getUser());
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return r;
    }

    public int actualizar(Vendedor v) {
        int r = 0;
        String sql = "update empleado set Dni=?, Nombres=?,Telefono=?,Estado=? Where IdEmpleado=?";
        try {
            PreparedStatement ps;
            try ( Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                //ResultSet rs = ps.executeQuery();
                ps.setString(1, v.getDni());
                ps.setString(2, v.getNom());
                ps.setString(3, v.getTel());
                ps.setString(4, v.getEstado().equals("ACTIVO")?"1":"0");
                ps.setInt(5, v.getId());
                r = ps.executeUpdate();
                if (r == 1) {
                    r = 1;
                } else {
                    r = 0;
                }
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return r;
    }

    public int delete(int id) {
        int r = 0;
        String sql = "delete from empleado where IdEmpleado=?";
        try {
            PreparedStatement ps;
            try ( Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return r;
    }
}
