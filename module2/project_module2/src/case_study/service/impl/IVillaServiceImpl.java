package case_study.service.impl;

import case_study.modules.Villa;
import case_study.service.IFacilityService;
import case_study.utils.read_write_files.ReadFile;
import case_study.utils.read_write_files.WriteFile;
import case_study.utils.valid.CheckInput;
import case_study.utils.valid.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IVillaServiceImpl implements IFacilityService {
    Scanner sc = new Scanner(System.in);
    List<Villa> villaList = new ArrayList<>();
    String path = "case_study/utils/data/villa.csv";
    private final String pathBackUp = "case_study/utils/data/back_up/villaBackUp.csv";
    static IFacilityServiceImpl iFacilityService = new IFacilityServiceImpl();


    @Override
    public void add() {
        villaList = ReadFile.readFileVilla(path);

        System.out.print("Enter service code(SVVL-XXXX): ");
        String code = CheckInput.stringInput(sc.nextLine(), Regex.SERVICECODEVILLA_REGEX);
        System.out.print("Enter service name(Xxxx): ");
        String name = CheckInput.stringInput(sc.nextLine(), Regex.SERVICENAME_REGEX);
        System.out.print("Enter use area(30.x): ");
        Double areaUse = Double.parseDouble(CheckInput.stringInput(sc.nextLine(), Regex.AREAOFPOOLANDAREAUSE_REGEX));
        System.out.print("Enter fee rent(number): ");
        Integer fee = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.FEERENT_REGEX));
        System.out.print("Enter person(1-19): ");
        Integer quantity = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.MAXIMUMPERSON_REGEX));
        System.out.println("Enter type of rent(Xxxx) -- >  ");
        String typeOfRent = IFacilityServiceImpl.chooseTypeOfRent();
        CheckInput.stringInput(typeOfRent, Regex.TYPEOFRENT_REGEX);
        System.out.print("Enter room standard(Xxxx): ");
        String roomStandard = CheckInput.stringInput(sc.nextLine(), Regex.ROOMSTANDARD_REGEX);
        System.out.print("Enter area pool(3x.x): ");
        Double areaPool = Double.parseDouble(CheckInput.stringInput(sc.nextLine(), Regex.AREAOFPOOLANDAREAUSE_REGEX));
        System.out.print("Enter number floor(1-9): ");
        Integer numberFloor = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.NUMBERFLOOR_REGEX));

        Villa villa = new Villa(code, name, areaUse, fee, quantity, typeOfRent, roomStandard, areaPool, numberFloor);
        villaList.add(villa);

        iFacilityService.addServiceMaintain(villaList);
        iFacilityService.updateMaintain(villa);
        if(!iFacilityService.checkMaintain(villaList.size())){
            WriteFile.writeFileAll(path, villaList);
        }
    }

    @Override
    public void display() {
        villaList = ReadFile.readFileVilla(path);
        if(villaList.isEmpty()){
            System.out.println("This service is suck, none use this suck !! >>> Of course, it's empty! :)");
        }
        else{
            for(Villa villa : villaList){
                System.out.println("Service code: "+ villa.getServiceCode());
                System.out.println("Quantity    : "+ villa.getMaximumPerson());
                System.out.println("Type of rent: "+ villa.getTypeOfRent());
            }
        }
    }

    @Override
    public void edit() {

    }
}
