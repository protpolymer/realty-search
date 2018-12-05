package ru.itpark.comparator;

import ru.itpark.domain.HouseSale;

import java.util.Comparator;

public class DistrictHouseSaleComparator implements Comparator<HouseSale> {

    @Override
    public int compare(HouseSale o1, HouseSale o2) {
        return o1.getDistrict().compareTo(o2.getDistrict());
    }
}
