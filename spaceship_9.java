import java.util.Random;
import java.util.Scanner;

public class Main
{
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 3 locations (1-7):");
        int maxAttempts = 5;
        int attempts = 0;
        
        int[] SpaceshipLocation = generateLocation();
        
        while(attempts < maxAttempts){
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
         
        while (!CheckInput(a, b, c)){
         System.out.println("Input error. Try again!");
         a = scanner.nextInt();
         b = scanner.nextInt();
         c = scanner.nextInt();
            }
         
        int rightInput = 0;
        
        for(int i = 0; i < 3; i++){
            if(SpaceshipLocation[i] == a || SpaceshipLocation[i] == b || SpaceshipLocation[i] == c){
                rightInput++;
            }
        }
        
        if(rightInput == 3){
            sayAllFound();
        }
        else {
         System.out.println("The number of found cargos : "  + rightInput);
        attempts++;
        }
        if (attempts == maxAttempts){
            attempts = 0;
            SpaceshipLocation = generateLocation();
            System.out.println("Cargos changed their locations. Try again.");
        }
        }
  
        
 }
 
 static int[] generateLocation() {
     int[] SpaceshipLocation = new int[3];
        Random random = new Random();
       for (int i = 0; i < 3; i++) {
            int location = -1;
            boolean unique = false;

            while (!unique) {
                location = random.nextInt(7) + 1;
                unique = true;

                for (int j = 0; j < i; j++) {
                    if (SpaceshipLocation[j] == location) {
                        unique = false;
                        break;
                    }
                }
            }

            SpaceshipLocation[i] = location;
        }
        
         return SpaceshipLocation;
 }
 static boolean CheckInput(int a, int b, int c) {
        boolean aIsRight = a < 8 && a > 0 && a != b && a != c;
        boolean bIsRight = b < 8 && b > 0 && b != a && b != c;
        boolean cIsRight = c < 8 && c > 0 && c != b && a != c;
        
        if(aIsRight && bIsRight && cIsRight){
            return true;
        }
        else {
            return false;
        }
 }
    static void sayAllFound() {
         System.out.println("Congratulations! All cargos are found!");
            System.exit(0);
    }
}