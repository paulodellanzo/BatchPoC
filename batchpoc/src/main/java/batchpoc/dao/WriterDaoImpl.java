package batchpoc.dao;

import batchpoc.model.AjusteImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;

public class WriterDaoImpl implements WriterDao{
    @Autowired
    private EntityManager entityManager;

    public void saveAjuste(AjusteImpl ajuste){
        /*Query query = this.entityManager.createNativeQuery(
                "insert into OPE_AJUSTE " +
                        "(DELTA_ENERGIA, DELTA_VOLUMEN, ENERGIA, FECHA, FUENTE, OBSERVACIONES, PODER_CALORIFICO, TIPO, OPE_VALOR_DIA_ID, VOLUMEN, " +
                        "CREATED_BY, DATE_CREATED, DATE_MODIFIED, MODIFIED_BY, FISCAL_ESTIMADO, OPE_AJUSTE_ID) " +
                        "values " +
                        "(:deltaEnergia, :deltaVolumen, :energia, :fecha, :fuente, :observaciones, :poderCalorifico, :tipo, :opeValorDiaId, :volumen, :createdBy, :dateCreated, :dateModified, :modifiedBy, :fiscalEstimado, :opeAjusteId)")
                .setParameter("deltaEnergia", null)
                .setParameter("deltaVolumen", null)
                .setParameter("energia", null)
                .setParameter("fecha", null)
                .setParameter("fuente", null)
                .setParameter("observaciones", null)
                .setParameter("poderCalorifico", null)
                .setParameter("tipo", null)
                .setParameter("opeValorDiaId", 4003552)
                .setParameter("volumen", null)
                .setParameter("createdBy", null)
                .setParameter("dateCreated", null)
                .setParameter("dateModified", null)
                .setParameter("modifiedBy", null)
                .setParameter("fiscalEstimado", null)
                .setParameter("opeAjusteId", null);
        //(0.0, null, 1254018.0, TO_DATE('2011-08-02','yyyy-MM-dd'), 'INTERFAZ', null, null, 'FIS', 4003552, null, null,null,null,null, 'N', null)
        query.executeUpdate();
*/

        String q = "insert into OPE_AJUSTE\n" +
                "        (DELTA_ENERGIA, DELTA_VOLUMEN, ENERGIA, FECHA, FUENTE, OBSERVACIONES, PODER_CALORIFICO, TIPO, OPE_VALOR_DIA_ID, VOLUMEN, CREATED_BY, DATE_CREATED, DATE_MODIFIED, MODIFIED_BY, FISCAL_ESTIMADO, OPE_AJUSTE_ID) \n" +
                "    values\n" +
                "        ("++", null, 1254018.0, TO_DATE('2011-08-02','yyyy-MM-dd'), 'INTERFAZ', null, null, 'FIS', 4003552, null, null,null,null,null, 'N', null)\n" +
                "\n";
        Query query = this.entityManager.createNativeQuery(q);
        query.executeUpdate();

    }

}
