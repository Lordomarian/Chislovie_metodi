package Exercise_1;

//package Ex_1;

import java.lang.reflect.Array;
//вар 7. f(x) = e^(x/3)/(1+x^2) x[0,10]
//
//интерполяционный  полином Лагранжа
public class Exercise_1 {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(Math.pow(2,3));
        float h = 0.5f;
        float x1 = 2.5f;// это пример нужно понять что за значение мы ищем .
        float[] x = new float[n];
        float[] y = new float[n];

        float lagr = 0;
        float[] l = new float[n];
        for (int i=0; i<n; i++){
            l[i]=1;
            x[i]+= i*h;
           // System.out.println(Math.exp(x[i]/3));
          //  System.out.println(1+Math.pow(x[i],2));
            y[i]+= Math.exp(x[i]/3)/(1+Math.pow(x[i],2));
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (j==i){
                    continue;
                }
                //для равномерной сетки будет x[i] = x[0] + i*h
                //заменяем и получим
                // l[i] = l[i]*(x1 - x[0] - i*h)/h*(j-i);

                l[i]= l[i] * (x1 - x[j])/(x[i]-x[j]);
            }
            lagr= lagr + y[i] * l[i];
        }
        System.out.println(lagr);
    }
}
