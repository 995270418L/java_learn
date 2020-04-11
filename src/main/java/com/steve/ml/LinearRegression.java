package com.steve.ml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LinearRegression {

    /**
     * 训练数据示例：
     * x0        x1        x2        y
     * 1.0       1.0       2.0       7.2
     * 1.0       2.0       1.0       4.9
     * 1.0       3.0       0.0       2.6
     * 1.0       4.0       1.0       6.3
     * 1.0       5.0      -1.0       1.0
     * 1.0       6.0       0.0       4.7
     * 1.0       7.0      -2.0      -0.6
     * 注意！！！！x1，x2，y三列是用户实际输入的数据，x0是为了推导出来  的公式统一，特地补上的一列。
     * x0,x1,x2是“特征”，y是结果
     * h(x) = theta0 * x0 + theta1* x1 + theta2 * x2
     * theta0,theta1,theta2 是想要训练出来的参数
     * 此程序采用“梯度下降法”
     */

    private double[][] trainData;
    private int row;
    private int column;
    private double[] theta;   // 待训练的参数
    private double alpha;     // 训练步长，沿梯度方向规定步长的迭代搜索
    private int iteration;    // 迭代次数
    private double error;     // 训练误差

    public LinearRegression(String filename) {
        this(filename, 0.001, 100);    // 训练100次，每次步长为 0.001
    }

    public LinearRegression(String filename, double alpha, int iteration) {
        getRowAndColumnNumber(filename);
        trainData = new double[row][column];
        this.alpha = alpha;                          //初始化训练步长
        this.iteration = iteration;                  //初始化迭代次数
        this.error = 0.0001;
        theta = new double[column - 1];                // 舍去y这一行
        loadTrainData(filename);
        init_theta();                                //初始化训练参数
    }

    private void loadTrainData(String filename) {
        // 将第一列数据全部置为 0
        for (int i = 0; i < this.row; i++)
            trainData[i][0] = 1.0;
        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int rowCount = 0;
            while (rowCount < this.row && (tempString = reader.readLine()) != null) {
                String[] tempData = tempString.split(" ");
                for (int i = 1; i < this.column; i++)
                    trainData[rowCount][i] = Double.parseDouble(tempData[i - 1]);
                rowCount++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {

                }

        }
    }

    // 将开始的训练参数theta全部置为 1
    public void init_theta() {
        for (int i = 0; i < column - 1; i++)
            theta[i] = 1.0;
    }

    public void getRowAndColumnNumber(String fileName) {
        int rowCount = 1;                            //设为1的原因，因为在获得列数的时候已经加载了一行
        int columnCount = 0;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            //获得列数
            reader = new BufferedReader(new FileReader(file));
            String temp = reader.readLine();
            if (temp != null) {
                columnCount = temp.split(" ").length;
            }
            //获得行数
            while (reader != null && reader.readLine() != null) {
                rowCount++;
            }
            this.column = columnCount + 1;          //注意，为什么要+1？？？ 因为为了使得公式整齐，我们加了一个特征x0，x0恒等于1
            this.row = rowCount;
            System.out.println(this.column);
            System.out.println(this.row);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {

                }
        }
    }

    private void trainTheta() {
        for (int i = 0; i < iteration; i++) {
            // 对每次训练的theta， 计算偏导数
            double[] partial_derivative = compute_partial_derivative();

            for (int j = 0; j < column - 1; j++) {
                theta[j] -= alpha * partial_derivative[j];
            }

            for (int j = 0; j < column - 1; j++)
                System.out.print(theta[j] + " ");
            System.out.println("iteration number :" + i);

            // 计算损失函数
            double error = compute_error();
            if (error < this.error) {
                System.out.println("The number of iteration: " + (i + 1));
                return;
            }
        }
    }

    private double compute_error() {
        double sum = 0;
        for (int i = 0; i < row; i++) {
            double temp = compute_row_diff(i);
            sum += temp * temp;
        }
        return sum / (2 * row);
    }

    private double[] compute_partial_derivative() {
        double[] partial_derivative = new double[column - 1];
        for (int i = 0; i < column - 1; i++) {
            partial_derivative[i] = compute_every_partial_derivative(i);
        }
        return partial_derivative;
    }

    private double compute_every_partial_derivative(int column) {
        double sum = 0;
        for (int i = 0; i < row; i++) {
            sum += compute_row_diff(i) * trainData[i][column];
        }
        return sum;
    }

    // 计算每行的预测值和实际值的差别
    private double compute_row_diff(int row) {
        double sum = 0;
        for (int i = 0; i < column - 1; i++) {
            sum += theta[i] * trainData[row][i];
        }
        return sum - trainData[row][column - 1];
    }

    /**
     * 打印训练数据
     */
    public void printData() {
        System.out.println("Train Data:");
        for (int i = 0; i < column - 1; i++)
            System.out.printf("%10s", "x" + i + " ");
        System.out.printf("%10s", "y" + "\n");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.printf("%10s", trainData[i][j] + " ");
            System.out.println();
        }

    }

    /**
     * 打印模型的训练参数
     */
    public void printTheta() {
        for (int i = 0; i < column - 1; i++)
            System.out.print(theta[i] + "  ");
        System.out.println();
    }

    public void main(){
        trainTheta();
        printData();
        printTheta();
    }

    public void test(double []num){
        System.out.println("core:");
        double []str = this.theta;
        double sum=0.0;
        for(int i=0;i<num.length;i++) {
            sum = sum + str[i] * num[i];
        }
        System.out.println(sum);
    }

}
