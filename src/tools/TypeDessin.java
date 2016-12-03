package tools;

import base.Type;

public class TypeDessin implements ElementDessin {

	private Type type;
	private int x; // Coordonnee x du coin gauche du type
	private int y; // Coordonnee y du coin gauche du type
	private int height;
	private int width;

	public TypeDessin(Type type,int x, int y, int height, int width){
		this.type = type;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public Type getType(){
		return this.type;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}

}
