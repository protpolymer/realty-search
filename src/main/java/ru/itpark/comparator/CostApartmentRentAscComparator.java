package ru.itpark.comparator;

import ru.itpark.domain.ApartmentRent;

import java.util.Comparator;

public class CostApartmentRentAscComparator implements Comparator<ApartmentRent> {
    @Override
    public int compare(ApartmentRent o1, ApartmentRent o2) {
        return -(o1.getCost() - o2.getCost());
    }
}
