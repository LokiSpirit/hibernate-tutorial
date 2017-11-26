package ru.javavision.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javavision.model.Car;

/**
 * Author : Pavel Ravvich.
 * Created : 26/11/2017.
 */
public class CarDAO implements DAO<Car, Integer> {
    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public CarDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Car car) {

        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(car);

            session.getTransaction().commit();
        }
    }

    @Override
    public Car read(@NotNull final Integer id) {

        try (final Session session = factory.openSession()) {

            final Car result = session.get(Car.class, id);

            return result != null ? result : new Car();
        }
    }

    @Override
    public void update(@NotNull final Car car) {

        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(car);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Car car) {

        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(car);

            session.getTransaction().commit();
        }
    }
}
