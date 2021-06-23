package usantatecla.mastermind.models;

class State {
		
	private StateValue stateValue;
	
	State() {
		this.stateValue = StateValue.INITIAL;
	}
	
	void next() {
		this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
	}
	
	void reset() {
		this.stateValue = StateValue.INITIAL;
	}

	void setStateValue(StateValue stateValue) {
		this.stateValue = stateValue;
	}

	StateValue getValueState() {
		return this.stateValue;
	}
	
}
