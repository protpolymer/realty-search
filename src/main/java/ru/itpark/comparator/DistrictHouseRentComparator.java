package ru.itpark.comparator;

import ru.itpark.domain.HouseRent;

import java.util.Comparator;

public class DistrictHouseRentComparator implements Comparator<HouseRent> {
    @Override
    public int compare(HouseRent o1, HouseRent o2) {
        return o1.getDistrict().compareTo(o2.getDistrict());
    }
}
