package fjab.optimalchange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by franciscoalvarez on 28/02/2016.
 */
public class DPImplTest {

  private OptimalChange optimalChange;

  @Before
  public void init(){
    optimalChange = new DPImpl();
  }

  @Test
  public void optimalChangeFor1pIs_1p(){

    //given
    int pence = 1;
    int[] coinBase = {1,4,6};

    //when
    List<Integer> change = optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(1));
    Assert.assertEquals(expectedChange, change);

  }

  @Test
  public void optimalChangeFor3pIs_1p1p1p(){

    //given
    int pence = 3;
    int[] coinBase = {1,4,6};

    //when
    List<Integer> change = optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(1));
    Assert.assertEquals(expectedChange, change);

  }

  @Test
  public void optimalChangeFor4pIs_4p(){

    //given
    int pence = 4;
    int[] coinBase = {1,4,6};

    //when
    List<Integer> change = optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(4));
    Assert.assertEquals(expectedChange, change);

  }

  @Test
  public void optimalChangeFor5pIs_4p1p(){

    //given
    int pence = 5;
    int[] coinBase = {1,4,6};

    //when
    List<Integer> change = optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(4),Integer.valueOf(1));
    Assert.assertEquals(expectedChange, change);

  }

  @Test
  public void optimalChangeFor9pIs_4p4p1p(){

    //given
    int pence = 9;
    int[] coinBase = {1,4,6};

    //when
    List<Integer> change = optimalChange.optimalChangeFor(pence,coinBase);

    //then
    List<Integer> expectedChange = Arrays.asList(Integer.valueOf(4), Integer.valueOf(4), Integer.valueOf(1));
    Assert.assertEquals(expectedChange, change);

  }

  @Test
  public void coinsEqualsOrLessThan5Is1_4(){

    //given
    int pence = 5;
    int[] coinBase = {1,4,6};

    //when
    int[] coins = OptimalChange.coinsEqualOrLessThan(pence, coinBase);

    //then
    int[] expected = {1,4};
    Assert.assertArrayEquals(expected, coins);
  }

  @Test
  public void partialNumberOfCoinsFor1pIs_0_1(){

    //given
    int pence = 1;
    int[] coinBase = {1,4,6};

    //when
    int[][] partialSolutions = ((DPImpl)optimalChange).partialSolutions(pence, coinBase);

    //then
    int[] expected = {0,1};
    Assert.assertArrayEquals(expected,partialSolutions[0]);

  }

  @Test
  public void partialCoinsFor1pIs_0_1(){

    //given
    int pence = 1;
    int[] coinBase = {1,4,6};

    //when
    int[][] partialSolutions = ((DPImpl)optimalChange).partialSolutions(pence, coinBase);

    //then
    int[] expected = {0,1};
    Assert.assertArrayEquals(expected,partialSolutions[1]);

  }

  @Test
  public void partialNumberOfCoinsFor4pIs_0_1_2_3_1(){

    //given
    int pence = 4;
    int[] coinBase = {1,4,6};

    //when
    int[][] partialSolutions = ((DPImpl)optimalChange).partialSolutions(pence, coinBase);

    //then
    int[] expected = {0,1,2,3,1};
    Assert.assertArrayEquals(expected,partialSolutions[0]);

  }

  @Test
  public void partialCoinsFor4pIs_0_1_1_1_4(){

    //given
    int pence = 4;
    int[] coinBase = {1,4,6};

    //when
    int[][] partialSolutions = ((DPImpl)optimalChange).partialSolutions(pence, coinBase);

    //then
    int[] expected = {0,1,1,1,4};
    Assert.assertArrayEquals(expected,partialSolutions[1]);

  }

}
