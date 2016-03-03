package fjab.optimalchange;

import java.util.*;

/**
 * Created by franciscoalvarez on 27/02/2016.
 */
public interface OptimalChange {

  /**
   * Coins must be returned sorted desc by denomination
   * @param pence
   * @param coinBase
   * @return
   */
  List<Integer> optimalChangeFor(int pence, int[] coinBase);

  static int maxCoinEqualOrLessThan(int pence, int[] coinBase) {

    int index = Arrays.binarySearch(coinBase,pence);
    if(index>=0){
      return coinBase[index];
    }
    else{
      return coinBase[-index-2];
    }
  }

  static int[] coinsEqualOrLessThan(int pence, int[] coinBase) {

    int index = Arrays.binarySearch(coinBase,pence);
    if(index<0){
      index = -index-2;
    }
    return Arrays.copyOfRange(coinBase,0,index+1);
  }
}
