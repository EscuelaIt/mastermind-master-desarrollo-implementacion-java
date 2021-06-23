package usantatecla.mastermind.models;

import java.util.List;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class Board {

    static final int MAX_ATTEMPTS = 10;
    private SecretCombination secretCombination;
    private ProposedCombination[] proposedCombinations;
    private Result[] results;
    private int attempts;

    public Board() {
        this.reset();
    }

    public void reset() {
        this.proposedCombinations = new ProposedCombination[Board.MAX_ATTEMPTS];
        this.results = new Result[Board.MAX_ATTEMPTS];
        this.secretCombination = new SecretCombination();
        this.attempts = 0;
    }

    public void add(List<Color> colors) {
        this.proposedCombinations[this.attempts] = new ProposedCombination(colors);
        this.results[this.attempts] = this.getResult(this.proposedCombinations[this.attempts]);
        this.attempts++;
    }

    Result getResult(ProposedCombination proposedCombination) {
        return this.secretCombination.getResult(proposedCombination);
    }

    public int getBlacks(int position) {
        return this.getResult(position).getBlacks();
    }

    public int getWhites(int position) {
        return this.getResult(position).getWhites();
    }

    public Result getResult(int position) {
        assert position < this.attempts && position >= 0;

        return this.results[position];
    }

    public List<Color> getProposedCombinationColors(int position) {
        assert position < this.attempts && position >= 0;

        return this.proposedCombinations[position].getColors();
    }

    public Error getError(List<Color> colors) {
        return new ProposedCombination(colors).getError();
    }

    public int getAttempts() {
        return this.attempts;
    }

    public boolean isFinished() {
        return this.isWinner() || this.isLooser();
    }

    public boolean isWinner() {
        return this.results[this.attempts - 1].isWinner();
    }

    private boolean isLooser() {
        return this.attempts == Board.MAX_ATTEMPTS;
    }

}
