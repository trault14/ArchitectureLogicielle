package tools;

public class MethodeDessin implements ElementDessin {

	private int x;
	
	private int y;

	public MethodeDessin(int x, int y) {
		this.x = x;
		this.y = y;
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
}
