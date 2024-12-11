package bridge.controller;


import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;
import bridge.domain.MoveSpace;
import bridge.domain.Retry;
import bridge.view.OutputView;
import java.util.ArrayList;

public class BridgeController {

    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public BridgeController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printGameStartMessage();
        BridgeSize bridgeSize = iteratorInputHandler.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.size()));

        BridgeGame bridgeGame = new BridgeGame(1, 1, new ArrayList<>(), bridge);

        boolean isContinue = true;
        do {
            MoveSpace moveSpace = iteratorInputHandler.inputMoveSpace();
            boolean result = bridgeGame.move(moveSpace);
            outputView.printMap(bridgeGame.getMoveHistories());

            if (!result) { //재시도 하기
                Retry retry = iteratorInputHandler.inputRetry();
                if (retry == Retry.RETRY) {
                    bridgeGame.retry();
                    continue;
                }
                outputView.printResult(false, bridgeGame.getTryCount(), bridgeGame.getMoveHistories());
                isContinue = false;
            }

            if (bridgeGame.isGameOver()) {
                outputView.printResult(true, bridgeGame.getTryCount(), bridgeGame.getMoveHistories());
                isContinue = false;
            }
        } while (isContinue);
    }
}
