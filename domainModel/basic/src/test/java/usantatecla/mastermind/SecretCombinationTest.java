package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecretCombinationTest {

    private SecretCombination secretCombination;

    @Mock
    private ProposedCombination proposedCombination;

    @BeforeEach
    public void beforeEach() {
        this.secretCombination = new SecretCombination();
    }

    @Test
    public void testGivenSecretCombinationAndWinnerProposedCombinationWhenGetResultThenIs4blacksAnd0Whites() {
        when(this.proposedCombination.contains(any(ColorCode.class), anyInt())).thenReturn(true);
        when(this.proposedCombination.contains(any(ColorCode.class))).thenReturn(true);
        Result result = secretCombination.getResult(this.proposedCombination);
        assertThat(result,is(new Result(4,0)));
    }

    @Test
    public void testGivenSecretCombinationAndProposedCombinationWhenGetResultThen0blacksAnd0Whites() {
        when(this.proposedCombination.contains(any(ColorCode.class), anyInt())).thenReturn(false);
        when(this.proposedCombination.contains(any(ColorCode.class))).thenReturn(false);
        Result result = secretCombination.getResult(this.proposedCombination);
        assertThat(result, is(new Result(0, 0)));
    }

    @Test
    public void testGivenSecretCombinationAndProposedCombinationWhenGetResultThen2blacksAnd2Whites() {
        when(this.proposedCombination.contains(any(ColorCode.class), anyInt())).thenReturn(true, true, false);
        when(this.proposedCombination.contains(any(ColorCode.class))).thenReturn(true);
        Result result = secretCombination.getResult(this.proposedCombination);
        assertThat(result, is(new Result(2, 2)));
    }

    @Test
    public void testGivenSecretCombinationWhenWritelnThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            this.secretCombination.writeln();
            verify(console).writeln("****");
        }
    }

}
