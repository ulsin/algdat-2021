package timeThurUke33;

public class Kortstokk {
    public static void main(String[] args) {
        int[] values = {9, 13, 5, 10};
        System.out.println(findMin(values));

    }

    static int findMin(int[] innArr) {
        int index = 0;
        int minVal = innArr[0];

        for (int i = 1; i < innArr.length; i++) {
            if (innArr[i] < minVal) {
                minVal = innArr[i];
                index = i;
            }
        }

        return index;
    }
}
