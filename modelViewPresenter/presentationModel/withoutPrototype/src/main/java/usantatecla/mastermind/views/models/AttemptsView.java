package usantatecla.mastermind.views.models;

import usantatecla.mastermind.controllers.GameController;

class AttemptsView {

	private GameController gameController;

	AttemptsView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.gameController.getAttempts());
	}

}
