/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author xutto
 */
public class setGet_operaciones {

    private Integer id_op;  
    private String id_producto;
    private String cuenta_local;
    private String cuenta_externa;
    private String fecha;
    private String hora;
    private Integer importe;
    private Integer saldo;

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getId_op() {
        return id_op;
    }

    public void setId_op(Integer id_op) {
        this.id_op = id_op;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCuenta_local() {
        return cuenta_local;
    }

    public void setCuenta_local(String cuenta_local) {
        this.cuenta_local = cuenta_local;
    }

    public String getCuenta_externa() {
        return cuenta_externa;
    }

    public void setCuenta_externa(String cuenta_externa) {
        this.cuenta_externa = cuenta_externa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

}
