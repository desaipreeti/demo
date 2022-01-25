package com;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HousingTicket1 {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter num of rows and columns");
		int l=sc.nextInt();
		int m=sc.nextInt();
		IntStream.range(0, 6).forEach(value->
		{
			System.out.println("**************");
			startGame( l ,m);
		});
		
			
		
		
	}
private static void startGame(int l ,int m)
{
	
	
	int game[][]=new int[l][m];
	
	
	int occulimit=15;
	
	while(occulimit>0)
	{
	int i =getRandomNumber(3);
	int j= getRandomNumber(9);
	
	
	int data= validateAndReturnNum(i,j,game);
	
	if(data>0)
	{
		game[i][j]=data;
		occulimit--;
	}
}
	System.out.println(Arrays.deepToString(game).replace("],", "]\n").replace("0", "").replace(",", ""));
}
private static int validateAndReturnNum(int i, int j, int[][] game) {
	// rule1 if value is alredy filled it cannot be overroden
	if(game[i][j]!=0)
	{
		return -1;
	}
	
	int rowcount=0;
	for(int r=0;r<3;r++)
	{
		if(game[r][j]!=0)
		{
			rowcount++;
		}
	}
	//Rule2-for column cannot contain more than 2 values.
	if(rowcount>=2)
	{
		return -1;
	}
	
	int columncount=0;
	for(int c=0;c<9;c++)
	{
		if(game[i][c]!=0)
		{
			columncount++;
		}
	}
	
	//rule rows cannot have more than 5 element.
	if(columncount>=5)
	{
		return -1;
	}
	 
	int data=0;
	boolean isvaluSet=false;
	do {
		data=getRandomNumberForColumn(j);
		isvaluSet = isValueExistCol(game,i,j,data);
	}while(isvaluSet);
	return data;
}

private static boolean isValueExistCol(int[][] game, int i, int j, int data) {
	boolean status= false;
	for(int k=0;k<3;k++)
	{
		if(game[k][j]==data)
		{
			status=true;
			break;
		}
	}
	return status;
}
private static int getRandomNumberForColumn(int high) {
	if(high==0)
	{
		high=10;
	}
	else
	{
		high=(high+1)*10;
	}
	
	int low=high-9;
	Random r= new Random();
	return r.nextInt(high-low)+low;
}
private static int getRandomNumber(int max)
{
	return (int) (Math.random()*max);
	
}
}


