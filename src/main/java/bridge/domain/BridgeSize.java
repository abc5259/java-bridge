package bridge.domain;

public record BridgeSize(
        int size
) {

    public BridgeSize {
        validateBridgeSize(size);
    }

    public void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
