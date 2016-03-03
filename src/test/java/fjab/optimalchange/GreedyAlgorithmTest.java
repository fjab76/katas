package fjab.optimalchange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

/**
 * Created by franciscoalvarez on 27/02/2016.
 */
public class GreedyAlgorithmTest {

  private OptimalChange optimalChange;

  @Before
  public void init(){
    //Use either one of the 2 implementations: GreedyRecursiveImpl or GreedyIterativeImpl
    optimalChange = new GreedyIterativeImpl();
  }

  @Test
  public void optimalChangeFor1pIs_1p(){

    //given
    int pence = 1;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    List<Integer> change = (List) optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(1));
    Assert.assertEquals(expectedChange,change);

  }

  @Test
  public void optimalChangeFor3pIs_2p1p(){

    //given
    int pence = 3;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    List<Integer> change = (List) optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(2),Integer.valueOf(1));
    Assert.assertEquals(expectedChange,change);

  }


  @Test
  public void optimalChangeFor12pIs_10p2p(){

    //given
    int pence = 12;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    List<Integer> change = (List) optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(10),Integer.valueOf(2));
    Assert.assertEquals(expectedChange,change);

  }

  @Test
  public void optimalChangeFor29pIs_20p5p2p2p(){

    //given
    int pence = 29;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    List<Integer> change = (List) optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(20),Integer.valueOf(5),Integer.valueOf(2),Integer.valueOf(2));
    Assert.assertEquals(expectedChange,change);

  }

  @Test
  public void maxCoinEqualOrLessThan10Is10(){

    //given
    int pence = 10;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    int coin = OptimalChange.maxCoinEqualOrLessThan(pence,coinBase);

    //then
    int expected = 10;
    Assert.assertEquals(expected,coin);
  }

  @Test
  public void maxCoinEqualOrLessThan12Is10(){

    //given
    int pence = 12;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    int coin = OptimalChange.maxCoinEqualOrLessThan(pence,coinBase);

    //then
    int expected = 10;
    Assert.assertEquals(expected,coin);
  }

  @Test
  public void maxCoinEqualOrLessThan1Is1(){

    //given
    int pence = 1;
    int[] coinBase = {1,2,5,10,20,50,100};

    //when
    int coin = OptimalChange.maxCoinEqualOrLessThan(pence,coinBase);

    //then
    int expected = 1;
    Assert.assertEquals(expected,coin);
  }

  @Test
  public void whenSearchValueIs12_returnedIndexIsMinus5(){

    Assert.assertEquals(-5,Arrays.binarySearch(new int[]{1,2,5,10,20,50,100}, 12));
  }

  @Test
  public void whenSearchValueIs1_returnedIndexIs0(){

    Assert.assertEquals(0,Arrays.binarySearch(new int[]{1,2,5,10,20,50,100},1));
  }

  @Ignore("greedy algorithms do not work with this coin base")
  public void optimalChangeFor9pIs_4p4p1p(){

    //given
    int pence = 9;
    int[] coinBase = {1,4,6};

    //when
    List<Integer> change = (List) optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(4),Integer.valueOf(4),Integer.valueOf(1));
    Assert.assertEquals(expectedChange, change);

  }

}
