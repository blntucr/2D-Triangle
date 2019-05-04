
public class testtri {
	public static void main(String args[]) {
		MyPoint a = new MyPoint(3,6);
		MyPoint b = new MyPoint(1,2);
		MyPoint c = new MyPoint(5,4);
		MyPoint d = new MyPoint(4,1);
		MyPoint e = new MyPoint(3,4);
		MyPoint f = new MyPoint(2,3);
		MyPoint g = new MyPoint(3,3);
		MyPoint h = new MyPoint(0,0);
		Triangle2D t1 = new Triangle2D(a,b,c);
		Triangle2D t2 = new Triangle2D(e,f,g);
		System.out.print(t1.contains(t2));
	}
}
