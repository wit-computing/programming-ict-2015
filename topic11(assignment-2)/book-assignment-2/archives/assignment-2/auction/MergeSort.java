

public class MergeSort
{
  static int[] aux;
  private static void merge(int[] a, int lo, int mid, int hi)
  {
    for (int k = lo; k <= hi; k++)
      aux[k] = a[k];

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++)
    {
      if (i > mid)              a[k] = aux[j++];
      else if (j > hi)          a[k] = aux[i++];
      else if (aux[j] < aux[i]) a[k] = aux[j++];
      else                      a[k] = aux[i++];
    }
  }

  public static void sort(int[] a)
  {
    aux = new int[a.length];
    int N = a.length;
    
    for (int size = 1; size < N; size = size + size)
      for (int lo = 0; lo < N - size; lo += size + size)
        merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
  }

  public static void print(int[] a)
  {
    for (int i : a)
      System.out.print(i + " ");
    System.out.println();
  }

  public static void main(String[] args)
  {
    int[] a = {20, 24, 17, 12, 11, 14, 22, 19};
    print(a);
    sort(a);
    print(a);
  }
}
