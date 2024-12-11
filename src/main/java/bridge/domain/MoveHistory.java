package bridge.domain;

public record MoveHistory(
        MoveSpace moveSpace,
        boolean isSuccess
) {
}
