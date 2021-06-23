package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

class ProposedCombination extends Combination {

	ProposedCombination(List<Color> colors) {
		this.colors = colors;
	}

	public ProposedCombination() {
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}
	
	ProposedCombination copy() {
		List<Color> colors = new ArrayList<Color>();
		for(Color color: this.colors) {
			colors.add(color);
		}
		return new ProposedCombination(colors);
	}

}
