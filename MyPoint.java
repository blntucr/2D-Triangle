
public class MyPoint {
	double x, y;
	
	MyPoint(){
		this(0,0);
	}
	
	MyPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distance(double x, double y) {
		return Math.sqrt(Math.pow(Math.abs(this.x - x), 2) - Math.pow(Math.abs(this.y - y), 2));
		 
}
	public static MyPoint getObject(double x, double y) {
		return new MyPoint(x, y);
	}
}


