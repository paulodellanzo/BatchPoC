package batchpoc.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CompleteDaoImpl implements CompleteDao {
    @Autowired
    private EntityManager entityManager;
}
