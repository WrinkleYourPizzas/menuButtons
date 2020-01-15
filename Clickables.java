public class Clickables {	//This thing makes a custom button shape with parabolas for top and bottom and linears for left and right
	private Line upper, lower, right, left;
	
	public Clickables(double a, double h, double k) {	//Constructor, makes a parabola on top for top boundary of button (make a = 0 for linear)
		this.upper = new Parabola(a, h, k);
	}
	
	public void createLinear(double m, double b, double side) {	//Create a linear line
		Linear line = new Linear(m, b);
		
		if(side == 1) this.right = line;
		else if(side == 0) this.lower = line;
		else if(side == -1) this.left = line;
	}
	
	public void createParabola(double a, double h, double k, int side) {	//Create a parabolic line
		Parabola line = new Parabola(a, h, k);
		
		if(side == 1) this.right = line;
		else if(side == 0) this.lower = line;
		else if(side == -1) this.left = line;
	}
	
	public boolean clicked(int x, int y) {	//If coordinates are inside all lines
		if(((Parabola) upper).calcPosition(x, y) <= 0 && ((Parabola) lower).calcPosition(x, y) >= 0)
			if(((Linear) right).calcPosition(x, y) <= 0 && ((Linear) left).calcPosition(x, y) >= 0)
				return true;
		return false;
	}
	
	interface Line{}	//So I can get everything into one arrayList

	public static class Parabola implements Line {	//y = a(x-h)^2+k	
		private double a, h, k;
		public Parabola(double a, double h, double k) {
			this.a = a;
			this.h = h;
			this.k = k;
		}
		
		public int calcPosition(int x, int y) {	//If >0, outside. If ==0, on the line. If <0, inside.
			return (int) (y - ((Math.pow((x - h), 2)*a) + k)); 
		}
	}
	
	public static class Linear implements Line {	//y = mx + b
		private double m, b;
		public Linear(double m, double b) {
			this.m = m;
			this.b = b;
		}
		
		public int calcPosition(int x, int y) {	//If <0, point is to the left of line. If >0, to the right. If ==0, on the line.
			return (int) (x - ((y-b)/m));
		}
	}
}