package com.karma.practice.demo.CircularBuffer;

public class CircularBuffer<T> {
    private T[] buffer;
    private int readCursor;
    private int writeCursor;

    public CircularBuffer(int size) {
        buffer = (T[]) new Object[size];
    }

    public boolean offer(T value) {
        if(buffer[writeCursor]!= null) {
            return false;
        }
        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    private int next(int index) {
        return (index+1) % buffer.length;
    }

    public T poll() {
        final T value = buffer[readCursor];
        if(value!=null) {
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }
        return value;
    }
}
