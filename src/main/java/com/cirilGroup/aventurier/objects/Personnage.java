package com.cirilGroup.aventurier.objects;

public class Personnage {

	private int x;
	private int y;
	
	public Personnage(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public Personnage(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
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

	@Override
	public String toString() {
		return "Personnage [x=" + x + ", y=" + y + "]";
	}
	
}
