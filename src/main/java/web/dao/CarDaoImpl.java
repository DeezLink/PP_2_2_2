package web.dao;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    public int count = 0;

    private final List<Car> carList;

    public CarDaoImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("ГАЗ 3109", "белый", 1985));
        carList.add(new Car("ВАЗ 2109", "красный", 1990));
        carList.add(new Car("УАЗ 469", "серый", 1975));
        carList.add(new Car("ЗАЗ 968", "жёлый", 1970));
        carList.add(new Car("ЛУАЗ 969", "синий", 1980));
    }

    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarCount(int count) {
        if (count==0||count>=5) {
            return carList;
        }
        List<Car> carCount = carList.subList(0,count);
        return carCount;
    }
}

