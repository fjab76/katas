package fjab.stringcalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by franciscoalvarez on 25/01/2016.
 */

public class StringCalculatorTest {

  private StringCalculator calculator;

  @Before
  public void init() {
    calculator = new StringCalculator();
  }

  @Test
  //An empty string returns zero
  public void emptyStringIs0(){
    Assert.assertEquals(0,calculator.calculate(""));
  }

  @Test
  //A single number returns the value
  public void singleNumberReturnsValue(){
    Assert.assertEquals(1,calculator.calculate("1"));
  }

  @Test
  //Two numbers, comma delimited, returns the sum
  public void twoNumbersCommaDelimitedReturnSum(){
    Assert.assertEquals(3,calculator.calculate("1,2"));
  }

  @Test
  //Two numbers, newline delimited, returns the sum
  public void twoNumbersNewlineDelimitedReturnSum(){
    Assert.assertEquals(3,calculator.calculate("1" + System.lineSeparator() + "2"));
  }

  @Test
  //Three numbers, delimited either way, returns the sum
  public void threeNumbersDelimitedReturnSum(){
    Assert.assertEquals(6, calculator.calculate("1" + System.lineSeparator() + "2,3"));
  }

  @Test(expected = Exception.class)
  //Negative numbers throw an exception
  public void negativeNumbersThrowException(){
    calculator.calculate("-1");
  }

  @Test(expected = Exception.class)
  //Negative numbers throw an exception
  public void negativeNumbersWithDelimitersThrowException(){
    calculator.calculate("3,-1");
  }

  @Test
  //Numbers greater than 1000 are ignored
  public void numbersGreater1000AreIgnored(){
    Assert.assertEquals(1, calculator.calculate("1,1001"));
  }

  @Test
  //A single char delimiter can be defined on the first line (e.g. //# for a ‘#’ as the delimiter)
  public void singleCharDelimiterCanBeDefined(){
    Assert.assertEquals(3, calculator.calculate("//#1#2"));
  }

  @Test
  //A multi char delimiter can be defined on the first line (e.g. //[###] for ‘###’ as the delimiter)
  public void multiCharDelimiterCanBeDefined(){
    Assert.assertEquals(3, calculator.calculate("//[###]1###2"));
  }

  @Test
  public void multiDelimiters(){
    Assert.assertEquals(10, calculator.calculate("//[###]1,2"+System.lineSeparator()+"3###4"));
  }

}
