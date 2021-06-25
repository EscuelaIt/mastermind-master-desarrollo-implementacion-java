package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.types.Card;
import usantatecla.klondike.views.console.types.CardView;
import usantatecla.utils.Console;

public abstract class CardStackView {
  
  private final String message;
  protected final Controller controller;
    
  public CardStackView(Controller controller, String message) {
      this.controller = controller;
      this.message = message;
  }

  public void writeln() {
      Console.getInstance().write(this.message);
      new CardView(this.getPeek()).writeln();
  }

  public abstract Card getPeek();

}
