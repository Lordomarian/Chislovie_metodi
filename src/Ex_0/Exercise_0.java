package Ex_0;
import java.util.Scanner;
//Задание 0 нахождение машинного e
/** Автор Козлов Михаил Дмитриевич
 * Группа С18-101
**/
public class Exercise_0 {
    public static void main(String[] args) {
        int var;
        System.out.println("Выберите тип данных \nfloat = 1 \ndouble = 2");
        Scanner scanner = new Scanner(System.in);
        var = scanner.nextInt();
        scanner.close();
        int a = 1;
        int e1 = 1;
        if (var == 1) {
            float e = e1;
            while( a + e > a){ // Проверка условий различия между числами
                e= e/2;
                if(a + e <= a ){
                    break;
                }
            }
            System.out.println("Машинное e = " + e);
        }else if (var == 2) {
            double e = e1;
            while( a + e > a){
                e= e/2;
                if(a + e <= a ){
                    break;
                }
            }
            System.out.println("Машинное e = " + e);
        }else{
            System.out.println("Не верный вариант");
        }
    }
}
