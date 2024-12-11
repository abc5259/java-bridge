package bridge.domain;

import java.util.Arrays;

public enum Retry {
    RETRY("R"), QUIT("Q");

    private final String symbol;

    Retry(String symbol) {
        this.symbol = symbol;
    }

    public static Retry findBySymbol(String symbol) {
        return Arrays.stream(Retry.values())
                .filter(retry -> retry.isEqualSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }

    private boolean isEqualSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
