package batchpoc.dao;

import batchpoc.model.AjusteImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class WriterDaoImpl implements WriterDao{
    @Autowired
    private EntityManager entityManager;

    public void saveAjuste(AjusteImpl ajuste){
        Query query = this.entityManager.createNativeQuery(
                "insert into OPE_AJUSTE " +
                        "(DELTA_ENERGIA, DELTA_VOLUMEN, ENERGIA, FECHA, FUENTE, OBSERVACIONES, PODER_CALORIFICO, TIPO, OPE_VALOR_DIA_ID, VOLUMEN, " +
                        "CREATED_BY, DATE_CREATED, DATE_MODIFIED, MODIFIED_BY, FISCAL_ESTIMADO, OPE_AJUSTE_ID) " +
                        "values " +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?)")
                .setParameter(0, ajuste.getDeltaEnergia())
                .setParameter(1, ajuste.getDeltaVolumen())
                .setParameter(2, ajuste.getEnergia())
                .setParameter(3, ajuste.getFecha())
                .setParameter(4, ajuste.getFuente())
                .setParameter(5, ajuste.getObservaciones())
                .setParameter(6, ajuste.getPoder_calorifico())
                .setParameter(7, ajuste.getTipo())
                .setParameter(8, ajuste.getTransaccionDTO())
                .setParameter(9, ajuste.getVolumen())
                .setParameter(10, null)
                .setParameter(11, null)
                .setParameter(12, null)
                .setParameter(13, null)
                .setParameter(14, ajuste.getFiscalEstimado())
                .setParameter(15, null);
        query.executeUpdate();
    }
}
