package passwordgenerator;

/**
 *
 * @author TLJ5258
 */

import java.util.Scanner;

public class PasswordGenerator
{

    public static void main(String[] args)
    {

        //Ask user how many passwords they want generated
        Scanner in = new Scanner(System.in);
        System.out.print("How many passwords do you want to generate? ");
        int total = in.nextInt();

        //Ask user how long they want their passwords to be
        System.out.print("Preferred password length (in characters)? ");
        int length = in.nextInt();

        //Create array of random passwords
        String[] randomPasswords = new String[total];

        //Randomly generate passwords requested number of times
        for (int i = 0; i < total; i++)
        {
            //Create a variable to store the random password
            String randomPassword = "";
            //Randomly generate character for the password length requested number of times
            for (int j = 0; j < length; j++)
            {
                //Add random lowercase or UPPERCASE character to randomPassword
                randomPassword += randomCharacter();
            }
            //Add password to array
            randomPasswords[i] = randomPassword;
        }

        //Print passwords array
        printArray(randomPasswords);

    }

    //Prints array that's passed as a parameter
    public static void printArray(String[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

    //Randomly generates a letter (lowercase or UPPERCASE) or number (0-9) using ASCII
    //'0' - '9' => 48-57 in ASCII
    //'A' - 'Z' => 65-90 in ASCII
    //'a' - 'z' => 97-122 in ASCII
    public static char randomCharacter()
    {

        int rand = (int) (Math.random() * 62);

        //0-61 inclusive = all possible values of rand
        //0-9 inclusive = 10 possible numbers/digits
        //10-35 inclusive = 26 possible uppercase letters
        //36-61 inclusive = 26 possible lowercase letters
        //If rand is between 0 (inclusive) and 9 (inclusive), declare a number
        //If rand is between 10 (inclusive) and 35 (inclusive), declare an uppercase letter
        //If rand is between 36 (inclusive) and 61 (inclusive), declare a lowercase letter
        if (rand <= 9)
        {
            //Number (48-57 in ASCII)
            //To convert from 0-9 to 48-57, we can add 48 to rand, as 48-0 = 48
            int number = rand + 48;
            //This way, rand = 0 => number = 48 => '0'
            return (char) (number);
        } else if (rand <= 35)
        {
            //Uppercase letter (65-90 in ASCII)
            //To convert from 10-35 to 65-90, we can add 55 to rand, as 65-10 = 55
            int uppercase = rand + 55;
            //This way, rand = 10 => uppercase = 65 => 'A'
            return (char) (uppercase);
        } else
        {
            //Lowercase letter (97-122 in ASCII)
            //To convert from 36-61 to 97-122, we can add 61 to rand, as 97-36 = 61
            int lowercase = rand + 61;
            //This way, rand = 36 => lowercase = 97 => 'a'
            return (char) (lowercase);
        }
    }

}
