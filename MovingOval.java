/*Se Ho Lee	slee626
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import com.sun.corba.se.impl.orbutil.graph.Graph;


class MovingOval extends MovingShape  {

	
	MovingOval(int x, int y, int Width, int Height, int marginWidth, int marginHeight, int BorderColor, int FillColor, int PathType){
		super(x, y, w, h, mw, mh, bc, fc, pt);
	}
	public String toString() {	
		String x = String.format("%.d", topLeft.x);
		String y = String.format("%.d", topLeft.y);
		String w = String.format("%.d", width);
		String h = String.format("%.d", height);
		return ("("+ x +","+ y +")," + w + "x" + h);

	}
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.drawHandles(g2);
		g2.drawOval(x, y, width, height);
	
	}
	public void move() {
		topLeft.x = topLeft.x + 1;
		topLeft.y = topLeft.y + 2;
	}
	
	MovingOval(int x, int y, int width, int height) {
		topLeft = new Point(0,0);
		height = 10;
		width = 10;
		borderColor = Color.black;
		fillColor = Color.black;
	
	}

	MovingOval(Point point, int x, int y, int Width, int Height, Color passBorder, Color passFill) {
		topLeft = point;
		height = Height;
		width = Width;
		borderColor = passBorder;
		fillColor = passFill;
	}
	
	public boolean contains(Point p) {
		double checkX = Math.pow((topLeft.y + width/2) - p.y,2) / Math.pow(width/2, 2);
		double checkY = Math.pow((topLeft.y + width/2) - p.y,2) / Math.pow(width/2, 2);
		if (checkX + checkY <= 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
