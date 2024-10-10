import java.util.Random;
import java.util.Scanner;

public class Main
{
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
        
        int[] SpaceshipLocation = generateLocation();
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        while (true){
            boolean input = CheckInput(a, b, c);
            if (CheckInput(a, b, c)){
                break;
            }
            else {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                a = scanner.nextInt();
         b = scanner.nextInt();
         c = scanner.nextInt();
            }
            
        }
        
        for (int i = 0; i < 3; i++){
            if (SpaceshipLocation[i] == a){
                int RightLocation = a;
                System.out.println("Груз №" + (i + 1) + " находится на " + a + " км");
            } 
            if (SpaceshipLocation[i] == b){
                int RightLocation = b;
                System.out.println("Груз №" + (i + 1) + " находится на " + b + " км");
            } 
            if (SpaceshipLocation[i] == c){
                int RightLocation = c;
                System.out.println("Груз №" + (i + 1) + " находится на " + c + " км");
            }
            if (SpaceshipLocation[i] != a && SpaceshipLocation[i] != b && SpaceshipLocation[i] != c){
                System.out.println("Груз №" + (i + 1) + " не найден");
            }
        }
        
        System.out.println("Во время поиска груз переместился на новое место. К сожалению, теперь программа  может показать только количество правильно угаданных отметок километра.");
        
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
                System.out.println("Ошибка ввода. Попробуйте снова.");
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
            System.out.println("Все грузы найдены!");
            System.exit(0);
        }
        else {
         System.out.println(rightInput);
        attempts++;
        }
        if (attempts == 5){
            attempts = 0;
            System.out.println("Грузы поменяли локацию.");
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
}
