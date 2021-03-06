package repository;

import java.util.List;

public interface IFuramaRepository {

    <E> List<E> findById(int id);

    <E> List<E> findByName(String name);
}
