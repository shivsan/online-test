import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LongestValidParenthesesTest {

    private LongestValidParentheses longestValidParanthesis;

    @Before
    public void init() {
        this.longestValidParanthesis = new LongestValidParentheses();
    }

    @Test
    public void shouldGetLongestValidParenthesisWhenStartOfStringHasNoValidParenthesis() {
        int result = longestValidParanthesis.getLongest("(()");
        assertEquals(2, result);
    }

    @Test
    public void shouldGetLongestValidParenthesisWhenEndOfStringHasNoValidParenthesis() {
        int result = longestValidParanthesis.getLongest("())");
        assertEquals(2, result);
    }

    @Test
    public void shouldGetLongestValidParenthesisWhenBordersHaveNoValidParenthesis() {
        int result = longestValidParanthesis.getLongest("()(()))))");
        assertEquals(6, result);
    }

    @Test
    public void shouldGetLongestValidParenthesisWhenhavingNestedParenthesis() {
        int result = longestValidParanthesis.getLongest("()(()))))");
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnValidParenthesisIndexesForSingleParenthesisPair() {
        ValidStringIndexes indexes = longestValidParanthesis.getFirstValidStringIndexes("()", 0, 2);
        assertEquals(0, indexes.startIndex);
        assertEquals(1, indexes.endIndex);
    }

    @Test
    public void shouldReturnValidParenthesisIndexesWhenEndOfStringIsNotValid() {
        ValidStringIndexes indexes1 = longestValidParanthesis.getFirstValidStringIndexes("()(", 0, 3);
        assertEquals(0, indexes1.startIndex);
        assertEquals(1, indexes1.endIndex);
    }

    @Test
    public void shouldReturnValidParenthesisIndexesWhenStartOfStringIsNotValid() {
        ValidStringIndexes indexes2 = longestValidParanthesis.getFirstValidStringIndexes("(()", 0, 2);
        assertEquals(1, indexes2.startIndex);
        assertEquals(2, indexes2.endIndex);
    }

    @Test
    public void shouldReturnValidParenthesisIndexesWhenBorderOfStringIsNotValid() {
        ValidStringIndexes indexes3 = longestValidParanthesis.getFirstValidStringIndexes(")()())", 0, 5);
        assertEquals(1, indexes3.startIndex);
        assertEquals(2, indexes3.endIndex);
    }

    @Test
    public void shouldReturnValidParenthesisIndexesWhenHavingNestedValidParenthesis() {
        ValidStringIndexes indexes4 = longestValidParanthesis.getFirstValidStringIndexes(")(())())", 0, 8);
        assertEquals(1, indexes4.startIndex);
        assertEquals(4, indexes4.endIndex);
    }

    @Test
    public void shouldReturnValidParenthesisIndexesWhenHavingNestedValidParenthesisWithNonZeroStartingIndex() {
        ValidStringIndexes indexes4 = longestValidParanthesis.getFirstValidStringIndexes(")(())())", 2, 8);
        assertEquals(2, indexes4.startIndex);
        assertEquals(3, indexes4.endIndex);
    }
}