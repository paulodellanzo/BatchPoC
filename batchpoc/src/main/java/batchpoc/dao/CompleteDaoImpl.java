package batchpoc.dao;

import java.util.Date;
import java.util.List;

public class CompleteDaoImpl implements CompleteDao {
	
	// Constantes de transporte
	public static final String	TTE_TIPO_TRANSPORTE				= "TRANSPORTE";
	public static final String	TTE_TIPO_TRANSPORTE_TERCEROS	= "TRANSPORTE TERCEROS";
	public static final String	TTE_TIPO_USO_CAPACIDAD			= "USO CAPACIDAD";
	public static final String	TTE_TIPO_DISTRIBUCION			= "DISTRIBUCION";
	public static final String	TTE_TIPO_SERVICIOS				= "SERVICIOS";
	
	private StringBuffer getQueryTransaccionMarcoSQL(String clase)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TM.TRANSAC_MARCO_ID ");
		sql.append("          FROM OPE_TM_TRANSAC_MARCO   TM ");
		sql.append("        ,      REF_REFERENCIA         RR ");
		sql.append("        ,      REF_REFERENCIA_PROPIA  RP ");
		sql.append("        ,      REF_REFERENCIA_EXTERNA RE ");
		sql.append("        ,      CON_CONTRATO           CC ");
		sql.append("        ,      CF_PUNTO_MEDICION      PM");
		sql.append("        ,     (SELECT R.REF_REFERENCIA_ID ");
		sql.append("               ,      R.ALIAS ");
		sql.append("               ,      C.FECHA_EFECTIVA ");
		sql.append("               ,      C.FECHA_CANCELACION ");
		sql.append("               ,      C.FECHA_VENCIMIENTO ");
		sql.append("                 FROM REF_REFERENCIA R ");
		sql.append("               ,      CON_CONTRATO   C ");
		sql.append("                WHERE TIPO IN (" + this.getCtoTteFilter() + ") ");
		sql.append("                  AND R.REF_REFERENCIA_ID = C.REFERENCIA_ID(+)) CT ");
		sql.append("         WHERE TM.OPE_REFERENCIA_ID    = RR.REF_REFERENCIA_ID ");
		sql.append("           AND TM.CF_PUNTO_MEDICION_ID = PM.CF_PUNTO_MEDICION_ID ");
		sql.append("           AND TM.CON_TRANSPORTE_ID    = CT.REF_REFERENCIA_ID(+) ");
		sql.append("           AND TM.REF_PROPIA_ID        = RP.REFERENCIA_PROPIA_ID(+) ");
		sql.append("           AND TM.REF_EXTERNA_ID       = RE.REFERENCIA_EXTERNA_ID(+) ");
		sql.append("           AND TM.OPE_REFERENCIA_ID    = CC.REFERENCIA_ID(+) ");
		if (clase != null)
		{
			sql.append("       AND TM.CLASE                = '" + clase + "' ");
		}
		// sql.append("       )");
		return sql;
	}
	
	private String getCtoTteFilter()
	{
		return "'" + TTE_TIPO_TRANSPORTE + "','" + TTE_TIPO_TRANSPORTE_TERCEROS + "','" + TTE_TIPO_USO_CAPACIDAD + "','" + TTE_TIPO_DISTRIBUCION + "','" + TTE_TIPO_SERVICIOS + "'";
	}
	
	public List findTransaccion(Date fecha, String tipo, String punto, String referencia, String refPropia, String refExterna, String ctoTte, boolean activa)
	{
		try
		{
			StringBuffer sql = this.getQueryTransaccionMarcoSQL(null);
			// Wheres explicitos
			sql.append("           AND TM.RECEP_ENTREGA    = :tipo ");
			sql.append("           AND TRIM(UPPER(PM.ALIAS))    = :punto ");
			sql.append("           AND TRIM(UPPER(RR.ALIAS))    = :referencia ");
			if (ctoTte != null) sql.append("           AND TRIM(UPPER(CT.ALIAS))    = :ctoTte ");
			else sql.append("           AND TRIM(UPPER(CT.ALIAS))    IS NULL ");
			if (refPropia != null) sql.append("           AND TRIM(UPPER(RP.ALIAS))    = :refPropia ");
			else sql.append("           AND TRIM(UPPER(RP.ALIAS))    IS NULL ");
			if (refExterna != null) sql.append("           AND TRIM(UPPER(RE.ALIAS))    = :refExterna ");
			else sql.append("           AND TRIM(UPPER(RE.ALIAS))    IS NULL ");
			if (activa) sql.append("           AND TM.ESTADO_ACTIVIDAD    = :activado ");
//			sql.append("       )");

			Query query = this.getSession().createSQLQuery(sql.toString());
			query.setString("tipo", tipo.toUpperCase());
			query.setString("punto", punto.toUpperCase());
			query.setString("referencia", referencia.toUpperCase());
			if (ctoTte != null) query.setString("ctoTte", ctoTte.toUpperCase());
			if (refPropia != null) query.setString("refPropia", refPropia.toUpperCase());
			if (refExterna != null) query.setString("refExterna", refExterna.toUpperCase());
			if (activa) query.setString("activado", "A");
			List results = query.list();
			return results;
		}
		catch (Exception he)
		{
			throw he;
		}
	}
	
}
