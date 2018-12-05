package ru.itpark.service;

import ru.itpark.domain.ApartmentSale;
import ru.itpark.repository.ApartmentSaleRepository;

import java.util.Comparator;
import java.util.List;

public class ApartmentSaleService {
    private ApartmentSaleRepository repository;

    public ApartmentSaleService(ApartmentSaleRepository repository) {
        this.repository = repository;
    }

    public void add(ApartmentSale apartmentSale){
        repository.add(apartmentSale);
    }
    public List<ApartmentSale> getAll(){
        return repository.getAll();
    }
    public List<ApartmentSale> getSortedCost(Comparator<ApartmentSale> comparator){
        List<ApartmentSale> result = repository.getAll();
        result.sort(comparator);
        return result;
    }
    public ApartmentSaleService getApartmentSaleFilterDistrict(String district){
        ApartmentSaleService result = new ApartmentSaleService(new ApartmentSaleRepository());
        for (ApartmentSale apartmentSale : repository.getAll()) {
            if(apartmentSale.getDistrict().equalsIgnoreCase(district)){
                result.add(apartmentSale);
            }
        }
        return result;
    }
}
