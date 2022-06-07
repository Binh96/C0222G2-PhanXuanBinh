package repository.impl;

import repository.IFuramaRepository;

import java.util.List;

public class IFuramaRepositoryImpl implements IFuramaRepository {
    ConnectDataBase connectDataBase = new ConnectDataBase();
    private final static String SQL_SEARCH_ALL = " select * from view_person where name like '%?%' ";

    @Override
    public <E> List<E> findById(int id) {
        return null;
    }

    @Override
    public <E> List<E> findByName(String name) {
        return null;
    }
}
