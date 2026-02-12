package tech.codoverse.table.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnnotationTableView<T> {
	
	private List<ColumnDefinition<T>> columns = new ArrayList<>();
	private List<T> dataList;
	private String tableName;
	
	public AnnotationTableView(List<T> dataList) {
		this.dataList = dataList;
		if(dataList != null && !dataList.isEmpty()) {
			analyzeClass(dataList.getFirst().getClass());
		}
	}
	
	private void analyzeClass(Class<?> clazz) {
		if(clazz.isAnnotationPresent(Table.class)) {
			Table tblAnno = clazz.getAnnotation(Table.class);
			this.tableName = tblAnno.name();
		}
		
		for(Field field : clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(Column.class)) {
				Column colAnno = field.getAnnotation(Column.class);
				
				String header = colAnno.name().isBlank() ? field.getName().toUpperCase() : colAnno.name();
				columns.add(new ColumnDefinition<>(header, field, colAnno.order()));
			}
		}
		
		columns.sort(Comparator.comparingInt(c -> c.order));
	}
	
	public void print() {
		if(columns.isEmpty()) {
			IO.println("No columns defined or data list is empty.");
			return;
		}
		
		calculateWidths();
		
		if(tableName != null && !tableName.isBlank()) {
			IO.println("TABLE: " + tableName);
		}
		
		printLine();
		printHeader();
		printLine();
		printRows();
		printLine();
	}
	
	private void calculateWidths() {
		for(ColumnDefinition<T> col : columns) {
			for(T item : dataList) {
				String value = col.getValue(item);
				if(value != null && value.length() > col.width) {
					col.width = value.length();
				}
			}
		}
	}
	
	private void printLine() {
		IO.print("+");
		for(ColumnDefinition<T> col : columns) {
			IO.print("-".repeat(col.width + 2) + "+");
		}
		IO.println();
	}
	
	private void printHeader() {
		IO.print("|");
		for(ColumnDefinition<T> col : columns) {
			IO.print(String.format(" %-" + col.width + "s |", col.header));
		}
		IO.println();
	}
	
	private void printRows() {
		for(T item : dataList) {
			IO.print("|");
			for(ColumnDefinition<T> col : columns) {
				IO.print(String.format(" %-" + col.width + "s |", col.getValue(item)));
			}
			IO.println();
		}
	}

	private static class ColumnDefinition<T> {
		String header;
		Field field;
		int width;
		int order;
	
		public ColumnDefinition(String header, Field field, int order) {
			this.header = header;
			this.field = field;
			this.order = order;
			this.width = this.header.length();
		}
		
		String getValue(T obj) {
			try {
				if(!field.canAccess(obj)) {
					field.setAccessible(true);
				}
				Object val = field.get(obj);
				return val == null ? "-" : val.toString();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
				return "";
			}
		}
		
	}

}
