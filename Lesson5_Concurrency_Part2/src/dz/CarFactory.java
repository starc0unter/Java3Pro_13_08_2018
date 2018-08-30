package dz;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CarFactory {

    private final CyclicBarrier waitForPrepareBarrier;
    private FinishNotifier finishNotifier;

    public CarFactory(int carCount, FinishNotifier finishNotifier) {
        this.waitForPrepareBarrier = new CyclicBarrier(carCount);
        this.finishNotifier = finishNotifier;
    }

    public Car create(Race race, int speed) {
        return new Car(race, speed, waitForPrepareBarrier, finishNotifier);
    }


}
