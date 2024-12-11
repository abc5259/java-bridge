package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeConfig bridgeConfig = new BridgeConfig();
        BridgeController bridgeController = bridgeConfig.bridgeController();
        bridgeController.process();
    }
}
