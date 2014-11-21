package batchpoc.dao;

import batchpoc.model.AjusteImpl;
import batchpoc.model.InterfazCorridaImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriterDaoImpl implements WriterDao{
    @Autowired
    private EntityManager entityManager;

    public void saveCorrida(InterfazCorridaImpl corrida)
    {
    	Session session = entityManager.unwrap(Session.class);
    	session.save(corrida);
    }
    
    public void saveAjuste(AjusteImpl ajuste){
    	Session session = entityManager.unwrap(Session.class);
    	session.save(ajuste);
    }

}
