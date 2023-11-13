// Ori Levy 318501897


/**
 * The type Counter.
 * counter that counts the game score
 */
public class Counter {
    private int num;

    /**
     * Increase.
     * add number to current count.
     * @param number the number to increase int
     */
    void increase(int number) {
        num = num + number;
    }

    /**
     * Decrease.
     * subtract number from current count
     * @param number the number to subtract
     */
    void decrease(int number) {
        num = num - number;
    }

    /**
     * Gets value.
     * get current count.
     * @return the value
     */
    int getValue() {
        return num;
    }
}