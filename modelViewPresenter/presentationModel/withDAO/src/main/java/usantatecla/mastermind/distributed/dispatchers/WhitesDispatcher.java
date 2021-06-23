package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;

public class WhitesDispatcher extends Dispatcher {

	public WhitesDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getWhites(position));
	}

}
