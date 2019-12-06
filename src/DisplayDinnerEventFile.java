
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meera mishra
 */
public class DisplayDinnerEventFile {
    public static void main(String[] args){
        Path file = Paths.get("C:\\Users\\meera mishra\\Documents\\staffdinnerevent.txt");
        InputStream input = null;
        try{
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = "";
            s = reader.readLine();
            System.out.println(s);
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        }
    } 

