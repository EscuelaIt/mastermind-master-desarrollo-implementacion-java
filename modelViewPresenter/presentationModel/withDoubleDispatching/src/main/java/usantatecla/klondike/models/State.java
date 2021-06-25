package usantatecla.klondike.models;

import usantatecla.klondike.types.StateValue;

public class State {

    private StateValue stateValue;

    public State() {
        this.stateValue = StateValue.INITIAL;
    }

    public void next() {
        this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
    }

    public void reset() {
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }

}
