import java.util.Arrays;

public class ArrayUtils {

    /**
     * Rotates array items by n.
     * @param n volume of rotation
     * @param xs the integer array
     * @return the same array but with items rotated
     */
    public static int[] rotateBy(final int n, final int[] xs) {
        //handle trivial cases
        if (xs == null) return null;
        if (xs.length == 0) return xs;
        if ((n % xs.length) == 0) return xs;

        //normalize rotation number by the length of array
        int rotation = n % xs.length;  // so its not bigger
        if (rotation  < 0) rotation = xs.length + rotation; //so its positive

        int rotated = 0; //count how many were moved so we know when to stop

        int i = 0; //lets start with the first item in array and rotate "related" until we move them all
        while (rotated < xs.length) {
            rotated += rotateRelated(i, rotation, xs);
            i++; // in case we haven't moved all of them the next (i++) item wasn't moved yet
        }

        return xs;
    }

    /**
     * Rotates all items that sit on each others target positions, starting with the startingIndex.
     */
    private static int rotateRelated(final int startingIndex, int rotation, int[] xs) {
        int x = xs[startingIndex]; // contains the item being moved
        int i = (startingIndex + rotation) % xs.length; // the index to which the item x is being moved
        int count = 0; // count how many were moved
        while (i != startingIndex) {
            int y = xs[i];
            xs[i] = x; // store the item being moved
            count++;
            x = y; // remember replaced item
            i = (i + rotation) % xs.length; // rotate i
        }
        xs[i] = x; // store the last item
        count++;
        return count;
    }

    public static void main(String[] args) {
        int[] xs = {1,2,3,4,5,6};
        rotateBy(2, xs);
        System.out.print(Arrays.toString(xs));
    }
}


