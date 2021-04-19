package Exercise_1;

//package Ex_1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.lang.reflect.Array;
//вар 7. f(x) = e^(x/3)/(1+x^2) x[0,10]
//
//интерполяционный  полином Лагранжа
public class Exercise_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
        @Override
        public void start(Stage primaryStage) throws Exception{
           // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("JavaFX Chart (Series)");

            NumberAxis xAx = new NumberAxis();
            NumberAxis yAx = new NumberAxis();

            LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(xAx,yAx);
            numberLineChart.setTitle("Series");
            XYChart.Series series1 = new XYChart.Series();
            XYChart.Series series2 = new XYChart.Series();
            series2.setName("cos(x)");
            series1.setName("sin(x)");
            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();






        int n = 21;

        System.out.println(Math.pow(2,3));
        float h = 0.5f;
        float x1 = 2.5f;// это пример нужно понять что за значение мы ищем .
        float[] x = new float[n];
        float[] y = new float[n];
        int p = 4;
        float lagr = 0;
        float[] l = new float[n];
        for (int i=0; i<n; i++){
            l[i]=1;
            x[i]+= i*h;
           // System.out.println(Math.exp(x[i]/3));
          //  System.out.println(1+Math.pow(x[i],2));
            y[i]+= Math.exp(x[i]/3)/(1+Math.pow(x[i],2));
        }
        for(int k=1; k<10*p; k++){
            for (int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }
                    //для равномерной сетки будет x[i] = x[0] + i*h
                    //заменяем и получим
                    // l[i] = l[i]*(x1 - x[0] - i*h)/h*(j-i);

                    l[i] = l[i] * ( (float) k/p - x[j]) / (x[i] - x[j]);
                }
                lagr = lagr + y[i] * l[i];
            }
            System.out.println(lagr);
            datas.add(new XYChart.Data((float)k/p,lagr));
            lagr=0;
            for (int i=0; i<n; i++) {
                l[i] = 1;
            }
        }
        System.out.println(lagr);
        series1.setData(datas);
        series2.setData(datas2);
        Scene scene = new Scene(numberLineChart, 600,600);
        numberLineChart.getData().add(series1);
        numberLineChart.getData().add(series2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

