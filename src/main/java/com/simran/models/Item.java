package com.simran.models;

import java.util.UUID;

public class Item
{
    private String id;
    private String name;
    private double cost;

    public Item(String name, double cost) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
