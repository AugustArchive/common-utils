package dev.floofy.utils.java.tests;

import dev.floofy.utils.java.SetOnceGetValue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class SetOnceGetValueTests {
    @Test
    public void test_valueByDefaultIsNull() {
        var setter = new SetOnceGetValue<String>();

        assertNull(setter.getValueOrNull());
        assertThrows(IllegalStateException.class, setter::getValue);
    }

    @Test
    public void test_setValue() {
        var setter = new SetOnceGetValue<String>();
        assertFalse(setter.wasSet());

        setter.setValue("owo da uwu");
        assertTrue(setter.wasSet());
        assertEquals("owo da uwu", setter.getValue());
        assertNotEquals("uwu da owo", setter.getValue());

        setter.setValue("heck");
        assertTrue(setter.wasSet());
        assertEquals("owo da uwu", setter.getValue());
        assertNotEquals("heck", setter.getValue());
    }
}
