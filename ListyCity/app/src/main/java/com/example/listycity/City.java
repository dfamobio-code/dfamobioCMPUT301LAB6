package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a city.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /**
     * This compares two city objects by their city names
     * @param o
     * This is the other city object we are comparing to
     * @return
     * Return a negative number, zero, or a positive number depending on
     * whether this city name comes before, is equal to, or comes after the other city name
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Two cities are considered equal if they have the same city name and province name
     * @param o
     * The object we are comparing this city to
     * @return
     * Return true if both city and province names match, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) &&
                Objects.equals(province, city1.province);
    }

    /**
     * This generates a hash code for the city object
     * @return
     * Return the hash code based on city and province
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
