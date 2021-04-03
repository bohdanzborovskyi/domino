package controller;

import java.awt.Color;

import model.Buttons;
import model.Point;

public class CheckPosition
{
	public static boolean checkNearPositionA(int x, int y) 
	{
		try 
		{
		if(Buttons.positions[x][y+1]==0 && Buttons.positions[x][y+1]!=-1)
			{
				Buttons.buttons[x][y].setBackground(Color.BLUE);
				Buttons.buttons[x][y+1].setBackground(Color.BLUE);	
				Buttons.positions[x][y+1]=2;
				Buttons.positions[x][y]=2;
				return true;
			}
		else if(Buttons.positions[x+1][y]==0 && Buttons.positions[x+1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x+1][y].setBackground(Color.BLUE);	
			Buttons.positions[x+1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
		else if(Buttons.positions[x][y-1]==0 && Buttons.positions[x][y-1]!=-1) 
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x][y-1].setBackground(Color.BLUE);
			Buttons.positions[x][y-1]=2;
			Buttons.positions[x][y]=2;
			return true;
		}		
		else if(Buttons.positions[x-1][y]==0 && Buttons.positions[x-1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x-1][y].setBackground(Color.BLUE);	
			Buttons.positions[x-1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}		
		return false;
		}catch(ArrayIndexOutOfBoundsException ex) 
		{
			return false;
		}
	}
	
	public static boolean checkNearPositionB(int x, int y) 
	{
		try 
		{		
		if(Buttons.positions[x][y-1]==0 && Buttons.positions[x][y-1]!=-1) 
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x][y-1].setBackground(Color.BLUE);
			Buttons.positions[x][y-1]=2;
			Buttons.positions[x][y]=2;
			return true;
		}		
		else if(Buttons.positions[x-1][y]==0 && Buttons.positions[x-1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x-1][y].setBackground(Color.BLUE);	
			Buttons.positions[x-1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
		else if(Buttons.positions[x][y+1]==0 && Buttons.positions[x][y+1]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x][y+1].setBackground(Color.BLUE);	
			Buttons.positions[x][y+1]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
	else if(Buttons.positions[x+1][y]==0 && Buttons.positions[x+1][y]!=-1)
	{
		Buttons.buttons[x][y].setBackground(Color.BLUE);
		Buttons.buttons[x+1][y].setBackground(Color.BLUE);	
		Buttons.positions[x+1][y]=2;
		Buttons.positions[x][y]=2;
		return true;
	}
		return false;
		}catch(ArrayIndexOutOfBoundsException ex) 
		{
			return false;
		}
	}
	
	public static boolean checkNearPositionC(int x, int y) 
	{
		try 
		{
		if(Buttons.positions[x][y+1]==0 && Buttons.positions[x][y+1]!=-1)
			{
				Buttons.buttons[x][y].setBackground(Color.BLUE);
				Buttons.buttons[x][y+1].setBackground(Color.BLUE);	
				Buttons.positions[x][y+1]=2;
				Buttons.positions[x][y]=2;
				return true;
			}
				
		else if(Buttons.positions[x-1][y]==0 && Buttons.positions[x-1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x-1][y].setBackground(Color.BLUE);	
			Buttons.positions[x-1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
		else if(Buttons.positions[x+1][y]==0 && Buttons.positions[x+1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x+1][y].setBackground(Color.BLUE);	
			Buttons.positions[x+1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
		else if(Buttons.positions[x][y-1]==0 && Buttons.positions[x][y-1]!=-1) 
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x][y-1].setBackground(Color.BLUE);
			Buttons.positions[x][y-1]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
		return false;
		}catch(ArrayIndexOutOfBoundsException ex) 
		{
			return false;
		}
	}
	
	public static boolean checkNearPositionD(int x, int y) 
	{
		try 
		{
			if(Buttons.positions[x][y-1]==0 && Buttons.positions[x][y-1]!=-1) 
			{
				Buttons.buttons[x][y].setBackground(Color.BLUE);
				Buttons.buttons[x][y-1].setBackground(Color.BLUE);
				Buttons.positions[x][y-1]=2;
				Buttons.positions[x][y]=2;
				return true;
			}
			else if(Buttons.positions[x][y+1]==0 && Buttons.positions[x][y+1]!=-1)
			{
				Buttons.buttons[x][y].setBackground(Color.BLUE);
				Buttons.buttons[x][y+1].setBackground(Color.BLUE);	
				Buttons.positions[x][y+1]=2;
				Buttons.positions[x][y]=2;
				return true;
			}
				
		else if(Buttons.positions[x-1][y]==0 && Buttons.positions[x-1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x-1][y].setBackground(Color.BLUE);	
			Buttons.positions[x-1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}
		else if(Buttons.positions[x+1][y]==0 && Buttons.positions[x+1][y]!=-1)
		{
			Buttons.buttons[x][y].setBackground(Color.BLUE);
			Buttons.buttons[x+1][y].setBackground(Color.BLUE);	
			Buttons.positions[x+1][y]=2;
			Buttons.positions[x][y]=2;
			return true;
		}		
		return false;
		}catch(ArrayIndexOutOfBoundsException ex) 
		{
			return false;
		}
	}
	
	public static boolean checkNearPosition(Point p,int variance) 
	{
	boolean check = false;
		switch(variance) 
		{
		case 1:
			check = checkNearPositionA(p.x, p.y);	 
			return check;			
		case 2:
			check = checkNearPositionB(p.x, p.y);
			return check;
		case 3:
			check = checkNearPositionC(p.x, p.y);
			return check;
		case 4:
			check = checkNearPositionD(p.x, p.y);	
			return check;
		}
		return check;
	}
	
	
}
