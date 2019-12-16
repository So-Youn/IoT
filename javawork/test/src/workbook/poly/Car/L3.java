package workbook.poly.Car;

public class L3 extends Car implements temp{
	public L3() {
		
	}
	public L3(String name,String engine,int oilTank,int oilSize,int distance) {
		super(name,engine,oilTank,oilSize,distance);
	}
	@Override
	public void go(int distance) {
		setOilSize(getOilSize()-1*(distance/10));
		setDistance(distance);
	}
	@Override
	public void setOil(int oilSize) {
		setOilSize(getOilSize()+oilSize);
	}
	
	@Override
	public int getTempGage() {
		int temp=0;
		temp=temp+(getDistance()/10)*1;
		return temp;  ///ä���
	}

	
}
