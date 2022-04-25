package ss17_binary_file.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {

    public static void writeFile(String path, List<Product> products){
        try{
            FileOutputStream fos= new FileOutputStream(path);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
