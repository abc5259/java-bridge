package bridge.view;

import bridge.domain.MoveHistory;
import bridge.domain.MoveSpace;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<MoveHistory> moveHistories) {
        String up = moveHistories.stream()
                .map(moveHistory -> {
                    if (moveHistory.moveSpace() == MoveSpace.UP && moveHistory.isSuccess()) {
                        return "O";
                    }
                    if (moveHistory.moveSpace() == MoveSpace.UP) {
                        return "X";
                    }
                    return " ";
                })
                .collect(Collectors.joining(" | "));

        String down = moveHistories.stream()
                .map(moveHistory -> {
                    if (moveHistory.moveSpace() == MoveSpace.DOWN && moveHistory.isSuccess()) {
                        return "O";
                    }
                    if (moveHistory.moveSpace() == MoveSpace.DOWN) {
                        return "X";
                    }
                    return " ";
                })
                .collect(Collectors.joining(" | "));

        System.out.println("[ " + up + " ]");
        System.out.println("[ " + down + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
