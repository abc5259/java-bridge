package bridge.controller;


import bridge.converter.StringToBridgeSizeConverter;
import bridge.domain.BridgeSize;
import bridge.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public BridgeSize readBridgeSize() {
        return iteratorInputTemplate.execute(
                inputView::readBridgeSize,
                new StringToBridgeSizeConverter()
        );
    }

}
