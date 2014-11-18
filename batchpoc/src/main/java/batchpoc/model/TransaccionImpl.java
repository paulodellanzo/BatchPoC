package batchpoc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class TransaccionImpl 
{
	@Id
    private Long                  id;
	
//	@Column(name="TRANSAC_MARCO_ID")
//    @ManyToOne
//	private TransaccionMarco      transaccionMarco;
	
    @Column(name="FECHA")
    private Date                  fecha;
    @Column(name="SOL_PRG")
    private Double                valSolicitado;
    @Column(name="ASIG_PRG")
    private Double                valAsignado;
    @Column(name="REST_PRG")
    private Double                valConfirmado;
    
//    private UnidadMedicion        unidadMedicionProgramacion;
    @Column(name="VOL_FIS")
    private Double                valVolumenReal;
    @Column(name="PC_FIS")
    private Double                valPcReal;
    @Column(name="ENER_FIS")
    private Double                valEnergiaReal;
    @Column(name="VOL_MED_PROPIA")
    private Double                valVolumenMedPropia;
    @Column(name="PC_MED_PROPIA")
    private Double                valPcMedPropia;
    @Column(name="ENER_MED_PROPIA")
    private Double                valEnergiaMedPropia;
    @Column(name="FUENTE_INFO")
    private String                fuenteInfo;
    @Column(name="FUENTE_INFO_PRG")
    private String                fuenteProgramacion;
    @Column(name="FUENTE_INFO_FIS")
    private String                fuenteReal;
    @Column(name="FUENTE_INFO_MED")
    private String                fuenteMedicionPropia;
    @Column(name="OBSERVACIONES")
    private String                observaciones;
    
    
    private Set                   ajustes          = new HashSet();
//    private UnidadEnergia         unidadEnergiaReal;
//    private UnidadVolumen         unidadVolumenReal;
//    private UnidadPoderCalorifico unidadPoderCalorificoReal;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="DATE_CREATED")
    private java.util.Date dateCreated;
    @Column(name="DATE_MODIFIED")
    private java.util.Date dateModified;
    @Column(name="MODIFIED_BY")
    private java.lang.String modifiedBy;
	
    @Column(name="FISCAL_ESTIMADO")
    private boolean               fiscalEstimado;
    private Double                volumenTransferido=null;
	private boolean 			  volumentransferidoInicializado=false;
}
