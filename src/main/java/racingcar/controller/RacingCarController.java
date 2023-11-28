package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.service.RacingCarService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setUp();
        play();
        printWinners();
    }

    private void setUp() {
        String inputCars = inputView.readCarNames();
        Cars cars = new Cars(inputCars);
        racingCarService = new RacingCarService(cars);
    }

    private int getAttemptCount() {
        return new AttemptCount(inputView.readAttemptCount()).getAttemptCount();
    }

    private void play() {
        int attemptCount = getAttemptCount();
        outputView.printExecutionResultFormat();
        RandomNumberGenerator generator = new RandomNumberGenerator();
        for (int i = 0; i < attemptCount; i++) {
            for (String carName : racingCarService.getCars()) {
                racingCarService.checkMoveForward(generator.execute(), carName);
            }
            printOneAttemptResult();
        }
    }

    private void printOneAttemptResult() {
        outputView.printProgressInformation(racingCarService.getOneAttemptResult());
    }

    private void printWinners() {
        outputView.printProgressInformation(racingCarService.getWinners());
    }
}
