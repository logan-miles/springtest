package com.dev.cicd.data;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Currency;
import com.github.javafaker.Faker;
import com.github.javafaker.Nation;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class DataController {
    @GetMapping("/")
    public String healthCheck() {
        return "HEALTH CHECK OK!";
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.1";
    }

    @GetMapping("/nations")
    public JsonElement getRandomNations() {
        Faker faker = new Faker(new Locale("en-US"));
        
        JsonArray nations = new JsonArray();
        for (int i = 0; i < 10; i++) {
            Nation nation = faker.nation();
            JsonObject jNation = new JsonObject();
            jNation.addProperty("nationality", nation.nationality());
            jNation.addProperty("capitalCity", nation.capitalCity());
            jNation.addProperty("flag", nation.flag());
            jNation.addProperty("language", nation.language());

            nations.add(jNation);
        }

        return nations;
    }

    @GetMapping("/currencies")
    public JsonElement getRandomCurrencies() {
        Faker faker = new Faker(new Locale("en-US"));
        JsonArray currencies = new JsonArray();

        for (int i = 0; i < 20; i++) {
            Currency currency = faker.currency();

            JsonObject jCurrency = new JsonObject();
            jCurrency.addProperty("name", currency.name());
            jCurrency.addProperty("code", currency.code());

            currencies.add(jCurrency);
        }

        return currencies;
    }
}
