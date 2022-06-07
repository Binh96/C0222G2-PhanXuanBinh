package repository;

import Model.Gender;

import java.util.List;

public interface IGenderRepository {
    List<Gender> findAllGender();
}
