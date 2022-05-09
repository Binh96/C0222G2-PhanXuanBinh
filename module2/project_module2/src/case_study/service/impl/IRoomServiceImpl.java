package case_study.service.impl;

import case_study.modules.Room;
import case_study.utils.valid.Regex;
import case_study.utils.valid.CheckInput;
import case_study.service.IFacilityService;
import case_study.utils.read_write_files.ReadFile;
import case_study.utils.read_write_files.WriteFile;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class IRoomServiceImpl implements IFacilityService {
    static Scanner sc = new Scanner(System.in);
    static String path = "case_study/utils/data/room.csv";
    static String pathBackUp = "case_study/utils/data/back_up/roomBackUp.csv";
    static List<Room> roomList = new ArrayList<>();
    static IFacilityServiceImpl iFacilityService = new IFacilityServiceImpl();

    @Override
    public void add() {
        roomList = ReadFile.readFileRoom(path);
        for(Room room : roomList){
            System.out.println(room);
        }

        System.out.print("Enter service code(SVRO-XXXX): ");
        String code = CheckInput.stringInput(sc.nextLine(), Regex.SERVICECODEROOM_REGEX);
        System.out.print("Enter service name(Xxxx): ");
        String name = CheckInput.stringInput(sc.nextLine(), Regex.SERVICENAME_REGEX);
        System.out.print("Enter use area(30.x): ");
        Double areaUse = Double.parseDouble(CheckInput.stringInput(sc.nextLine(), Regex.AREAOFPOOLANDAREAUSE_REGEX));
        System.out.print("Enter fee rent(number): ");
        Integer fee = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.FEERENT_REGEX));
        System.out.print("Enter person(1-19): ");
        Integer quantity = Integer.parseInt(CheckInput.stringInput(sc.nextLine(), Regex.MAXIMUMPERSON_REGEX));
        System.out.println("Enter type of rent(Xxxx) --> ");
        String typeOfRent = IFacilityServiceImpl.chooseTypeOfRent();
        CheckInput.stringInput(typeOfRent, Regex.TYPEOFRENT_REGEX);
        System.out.print("Enter free service(Xxxx): ");
        String freeService = CheckInput.stringInput(sc.nextLine(), Regex.SERVICENAME_REGEX);

        Room room = new Room(code, name, areaUse, fee, quantity, typeOfRent, freeService);
        roomList.add(room);

        iFacilityService.addServiceMaintain(roomList);
        iFacilityService.updateMaintain(room);
        WriteFile.writeFileBackUp(roomList, pathBackUp);
        if(!iFacilityService.checkMaintain(roomList.size())) {
            WriteFile.writeFileAll(path, roomList);
        }
        else{
            roomList.clear();
            WriteFile.writeFileAllEmpty(path, roomList);
        }
    }

    @Override
    public void display() {
        roomList = ReadFile.readFileRoom(path);
        if(roomList.isEmpty()){
            System.out.println("This service is suck, none use this suck !! >>> Of course, it's empty! :)");
        }
        else{
            for(Room room : roomList){
                System.out.println("Service code: "+ room.getServiceCode());
                System.out.println("Quantity    : "+ room.getMaximumPerson());
                System.out.println("Type of rent: "+ room.getTypeOfRent());
            }
        }
    }

    @Override
    public void edit() {

    }


}