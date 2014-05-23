package com.java.ro.invoices.model.to;

import java.util.List;

public class DataTO<T> {
	
	long total;
	List<T> records;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
}
