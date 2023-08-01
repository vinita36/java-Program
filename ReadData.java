// Accept file name from user and read the data from that file and print it on screen

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

class ReadData
{
    public static void main(String Arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the file name");
        String FName = sobj.nextLine();

        try
         {
            BufferedReader bobj = new BufferedReader(new FileReader(FName));

            String line;

            while((line = bobj.readLine()) != null)
            {
                System.out.println(line);
            }
         }
         catch(IOException e)
         {
            System.out.println("Error reading the file:"+e.getMessage());
         }
         finally
         {
            sobj.close();
         }
    }
}