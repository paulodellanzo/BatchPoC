package batchpoc.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CompleteDao {
	List findTransaccion(Date fecha, String tipo, String punto,
			String referencia, String refPropia, String refExterna,
			String ctoTte, boolean activa);

	Long findTransaccionDiaria(Long tmId, Date fecha);

	List<BigDecimal> findLocalizacionId(Long transId, String solicitante);
}
