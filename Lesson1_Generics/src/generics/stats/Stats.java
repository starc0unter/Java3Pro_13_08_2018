package generics.stats;

import java.io.Serializable;

public class Stats<T extends Number & Serializable> {

    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<?> another) {
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Stats<Integer> integerStats = new Stats<>(ints);
        System.out.println("AVG for int is " + integerStats.avg());

        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> doubleStats = new Stats<>(doubles);
        System.out.println("AVG for double is " + doubleStats.avg());

        System.out.println(integerStats.sameAvg(doubleStats));

    }
}
