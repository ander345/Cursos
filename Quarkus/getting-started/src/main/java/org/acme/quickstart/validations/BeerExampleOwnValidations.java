package org.acme.quickstart.validations;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class BeerExampleOwnValidations {

    @NotNull
    @NotBlank
    private String name;
    @Min(100)
    private int capacity;

    @NotExpired
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expired;


    public BeerExampleOwnValidations() {
    }

    public BeerExampleOwnValidations(String name, int capacity, LocalDate expired) {
        this.name = name;
        this.capacity = capacity;
        this.expired = expired;
    }

    public BeerExampleOwnValidations(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public @NotExpired LocalDate getExpired() {
        return expired;
    }

    public void setExpired(@NotExpired LocalDate expired) {
        this.expired = expired;
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
        return "BeerExampleOwnValidations{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", expired=" + expired +
                '}';
    }
}
