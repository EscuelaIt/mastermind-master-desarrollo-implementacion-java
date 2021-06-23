package usantatecla.mastermind.views.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.GameController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.models.ColorView;
import usantatecla.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {
	
	private GameController gameController;
	
	public ProposedCombinationView(GameController gameController) {
		this.gameController = gameController;
	}
	
	void write(int position) {
		for (Color color : this.gameController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
