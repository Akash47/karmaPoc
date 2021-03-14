package com.karma.practice.demo.CircularBuffer.demo;

import com.karma.practice.demo.CircularBuffer.CircularBuffer;
import com.karma.practice.demo.CircularBuffer.StringCircularBuffer;

public class TypeUnsafeExample {

    public static void main(String[] args) {
        CircularBuffer<String> buffer = new CircularBuffer<String>(10);
        buffer.offer("a");
        buffer.offer("b");
        buffer.offer("c");
        buffer.offer("d");

       // buffer.offer(1);
        String str = concate(buffer);
        System.out.println(str);
    }

    private static String concate(CircularBuffer<String> buffer) {
        StringBuilder result = new StringBuilder();
        String value;
        while ((value = buffer.poll())!=null) {
            result.append(value);
        }
        return result.toString();
    }

}
