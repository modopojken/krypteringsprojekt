import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class kryptera {
    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
        BufferedReader br = null;
        String line = null;
        String keyline = null;

        System.out.println("Välj meddelandet sedan nyckeln");

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\coel16\\IdeaProjects\\krypteringsprojekt\\" + scanner.next()));

        }catch (FileNotFoundException fnfex){
            System.out.println(fnfex.getMessage() + "Filen hittades inte");
            System.exit(0);
        }



        ArrayList<String> lines = new ArrayList<String>();
        //Här läser vi raderna
        try {
            while ((line = br.readLine()) != null){
                lines.add(line);
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


        ArrayList<String> keylines = new ArrayList<String>();
        //Här läser vi raderna
        try {
            while ((keyline = br.readLine()) != null){
                keylines.add(keyline);
            }
        }catch (IOException ioex){
            System.out.println(ioex.getMessage() + "Error i läsandet av filen");
        }





        String msg = lines.get(0);
        String key = keylines.get(0);



        //kryptera
        int[] crypt = new int[msg.length()];
        for(int i = 0 ; i < msg.length() ; i++){
            crypt[i] = msg.charAt(i) ^ key.charAt(i);
        }

        DataOutputStream output = null;
        String filename = "hejsansvejsan.dat";
        try {
            output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println("Krypterat: ");
        //skriv ut
        for (int i = 0 ; i < crypt.length ; i++){
            try {
                output.write(crypt[i]);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        try {
            output.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        //int[] decrypt = new int[crypt.length];
        //dekryptera crypt ^ key
        //for(int i = 0 ; i < crypt.length ; i++) {
          //  decrypt[i] = crypt[i] ^ key.charAt(i);
        //}

        //System.out.println("\nDekrypterat: ");
        //skriv ut
        //for (int i = 0 ; i < decrypt.length ; i++){
            //System.out.print((char)decrypt[i]);

        //}


        DataInputStream input = null;
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> inputlines = new ArrayList<Integer>();
        try {
            int i;
            int count = 0;
            while ((i = input.read()) >= 0){



                System.out.print((char)(i^key.charAt(count)));
                count++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//Kolla filewriter test.java för att se hur du gör en "bufferedwriter" sak