package usantatecla.klondike.views.console.types;

import usantatecla.utils.BoundedIntDialog;

public class PileDialog extends BoundedIntDialog {
  
	public PileDialog(){
    super(1, 7);
	}

  @Override
	public int read(String message) {
		return super.read(Message.READ_PILE.toString(message)) - 1;
	}  

}
