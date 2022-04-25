package ss16_file_text.bai_tap.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public static void main(String[] args) {
        int count = 0;
        CopyFileText copyFileText = new CopyFileText();
        List<String> text = copyFileText.readFile("ss16_file_text/bai_tap/copy_file/sourceFile.txt");
        StringBuilder lines = new StringBuilder();
        for(String line : text){
            lines.append(line);
        }
        copyFileText.writeFile("ss16_file_text/bai_tap/copy_file/targetFile.txt", lines);
    }

    public List<String> readFile(String filePath){
        List<String> text = new ArrayList<>();
        try{
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line ="";
            while((line = br.readLine()) != null){
                text.add(line);
            }
            br.close();
        }
        catch (Exception e){
            System.err.println("File khong co noi dung hoac khong ton tai");
        }
        return text;
    }

    public void writeFile(String filePath, StringBuilder text){
        try{
            FileWriter write = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(write);
            bufferedWriter.write(String.valueOf(text));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
