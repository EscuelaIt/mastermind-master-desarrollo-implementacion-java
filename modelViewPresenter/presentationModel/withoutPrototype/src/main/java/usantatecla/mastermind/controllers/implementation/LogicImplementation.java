package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.models.DAO.SessionImplementationDAO;

public class LogicImplementation extends Logic {

	protected SessionImplementationDAO sessionImplementationDAO;

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected SaveControllerImplementation saveControllerImplementation;

	protected ResumeControllerImplementation resumeControllerImplementation;

	public LogicImplementation(SessionImplementationDAO sessionImplementationDAO) {
		this.session = new SessionImplementation();
		this.sessionImplementationDAO = sessionImplementationDAO;
		this.sessionImplementationDAO.associate((SessionImplementation) this.session);
		this.startControllerImplementation = new StartControllerImplementation(this.session,
				this.sessionImplementationDAO);
		this.playControllerImplementation = new PlayControllerImplementation(this.session);
		this.saveControllerImplementation = new SaveControllerImplementation(this.session,
				this.sessionImplementationDAO);
		this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
		this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
		this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
		this.acceptorControllers.put(StateValue.SAVING, this.saveControllerImplementation);
		this.acceptorControllers.put(StateValue.FINAL, this.resumeControllerImplementation);
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

}
