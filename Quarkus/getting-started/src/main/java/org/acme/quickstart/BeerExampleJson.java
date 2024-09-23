package org.acme.quickstart;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BeerExampleJson {

    @NotNull
    @NotBlank
    private String name;
    @Min(100)
    private int capacity;

    public BeerExampleJson() {
    }

    public BeerExampleJson(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "BeerExampleJson{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
