package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int tryCount;
    private int currSpace;
    private List<MoveHistory> moveHistories;
    private final Bridge bridge;

    public BridgeGame(int tryCount, int currSpace, List<MoveHistory> moveHistories, Bridge bridge) {
        this.tryCount = tryCount;
        this.currSpace = currSpace;
        this.moveHistories = moveHistories;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(MoveSpace moveSpace) {
        if (!bridge.isMovable(currSpace, moveSpace)) {
            moveHistories.add(new MoveHistory(moveSpace, false));
            return false;
        }

        currSpace++;
        moveHistories.add(new MoveHistory(moveSpace, true));
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currSpace = 1;
        tryCount++;
        moveHistories = new ArrayList<>();
    }

    public List<MoveHistory> getMoveHistories() {
        return moveHistories;
    }

    public boolean isGameOver() {
        return bridge.isFinish(currSpace);
    }

    public int getTryCount() {
        return tryCount;
    }
}
