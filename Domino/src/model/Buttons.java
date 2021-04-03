package model;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;

import controller.CheckPosition;
import view.Main;

public class Buttons 
{		
	static int currentPosY,currentPosX;
	static public JButton [][] buttons, buttonsSaved;
	static public int [][]positions, positionsSaved;
	static public int size,repeatCount;
	static boolean state = true, endEmptyPoints = true;
	static CopyOnWriteArrayList<Point>points,pointsSaved,repeatingPoints;
	
	public static void createButtonsField(int sizeOfField) 
	{		
		repeatCount = 0;
		size = sizeOfField;
		buttons = new JButton [sizeOfField][sizeOfField];
		positions = new int [sizeOfField][sizeOfField];		
		points = new CopyOnWriteArrayList<Point>();
		pointsSaved = new CopyOnWriteArrayList<Point>();
		repeatingPoints = new CopyOnWriteArrayList<Point>();
		ActionListener action = new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				JButton clickedButton = (JButton)ae.getSource();
				int currentPosX = clickedButton.getX()/20;
				int currentPosY = clickedButton.getY()/20;
				try 
				{
				if(Main.horiz.isSelected()) 
				{
					if(buttons[currentPosX][currentPosY-1]!=null && positions[currentPosX][currentPosY]!=1 && positions[currentPosX][currentPosY-1]!=1) 
					{
						buttons[currentPosX][currentPosY].setBackground(Color.RED);
						buttons[currentPosX][currentPosY-1].setBackground(Color.RED);
						positions[currentPosX][currentPosY]=1;
						positions[currentPosX][currentPosY-1]=1;
					} 
				}else 
				{
					if(buttons[currentPosX-1][currentPosY]!=null && positions[currentPosX][currentPosY]!=1 && positions[currentPosX-1][currentPosY]!=1) 
					{
						buttons[currentPosX][currentPosY].setBackground(Color.RED);
						buttons[currentPosX-1][currentPosY].setBackground(Color.RED);
						positions[currentPosX][currentPosY]=1;
						positions[currentPosX-1][currentPosY]=1;
					}
				}
				}catch(ArrayIndexOutOfBoundsException e) 
				{
					 System.out.println("You cant put block in this position!");
				}
			}
		};
		
		for(int i=0;i<sizeOfField;i++) 
		{			
			for(int k=0;k<sizeOfField;k++) 
			{
				positions[i][k] = 0;
				buttons[i][k] = new JButton(""  + i + ";" + k);
				buttons[i][k].setBounds(i*20,k*20,20,20);
				buttons[i][k].addActionListener(action);
				Main.field.add((JButton)buttons[i][k]);				
			//	System.out.println(buttons[i][k].getSize());
			}
		}	
		
		Main.field.invalidate();
		Main.field.repaint();			
	} 
	
	public static void checkInsertBlocks() 
	{		
		buttonsSaved = cloned(buttons);
		positionsSaved = cloned(positions);		
		allEmptyPositions();	
		pointsSaved = cloned(points);
		if(!(points.size()%2==0)) 
		{
			state = false;
		}
		for(int i=0; i<10000001; i++) 
		{
			int  count = points.size()/2;
			int round = 0;
			while(round<count && checkRepeating(points)) 
			{	
				if(points.size()<=1) break;				
				int random = (int)(Math.random()*points.size());	
				if(random ==0) random=+1;				
				int checkVariance = (int)(Math.random()*4)+1;						
				Point current = points.get(random);					
				boolean check = CheckPosition.checkNearPosition(current, checkVariance);
				if(check==true) 
				{				
					points.remove(random);
					round++;
				}	
				cleanPositions(points);				
			}	
			print(positions);
			System.out.println("Input status: " + isEmptyPositions());
			if(!isEmptyPositions()) 
			{
				System.out.println("Próba nr. " + i + " była udana!");
				break;	
			}
			System.out.println("Size: " + points.size() + " " + pointsSaved.size());
			if(i!=10000000)
			{
				refreshField();
			}
			buttons = cloned(buttonsSaved);
			positions = cloned(positionsSaved);
			points = cloned(pointsSaved);
			Main.field.repaint();			
			Main.panel.repaint();
			repeatCount=0;
		}
		
		
	}
	
	public static boolean isEmptyPositions() 
	{		
		boolean isEmpty = false;
		fo: for(int position[] : positions) 
		{
			for(int onePosition : position) 
			{
				if(onePosition == 0)
				{
					isEmpty = true;
					break fo;					
				}
			}
		}
		return isEmpty;
	}
	
	public static void allEmptyPositions() 
	{
		
		for(int i=0; i<size;i++) 
		{
			//point.setX(i);
			for(int k = 0; k<size;k++) 
			{			
				if(positions[i][k]==0) 
				{					
				//	System.out.println(positions[i][k]);
					Point point = new Point();
					point.setX(i);
					point.setY(k);
					points.add(point);										
				}
			}
		}		
	}		
	
	
	public static boolean equalPoint(Point p) 
	{
		for(Point point : points) 
		{
			if(p.equals(point))
				return true;
		}
		return false;
	}
	
	public static void print(ArrayList<Point> list) 
	{
		for(Point p: list) 
		{
			System.out.println(p.x + " " + p.y);
		}
	}
	
	public static void print(int[][] array) 
	{
		for(int i=0;i<array.length;i++) 
		{
			for(int k=0;k<array[i].length;k++) 
			{
				System.out.print(array[i][k] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] cloned(int[][]array)
	{		
		int [][]arr = new int[array.length][array[0].length] ;
		for(int i=0;i<array.length;i++) 
		{
			for(int k=0; k<array[i].length;k++) 
			{
				arr[i][k] = array[i][k];
			}
		}
		return arr;
	}
	
	public static CopyOnWriteArrayList<Point> cloned(CopyOnWriteArrayList<Point>list)
	{
		CopyOnWriteArrayList <Point> points = new CopyOnWriteArrayList<Point>();
		for(int i=0; i<list.size();i++) 
		{
			points.add(list.get(i));
		}
		return points;
	}
	
	public static JButton[][] cloned(JButton[][]array)
	{		
		JButton [][]arr = new JButton[array.length][array[0].length] ;
		for(int i=0;i<array.length;i++) 
		{
			for(int k=0; k<array[i].length;k++) 
			{
				arr[i][k] = array[i][k];
			}
		}
		return arr;
	}
	
	public static void refreshField() 
	{
		for(int i=0; i<positions.length;i++) 
		{
			for(int k=0; k<positions[i].length;k++) 
			{
				if(positions[i][k]==2) 
				{
					buttons[i][k].setBackground(new JButton().getBackground());;
				}
			}
		}
	}
	
	public static boolean isRightPoint(Point p) 
	{
		if(positions[p.getX()][p.getY()]==0) return true;
		else return false;
	}
	
	public static void cleanPositions(CopyOnWriteArrayList<Point> points2) 
	{
		for(Point p : points2) 
		{
			if(positions[p.getX()][p.getY()]==2) 
			{
				points2.remove(p);				
			}
		}
	}
	
	public static boolean checkRepeating(CopyOnWriteArrayList<Point> list) 
	{
		if(repeatingPoints.equals(list)) 
		{
			repeatCount++;
		}
		repeatingPoints = list;
		if(repeatCount>100) 
		{
			return false;
		}
		else 
		{
			return true;
		}
		
	}
	
	
	
}
