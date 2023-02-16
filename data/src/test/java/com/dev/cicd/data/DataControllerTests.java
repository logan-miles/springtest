package com.dev.cicd.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.google.gson.JsonElement;

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

    @Test
    void testVersionShouldBe1_0_0() {
        assertEquals("The actual version is 1.0.1", dc.version());
    }

    @Test
    void getRandomNationsShouldHaveNationalityCapitalFlagLanguage() {
        JsonElement nations = dc.getRandomNations();

        assertTrue(nations.isJsonArray());
        assertEquals(10, nations.getAsJsonArray().size());
    }

    @Test
    void testGetRandomCurrencies() {
        JsonElement currencies = dc.getRandomCurrencies();

        assertTrue(currencies.isJsonArray());
        assertEquals(20, currencies.getAsJsonArray().size());
        
    }
}
