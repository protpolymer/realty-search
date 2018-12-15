package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.ApartmentSale;
import ru.itpark.repository.ApartmentSaleRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentSaleServiceTest {
    ApartmentSaleService service;
    @BeforeEach
    void setUp(){
        ApartmentSaleRepository repository = new ApartmentSaleRepository();
        repository.add(new ApartmentSale(1, 100, 1, 1, 1, null, "Авиастроительный", 1_000_000, null, null));
        repository.add(new ApartmentSale(2, 100, 1, 1, 1, null, "Ново-Савиновский", 1_500_000, null, null));
        repository.add(new ApartmentSale(3, 100, 1, 1, 1, null, "Вахитовский", 3_000_000, null, null));
        repository.add(new ApartmentSale(4, 100, 1, 1, 1, null, "Авиастроительный", 1_200_000, null, null));
        service = new ApartmentSaleService(repository);
    }
    @Test
    void addWithOneResult() {
        service.add(new ApartmentSale(5, 100, 1, 1, 1, null, "Авиастроительный", 1_200_000, null, null));
        assertEquals(5, service.getAll().size());
    }

    @Test
    void addWithMultipleResult() {
        service.add(new ApartmentSale(5, 100, 1, 1, 1, null, "Авиастроительный", 1_200_000, null, null));
        service.add(new ApartmentSale(6, 100, 1, 1, 1, null, "Авиастроительный", 1_200_000, null, null));
        assertEquals(6, service.getAll().size());
    }
    @Test
    void getAll() {
        assertEquals(4, service.getAll().size());
    }

    @Test
    void findByDistrictWithZeroResult() {
        {
            List<ApartmentSale> result = service.findByDistrict("Кировский");
            assertEquals(0, result.size());
        }
        {
            List<ApartmentSale> result = service.findByDistrict("Кировский", "Приволжский");
            assertEquals(0, result.size());
        }
    }
    @Test
    void findByDistrictWithOneResult() {
        List<ApartmentSale> result = service.findByDistrict("Вахитовский");
        assertEquals(1, result.size());
    }

    @Test
    void findByDistrictWithMultipleResult() {
        List<ApartmentSale> result = service.findByDistrict("Авиастроительный");
        assertEquals(2, result.size());
    }


}