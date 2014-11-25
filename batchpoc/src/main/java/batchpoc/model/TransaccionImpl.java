package batchpoc.model;

import java.util.Date;

public class TransaccionImpl {

	private Long id;

	// private TransaccionMarco transaccionMarco;
	private Long transaccionMarco;

	private Date fecha;
	private Double valSolicitado;
	private Double valAsignado;
	private Double valConfirmado;

	// private UnidadMedicion unidadMedicionProgramacion;
	private Long unidadMedicionProgramacion;

	private Double valVolumenReal;
	private Double valPcReal;
	private Double valEnergiaReal;
	private Double valVolumenMedPropia;
	private Double valPcMedPropia;
	private Double valEnergiaMedPropia;
	private String fuenteInfo;
	private String fuenteProgramacion;
	private String fuenteReal;
	private String fuenteMedicionPropia;
	private String observaciones;

	// private Set ajustes = new HashSet();
	// private UnidadEnergia unidadEnergiaReal;
	// private UnidadVolumen unidadVolumenReal;
	// private UnidadPoderCalorifico unidadPoderCalorificoReal;
	private Long unidadEnergiaReal;
	private Long unidadVolumenReal;
	private Long unidadPoderCalorificoReal;

	private String fiscalEstimado;
	private Double volumenTransferido = null;

	// private boolean volumentransferidoInicializado=false;

	public TransaccionImpl() {

	}

	public TransaccionImpl(Long id, Long transaccionMarco, Date fecha,
			Double valSolicitado, Double valAsignado, Double valConfirmado,
			Long unidadMedicionProgramacion, Double valVolumenReal,
			Double valPcReal, Double valEnergiaReal,
			Double valVolumenMedPropia, Double valPcMedPropia,
			Double valEnergiaMedPropia, String fuenteInfo,
			String fuenteProgramacion, String fuenteReal,
			String fuenteMedicionPropia, String observaciones,
			Long unidadEnergiaReal, Long unidadVolumenReal,
			Long unidadPoderCalorificoReal, String fiscalEstimado,
			Double volumenTransferido) {
		super();
		this.id = id;
		this.transaccionMarco = transaccionMarco;
		this.fecha = fecha;
		this.valSolicitado = valSolicitado;
		this.valAsignado = valAsignado;
		this.valConfirmado = valConfirmado;
		this.unidadMedicionProgramacion = unidadMedicionProgramacion;
		this.valVolumenReal = valVolumenReal;
		this.valPcReal = valPcReal;
		this.valEnergiaReal = valEnergiaReal;
		this.valVolumenMedPropia = valVolumenMedPropia;
		this.valPcMedPropia = valPcMedPropia;
		this.valEnergiaMedPropia = valEnergiaMedPropia;
		this.fuenteInfo = fuenteInfo;
		this.fuenteProgramacion = fuenteProgramacion;
		this.fuenteReal = fuenteReal;
		this.fuenteMedicionPropia = fuenteMedicionPropia;
		this.observaciones = observaciones;
		this.unidadEnergiaReal = unidadEnergiaReal;
		this.unidadVolumenReal = unidadVolumenReal;
		this.unidadPoderCalorificoReal = unidadPoderCalorificoReal;
		this.fiscalEstimado = fiscalEstimado;
		this.volumenTransferido = volumenTransferido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTransaccionMarco() {
		return transaccionMarco;
	}

	public void setTransaccionMarco(Long transaccionMarco) {
		this.transaccionMarco = transaccionMarco;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @hibernate.property column="SOL_PRG"
	 */
	public Double getValorSolicitado() {
		return this.valSolicitado;
	}

	/**
	 * @param solPrg
	 */
	public void setValorSolicitado(Double solPrg) {
		this.valSolicitado = solPrg;
	}

	/**
	 * @hibernate.property column="ASIG_PRG"
	 */
	public Double getValorAsignadoProductor() {
		return this.valAsignado;
	}

	/**
	 * @param asigPrg
	 */
	public void setValorAsignadoProductor(Double asigPrg) {
		this.valAsignado = asigPrg;
	}

	/**
	 * @hibernate.property column="REST_PRG"
	 */
	public Double getValorConfirmadoTransporte() {
		return this.valConfirmado;
	}

	/**
	 * @param valConfirmado
	 */
	public void setValorConfirmadoTransporte(Double valConfirmado) {
		this.valConfirmado = valConfirmado;
	}

	/**
	 * @hibernate.many-to-one column="CN_UNIDAD_MEDICION_PRG_ID" class=
	 *                        "ar.com.odea.esigas.model.jbo.configuracion.unidad.UnidadMedicionImpl"
	 */
	public Long getUnidadMedicionProgramacion() {
		return this.unidadMedicionProgramacion;
	}

	/**
	 * @param unidadMedicionProgramacion
	 */
	public void setUnidadMedicionProgramacion(
			Long unidadMedicionProgramacion) {
		this.unidadMedicionProgramacion = unidadMedicionProgramacion;
	}

	/**
	 * @hibernate.property column="ENER_FIS"
	 */
	public Double getValorEnergiaReal() {
		return this.valEnergiaReal;
	}

	/**
	 * @param energiaReal
	 */
	public void setValorEnergiaReal(Double energiaReal) {
		this.valEnergiaReal = energiaReal;
	}

	/**
	 * @hibernate.property column="VOL_FIS"
	 */
	public Double getValorVolumenReal() {
		return this.valVolumenReal;
	}

	/**
	 * @param volumenReal
	 */
	public void setValorVolumenReal(Double volumenReal) {
		this.valVolumenReal = volumenReal;
	}

	/**
	 * @hibernate.property column="PC_FIS"
	 */
	public Double getValorPCReal() {
		return this.valPcReal;
	}

	/**
	 * @param pcReal
	 */
	public void setValorPCReal(Double pcReal) {
		this.valPcReal = pcReal;
	}

	/**
	 * @hibernate.property column="ENER_MED_PROPIA"
	 */
	public Double getValorEnergiaMedicionPropia() {
		return this.valEnergiaMedPropia;
	}

	/**
	 * @param energiaMedPropia
	 */
	public void setValorEnergiaMedicionPropia(Double energiaMedPropia) {
		this.valEnergiaMedPropia = energiaMedPropia;
	}

	/**
	 * @hibernate.property column="VOL_MED_PROPIA"
	 */
	public Double getValorVolumenMedicionPropia() {
		return this.valVolumenMedPropia;
	}

	/**
	 * @param volumenMedPropia
	 */
	public void setValorVolumenMedicionPropia(Double volumenMedPropia) {
		this.valVolumenMedPropia = volumenMedPropia;
	}

	/**
	 * @hibernate.property column="PC_MED_PROPIA"
	 */
	public Double getValorPCMedicionPropia() {
		return this.valPcMedPropia;
	}

	/**
	 * @param pcMedPropia
	 */
	public void setValorPCMedicionPropia(Double pcMedPropia) {
		this.valPcMedPropia = pcMedPropia;
	}

	public String getFuenteInfo() {
		return fuenteInfo;
	}

	public void setFuenteInfo(String fuenteInfo) {
		this.fuenteInfo = fuenteInfo;
	}

	public String getFuenteProgramacion() {
		return fuenteProgramacion;
	}

	public void setFuenteProgramacion(String fuenteProgramacion) {
		this.fuenteProgramacion = fuenteProgramacion;
	}

	public String getFuenteReal() {
		return fuenteReal;
	}

	public void setFuenteReal(String fuenteReal) {
		this.fuenteReal = fuenteReal;
	}

	public String getFuenteMedicionPropia() {
		return fuenteMedicionPropia;
	}

	public void setFuenteMedicionPropia(String fuenteMedicionPropia) {
		this.fuenteMedicionPropia = fuenteMedicionPropia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getUnidadEnergiaReal() {
		return unidadEnergiaReal;
	}

	public void setUnidadEnergiaReal(Long unidadEnergiaReal) {
		this.unidadEnergiaReal = unidadEnergiaReal;
	}

	public Long getUnidadVolumenReal() {
		return unidadVolumenReal;
	}

	public void setUnidadVolumenReal(Long unidadVolumenReal) {
		this.unidadVolumenReal = unidadVolumenReal;
	}

	public Long getUnidadPoderCalorificoReal() {
		return unidadPoderCalorificoReal;
	}

	public void setUnidadPoderCalorificoReal(Long unidadPoderCalorificoReal) {
		this.unidadPoderCalorificoReal = unidadPoderCalorificoReal;
	}

	public String getFiscalEstimado() {
		return fiscalEstimado;
	}

	public void setFiscalEstimado(String fiscalEstimado) {
		this.fiscalEstimado = fiscalEstimado;
	}

	public Double getVolumenTransferido() {
		return volumenTransferido;
	}

	public void setVolumenTransferido(Double volumenTransferido) {
		this.volumenTransferido = volumenTransferido;
	}

}
