package batchpoc.model;

/**
 * Created by pbergonzi on 13/11/14.
 */
public class ETransaction {
    private ItemCSV itemCSV;
    private static final String ENCODING = "UTF-8";
    private static final String HASH_ALG = "MD5";

    public ETransaction(ItemCSV itemCSV) {
        this.itemCSV = itemCSV;
    }

    public ItemCSV getItemCSV() {
        return itemCSV;
    }

    public void setItemCSV(ItemCSV itemCSV) {
        this.itemCSV = itemCSV;
    }

}
