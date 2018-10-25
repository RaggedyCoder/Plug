package io.github.raggedycoder.plug.converter;

import io.github.raggedycoder.plug.Plug;
import io.github.raggedycoder.plug.exception.ConversionException;
import io.github.raggedycoder.plug.http.PlugRequestBody;
import io.github.raggedycoder.plug.http.PlugResponseBody;

import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface PlugConverter<From, To> {

    To converter(From from) throws ConversionException;

    abstract class Factory {
        @Nullable
        public PlugConverter<PlugResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                                        Plug plug) {
            return null;
        }

        @Nullable
        public PlugConverter<?, PlugRequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                                      Annotation[] methodAnnotations,
                                                                      Plug plug) {
            return null;
        }

        @Nullable
        public PlugConverter<?, String> stringConverter(Type type, Annotation[] annotations, Plug plug) {
            return null;
        }
    }
}
