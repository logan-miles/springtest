package com.dev.cicd.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DataControllerTests {
    DataController dc;

    @BeforeAll
    public void setup() {
        dc = new DataController();
    }

    @Test
    public void healthCheckShouldReturnOk() {
        assertEquals("HEALTH CHECK OK!", dc.healthCheck());
    }
}
