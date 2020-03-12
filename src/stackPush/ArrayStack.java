package stackPush;

import java.util.Arrays;

public class ArrayStack<T> implements stackPushInterface {

    private static final int DEFAULT_CAPACITY = 10;
    private  T[] store;
    private int size = 0;
    private int capacity;

    public ArrayStack(){
        capacity = DEFAULT_CAPACITY;
        store = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        store = (T[]) new Object[capacity];
    }

    @Override
    public boolean push(Object value) {
        if (size >= store.length)
        {
            int newSize = size + (size>>1);
            store = Arrays.copyOf(store, newSize);
        }
        store[size++] = (T) value;
        return true;
    }

    @Override
    public Object pop() {
        if(size <= 0)
            return null;
        T value = store[--size];
        store[size] = null;

        int reducedSize = size;

        if(size >= capacity && size < (reducedSize + (reducedSize << 1))) {
            System.arraycopy(store, 0, store,0, size);
        }
        return value;

    }

    @Override
    public boolean contains(Object value) {
        boolean found = false;
        for(int i = 0; i < size; i++){
            T element = store[i];

            if(element.equals(value))
                return true;
        }
        return found;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
