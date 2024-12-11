package bridge;


import bridge.controller.BridgeController;
import bridge.controller.IteratorInputHandler;
import bridge.controller.IteratorInputTemplate;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private IteratorInputHandler iteratorInputHandler;
    private BridgeController bridgeController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            iteratorInputHandler = new IteratorInputHandler(inputView(), iteratorInputTemplate());
        }
        return iteratorInputHandler;
    }

    public BridgeController bridgeController() {
        if (bridgeController == null) {
            bridgeController = new BridgeController(iteratorInputHandler(), outputView());
        }
        return bridgeController;
    }
}
