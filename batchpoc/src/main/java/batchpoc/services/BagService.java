package batchpoc.services;

import batchpoc.model.ETransaction;

import java.util.*;

public class BagService {
    private Map<String,ETransaction> map = new HashMap<>();

    public void add(ETransaction eTransaction){
        map.put(Integer.toString(eTransaction.getItemCSV().hashCode()),null);
    }

    public ETransaction getETransaction(String key){
        return map.get(key);
    }

    public List<ETransaction> getAsList(){
       return new ArrayList<>(map.values());
    }

    public boolean contains(ETransaction eTransaction){
        return map.containsKey(Integer.toString(eTransaction.getItemCSV().hashCode()));
    }
}
