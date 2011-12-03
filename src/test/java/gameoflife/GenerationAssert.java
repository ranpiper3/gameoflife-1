package gameoflife;

import gameoflife.game.Generation;
import org.fest.assertions.GenericAssert;

import java.util.Arrays;

public class GenerationAssert extends GenericAssert<GenerationAssert, Generation> {

    public GenerationAssert(Generation actual) {
        super(GenerationAssert.class, actual);
    }

    public GenerationAssert cellIsDeadAt(int x, int y) {
        isNotNull();
        if (!actual.isAliveAt(x, y)) return myself;
        failIfCustomMessageIsSet();
        throw failure("Expected dead cell at ( " + x + " / " + y + " )");
    }

    public GenerationAssert cellIsAlifeAt(int x, int y) {
        isNotNull();
        if (actual.isAliveAt(x, y)) return myself;
        failIfCustomMessageIsSet();
        throw failure("Expected living cell cell at ( " + x + " / " + y + " )");
    }

    public GenerationAssert nextGenerationIs(int... matrix) {
        isNotNull();
        final Generation next = actual.next();
        final int[] nextAsMatrix = next.toMatrix();
        if (Arrays.equals(nextAsMatrix, matrix)) return myself;
        failIfCustomMessageIsSet();
        throw failure("Next generation should be '" + Arrays.toString(matrix)  + " but is: " + Arrays.toString(nextAsMatrix) + "'.");
    }
}
