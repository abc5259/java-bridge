package bridge.domain;

import java.util.Arrays;

public enum MoveSpace {
    UP("U"), DOWN("D");

    private final String symbol;

    MoveSpace(String symbol) {
        this.symbol = symbol;
    }

    public static MoveSpace findBySymbol(String symbol) {
        return Arrays.stream(MoveSpace.values())
                .filter(moveSpace -> moveSpace.isEqualSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }

    private boolean isEqualSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
