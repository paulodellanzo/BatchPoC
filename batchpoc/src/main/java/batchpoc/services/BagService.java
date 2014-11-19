package batchpoc.services;

import batchpoc.model.AjusteImpl;
import batchpoc.model.ETransaction;

import java.util.*;

public class BagService {
    private Map<String,AjusteImpl> map = new HashMap<>();

    public void add(AjusteImpl ajuste){
        map.put(Integer.toString(ajuste.getItemCSV().hashCode()),null);
    }

    public List<AjusteImpl> getAsList(){
       return new ArrayList<>(map.values());
    }

    public boolean contains(AjusteImpl ajuste){
        return map.containsKey(Integer.toString(ajuste.getItemCSV().hashCode()));
    }

    public void emptyBag() {
        this.map = new HashMap<>();
    }
}
