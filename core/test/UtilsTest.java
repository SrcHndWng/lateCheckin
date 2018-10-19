package com.latecheckin;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void transferToRomaji() {
        String result = "";
        result = Utils.transferToRomaji("日本");
        System.out.println(result);
        assertEquals("Nippon", result);

        result = Utils.transferToRomaji("新宿区");
        System.out.println(result);
        assertEquals("ShinjukuKu", result);

        result = Utils.transferToRomaji("東京都新宿区");
        System.out.println(result);
        assertEquals("ToukyouToShinjukuKu", result);
    }
}

