package fjab.optimalchange;

import java.util.*;

/**
 * Created by franciscoalvarez on 28/02/2016.
 *
 * Dynamic Programming Implementation
 * See https://www.youtube.com/watch?v=rdI94aW6IWw
 */
public class DPImpl implements OptimalChange {

  @Override
  public List<Integer> optimalChangeFor(int pence, int[] coinBase) {

    List<Integer> change = new ArrayList<>();
    int[][] partialSolutions = partialSolutions(pence, coinBase);

    while (pence>0) {
      change.add(partialSolutions[1][pence]);
      pence -= partialSolutions[1][pence];
    }

    Collections.sort(change);
    Collections.reverse(change);
    return Collections.unmodifiableList(change);
  }

  int[][] partialSolutions(int pence, int[] coinBase) {

    int[][] numCoins = new int[pence+1][pence+1];
    numCoins[0][0] = 0;
    numCoins[1][0] = 0;

    for(int j=1;j<=pence;j++){
      int[] candidateCoins = OptimalChange.coinsEqualOrLessThan(j, coinBase);

      int minNumCoins = Integer.MAX_VALUE;
      int candidateCoin = 0;
      for(int k=0;k<candidateCoins.length;k++){
        int partialMinNumCoins = numCoins[0][j-candidateCoins[k]];
        if(minNumCoins>partialMinNumCoins){
          minNumCoins = partialMinNumCoins;
          candidateCoin = candidateCoins[k];
        }
      }
      numCoins[0][j] = minNumCoins+1;
      numCoins[1][j] = candidateCoin;
    }

    return numCoins;
  }
}
