package ru.itpark.domain;

public class HouseRent extends HouseSale {
    public HouseRent(int id, int amountFloors, int area, String settlement, String district, int cost, String owner, String description) {
        super(id, amountFloors, area, settlement, district, cost, owner, description);
    }

}
