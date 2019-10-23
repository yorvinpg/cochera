package com.example.cocheraadmin;

public class admin {

    String nombre;
    String apellido;
    String correo;
    String contraseña;
    //Spinner tipo;//
    long createdAt;

    public admin(String nombre, String apellido, String correo, String contraseña, long createdAt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.createdAt = createdAt;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public String getCorreo()
    {
        return correo;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public long getCreatedAt()
    {
        return createdAt;
    }
}
