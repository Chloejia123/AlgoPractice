public class LC832FlippingAnImage {
  public int[][] flipAndInvertImage(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      reverse(A[i]);
      flip(A[i]);
    }
    return A;
  }

  private void reverse(int[] a) {
    int i = 0;
    int j = a.length - 1;
    while (i < j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i++;
      j--;
    }
  }

  private void flip(int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] ^= 1;
    }
  }
}
