/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.clases;

/**
 *
 * @author Fallas
 */
public class Persona {
    private String Codigo;
    private String Provincia;
    private String Lugar;
    private String Distrito;

    public Persona(String Codigo, String Provincia, String Lugar, String Distrito) {
        this.Codigo = Codigo;
        this.Provincia = Provincia;
        this.Lugar = Lugar;
        this.Distrito = Distrito;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    @Override
    public String toString() {
        return "Persona{" + "Codigo=" + Codigo + ", Provincia=" + Provincia + ", Lugar=" + Lugar + ", Distrito=" + Distrito + '}';
    }

    
}
