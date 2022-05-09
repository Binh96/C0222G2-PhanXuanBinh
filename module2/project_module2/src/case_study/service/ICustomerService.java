package case_study.service;

import case_study.modules.Person;

public interface ICustomerService extends IServices<Person> {
    void displayCustomerType();
    String chooseCustomerType();
    void displayID();
}
