package bridge.controller;


import bridge.domain.BridgeSize;
import bridge.view.OutputView;

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
    }
}
