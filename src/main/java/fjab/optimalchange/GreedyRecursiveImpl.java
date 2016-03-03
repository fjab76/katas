package fjab.optimalchange;

import java.util.*;

/**
 * Created by franciscoalvarez on 27/02/2016.
 */
public class GreedyRecursiveImpl implements OptimalChange {

  protected List<Integer> change = new ArrayList<>();

  @Override
  public List<Integer> optimalChangeFor(int pence, int[] coinBase) {

    if(pence>0){
      int coin = OptimalChange.maxCoinEqualOrLessThan(pence,coinBase);
      change.add(coin);
      optimalChangeFor(pence - coin,coinBase);
    }

    return Collections.unmodifiableList(change);

  }
}
