import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @org.junit.Test
    public void testRotateBy() throws Exception {
        {
            int[] expected = {6, 1, 2, 3, 4, 5};
            int[] original = {1, 2, 3, 4, 5, 6};
            testRotation(expected, 1, original);
        }

        {
            int[] expected = {2, 3, 4, 5, 6, 1};
            int[] original = {1, 2, 3, 4, 5, 6};
            testRotation(expected, 5, original);
        }

        {
            int[] expected = {6, 1, 2, 3, 4, 5};
            int[] original = {1, 2, 3, 4, 5, 6};
            testRotation(expected, 7, original);
        }

        {
            int[] expected = {1, 2, 3, 4, 5, 6};
            int[] original = {1, 2, 3, 4, 5, 6};
            testRotation(expected, 6, original);
        }

        {
            int[] expected = {4, 5, 6, 1, 2, 3};
            int[] original = {1, 2, 3, 4, 5, 6};
            testRotation(expected, 3, original);
        }

        {
            int[] expected = {3, 4, 5, 6, 7, 8, 1, 2};
            int[] original = {1, 2, 3, 4, 5, 6, 7, 8};
            testRotation(expected, 6, original);
        }

        {
            int[] expected = null;
            int[] original = null;
            testRotation(expected, 3, original);
        }

        {
            int[] expected = {};
            int[] original = {};
            testRotation(expected, 3, original);
        }

        {
            int[] expected = {1};
            int[] original = {1};
            testRotation(expected, 3, original);
        }

        {
            int[] expected = {2, 1};
            int[] original = {1, 2};
            testRotation(expected, 3, original);
        }

        {
            int[] expected = {1, 2};
            int[] original = {1, 2};
            testRotation(expected, 0, original);
        }

        {
            int[] expected = {2, 1};
            int[] original = {1, 2};
            testRotation(expected, -3, original);
        }

        {
            int[] expected = {2, 3, 4, 5, 1};
            int[] original = {1, 2, 3, 4, 5};
            testRotation(expected, -1, original);
        }

        {
            int[] expected = {5, 1, 2, 3, 4};
            int[] original = {1, 2, 3, 4, 5};
            testRotation(expected, -4, original);
        }
    }

    private void testRotation(int[] expected, int rotation, int[] original) {
        int[] actuals = ArrayUtils.rotateBy(rotation, original);
        assertArrayEquals("expected: " + Arrays.toString(expected) + ", r: " + rotation + " , actual: " + Arrays.toString(actuals), expected, actuals);
    }


}