package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.HouseSale;
import ru.itpark.repository.HouseSaleRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseSaleServiceTest {
    HouseSaleService service;
    @BeforeEach
    void setUp() {
        HouseSaleRepository repository = new HouseSaleRepository();
        repository.add(new HouseSale(1, 2, 120_000, null, "Авиастроительный", 4_000_000, null, null));
        repository.add(new HouseSale(2, 1, 80_000, null, "Ново-Савиновский", 3_600_000, null, null));
        repository.add(new HouseSale(3, 2, 120_000, null, "Вахитовский", 12_000_000, null, null));
        repository.add(new HouseSale(4, 2, 150_000, null, "Ново-Савиновский", 5_000_000, null, null));
        service = new HouseSaleService(repository);
    }

    @Test
    void addWithOneResult() {
        service.add(new HouseSale(5, 2, 150_000, null, "Ново-Савиновский", 5_000_000, null, null));
        int result = service.getAll().size();
        assertEquals(5, result);
    }
    @Test
    void addWithMultipleResult() {
        service.add(new HouseSale(5, 2, 150_000, null, "Ново-Савиновский", 5_000_000, null, null));
        service.add(new HouseSale(6, 2, 150_000, null, "Ново-Савиновский", 5_000_000, null, null));
        int result = service.getAll().size();
        assertEquals(6, result);
    }

    @Test
    void getAll() {
        int result = service.getAll().size();
        assertEquals(4, result);
    }

    @Test
    void findByDistrictWithZeroResult() {
        {
            List<HouseSale> result = service.findByDistrict("Кировский");
            assertEquals(0, result.size());
        }
        {
            List<HouseSale> result = service.findByDistrict("Мытищинский");
            assertEquals(0, result.size());
        }
    }
    @Test
    void findByDistrictWithOneResult() {
        {
            List<HouseSale> result = service.findByDistrict("Вахитовский");
            assertEquals(1, result.size());
        }
        {
            List<HouseSale> result = service.findByDistrict("Авиастроительный");
            assertEquals(1, result.size());
        }
    }
    @Test
    void findByDistrictWithMultipleResult() {
        List<HouseSale> result = service.findByDistrict("Ново-Савиновский");
        assertEquals(2, result.size());

    }
}