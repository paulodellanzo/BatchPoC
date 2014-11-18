package batchpoc.model;

/**
 * Created by pbergonzi on 13/11/14.
 */
public class ETransaction {
	private ItemCSV itemCSV;

	public ETransaction(ItemCSV itemCSV)
	{
		this.itemCSV = itemCSV;
	}
	
	public ItemCSV getItemCSV() {
		return itemCSV;
	}

	public void setItemCSV(ItemCSV itemCSV) {
		this.itemCSV = itemCSV;
	}
}
