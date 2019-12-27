package workbook.poly;

public abstract class Factory {
	private int openHour;
	private int closeHour;
	private String name;
	int workingtime=0;
	String mainFactory ;
	public Factory() {
		
	}
	public Factory(String name, int openHour,int closeHour) {
		this.name = name;
		this.openHour=openHour;
		this.closeHour=closeHour;
	}
	public int getOpenHour() {
		return openHour;
	}
	public void setOpenHour(int openHour) {
		this.openHour = openHour;
	}
	public int getCloseHour() {
		return closeHour;
	}
	public void setCloseHour(int closeHour) {
		this.closeHour = closeHour;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWorkingTime() {
		workingtime = closeHour-openHour;
		return workingtime;	
	}
	public abstract int makeProducts(char skill) ;
	
	public String getFactoryName() {
		mainFactory = getName();
		return mainFactory;
	}
}
