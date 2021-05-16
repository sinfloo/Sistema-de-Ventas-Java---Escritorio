package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Conexion;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleVentas;
import modelo.Ventas;
import utils.ImprimirObject;

public class VentasDAO {
    static final DecimalFormat DFORMAT=new DecimalFormat("0.00");
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
            int contador = 0;
            while (rs.next()) {
                contador = contador + 1;
                Object object[] = new Object[5];
                object[0] = contador;
                object[1] = rs.getString("p.Nombres");
                object[2] = rs.getDouble("dv.PrecioVenta");
                object[3] = rs.getInt("dv.Cantidad");
                object[4] = Double.valueOf(object[2].toString()) * Integer.valueOf(object[3].toString());
                objectList.add(object);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return objectList;
    }

    public static List<Object[]> getVentas(String fecInicio, String fecFinal) {
        List<Object[]> objectList = new ArrayList<>();
        String sql = "SELECT v.IdVentas,v.FechaVentas,v.NumeroSerie,v.Monto,e.Nombres,c.Nombres\n"
                + "FROM ventas v INNER JOIN empleado e\n"
                + "ON V.IdEmpleado=E.IdEmpleado INNER JOIN cliente c \n"
                + "ON V.IdCliente=c.IdCliente\n"
                + "WHERE v.FechaVentas BETWEEN ? AND ?";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecInicio);
            ps.setString(2, fecFinal);
            ResultSet rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador = contador + 1;
                Object object[] = new Object[7];
                object[0] = contador;
                object[1] = rs.getString("v.FechaVentas");
                object[2] = rs.getString("v.NumeroSerie");
                object[3] = DFORMAT.format(rs.getDouble("v.Monto"));
                object[4] = rs.getString("e.Nombres");
                object[5] = rs.getString("c.Nombres");
                //object[6] = rs.getInt("v.IdVentas");
                objectList.add(object);
            }
        } catch (SQLException e) {
            System.out.println("Error al Obtener el detalle de venta :" + e);
        }
        return objectList;
    }

    public String NroSerieVentas() {
        String serie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return serie;
    }

    public String IdVentas() {
        String idv = "";
        String sql = "select max(IdVentas) from ventas";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
        int r = 0;
        String sql = "insert into Ventas(IdCliente, IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado)values(?,?,?,?,?,?)";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }

        return r;
    }

    public int GuardarDetalleVentas(DetalleVentas dv) {
        int r = 0;
        String sql = "insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try {
            Connection con = Conexion.ConectarDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreVenta());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return r;
    }
}
