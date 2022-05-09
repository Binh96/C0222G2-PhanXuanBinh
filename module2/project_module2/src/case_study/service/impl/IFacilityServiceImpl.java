package case_study.service.impl;

import case_study.modules.Facility;
import case_study.modules.House;
import case_study.modules.Room;
import case_study.modules.Villa;
import case_study.service.IFacilityService;
import case_study.utils.read_write_files.ReadFile;

import java.util.*;

public class IFacilityServiceImpl implements IFacilityService {
    static final Integer NUMBERMAINTAIN = 5;

    static Scanner sc = new Scanner(System.in);
    static IHouseServiceImpl houseService = new IHouseServiceImpl();
    static IRoomServiceImpl roomService = new IRoomServiceImpl();
    static IVillaServiceImpl villaService = new IVillaServiceImpl();
    static Map<Facility, Integer> facilitiesContain = new LinkedHashMap<>();
    static List<Facility> listFacilitiesMaintain = new ArrayList<>();


    @Override
    public void add() {
        chooseMenuAddService();
    }

    @Override
    public void display() {
        if(facilitiesContain.isEmpty()){
            System.out.println("Facility has no object or no service exist!");
        }
        else{
            for(Map.Entry<Facility, Integer> facility : facilitiesContain.entrySet()){
                System.out.println(facility.getKey().getServiceName()+": "+facility.getValue());
            }
        }
    }

    @Override
    public void edit() {

    }

    public void menuAddService(){
        System.out.println("""
                ----- Menu service -----
                1. Add new house
                2. Add new villa
                3. Add new room
                4. Exit""");
    }

    public void chooseMenuAddService(){
        boolean check = true;
        do{
            menuAddService();
            System.out.print("Choose add service: ");
            int num = Integer.parseInt(sc.nextLine());
            try{
                switch (num){
                    case 1 -> houseService.add();
                    case 2 -> villaService.add();
                    case 3 -> roomService.add();
                    case 4 -> {
                        System.out.println("---> you have been return --------");
                        check= false;
                    }
                    default -> System.out.println(" ---> It's not an option ->");
                }
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }while (check);
    }

    public static void menuTypeOfRent(){
        System.out.println("""
                --- Type of rent ----
                1. Year
                2. Month
                3. Day
                4. Hours""");
    }

    public static String chooseTypeOfRent(){
        menuTypeOfRent();
        boolean check = true;
        String str ="";
        System.out.print("Enter type of rent: ");
        while(check){
            try{
                int num = Integer.parseInt(sc.nextLine());
                switch (num){
                    case 1 -> str = "Year";
                    case 2 -> str = "Month";
                    case 3 -> str = "Day";
                    case 4 -> str = "Hours";
                    default -> {
                        System.out.println("doesn't exist this type");
                        str = "Day";
                    }
                }
                check = false;
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return str;
    }

    public <E> void addServiceMaintain(List<E> list){
        for(E e : list){
            facilitiesContain.put((Facility) e, list.size());
        }
    }

    public void displayMaintain(){
        if(listFacilitiesMaintain.isEmpty()){
            System.out.println(">>> All is already to server");
        }
        else{
            System.out.println(">>> Service is maintaining");
            for(Facility e: listFacilitiesMaintain){
                System.out.println(e.getServiceName());
            }
        }
    }

    public void updateMaintain(Facility facility){
        if(checkMaintain(facilitiesContain.get(facility))){
            listFacilitiesMaintain.add(facility);
            System.out.println(">>> Sorry! System is maintaining");
            System.out.println(">>> This service can't server you now");
            facilitiesContain.put(facility, 0);
        }
    }

    public boolean checkMaintain(Integer facility){
        return facility > NUMBERMAINTAIN;
    }

    public void updateFacilities(){
        List<Room> roomList = ReadFile.readFileRoom("case_study/utils/data/room.csv");
        for(Room room : roomList){
            facilitiesContain.put(room, roomList.size());
        }
        List<Villa> villaList = ReadFile.readFileVilla("case_study/utils/data/villa.csv");
        for(Villa villa : villaList){
            facilitiesContain.put(villa, villaList.size());
        }
        List<House> houseList = ReadFile.readFileHouse("case_study/utils/data/house.csv");
        for(House house: houseList){
            facilitiesContain.put(house, houseList.size());
        }
    }

    public void displayListFacilities(){
        updateFacilities();
        if(facilitiesContain.isEmpty()){
            System.out.println(">>> No service has been used");
        }
        else{
            for (Map.Entry<Facility, Integer> facility : facilitiesContain.entrySet()){
                System.out.println(facility.getKey().getServiceName()+": "+facility.getValue());
            }
        }
    }
}
