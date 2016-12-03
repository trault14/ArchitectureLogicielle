package tools;

public class VariableDessin implements ElementDessin {

	private int x;
	private int y;

	public VariableDessin(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

}
