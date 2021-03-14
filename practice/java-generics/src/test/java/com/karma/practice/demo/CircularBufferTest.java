package com.karma.practice.demo;

import com.karma.practice.demo.CircularBuffer.CircularBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer(2);

    @Test
    @DisplayName("This method offer pollable Element")
    public void shouldOfferPollaleElement() {
        assertTrue(circularBuffer.offer(1));
        assertEquals(1,circularBuffer.poll());
        assertNull(circularBuffer.poll());
    }
    @Test
    @DisplayName("When the Buffer is full it will not offer element")
    public void shouldNotOfferWhenBufferIsFull() {
       assertTrue(circularBuffer.offer(1));
       assertTrue(circularBuffer.offer(2));
       assertFalse(circularBuffer.offer(3));
    }

    @Test
    @DisplayName("It should not be able to poll")
    public void shouldPollableWhenBufferIsEmpty() {
        assertNull(circularBuffer.poll());
    }

    @Test
    @DisplayName("It will empty the Buffer")
    public void shouldRecycleBuffer() {
        assertTrue(circularBuffer.offer(1));
        assertTrue(circularBuffer.offer(2));
        assertEquals(1,circularBuffer.poll());
        assertTrue(circularBuffer.offer(3));
        assertEquals(2,circularBuffer.poll());
        assertEquals(3,circularBuffer.poll());
    }

}
