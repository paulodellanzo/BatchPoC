package batchpoc.jobs;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.stereotype.Component;

import batchpoc.model.ItemCSV;

@Component
@StepScope
public class ReaderCSV<T extends ItemCSV> extends FlatFileItemReader<ItemCSV> {
	
	private String tipo;
	
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

}