package case_study.utils.read_write_files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public static void writeFile(String path, List<String> list){
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for(String s : list){
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static <E> void writeFileAll(String path, List<E> list){
        List<String> eStringList = new ArrayList<>();
        for(E e : list){
            eStringList.add(String.valueOf(e));
        }
        writeFile(path, eStringList);
    }
}
