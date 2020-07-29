/*Se Ho Lee	slee626
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;



class MovingRectangle extends MovingShape  {

	
	MovingRectangle(int x, int y, int Width, int Height, int marginWidth, int marginHeight, Color currentBorderColor, Color currentFillColor, int PathType){
		super(x, y, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, PathType);
	}
	public void draw(Graphics g) {
		g = (Graphics2D) g;
		
	}
	public void move() {
		topLeft.x = topLeft.x + 1;
		topLeft.y = topLeft.y + 2;
	}
	
	MovingRectangle(int x, int y, int width, int height) {
		topLeft = new Point(0,0);
		height = 10;
		width = 10;
		borderColor = Color.black;
		fillColor = Color.black;
	
	}
	public boolean contains(Point p) {
		boolean contains = false;
		if(p.x >topLeft.x && p.x <(topLeft.x + width)) {
			if(p.y >topLeft.y && p.y <(topLeft.y + height)) {
				contains = true;
			}
		}
		return contains;
	}
}
