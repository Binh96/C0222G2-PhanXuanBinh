package case_study.service;

import case_study.modules.Person;

public interface IEmployeeService extends IServices<Person> {
    void displayMenuLevel();
    void displayMenuPosition();
    String choosePosition();
    String chooseLevel();
    void displayID();
}
