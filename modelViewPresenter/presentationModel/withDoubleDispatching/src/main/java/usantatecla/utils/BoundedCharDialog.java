package usantatecla.utils;

public class BoundedCharDialog {

  private char[] options;

  public BoundedCharDialog(char[] options){
    this.options = options;
  }

	public char read(String message) {
		assert message != null;

		boolean ok;
		char character;
		do {
			character = Console.getInstance().readChar(message + "? " + this.getOptions() + ": ");
			ok = this.isOption(character);
			if (!ok) {
				Console.getInstance().writeln(BoundedIntDialog.ERROR_MESSAGE);
			}
		} while(!ok);
		return character;
	}

  private boolean isOption(char character){
    for(char option : this.options){
      if (option == character){
        return true;
      }
    }
    return false;
  }

  public String getOptions(){
    String options = "(";
    for (int i = 0; i < this.options.length - 1; i++) {
      options += this.options[i] + "/";
    }
    return options + this.options[this.options.length - 1] + ")";
  }

}
