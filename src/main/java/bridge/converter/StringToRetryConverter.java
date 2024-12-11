package bridge.converter;

import bridge.domain.Retry;

public class StringToRetryConverter implements Converter<String, Retry> {
    @Override
    public Retry convert(String source) {
        return Retry.findBySymbol(source.trim());
    }
}
