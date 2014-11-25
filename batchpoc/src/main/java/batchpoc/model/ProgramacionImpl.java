package batchpoc.model;

import java.util.Date;

public class ProgramacionImpl {

	private Long id;
	// private Localizacion localizacion;
	private Long localizacion;
	// private TransaccionMarco transaccionMarco;
	private Long transaccionMarco;
	private String tipo;
	private Double cantidadVolumen;
	private Double cantidadPoderCalorifico;
	private Double cantidadEnergia;
	private String observaciones;
	private Integer corte;
	private String fuente;
	private Date fecha;
	private Date fechaPublica;
	private Integer prioridad;

	public ProgramacionImpl() {
	}

	public ProgramacionImpl(Long id, Long localizacion, Long transaccionMarco,
			String tipo, Double cantidadVolumen,
			Double cantidadPoderCalorifico, Double cantidadEnergia,
			String observaciones, Integer corte, String fuente, Date fecha,
			Date fechaPublica, Integer prioridad) {
		super();
		this.id = id;
		this.localizacion = localizacion;
		this.transaccionMarco = transaccionMarco;
		this.tipo = tipo;
		this.cantidadVolumen = cantidadVolumen;
		this.cantidadPoderCalorifico = cantidadPoderCalorifico;
		this.cantidadEnergia = cantidadEnergia;
		this.observaciones = observaciones;
		this.corte = corte;
		this.fuente = fuente;
		this.fecha = fecha;
		this.fechaPublica = fechaPublica;
		this.prioridad = prioridad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Long localizacion) {
		this.localizacion = localizacion;
	}

	public Long getTransaccionMarco() {
		return transaccionMarco;
	}

	public void setTransaccionMarco(Long transaccionMarco) {
		this.transaccionMarco = transaccionMarco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getCantidadVolumen() {
		return cantidadVolumen;
	}

	public void setCantidadVolumen(Double cantidadVolumen) {
		this.cantidadVolumen = cantidadVolumen;
	}

	public Double getCantidadPoderCalorifico() {
		return cantidadPoderCalorifico;
	}

	public void setCantidadPoderCalorifico(Double cantidadPoderCalorifico) {
		this.cantidadPoderCalorifico = cantidadPoderCalorifico;
	}

	public Double getCantidadEnergia() {
		return cantidadEnergia;
	}

	public void setCantidadEnergia(Double cantidadEnergia) {
		this.cantidadEnergia = cantidadEnergia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getCorte() {
		return corte;
	}

	public void setCorte(Integer corte) {
		this.corte = corte;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaPublica() {
		return fechaPublica;
	}

	public void setFechaPublica(Date fechaPublica) {
		this.fechaPublica = fechaPublica;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

}
