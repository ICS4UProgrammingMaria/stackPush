package stackPush;

public interface stackPushInterface<T> {
    boolean push(T value);

    T pop();

    boolean contains (T value);
    int size();
    void clear();
    boolean isEmpty();



}
