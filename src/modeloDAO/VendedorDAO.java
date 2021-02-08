
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;
import modelo.EntidadVendedor;
import modelo.Vendedor;

public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;    
    
    Conexion acceso=new Conexion();
    Connection con;
    
    public EntidadVendedor ValidarVendedor(String dni,String user){
        EntidadVendedor ev=new EntidadVendedor();
        String sql="select * from empleado where Dni=? and User=?";
        try {
           con=acceso.Conectar();
           ps=con.prepareStatement(sql);
           ps.setString(1, dni);
           ps.setString(2, user);
           rs=ps.executeQuery();
            while (rs.next()) {
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setTel(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return ev;
    }
     public Vendedor listarVendedorId(String dni) {
        Vendedor v=new Vendedor();
        String sql = "select * from empleado where Dni=" + dni;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return v;
    }
    //********CRUD - Principal**************

    public List listarVendedor() {
        String sql = "select * from empleado";
        List<Vendedor> listaVendedor = new ArrayList<>();
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor ven = new Vendedor();
                ven.setId(rs.getInt(1));
                ven.setDni(rs.getString(2));
                ven.setNom(rs.getString(3));
                ven.setTel(rs.getString(4));
                ven.setEstado(rs.getString(5));
                ven.setUser(rs.getString(6));
                listaVendedor.add(ven);
            }
        } catch (Exception e) {
        }
        return listaVendedor;
    }

    public int agregar(Vendedor v) {
        int r=0;
        String sql = "insert into empleado(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNom());
            ps.setString(3, v.getTel());
            ps.setString(4, v.getEstado());
            ps.setString(5, v.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int actualizar(Vendedor v) {
        int r=0;
        String sql = "update empleado set Dni=?, Nombres=?,Telefono=?,Estado=? Where IdEmpleado=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getDni());
            ps.setString(2, v.getNom());
            ps.setString(3, v.getTel());
            ps.setString(4, v.getEstado());
            ps.setInt(5, v.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return r;
    }

    public int delete(int id) {
        int r=0;
        String sql = "delete from empleado where IdEmpleado=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
