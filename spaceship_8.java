import java.util.Random;
import java.util.Scanner;

public class Main
{
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
        
        int[] SpaceshipLocation = generateLocation();
        
        System.out.println("Enter 3 locations (1-7):");
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        while (true){
            boolean input = CheckInput(a, b, c);
            if (CheckInput(a, b, c)){
                break;
            }
            else {
                System.out.println("Input error. Try again!");
                a = scanner.nextInt();
         b = scanner.nextInt();
         c = scanner.nextInt();
            }
            
        }
        
        showResult1(a, b, c, SpaceshipLocation);
        
        System.out.println("During the search, the cargo moved to a new location. Unfortunately, the program can now only show the number of correctly guessed kilometer marks. Enter locations again.");
        
        int maxAttempts = 5;
        int attempts = 0;
        
        int[] SpaceshipLocation2 = generateLocation();
        
        for (int i = 0; i < 3; i++){
            System.out.println(SpaceshipLocation2[i]);
        }
        
        while(attempts < maxAttempts){
        
         a = scanner.nextInt();
         b = scanner.nextInt();
         c = scanner.nextInt();
         
        while (true){
            boolean input = CheckInput(a, b, c);
            if (CheckInput(a, b, c)){
                break;
            }
            else {
                System.out.println("Input error. Try again!");
                a = scanner.nextInt();
         b = scanner.nextInt();
         c = scanner.nextInt();
            }
        }
         
        int rightInput = 0;
        
        for(int i = 0; i < 3; i++){
            if(SpaceshipLocation2[i] == a || SpaceshipLocation2[i] == b || SpaceshipLocation2[i] == c){
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
    static void showResult1(int a, int b, int c, int[] SpaceshipLocation) {
    boolean allFound = true;

    for (int i = 0; i < 3; i++) {
        if (SpaceshipLocation[i] == a || SpaceshipLocation[i] == b || SpaceshipLocation[i] == c) {
            System.out.println("Cargo №" + (i + 1) + " is located at " + SpaceshipLocation[i] + " km");
        } else {
            System.out.println("Cargo №" + (i + 1) + " is not found");
            allFound = false;  
        }
    }

    if (allFound) {
        sayAllFound(); 
    }
}
    static void sayAllFound() {
         System.out.println("Congratulations! All cargos are found!");
            System.exit(0);
    }
}