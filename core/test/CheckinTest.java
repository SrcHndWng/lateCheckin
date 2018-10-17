package com.latecheckin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckinTest {
    @Test
    public void getLocations(){
        System.out.println("test execute!!");
        new Checkin().getLocations();
    }
}