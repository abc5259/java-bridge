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
    private static final String SUCCESS_FORMAT = "게임 성공 여부: %s%n";
    private static final String TRY_COUNT_FORMAT = "총 시도한 횟수: %d%n";

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
    public void printResult(boolean isSuccess, int tryCount, List<MoveHistory> moveHistories) {
        System.out.println("최종 게임 결과");
        printMap(moveHistories);
        System.out.println();
        if (isSuccess) {
            System.out.printf(SUCCESS_FORMAT, "성공");
            System.out.printf(TRY_COUNT_FORMAT, tryCount);
            return;
        }

        System.out.printf(SUCCESS_FORMAT, "실패");
        System.out.printf(TRY_COUNT_FORMAT, tryCount);
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }
}
