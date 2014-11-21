package batchpoc.model;

public class EstadoInterfazCorrida extends Enum
{

	private static final long	serialVersionUID	= -1553413469421671432L;
	static public final EstadoInterfazCorrida	ESTADO_ERROR_CHEQUEAR		= new EstadoInterfazCorrida("C", "interfaz.corrida.estado.errorChequear");
	static public final EstadoInterfazCorrida	ESTADO_ERROR_CARGAR	= new EstadoInterfazCorrida("L", "interfaz.corrida.estado.errorCargar");
	static public final EstadoInterfazCorrida	ESTADO_ERROR_GRABAR		= new EstadoInterfazCorrida("S", "interfaz.corrida.estado.errorGrabar");
	static public final EstadoInterfazCorrida	ESTADO_FINALIZADO	= new EstadoInterfazCorrida("F", "interfaz.corrida.estado.finalizado");
	static public final EstadoInterfazCorrida	ESTADO_FINALIZADO_ERRORES		= new EstadoInterfazCorrida("E", "interfaz.corrida.estado.finalizadoConErrores");
	static public final EstadoInterfazCorrida	ESTADO_ABORTADO		= new EstadoInterfazCorrida("A", "interfaz.corrida.estado.abortado");

	public EstadoInterfazCorrida()
    {
        super();
    }

    public EstadoInterfazCorrida(String key, String description)
    {
        super(key, description);
    }

	/**
	 * @return arreglo con los valores de la enumeracion
	 */
	public Enum[] getEnumValues()
	{
		return new Enum[] { ESTADO_ERROR_CARGAR, ESTADO_ERROR_CHEQUEAR, ESTADO_ERROR_GRABAR, ESTADO_FINALIZADO, ESTADO_FINALIZADO_ERRORES,ESTADO_ABORTADO};
	}

}
