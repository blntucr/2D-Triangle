import java.awt.geom.Line2D;

public class Triangle2D {
	MyPoint p1, p2, p3;
	double maxDistance;
	Line2D line1 = new Line2D.Double();
	Line2D line2 = new Line2D.Double();
	Line2D line3 = new Line2D.Double();

	Triangle2D(){
		this(new MyPoint(), new MyPoint(1,1), new MyPoint(2,5));
	}
	
	Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3){
		if(p1.getY() < p2.getY()) {
			this.p1 = p2;	
			this.p2 = p1;
			this.p3 = p3;
		}
		else if(p1.getY() < p3.getY()) {
			this.p1 = p3;
			this.p2 = p2;
			this.p3 = p1;
		}
		else {
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
		}
		line1.setLine(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY());
		line2.setLine(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY());
		line3.setLine(this.p3.getX(), this.p3.getY(), this.p1.getX(), this.p1.getY());
		
	}

	public MyPoint getP1() {
		return p1;
	}

	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}

	public MyPoint getP2() {
		return p2;
	}

	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}

	public MyPoint getP3() {
		return p3;
	}

	public void setP3(MyPoint p3) {
		this.p3 = p3;
	}
	public double getArea() {
		
		return (0.5 * (p1.getY() - Math.min(p2.getY(), p3.getY()))
				* Math.abs(p3.getX() - p2.getX()));
		
	}
	
	public double getPerimeter() {
		
		double p1p2 = p1.distance(p2.getX(), p2.getY());
		double p1p3 = p1.distance(p3.getX(), p3.getY());
		double p2p3 = p2.distance(p3.getX(), p3.getY());
		maxDistance = Math.max(Math.max(p1p2, p1p3), p2p3);
		double perimeter = p1p2 + p1p3 + p2p3;
		return perimeter;
	}
	
	public boolean contains(MyPoint p) {
		
		double area1 = 0.5 * (Math.abs(p1.getY() - p3.getY()) 
				* Math.abs((p3.getX() - p.getX())));
		double area2 = 0.5 * (Math.abs(p3.getY() - p2.getY()) 
				* Math.abs((p3.getX() - p.getX()))); 
		double area3 = 0.5 * (Math.abs(p1.getY() - p2.getY()) 
				* Math.abs((p2.getX() - p.getX())));
		double A = 0.5 * (p1.getY() - 
				Math.min(p2.getY(), p3.getY()))
				* Math.abs(p3.getX() - p2.getX());
		if(area1+area2+area3 == A)
			return true;
		else
			return false;
	}
	
	public boolean overlaps(Triangle2D t) {
		
		Line2D line4 = new Line2D.Double();
		Line2D line5 = new Line2D.Double();
		Line2D line6 = new Line2D.Double();
		
		line4.setLine(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
		line5.setLine(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());
		line6.setLine(t.p3.getX(), t.p3.getY(), t.p1.getX(), t.p1.getY());
		
		if(line1.intersectsLine(line4) || line2.intersectsLine(line5)
				|| line3.intersectsLine(line6))
			return true;
		else
			return false;
		}
	
	public boolean contains(Triangle2D t) {
		if(contains(t.p1) && contains(t.p2) && contains(t.p3))
			return true;
		else 
			return false;
	}
}
