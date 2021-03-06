package ENTITY;
// Generated 11-12-2016 14:12:43 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Solicitud generated by hbm2java
 */
@Entity
@Table(name="solicitud"
    ,catalog="dejmobile"
)
public class Solicitud  implements java.io.Serializable {


     private Integer idSolicitud;
     private Cliente cliente;
     private CuotaNavegacion cuotaNavegacion;
     private Minuto minuto;
     private String entrega;
     private int total;
     private Date fechaSolicitud;

    public Solicitud() {
    }

	
    public Solicitud(CuotaNavegacion cuotaNavegacion, Minuto minuto, String entrega, int total, Date fechaSolicitud) {
        this.cuotaNavegacion = cuotaNavegacion;
        this.minuto = minuto;
        this.entrega = entrega;
        this.total = total;
        this.fechaSolicitud = fechaSolicitud;
    }
    public Solicitud(Cliente cliente, CuotaNavegacion cuotaNavegacion, Minuto minuto, String entrega, int total, Date fechaSolicitud) {
       this.cliente = cliente;
       this.cuotaNavegacion = cuotaNavegacion;
       this.minuto = minuto;
       this.entrega = entrega;
       this.total = total;
       this.fechaSolicitud = fechaSolicitud;
    }
    //public Solicitud(String giga, String minuto, String domicilio, int telefono, String comuna, Date fecha, int total) {
     //   this.cuotaNavegacion = giga;
   // }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idSolicitud", unique=true, nullable=false)
    public Integer getIdSolicitud() {
        return this.idSolicitud;
    }
    
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="rutCliente")
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCuota", nullable=false)
    public CuotaNavegacion getCuotaNavegacion() {
        return this.cuotaNavegacion;
    }
    
    public void setCuotaNavegacion(CuotaNavegacion cuotaNavegacion) {
        this.cuotaNavegacion = cuotaNavegacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMinuto", nullable=false)
    public Minuto getMinuto() {
        return this.minuto;
    }
    
    public void setMinuto(Minuto minuto) {
        this.minuto = minuto;
    }

    
    @Column(name="entrega", nullable=false, length=50)
    public String getEntrega() {
        return this.entrega;
    }
    
    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    
    @Column(name="total", nullable=false)
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaSolicitud", nullable=false, length=19)
    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }
    
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }




}


