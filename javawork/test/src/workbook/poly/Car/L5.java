package workbook.poly.Car;

public class L5 extends Car implements temp{
public L5() {
		
	}
	public L5(String name,String engine,int oilTank,int oilSize,int distance) {
		super(name,engine,oilTank,oilSize,distance);
	}
	@Override
	public void go(int distance) {
		setOilSize(getOilSize()-1*(distance/8));
		setDistance(distance);
	}
	@Override
	public void setOil(int oilSize) {
		setOilSize(getOilSize()+oilSize);
	}
	
	@Override
	public int getTempGage() {
		int temp=0;
		temp=temp+(getDistance()/10)*2;
		return temp;  ///ä���
	}
}
