package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }


    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City present = new City("Edmonton", "Alberta");
        City absent = new City("Calgary", "Alberta");

        assertTrue(cityList.hasCity(present));
        assertFalse(cityList.hasCity(absent));
    }

    @Test
    void testDeleteRemoves() {
        CityList cityList = mockCityList();
        City c = new City("Regina", "Saskatchewan");
        cityList.add(c);

        assertTrue(cityList.hasCity(c));
        cityList.delete(c);

        assertFalse(cityList.hasCity(c));
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City notInList = new City("Toronto", "Ontario");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(notInList);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "Alberta"));
        cityList.add(new City("Calgary", "Alberta"));

        assertEquals(2, cityList.countCities());
    }

    @Test
    void testGetCitiesSorted() {
        CityList cityList = new CityList();
        cityList.add(new City("Toronto", "Ontario"));
        cityList.add(new City("Calgary", "Alberta"));
        cityList.add(new City("Edmonton", "Alberta"));

        assertEquals("Calgary", cityList.getCities().get(0).getCityName());
        assertEquals("Edmonton", cityList.getCities().get(1).getCityName());
        assertEquals("Toronto", cityList.getCities().get(2).getCityName());
    }
}
