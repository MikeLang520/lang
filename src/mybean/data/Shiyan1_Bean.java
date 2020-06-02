package mybean.data;
public class Shiyan1_Bean {
	String []columnName;
	String [][]tableRecord=null;
	public Shiyan1_Bean() {
		tableRecord=new String[1][1];
		columnName=new String[1];
	}
	public void setTableRecord(String[][]s) {
		tableRecord=s;
	}
	public String [][]getTableRecord(){
		return tableRecord;
	}
	public void setColumnName(String[]s) {
		columnName=s;
	}
	public String[]getColumnName(){
		return columnName;
	}
	}
		