package com.example.cocheraadmin;

public class cochera {

    private String local;
    private int ruc;
    private String direccion;
    private int sitios;
    private double tarifa;
    private int  localizacion;

    public cochera()
    {
    }

    public cochera(String local, int ruc, String direccion, int sitios, double tarifa, int localizacion)
    {
        this.local = local;
        this.ruc = ruc;
        this.direccion = direccion;
        this.sitios = sitios;
        this.tarifa = tarifa;
        this.localizacion = localizacion;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSitios() {
        return sitios;
    }

    public void setSitios(int sitios) {
        this.sitios = sitios;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public int getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(int localizacion) {
        this.localizacion = localizacion;
    }
}
