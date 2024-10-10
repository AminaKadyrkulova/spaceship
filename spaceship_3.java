import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main
{
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
        
        int[] SpaceshipLocation = generateLocation();
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        boolean aIsRight = a < 8 && a > 0;
        boolean bIsRight = b < 8 && b > 0;
        boolean cIsRight = c < 8 && c > 0;
        
        while (!aIsRight){
            System.out.println("Первые данные введены неправильно. Попробуйте снова:");
             a = scanner.nextInt();
             if(a < 8 && a > 0){
                 aIsRight = true;
             }
        }
        while (!bIsRight){
            System.out.println("Вторые данные введены неправильно. Попробуйте снова:");
             b = scanner.nextInt();
             if(b < 8 && b > 0){
                 bIsRight = true;
             }
        }
        while (!cIsRight){
            System.out.println("Третьи данные введены неправильно. Попробуйте снова:");
             c = scanner.nextInt();
             if(c < 8 && c > 0){
                 cIsRight = true;
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
        
        int[] SpaceshipLocation2 = generateLocation();
        
         a = scanner.nextInt();
         b = scanner.nextInt();
         c = scanner.nextInt();
        int rightInput = 0;
        
        for(int i = 0; i < 3; i++){
            if(SpaceshipLocation2[i] == a || SpaceshipLocation2[i] == b || SpaceshipLocation2[i] == c){
                rightInput++;
            }
        }
        
         System.out.println(rightInput);
        
        for (int i = 0; i < 3; i++){
            System.out.println(SpaceshipLocation2[i]);
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
}
