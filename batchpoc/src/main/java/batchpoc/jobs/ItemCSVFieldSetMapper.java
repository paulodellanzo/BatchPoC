package batchpoc.jobs;

import batchpoc.model.ItemCSV;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ItemCSVFieldSetMapper implements FieldSetMapper<ItemCSV> {

    @Override
    public ItemCSV mapFieldSet(FieldSet fieldSet) throws BindException {

        ItemCSV itemCSV = new ItemCSV();
//        itemCSV.setColumna01(fieldSet.readString("columna01"));
//        itemCSV.setColumna02(fieldSet.readString("columna02"));
//        itemCSV.setColumna03(fieldSet.readString("columna03"));
//        itemCSV.setColumna04(fieldSet.readString("columna04"));
//        itemCSV.setColumna05(fieldSet.readString("columna05"));
//        itemCSV.setColumna06(fieldSet.readString("columna06"));
//        itemCSV.setColumna07(fieldSet.readString("columna07"));
//        itemCSV.setColumna08(fieldSet.readString("columna08"));
//        itemCSV.setColumna09(fieldSet.readString("columna09"));
        return itemCSV;
    }
}
