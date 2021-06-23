package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.SaveController;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

	SaveControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void save(String name) {
		((SessionImplementation) this.session).save(name);
	}

	@Override
	public void save() {
		((SessionImplementation) this.session).save();
	}

	@Override
	public void next() {
		((SessionImplementation) this.session).next();
	}

	@Override
	public boolean hasName() {
		return ((SessionImplementation) this.session).hasName();
	}

	@Override
	public boolean exists(String name) {
		return ((SessionImplementation) this.session).exists(name);
	}

}
