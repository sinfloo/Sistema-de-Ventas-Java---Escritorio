package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleVentas;
import modelo.Ventas;
import utils.ImprimirObject;

public class VentasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public static ImprimirObject getDocumento(int idVenta) {
        ImprimirObject object = new ImprimirObject();
        String sql = "SELECT v.NumeroSerie,v.FechaVentas,v.Monto,c.Nombres,c.Dni,c.Direccion,"
                + "e.User,e.Nombres from ventas v INNER JOIN cliente c\n"
                + "ON v.IdCliente=c.IdCliente INNER JOIN empleado e\n"
                + "ON v.IdEmpleado=e.IdEmpleado\n"
                + "where IdVentas=" + idVenta;
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                object.setNroSerie(rs.getString("v.NumeroSerie"));
                object.setFecha(rs.getString("v.FechaVentas"));
                object.setTotalPagar(Double.valueOf(rs.getString("v.Monto")));
                object.setNomCliente(rs.getString("c.Nombres"));
                object.setDirCliente(rs.getString("c.Direccion"));
                object.setDocClient(rs.getString("c.Dni"));
                object.setUser(rs.getString("e.User"));
                object.setUserName(rs.getString("e.Nombres"));
                object.setDetalle(getDetalle(idVenta));
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return object;
    }

    public static List<Object[]> getDetalle(int idVenta) {
        List<Object[]> objectList = new ArrayList<>();
        String sql = "SELECT p.idProducto,p.Nombres,dv.PrecioVenta,dv.Cantidad\n"
                + "FROM detalle_ventas dv INNER JOIN producto p \n"
                + "ON dv.IdProducto=p.IdProducto\n"
                + "where dv.IdVentas=" + idVenta;
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int contador=0;
            while (rs.next()) {
                contador=contador+1;
                Object object[] = new Object[5];
                object[0]=contador;
                object[1]=rs.getString("p.Nombres");
                object[2]=rs.getDouble("dv.PrecioVenta");
                object[3]=rs.getInt("dv.Cantidad");
                object[4]=Double.valueOf(object[2].toString())*Integer.valueOf(object[3].toString());
                objectList.add(object);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return objectList;
    }

    public String NroSerieVentas() {
        String serie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return serie;
    }

    public String IdVentas() {
        String idv = "";
        String sql = "select max(IdVentas) from ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return idv;
    }

    public static int IdVenta() {
        int idv = 0;
        String sql = "select max(IdVentas) from ventas";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idv = Integer.valueOf(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return idv;
    }

    public int GuardarVentas(Ventas v) {
        String sql = "insert into Ventas(IdCliente, IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado)values(?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }

        return r;
    }

    public int GuardarDetalleVentas(DetalleVentas dv) {
        String sql = "insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreVenta());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return r;
    }
}
