package ru.itpark.service;

import ru.itpark.domain.HouseSale;
import ru.itpark.repository.HouseSaleRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HouseSaleService{
    private HouseSaleRepository repository;

    public HouseSaleService(HouseSaleRepository repository){
        this.repository = repository;
    }

    public void add(HouseSale houseSale){
        repository.add(houseSale);
    }

    public List<HouseSale> getAll(){
        return repository.getAll();
    }

    public List<HouseSale> getSortedCost(Comparator<HouseSale> comparator){
        List<HouseSale> result = repository.getAll();
        result.sort(comparator);
        return result;
    }
    public List<HouseSale> findByDistrict(String... districts) {
        List<HouseSale> result = new ArrayList<>();
        List<String> districtList = Arrays.asList(districts);
        for (HouseSale houseSale : repository.getAll()) {
            if (districtList.contains(houseSale.getDistrict())) {
                result.add(houseSale);
            }
        }
        return result;
    }
}
