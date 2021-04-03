package model;

public class Point
{
	public int x;
	public int y;
	public int getX() {
		return x;
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean equals(Point p) 
	{		
		if(this.x==p.x && this.y==p.y)
			return true;
		else 
		{
			return false;
		}
	}
	
	
	
	
}
