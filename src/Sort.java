import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {

        double[] groupMarks = new double[]{12.75, 11.25, 9.75, 5.75, 6.25, 13.75, 6.25, 12.75, 13.75,
                12.25, 8.25, 13.25, 13.75, 12, 10.75, 11.25, 2.25,
                7.25, 12.75, 8.25, 12.75, 5.25, 12.25, 12.75, 13.25, 5.75};

        double[] groupMarksChet = new double[groupMarks.length / 2];
        double[] groupMarksNeChet = new double[groupMarks.length / 2];

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

