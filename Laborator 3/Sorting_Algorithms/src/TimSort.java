import static java.lang.StrictMath.abs;

public class TimSort
{
    static int MIN_MERGE = 32;

    public static int minRunLength(int n)
    {
        assert n >= 0;

        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void insertionSort(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
                Main.iteration_ts ++;
            }
            arr[j + 1] = temp;
        }
    }

    public static void mergeS(int[] arr, int l, int m, int r)
    {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
                Main.iteration_ts ++;
            }
            else {
                arr[k] = right[j];
                j++;
                Main.iteration_ts ++;
            }
            k++;
        }

        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
            Main.iteration_ts ++;
        }

        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
            Main.iteration_ts ++;
        }
    }


    public static void timSort(int[] arr, int n)
    {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun)
        {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size)
        {
            for (int left = 0; left < n; left += 2 * size)
            {
                int mid = Math.min(left + size - 1 , n-1);
                int right = Math.min((left + 2 * size - 1), (n - 1));

                mergeS(arr, left, mid, right);
            }
        }
    }
}