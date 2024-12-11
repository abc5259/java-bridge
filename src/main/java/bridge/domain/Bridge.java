package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<MoveSpace> bridges;

    public Bridge(List<String> bridges) {
        this.bridges = bridges.stream().map(MoveSpace::findBySymbol).toList();
    }

    public boolean isMovable(int space, MoveSpace moveSpace) {
        return bridges.get(space - 1) == moveSpace;
    }

    public boolean isFinish(int currSpace) {
        return bridges.size() < currSpace;
    }
}
