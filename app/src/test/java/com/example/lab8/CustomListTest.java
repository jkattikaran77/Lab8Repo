package com.example.lab8;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * Set up the mock list before each test
     */
    @BeforeEach
    public void setUp() {
        list = MockCityList();
    }

    /**
     * Create a mock list for my city list
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void testHasCity() {
        City city = new City("Edmonton", "AB");
        assertFalse(list.hasCity(city)); // Should return false initially
        list.addCity(city);
        assertTrue(list.hasCity(city)); // Should return true after adding the city
    }

    @Test
    public void testDeleteCity() {
        City city = new City("Calgary", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city)); // Verify the city was added
        list.deleteCity(city);
        assertFalse(list.hasCity(city)); // Verify the city was deleted
    }

    @Test
    public void testCountCities() {
        assertEquals(0, list.getCount()); // Should initially be 0
        list.addCity(new City("Red Deer", "AB"));
        assertEquals(1, list.getCount()); // Should increment to 1
        list.addCity(new City("Banff", "AB"));
        assertEquals(2, list.getCount()); // Should increment to 2
    }
}
