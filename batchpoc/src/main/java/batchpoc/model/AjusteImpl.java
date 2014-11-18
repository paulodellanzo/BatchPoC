package batchpoc.model;

import java.util.Date;

public class AjusteImpl {
    Long id;
    Double deltaEnergia;
    Double deltaVolumen;
    Double energia;
    Date fecha;
    String fuente;
    String observaciones;
    Double poder_calorifico;
    String tipo;
    Long transaccionDTO;
    Double volumen;
    String createdBy;
    Date dateCreated;
    Date dateModified;
    String modifiedBy;
    String fiscalEstimado;

    public AjusteImpl() {
    }

    public AjusteImpl(Long id, Double deltaEnergia, Double deltaVolumen, Double energia, Date fecha, String fuente, String observaciones, Double poder_calorifico, String tipo, Long transaccionDTO, Double volumen, String createdBy, Date dateCreated, Date dateModified, String modifiedBy, String fiscalEstimado) {
        this.id = id;
        this.deltaEnergia = deltaEnergia;
        this.deltaVolumen = deltaVolumen;
        this.energia = energia;
        this.fecha = fecha;
        this.fuente = fuente;
        this.observaciones = observaciones;
        this.poder_calorifico = poder_calorifico;
        this.tipo = tipo;
        this.transaccionDTO = transaccionDTO;
        this.volumen = volumen;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
        this.fiscalEstimado = fiscalEstimado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDeltaEnergia() {
        return deltaEnergia;
    }

    public void setDeltaEnergia(Double deltaEnergia) {
        this.deltaEnergia = deltaEnergia;
    }

    public Double getDeltaVolumen() {
        return deltaVolumen;
    }

    public void setDeltaVolumen(Double deltaVolumen) {
        this.deltaVolumen = deltaVolumen;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getPoder_calorifico() {
        return poder_calorifico;
    }

    public void setPoder_calorifico(Double poder_calorifico) {
        this.poder_calorifico = poder_calorifico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getTransaccionDTO() {
        return transaccionDTO;
    }

    public void setTransaccionDTO(Long transaccionDTO) {
        this.transaccionDTO = transaccionDTO;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getFiscalEstimado() {
        return fiscalEstimado;
    }

    public void setFiscalEstimado(String fiscalEstimado) {
        this.fiscalEstimado = fiscalEstimado;
    }
}
