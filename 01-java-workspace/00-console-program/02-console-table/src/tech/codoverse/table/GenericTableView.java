package tech.codoverse.table;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericTableView<T> {
	
	private final List<Column<T>> columns = new ArrayList<>();
	private List<T> dataList;
	
	public GenericTableView<T> addColumn(String header, Function<T, String> provider) {
		columns.add(new Column<>(header, provider));
		return this;
	}
	
	public GenericTableView<T> setData(List<T> list) {
		this.dataList = list;
		return this;
	}
	
	public void printTable() {
		if(dataList == null || dataList.isEmpty()) {
			IO.println("No data to display.");
			return;
		}
		calculateWidths();
		printSeparator();
		printHeader();
		printSeparator();
		printRows();
		printSeparator();
	}
	
	private void calculateWidths() {
		for(Column<T> col : columns) {
			for(T item : dataList) {
				String value = col.valueProvider.apply(item);
				if(value != null && value.length() > col.maxLength) {
					col.maxLength = value.length();
				}
			}
		}
	}
	
	private void printSeparator() {
		IO.print("+");
		for(Column<T> col : columns) {
			IO.print("-".repeat(col.maxLength + 2) + "+");
		}
		IO.println();
	}
	
	private void printHeader() {
		IO.print("|");
		for(Column<T> col : columns) {
			IO.print(String.format(" %-" + col.maxLength + "s |", col.header));
		}
		IO.println();
	}
	
	private void printRows() {
		for(T item : dataList) {
			IO.print("|");
			for(Column<T> col : columns) {
				String value = col.valueProvider.apply(item);
				IO.print(String.format(" %-" + col.maxLength + "s |", value == null ? "" : value));
			}
			IO.println();
		}
	}
	
	private static class Column<T> {
		String header;
		Function<T, String> valueProvider;
		int maxLength;
		
		Column(String header, Function<T, String> valueProvider) {
			super();
			this.header = header;
			this.valueProvider = valueProvider;
			this.maxLength = header.length();
		}
		
	}

}
