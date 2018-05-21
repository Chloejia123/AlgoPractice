public class LC461HammingDistance {
  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
  }

  public int hammingDistance2(int x, int y) {
    int res = 0;
    for(int i = 0; i < 32; i++){
      res += (x & 1) ^ (y & 1);
      x = x >> 1;
      y = y >> 1;
    }
    return res;
  }
}
