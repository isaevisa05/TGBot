package io.github.isaevisa05.TGBot.dao.car;

import io.github.isaevisa05.TGBot.dao.Dao;

import java.util.*;
import java.util.stream.Collectors;

public class CarListDao implements Dao<Car> {

    private List<Car> carList = new ArrayList<>();

    @Override
    public Optional<Car> get(int id) {
        return Optional.ofNullable(carList.get(id));
    }

    @Override
    public Collection<Car> getAll() {
        return carList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public int save(Car car) {
        carList.add(car);
        int index = carList.size() - 1;
        car.setId(index);
        return index;
    }

    @Override
    public void update(Car car) {
        carList.set(car.getId(), car);
    }

    @Override
    public void delete(Car car) {
        carList.set(car.getId(), null);
    }
}
