package ru.itpark.comparator;

import ru.itpark.domain.ApartmentRent;

import java.util.Comparator;

public class CostApartmentRentDescComparator implements Comparator<ApartmentRent> {
    @Override
    public int compare(ApartmentRent o1, ApartmentRent o2) {
        return o1.getCost() - o2.getCost();
    }
}
