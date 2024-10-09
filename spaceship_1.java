import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int[] SpaceshipLocation = new int[3];
        
        for (int i = 0; i < 3; i++ ){
            SpaceshipLocation[i] = random.nextInt(8);
        }
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
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
                System.out.println("Груз №" + (i + 1) + "не найден");
            }
        }
        
        System.out.println();
            
        for (int i = 0; i < 3; i++ ){
           System.out.println(SpaceshipLocation[i] + " ");
        }
        
	}
}