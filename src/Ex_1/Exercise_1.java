package Ex_1;

import java.lang.reflect.Array;

//интерполяционный  полином Лагранжа
public class Exercise_1 {
    public static void main(String[] args) {
        int n = 20;
        float h = 0.25f;
        float x1 = 2.5f;// это пример нужно понять что за значение мы ищем .
        float[] x = new float[n];
        float[] y = new float[n];

        float lagr = 0;
        float[] l = new float[n];
        for (int i=0; i<n; i++){
            l[i]=1;
            x[i]+= i*h;
            y[i]+= 2*i*h;
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (j==i){
                    continue;
                }
                //для равномерной сетки будет x[i] = x[0] + i*h
                //заменяем и получим
                // l[i] = l[i]*(x1 - x[0] - i*h)/h*(j-i)

                l[i]= l[i] * (x1 - x[j])/(x[i]-x[j]);
            }
            lagr= lagr + y[i] * l[i];
        }
        System.out.println(lagr);
    }
}
