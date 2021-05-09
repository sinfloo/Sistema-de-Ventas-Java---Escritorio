package utils;

import java.util.List;

public class ImprimirObject {

    private String nroSerie;
    private String fecha;
    private String nomCliente;
    private String dirCliente;
    private String docClient;
    private List<Object[]> detalle;
    private double subTotal;
    private double igv;
    private double totalPagar;
    private String user;
    private String userName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getDirCliente() {
        return dirCliente;
    }

    public void setDirCliente(String dirCliente) {
        this.dirCliente = dirCliente;
    }

    public String getDocClient() {
        return docClient;
    }

    public void setDocClient(String docClient) {
        this.docClient = docClient;
    }

    public List<Object[]> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Object[]> detalle) {
        this.detalle = detalle;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    
}
