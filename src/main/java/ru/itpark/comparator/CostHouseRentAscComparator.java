package ru.itpark.comparator;

import ru.itpark.domain.HouseRent;

import java.util.Comparator;

public class CostHouseRentAscComparator implements Comparator<HouseRent> {
    @Override
    public int compare(HouseRent o1, HouseRent o2) {
        return -(o1.getCost() - o2.getCost());
    }
}
