import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] groupMarks = new double[25];
        for (int i = 0; i < 25; i++) {
            groupMarks[i] = in.nextDouble();
        }

        double[] groupMarksChet;
        double[] groupMarksNeChet;

        if(groupMarks.length % 2 == 0){
            groupMarksChet = new double[groupMarks.length / 2];
            groupMarksNeChet = new double[groupMarks.length / 2];
        }
        else{
            groupMarksChet = new double[groupMarks.length / 2 + 1];
            groupMarksNeChet = new double[groupMarks.length / 2];
        }

        for (int i = 0; i < groupMarks.length; i++) {
            if(i % 2 == 0) groupMarksChet[i / 2] = groupMarks[i];
            else groupMarksNeChet[i / 2] = groupMarks[i];
        }

        groupMarksChet = insertSort(groupMarksChet);
        groupMarksNeChet = chooseSort(groupMarksNeChet);

        for (int i = 0; i < groupMarks.length; i++) {
            if(i % 2 == 0) groupMarks[i] = groupMarksChet[i/2];
            else groupMarks[i] = groupMarksNeChet[i/2];

            System.out.println(groupMarks[i]);
        }
    }

    public static double[] chooseSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            double tmp = arr[i];
            arr[i] = arr[least];
            arr[least] = tmp;
        }
        return arr;
    }

    public static double[] insertSort(double[] arr){
        for (int i = 1; i < arr.length; i++)
        {
            double newValue = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }
        return arr;
    }

}

