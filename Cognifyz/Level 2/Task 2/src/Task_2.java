import java.util.*;

class Task_2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String password;
        System.out.println("enter password:");
        password=sc.nextLine();
        //System.out.println(password);

        // conditions for password to be strong:
        // 1.password should have at least 8 characters;
        // 2.password should contains at least one lowercase letter;
        // 3.password should contains at least one uppercase letter;
        // 4.password should contains at least one digit letter;
        // 5.password should contains at least one special letter;

        // in addition , a valid password should not include whitespace;

        // EX:
        //         password:"Cydeo123!";

        if(password.contains(" "))
        {
            System.out.println("Invalid password.");
            return;
        }

        boolean hasAtLeast8Chars=password.length() >= 8;                
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigitCase = false;
        boolean hasSpecialCase = false;

        for(int i=0;i<password.length();i++)
        {
            char ch=password.charAt(i);
            if(Character.isUpperCase(ch))
            {
                hasUpperCase = true;
            }
           else if(Character.isLowerCase(ch))
            {
                hasLowerCase = true;
            }
            else if(Character.isDigit(ch))
            {
                hasDigitCase = true;
            }
            else
            {
                hasSpecialCase = true;
            }
        }
         
        boolean isStrongPassword= hasAtLeast8Chars && hasUpperCase && hasLowerCase && hasDigitCase && hasSpecialCase;

        if(isStrongPassword)
        {
            System.out.println(password+ " is a strong password");
        }
        else
        {
            System.out.println(password+ " is a weak password");
        }

    }
}