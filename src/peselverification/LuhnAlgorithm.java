package peselverification;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LuhnAlgorithm {

    public boolean verify(String peselNr) {
        int sum = 0;
        int temp = 0;
        int wages[] = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int x = 0;

        for (int i = 0; i < peselNr.length() - 1; i++) {
            temp = Character.getNumericValue(peselNr.charAt(i));
            sum += (temp * wages[i]);
        }

        x = 10 - (sum % 10);
        x = x % 10;
        
        if (x == Character.getNumericValue(peselNr.charAt(10))) {
            return true;
        } else {
            return false;
        }
    }
    
    public void writeToFile(String peselNr){
        try{
            FileWriter fw = new FileWriter("numbers.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(peselNr);
            pw.write(System.getProperty("line.separator"));
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
