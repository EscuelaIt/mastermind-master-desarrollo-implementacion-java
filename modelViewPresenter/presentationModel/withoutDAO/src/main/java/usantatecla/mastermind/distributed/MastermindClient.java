package usantatecla.mastermind.distributed;

import usantatecla.mastermind.Mastermind;
import usantatecla.mastermind.controllers.Logic;

public class MastermindClient extends Mastermind{
	
	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}
	
	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new MastermindClient().play();
	}

}
