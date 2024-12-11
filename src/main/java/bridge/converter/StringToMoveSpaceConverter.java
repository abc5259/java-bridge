package bridge.converter;

import bridge.domain.MoveSpace;

public class StringToMoveSpaceConverter implements Converter<String, MoveSpace> {
    @Override
    public MoveSpace convert(String source) {
        return MoveSpace.findBySymbol(source.trim());
    }
}
