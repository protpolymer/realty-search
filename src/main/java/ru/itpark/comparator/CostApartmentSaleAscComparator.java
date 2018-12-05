package ru.itpark.comparator;

import ru.itpark.domain.ApartmentSale;

import java.util.Comparator;

public class CostApartmentSaleAscComparator implements Comparator<ApartmentSale> {
    @Override
    public int compare(ApartmentSale o1, ApartmentSale o2) {
        return -(o1.getCost() - o2.getCost());
    }
}
