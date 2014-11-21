package batchpoc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InterfazCorridaImpl
{

    private Long               id;
    private Date               fechaFin;
    private Date               fecha;
	private String				duracion;
    private String             responsable;
    private String             estado;
    private String             errorLog;
    private Date               datosFechaDesde;
    private Date               datosFechaHasta;
    private String             lineasErroneas;
    private String             archivoFuente;
//    private InterfazArchivoDTO archivo;
    private Long archivo;

    public InterfazCorridaImpl()
    {
    }
    
    public Long getArchivo() {
		return archivo;
	}

	public void setArchivo(Long archivo) {
		this.archivo = archivo;
	}

	public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

//    public void update()
//    {
//    	super.update();
//        DAOFacade.getABMDAOFacade().flush();
//        DAOFacade.getInterfazDAOFacade().establecerAsciiFuenteInterfazCorrida(this);
//    }
//
//    public void insert()
//    {
//    	super.insert();
//        DAOFacade.getABMDAOFacade().flush();
//        DAOFacade.getInterfazDAOFacade().establecerAsciiFuenteInterfazCorrida(this);
//    }
    
    public Date getDatosFechaDesde()
    {
        return this.datosFechaDesde;
    }

    public void setDatosFechaDesde(Date datosFechaDesde)
    {
        this.datosFechaDesde = datosFechaDesde;
    }

    public Date getDatosFechaHasta()
    {
        return this.datosFechaHasta;
    }

    public void setDatosFechaHasta(Date datosFechaHasta)
    {
        this.datosFechaHasta = datosFechaHasta;
    }

    public String getErrorLog()
    {
        return this.errorLog;
    }

    public void setErrorLog(String errorLog)
    {
        this.errorLog = errorLog;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public Date getFecha()
    {
        return this.fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Date getFechaFin()
    {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    public String getResponsable()
    {
        return this.responsable;
    }

    public void setResponsable(String responsable)
    {
        this.responsable = responsable;
    }

    /**
     * @return el documento asociado a la corrida
     * @return Returns the archivo.
     */
//    public InterfazArchivoDTO getArchivo()
//    {
//        return this.archivo;
//    }

    /**
     * @param archivo
     *            The archivo to set.
     */
//    public void setArchivo(InterfazArchivoDTO archivo)
//    {
//        this.archivo = archivo;
//    }

//    public EstadosEjecucionProceso getEstadoEjecucion()
//    {
//        if (getEstado() != null)
//        {
//            if (getEstado().equals(EstadosEjecucionProceso.PROCESO_ABORTADO.getKey()))
//			{
//                return EstadosEjecucionProceso.PROCESO_ABORTADO;
//			}
//            if (getEstado().equals(EstadosEjecucionProceso.PROCESO_CON_ERRORES.getKey()))
//			{
//                return EstadosEjecucionProceso.PROCESO_CON_ERRORES;
//			}
//			if (getEstado().equals(EstadosEjecucionProceso.PROCESO_FINALIZADO_EXITOSAMENTE.getKey()))
//			{
//                return EstadosEjecucionProceso.PROCESO_FINALIZADO_EXITOSAMENTE;
//        }
//		}
//        return null;
//    }

    public EstadoInterfazCorrida getEstadoCorrida()
    {
        if (getEstado() != null)
        {
            return (EstadoInterfazCorrida) EstadoInterfazCorrida.ESTADO_FINALIZADO.fromKey(getEstado());
        }
        return null;
    }    
    
	public void setDuracion(String duracion)
	{
		this.duracion = duracion;
	}

	public String getDuracion()
	{
		String out = null;

		if (this.duracion != null)
		{
			out = this.duracion;
		}
		else if (this.getFecha() != null && this.getFechaFin() != null)
		{
			long tiempoFin = this.getFechaFin().getTime();
			long tiempoIni = this.getFecha().getTime();
			long diferencia = (tiempoFin - tiempoIni) - Calendar.getInstance().getTimeZone().getOffset(0);
			out = new java.text.SimpleDateFormat("HH:mm:ss").format(new Date(diferencia));
		}

		return out;
	}

	public String getFechaProcesada()
	{
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String res = formateador.format(this.getDatosFechaDesde());
		if (this.getDatosFechaHasta() != null && this.getDatosFechaDesde().compareTo(this.getDatosFechaHasta()) != 0)
		{
			res += " - " + formateador.format(this.getDatosFechaHasta());
		}
		return res;
		
	}
	
	public void setFechaProcesada(String fecha){}

	public void addLineaError(String error, String breakLine)
	{
//		if (this.lineasErroneas == null)
//		{
//			try
//			{
//				Document xmlControl = XmlUtil.StringToXml(this.getArchivo().getXmlControl());
//				String aux = xmlControl.getElementsByTagName(InterfazFacadeCommonImpl.TAG_INICIAL).item(0).getAttributes().getNamedItem(InterfazFacadeCommonImpl.ATTR_COMENZAR).getNodeValue();
//				int fila = ((aux != null) && !aux.equals("")) ? Integer.parseInt(aux) : 1;
//				this.lineasErroneas = "";
//				for (int i = 0; i < (fila-1); i++)
//				{
//					this.lineasErroneas += breakLine;
//				}
//			}
//			catch (Exception e)
//			{
//				this.lineasErroneas = breakLine;
//			}
//		}
		this.lineasErroneas += error + breakLine;
	}

	public String getLineasErroneas()
	{
		return this.lineasErroneas;
	}

	public void setLineasErroneas(String lineasErroneas)
	{
		this.lineasErroneas = lineasErroneas;
	}

	public String getArchivoFuente()
	{
		return this.archivoFuente;
	}

	public void setArchivoFuente(String archivoFuente)
	{
		this.archivoFuente = archivoFuente;
	}
	
}

