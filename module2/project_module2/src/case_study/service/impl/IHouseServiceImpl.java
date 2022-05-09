package case_study.service.impl;

import case_study.modules.House;
import case_study.service.IFacilityService;
import case_study.utils.read_write_files.ReadFile;
import case_study.utils.read_write_files.WriteFile;
import case_study.utils.valid.CheckInput;
import case_study.utils.valid.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHouseServiceImpl implements IFacilityService {
    static Scanner sc = new Scanner(System.in);
    static String path = "case_study/utils/data/house.csv";
    private final String pathBackUp = "case_study/utils/data/back_up/houseBackUp.csv";
    static List<House> houseList = new ArrayList<>();
    static IFacilityServiceImpl iFacilityService = new IFacilityServiceImpl();

    @Override
    public void add() {
        houseList = ReadFile.readFileHouse(path);

        System.out.print("Enter service code(SVHO-XXXX): ");
        String code = CheckInput.stringInput(sc.nextLine(), Regex.SERVICECODEHOUSE_REGEX);
        System.out.print("Enter service name(Xxxx): ");
        String name = CheckInput.stringInput(sc.nextLine(), Regex.SERVICENAME_REGEX);
        System.out.print("Enter use area(30.x): ");
        Double areaUse = Double.parseDouble(CheckInput.stringInput(sc.nextLine(), Regex.AREAOFPOOLANDAREAUSE_REGEX));
        System.out.print("Enter fee rent(number): ");
        Integer fee = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.FEERENT_REGEX));
        System.out.print("Enter person(1-19): ");
        Integer quantity = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.MAXIMUMPERSON_REGEX));
        System.out.println("Enter type of rent(Xxxx) -->  ");
        String typeOfRent = IFacilityServiceImpl.chooseTypeOfRent();
        CheckInput.stringInput(typeOfRent, Regex.TYPEOFRENT_REGEX);
        System.out.print("Enter room standard(Xxxx): ");
        String roomStandard = CheckInput.stringInput(sc.nextLine(), Regex.ROOMSTANDARD_REGEX);
        System.out.print("Enter number floor(1-9): ");
        Integer numberFloor = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.NUMBERFLOOR_REGEX));

        House house = new House(code, name, areaUse, fee, quantity, typeOfRent, roomStandard, numberFloor);
        houseList.add(house);

        iFacilityService.addServiceMaintain(houseList);
        iFacilityService.updateMaintain(house);
        WriteFile.writeFileBackUp(houseList, pathBackUp);
        if(!iFacilityService.checkMaintain(houseList.size())){
            WriteFile.writeFileAll(path, houseList);
        }
        else{
            houseList.clear();
            WriteFile.writeFileAllEmpty(path, houseList);
        }
    }

    @Override
    public void display() {
        houseList = ReadFile.readFileHouse(path);
        if(houseList.isEmpty()){
            System.out.println("This service is suck, none use this suck !! >>> Of course, it's empty! :)");
        }
        else{
            for(House house : houseList){
                System.out.println("Service code: "+ house.getServiceCode());
                System.out.println("Quantity    : "+ house.getMaximumPerson());
                System.out.println("Type of rent: "+ house.getTypeOfRent());
            }
        }
    }

    @Override
    public void edit() {
        houseList = ReadFile.readFileHouse(path);
    }
}
