package bridge.converter;

import bridge.domain.BridgeSize;

public class StringToBridgeSizeConverter implements Converter<String, BridgeSize> {
    @Override
    public BridgeSize convert(String source) {
        try {
            return new BridgeSize(Integer.parseInt(source.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }
}
