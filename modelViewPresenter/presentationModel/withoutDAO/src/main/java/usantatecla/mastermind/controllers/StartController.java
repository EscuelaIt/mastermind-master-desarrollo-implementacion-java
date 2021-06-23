package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class StartController extends GameController {

	public StartController(Session session) {
		super(session);
	}

	public abstract void start();

	public abstract void start(String title);

	public abstract String[] getGamesNames();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
