package fjab.optimalchange;

import java.util.*;

/**
 * Created by franciscoalvarez on 27/02/2016.
 */
public class GreedyIterativeImpl implements OptimalChange {

  @Override
  public List<Integer> optimalChangeFor(int pence,int[] coinBase) {

    List<Integer> change = new ArrayList<>();

    while(pence>0){
      int coin = OptimalChange.maxCoinEqualOrLessThan(pence,coinBase);
      change.add(coin);
      pence -= coin;
    }

    return Collections.unmodifiableList(change);

  }
}
