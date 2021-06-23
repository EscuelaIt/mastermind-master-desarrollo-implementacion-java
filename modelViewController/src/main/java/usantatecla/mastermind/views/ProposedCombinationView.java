package usantatecla.mastermind.views;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.WithConsoleView;

public class ProposedCombinationView extends WithConsoleView {

	private ProposedCombination proposedCombination;

	public ProposedCombinationView(ProposedCombination proposedCombination) {
		this.proposedCombination = proposedCombination;
	}

	void write() {
		for (Color color : this.proposedCombination.getColors()) {
			new ColorView(color).write();
		}
	}

	public void read() {
		Error error;
		List<Color> colors;
		do {
			String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
			colors = new ArrayList<Color>();
			for (int i = 0; i < characters.length(); i++) {
				colors.add(ColorView.getInstance(characters.charAt(i)));
			}
			error = ProposedCombination.isValid(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		this.proposedCombination.set(colors);
	}
}
