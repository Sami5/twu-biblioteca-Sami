package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void testMainMenu() {
        assertEquals("List Books", MainMenu.getMenuItem(0));
    }
}
