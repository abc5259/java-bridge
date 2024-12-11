package bridge.controller;


import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;
import bridge.view.OutputView;
import java.util.List;

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
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.size());
        
    }
}
