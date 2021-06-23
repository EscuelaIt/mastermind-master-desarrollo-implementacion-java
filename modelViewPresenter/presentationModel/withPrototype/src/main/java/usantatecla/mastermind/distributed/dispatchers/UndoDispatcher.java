package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;

public class UndoDispatcher extends Dispatcher {

	public UndoDispatcher( PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		((PlayControllerImplementation)this.acceptorController).undo();
	}

}
