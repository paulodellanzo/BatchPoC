package batchpoc.services;

import batchpoc.model.ItemCSV;
import batchpoc.model.ETransaction;

import java.util.*;

public class BagItemService {
    private Map<String,ItemCSV> map = new HashMap<>();

    public void add(ItemCSV item){
        map.put(Integer.toString(item.hashCode()),null);
    }

    public List<ItemCSV> getAsList(){
       return new ArrayList<>(map.values());
    }

    public boolean contains(ItemCSV item){
        return map.containsKey(Integer.toString(item.hashCode()));
    }

    public void emptyBag() {
        this.map = new HashMap<>();
    }
}
