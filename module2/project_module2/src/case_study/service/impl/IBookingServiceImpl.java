package case_study.service.impl;

import case_study.service.IBookingServices;
import case_study.utils.valid.CheckInput;
import case_study.utils.valid.InputDate;

import java.util.Date;
import java.util.Scanner;


public class IBookingServiceImpl implements IBookingServices {
    static Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        System.out.print("Enter booking code: ");
        Integer code = CheckInput.intInput();
        System.out.print("Enter start date: ");
        Date startDate = InputDate.dateValid();
        System.out.print("Enter end date: ");
        Date endDate = InputDate.dateValid();
        System.out.print("Enter customer code: ");
        Integer customerCode = CheckInput.intInput();
        System.out.print("Enter name service: ");
//        String nameService = CheckInput.stringInput(sc.nextLine(), );
    }

    @Override
    public void display() {

    }

    @Override
    public void edit() {

    }
}
