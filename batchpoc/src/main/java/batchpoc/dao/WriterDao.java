package batchpoc.dao;

import batchpoc.model.AjusteImpl;
import batchpoc.model.InterfazCorridaImpl;
import batchpoc.model.ProgramacionImpl;
import batchpoc.model.TransaccionImpl;

/**
 * Created by pbergonzi on 13/11/14.
 */
public interface WriterDao {
    public void saveAjuste(AjusteImpl ajuste);

	public void saveCorrida(InterfazCorridaImpl corrida);

	public void saveTransaccionImpl(TransaccionImpl transaccion);

	public void saveProgramacion(ProgramacionImpl programacion);
}
