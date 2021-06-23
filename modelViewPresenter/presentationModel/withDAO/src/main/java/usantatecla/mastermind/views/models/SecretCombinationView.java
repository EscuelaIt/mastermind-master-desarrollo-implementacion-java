package usantatecla.mastermind.views.models;

import usantatecla.mastermind.controllers.Controller;

class SecretCombinationView {
	
	private Controller controller;
	
	SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}
	
	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			MessageView.SECRET.write();
		}
		MessageView.NEW_LINE.writeln();
	}
	
}
