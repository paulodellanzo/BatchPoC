package batchpoc.model;

import java.util.Date;

public class TransaccionMarcoImpl {
	
	private Long id;
//	private Referencia referencia;
//	private PuntoMedicion puntoMedicion;
	private String recepcionEntrega;
//	private Instalacion instalacion;
//	private Referencia referenciaTransporte;
	private String alias;
	private String nombre;
	private Integer orden;
	private String estadoActividad;
	private String reglaNominadores;
	private String reglaProgramacionFinal;
	private String cExtension1;
	private String cExtension2;
	private String cExtension3;
	private String cExtension4;
	private String cExtension5;
	private Integer nExtension1;
	private Integer nExtension2;
	private Integer nExtension3;
	private Integer nExtension4;
	private Integer nExtension5;
	private Date dExtension1;
	private Date dExtension2;
	private Date dExtension3;
	private Date dExtension4;
	private Date dExtension5;
	private String observaciones;
	private String clase;
//	private Ruta ruta;
//	private ReferenciaPropia referenciaPropia;
//	private ReferenciaExterna referenciaExterna;
	private String autoSolicitado;
	private String autoAsignado;
	private String autoRestringido;
	private String autoFiscal;
//	private Set transaccionesFuente=new HashSet();	
//	private Cuenca cuenca;
//  private Set prioridadesTte=new HashSet();
//  private Set nominadores = new HashSet();
//	private Set datosVigenciaEstadoImportacion;
//	private Set datosVigenciaEstadoInterfacesTransportistas;	
	private String claseEnum;     
	private String recepcionEntregaEnum;
	
	public TransaccionMarcoImpl()
	{
	}
	
	public TransaccionMarcoImpl(Long id, String recepcionEntrega, String alias,
			String nombre, Integer orden, String estadoActividad,
			String reglaNominadores, String reglaProgramacionFinal,
			String cExtension1, String cExtension2, String cExtension3,
			String cExtension4, String cExtension5, Integer nExtension1,
			Integer nExtension2, Integer nExtension3, Integer nExtension4,
			Integer nExtension5, Date dExtension1, Date dExtension2,
			Date dExtension3, Date dExtension4, Date dExtension5,
			String observaciones, String clase, String autoSolicitado,
			String autoAsignado, String autoRestringido, String autoFiscal,
			String claseEnum, String recepcionEntregaEnum) {
		super();
		this.id = id;
		this.recepcionEntrega = recepcionEntrega;
		this.alias = alias;
		this.nombre = nombre;
		this.orden = orden;
		this.estadoActividad = estadoActividad;
		this.reglaNominadores = reglaNominadores;
		this.reglaProgramacionFinal = reglaProgramacionFinal;
		this.cExtension1 = cExtension1;
		this.cExtension2 = cExtension2;
		this.cExtension3 = cExtension3;
		this.cExtension4 = cExtension4;
		this.cExtension5 = cExtension5;
		this.nExtension1 = nExtension1;
		this.nExtension2 = nExtension2;
		this.nExtension3 = nExtension3;
		this.nExtension4 = nExtension4;
		this.nExtension5 = nExtension5;
		this.dExtension1 = dExtension1;
		this.dExtension2 = dExtension2;
		this.dExtension3 = dExtension3;
		this.dExtension4 = dExtension4;
		this.dExtension5 = dExtension5;
		this.observaciones = observaciones;
		this.clase = clase;
		this.autoSolicitado = autoSolicitado;
		this.autoAsignado = autoAsignado;
		this.autoRestringido = autoRestringido;
		this.autoFiscal = autoFiscal;
		this.claseEnum = claseEnum;
		this.recepcionEntregaEnum = recepcionEntregaEnum;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecepcionEntrega() {
		return recepcionEntrega;
	}
	public void setRecepcionEntrega(String recepcionEntrega) {
		this.recepcionEntrega = recepcionEntrega;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getEstadoActividad() {
		return estadoActividad;
	}
	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
	}
	public String getReglaNominadores() {
		return reglaNominadores;
	}
	public void setReglaNominadores(String reglaNominadores) {
		this.reglaNominadores = reglaNominadores;
	}
	public String getReglaProgramacionFinal() {
		return reglaProgramacionFinal;
	}
	public void setReglaProgramacionFinal(String reglaProgramacionFinal) {
		this.reglaProgramacionFinal = reglaProgramacionFinal;
	}
	public String getCExtension1() {
		return cExtension1;
	}
	public void setCExtension1(String cExtension1) {
		this.cExtension1 = cExtension1;
	}
	public String getCExtension2() {
		return cExtension2;
	}
	public void setCExtension2(String cExtension2) {
		this.cExtension2 = cExtension2;
	}
	public String getCExtension3() {
		return cExtension3;
	}
	public void setCExtension3(String cExtension3) {
		this.cExtension3 = cExtension3;
	}
	public String getCExtension4() {
		return cExtension4;
	}
	public void setCExtension4(String cExtension4) {
		this.cExtension4 = cExtension4;
	}
	public String getCExtension5() {
		return cExtension5;
	}
	public void setCExtension5(String cExtension5) {
		this.cExtension5 = cExtension5;
	}
	public Integer getNExtension1() {
		return nExtension1;
	}
	public void setNExtension1(Integer nExtension1) {
		this.nExtension1 = nExtension1;
	}
	public Integer getNExtension2() {
		return nExtension2;
	}
	public void setNExtension2(Integer nExtension2) {
		this.nExtension2 = nExtension2;
	}
	public Integer getNExtension3() {
		return nExtension3;
	}
	public void setNExtension3(Integer nExtension3) {
		this.nExtension3 = nExtension3;
	}
	public Integer getNExtension4() {
		return nExtension4;
	}
	public void setNExtension4(Integer nExtension4) {
		this.nExtension4 = nExtension4;
	}
	public Integer getNExtension5() {
		return nExtension5;
	}
	public void setNExtension5(Integer nExtension5) {
		this.nExtension5 = nExtension5;
	}
	public Date getDExtension1() {
		return dExtension1;
	}
	public void setDExtension1(Date dExtension1) {
		this.dExtension1 = dExtension1;
	}
	public Date getDExtension2() {
		return dExtension2;
	}
	public void setDExtension2(Date dExtension2) {
		this.dExtension2 = dExtension2;
	}
	public Date getDExtension3() {
		return dExtension3;
	}
	public void setDExtension3(Date dExtension3) {
		this.dExtension3 = dExtension3;
	}
	public Date getDExtension4() {
		return dExtension4;
	}
	public void setDExtension4(Date dExtension4) {
		this.dExtension4 = dExtension4;
	}
	public Date getDExtension5() {
		return dExtension5;
	}
	public void setDExtension5(Date dExtension5) {
		this.dExtension5 = dExtension5;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getAutoSolicitado() {
		return autoSolicitado;
	}
	public void setAutoSolicitado(String autoSolicitado) {
		this.autoSolicitado = autoSolicitado;
	}
	public String getAutoAsignado() {
		return autoAsignado;
	}
	public void setAutoAsignado(String autoAsignado) {
		this.autoAsignado = autoAsignado;
	}
	public String getAutoRestringido() {
		return autoRestringido;
	}
	public void setAutoRestringido(String autoRestringido) {
		this.autoRestringido = autoRestringido;
	}
	public String getAutoFiscal() {
		return autoFiscal;
	}
	public void setAutoFiscal(String autoFiscal) {
		this.autoFiscal = autoFiscal;
	}
	public String getClaseEnum() {
		return claseEnum;
	}
	public void setClaseEnum(String claseEnum) {
		this.claseEnum = claseEnum;
	}
	public String getRecepcionEntregaEnum() {
		return recepcionEntregaEnum;
	}
	public void setRecepcionEntregaEnum(String recepcionEntregaEnum) {
		this.recepcionEntregaEnum = recepcionEntregaEnum;
	}

	
	
}
