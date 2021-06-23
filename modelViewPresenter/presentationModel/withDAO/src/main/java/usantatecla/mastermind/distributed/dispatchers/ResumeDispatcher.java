package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.ResumeControllerImplementation;

public class ResumeDispatcher extends Dispatcher {

	public ResumeDispatcher(ResumeControllerImplementation resumeControllerImplementation) {
		super(resumeControllerImplementation);
	}

	@Override
	public void dispatch() {
		boolean resume = this.tcpip.receiveBoolean();
		((ResumeControllerImplementation)this.acceptorController).isNewGame(resume);
	}

}
