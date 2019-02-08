import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class kryptera {
    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
        BufferedReader br = null;
        String line = null;
        String keyline = null;

        System.out.println("Välj meddelandet som skall läsas");

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\coel16\\IdeaProjects\\krypteringsprojekt\\" + scanner.next()));
        }catch (FileNotFoundException fnfex){
            System.out.println(fnfex.getMessage() + "Filen hittades inte");
            System.exit(0);
        }

        //Här läser vi raderna
        try {
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException ioex){
            System.out.println(ioex.getMessage() + "Error i läsandet av filen");
        }


        System.out.println("Välj din nyckel");

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\coel16\\IdeaProjects\\krypteringsprojekt\\" + scanner.next()));
        }catch (FileNotFoundException fnfex){
            System.out.println(fnfex.getMessage() + "Filen hittades inte");
            System.exit(0);
        }

        //Här läser vi raderna
        try {
            while ((keyline = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException ioex){
            System.out.println(ioex.getMessage() + "Error i läsandet av filen");
        }





        String msg = line;
        String key = keyline;



        //kryptera
        int[] crypt = new int[msg.length()];
        for(int i = 0 ; i < msg.length() ; i++){
            crypt[i] = msg.charAt(i) ^ key.charAt(i);
        }

        System.out.println("Krypterat: ");
        //skriv ut
        for (int i = 0 ; i < crypt.length ; i++){
            System.out.print(crypt[i]);
        }

        int[] decrypt = new int[crypt.length];
        //dekryptera crypt ^ key
        for(int i = 0 ; i < crypt.length ; i++) {
            decrypt[i] = crypt[i] ^ key.charAt(i);
        }

        System.out.println("\nDekrypterat: ");
        //skriv ut
        for (int i = 0 ; i < decrypt.length ; i++){
            System.out.print((char)decrypt[i]);

        }
    }
}

//Kolla filewriter test.java för att se hur du gör en "bufferedwriter" sak