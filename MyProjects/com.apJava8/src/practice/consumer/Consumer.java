package practice.consumer;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

@FunctionalInterface
public interface Consumer <T>{
    void accept(T paramT);
    default Consumer<T> andThen(Consumer<? super T> paramConsumer){
        Objects.requireNonNull(paramConsumer);
        return paramObject -> {
            accept(paramObject);
            paramConsumer.accept(paramObject);
        };
    }
}
