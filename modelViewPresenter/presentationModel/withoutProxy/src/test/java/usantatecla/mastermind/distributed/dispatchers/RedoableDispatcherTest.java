package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RedoableDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new RedoableDispatcher(this.playController);
	}

	@Test
	public void testGivenRedoableDispatcherWhenDispatchThenCorrect() {
		when(this.playController.redoable()).thenReturn(false);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(false);
	}

}
