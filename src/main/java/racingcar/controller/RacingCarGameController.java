package racingcar.controller;

import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;

public class RacingCarGameController {

    private final RacingCarGameService racingCarGameService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(RacingCarGameService racingCarGameService, InputView inputView, OutputView outputView) {
        this.racingCarGameService = racingCarGameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = getCarNames();
        LinkedHashMap<String, Integer> racingProgressStatus = racingCarGameService.initializeRacingProgressStatus(carNames);
        int attemptCount = getAttemptCount();
        playRacingCarGame(attemptCount, carNames, racingProgressStatus);
        announceWinners(racingProgressStatus);
    }

    private List<String> getCarNames() {
        outputView.printInputRacingCarNamesMessage();
        return inputView.readCarNames();
    }

    private int getAttemptCount() {
        outputView.printInputAttemptCountMessage();
        return inputView.readAttemptCount();
    }

    private void playRacingCarGame(int attemptCount, List<String> carNames, LinkedHashMap<String, Integer> racingProgressStatus) {
        System.out.println();
        outputView.printExecutionResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            racingCarGameService.playSingleGame(carNames, racingProgressStatus);
            outputView.printExecutionResult(racingProgressStatus);
        }
    }

    private void announceWinners(LinkedHashMap<String, Integer> racingProgressStatus) {
        List<String> winners = racingCarGameService.getWinners(racingProgressStatus);
        outputView.printWinners(winners);
    }
}
