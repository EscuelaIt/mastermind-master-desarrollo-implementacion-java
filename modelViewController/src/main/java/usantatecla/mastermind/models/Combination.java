package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

public abstract class Combination {
	
	private static final int WIDTH = 4;

	protected List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList<Color>();
	}
	
	static int getWidth() {
		return Combination.WIDTH;
	}
	
	public List<Color> getColors(){
		return this.colors;
	}
	
}
