package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.CRUD;
import modelo.Cliente;
import config.Conexion;
import java.sql.SQLException;

public class ClienteDAO implements CRUD {
   
    
    public Cliente listarID(String dni){
        Cliente c=new Cliente();
       String sql="select * from cliente where Dni=? and Estado='1'";
        try {
            PreparedStatement ps;
            ResultSet rs;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setString(1, dni);
                rs = ps.executeQuery();
                while (rs.next()) {
                    c.setId(rs.getInt(1));
                    c.setDni(rs.getString(2));
                    c.setNom(rs.getString(3));
                    c.setDir(rs.getString(4));
                    c.setEstado(rs.getString(5).equals("1")?"ACTIVO":"INACTIVO");
                }
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return c;
    }
    //Metodos de Mantenimiento CRUD
    @Override
    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5).equals("1")?"ACTIVO":"INACTIVO");
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {  
        int r=0;
        String sql = "insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        try {
            PreparedStatement ps;
            try (Connection con = Conexion.ConectarDB()) {
                ps = con.prepareStatement(sql);
                ps.setObject(1, o[0]);
                ps.setObject(2, o[1]);
                ps.setObject(3, o[2]);
                ps.setObject(4, o[3]=="ACTIVO"?"1":"0");
                r=ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
       String sql="update cliente set Dni=?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        try {
            Connection con=Conexion.ConectarDB();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]=="ACTIVO"?"1":"0");
            ps.setObject(5, o[4]);
            r=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="delete from cliente where IdCliente=?";
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
    }

}
