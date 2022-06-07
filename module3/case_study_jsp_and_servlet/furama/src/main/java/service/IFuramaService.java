package service;

import java.util.List;

public interface IFuramaService {
    <E> List<E> findByName(String name);
}
