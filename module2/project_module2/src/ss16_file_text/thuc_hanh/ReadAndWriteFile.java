package ss16_file_text.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("E:\\WorkSpace\\CodeGym\\C0222G2-PhanXuanBinh\\module2\\project_module2\\src\\ss16_file_text\\thuc_hanh\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("ss16_file_text/thuc_hanh/result.txt", maxValue);
    }

    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try{
            File file = new File(filePath);

            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line ="";
            while((line = br.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        }
        catch (Exception e){
            System.err.println("File khong co noi dung hoac khong ton tai");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max){
        try{
            FileWriter write = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(write);
            bufferedWriter.write("Gia tri lon nha la: "+max);
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int findMax(List<Integer> number){
        int max = number.get(0);
        for(int i=0; i< number.size(); i++){
            if(max < number.get(i)){
                max = number.get(i);
            }
        }
        return max;
    }
}
