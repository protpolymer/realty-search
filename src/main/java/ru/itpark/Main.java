package ru.itpark;

import ru.itpark.comparator.*;
import ru.itpark.domain.ApartmentRent;
import ru.itpark.domain.ApartmentSale;
import ru.itpark.domain.HouseRent;
import ru.itpark.domain.HouseSale;
import ru.itpark.repository.ApartmentRentRepository;
import ru.itpark.repository.ApartmentSaleRepository;
import ru.itpark.repository.HouseRentRepository;
import ru.itpark.repository.HouseSaleRepository;
import ru.itpark.service.ApartmentRentService;
import ru.itpark.service.ApartmentSaleService;
import ru.itpark.service.HouseRentService;
import ru.itpark.service.HouseSaleService;

public class Main {
    public static void main(String[] args) {
        ApartmentRentService apartmentRentService = new ApartmentRentService(new ApartmentRentRepository());
        ApartmentSaleService apartmentSaleService = new ApartmentSaleService(new ApartmentSaleRepository());
        HouseRentService houseRentService = new HouseRentService(new HouseRentRepository());
        HouseSaleService houseSaleService = new HouseSaleService(new HouseSaleRepository());

        apartmentRentService.add(new ApartmentRent(1, 35, 1, 5, 1, "Казань", "Вахитовский", 15_000, "ООО Риелтор", "..."));
        apartmentRentService.add(new ApartmentRent(2, 50, 3, 5, 2, "Казань", "Вахитовский", 25_000, "ООО Риелтор", "..."));
        apartmentRentService.add(new ApartmentRent(3, 32, 5, 5, 1, "Казань", "Вахитовский", 15_000, "ООО Риелтор", "..."));
        apartmentRentService.add(new ApartmentRent(4, 120, 1, 2, 4, "Казань", "Ново-Савиновский", 55_000, "ООО Риелтор", "..."));
        apartmentRentService.add(new ApartmentRent(5, 100, 1, 1, 3, "Казань", "Авиастроительный", 35_000, "ООО Риелтор", "..."));

        apartmentSaleService.add(new ApartmentSale(1, 35, 1, 5, 1, "Казань", "Вахитовский", 2_900_000, "ООО Риелтор", "..."));
        apartmentSaleService.add(new ApartmentSale(2, 50, 3, 5, 2, "Казань", "Вахитовский", 2_225_000, "ООО Риелтор", "..."));
        apartmentSaleService.add(new ApartmentSale(3, 32, 5, 5, 1, "Казань", "Вахитовский", 1_500_000, "ООО Риелтор", "..."));
        apartmentSaleService.add(new ApartmentSale(4, 120, 1, 2, 4, "Казань", "Ново-Савиновский", 5_505_000, "ООО Риелтор", "..."));
        apartmentSaleService.add(new ApartmentSale(5, 100, 1, 1, 3, "Казань", "Авиастроительный", 3_305_000, "ООО Риелтор", "..."));

        houseRentService.add(new HouseRent(1, 2, 39, "Казань", "Ново-Савиновский", 25_000, "Филлип", "двушка на окраине"));
        houseRentService.add(new HouseRent(2, 2, 39, "Казань", "Ново-Савиновский", 23_000, "Кирилл", "двушка на окраине"));
        houseRentService.add(new HouseRent(3, 1, 25, "Казань", "Авиастроительный", 12_000, "Кирилл", "однушка на окраине"));
        houseRentService.add(new HouseRent(4, 3, 81, "Москва", "Мытищинский", 32_000, "ООО Прибыль", "трешка в Мытищах"));
        houseRentService.add(new HouseRent(5, 2, 65, "Казань", "Вахитовский", 30_000, "ООО Прибыль", "трешка в Мытищах"));

        houseSaleService.add(new HouseSale(1, 2, 39, "Казань", "Ново-Савиновский", 3_300_000, "Филлип", "двушка на окраине"));
        houseSaleService.add(new HouseSale(2, 2, 39, "Казань", "Ново-Савиновский", 2_400_000, "Кирилл", "двушка на окраине"));
        houseSaleService.add(new HouseSale(3, 1, 25, "Казань", "Авиастроительный", 1_800_000, "Кирилл", "однушка на окраине"));
        houseSaleService.add(new HouseSale(4, 3, 81, "Москва", "Мытищинский", 5_800_000, "ООО Прибыль", "трешка в Мытищах"));
        houseSaleService.add(new HouseSale(5, 2, 65, "Казань", "Вахитовский", 5_800_000, "ООО Прибыль", "трешка в Мытищах"));

        System.out.println(apartmentRentService.getAll());
        System.out.println(apartmentRentService.getSortedCost(new CostApartmentRentAscComparator()));
        System.out.println(apartmentRentService.getApartmentRentFilterDistrict("вахитовский").getSortedCost(new CostApartmentRentDescComparator()));

        System.out.println(apartmentSaleService.getAll());
        System.out.println(apartmentSaleService.getSortedCost(new CostApartmentSaleAscComparator()));
        System.out.println(apartmentRentService.getApartmentRentFilterDistrict("авиастроительный").getSortedCost(new CostApartmentRentDescComparator()));

        System.out.println(houseRentService.getAll());
        System.out.println(houseRentService.getSortedCost(new CostHouseRentDescComparator()));
        System.out.println(houseRentService.getFilterDistrict("авиастроительный").getSortedCost(new CostHouseRentAscComparator()));

        System.out.println(houseSaleService.getAll());
        System.out.println(houseSaleService.getSortedCost(new CostHouseSaleAscComparator()));
        System.out.println(houseSaleService.getFilterDistrict("ново-савиновский").getSortedCost(new CostHouseSaleDescComparator()));
    }
}
