package fjab.berlinclock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {

  private BerlinClock berlinClock;

  @Before
  public void setup(){
    berlinClock = new BerlinClock();
  }

  @Test
  public void is_00_00_00(){

    String standardRepresentation = "00:00:00";
    String berlinClockRepresentation = berlinClock.getTime(standardRepresentation);

    assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO",berlinClockRepresentation);
  }

  @Test
  public void is_13_17_01(){

    String standardRepresentation = "13:17:01";
    String berlinClockRepresentation = berlinClock.getTime(standardRepresentation);

    assertEquals("O RROO RRRO YYROOOOOOOO YYOO",berlinClockRepresentation);
  }

  @Test
  public void is_23_59_59(){

    String standardRepresentation = "23:59:59";
    String berlinClockRepresentation = berlinClock.getTime(standardRepresentation);

    assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY",berlinClockRepresentation);
  }

  @Test
  public void is_24_00_00(){

    String standardRepresentation = "24:00:00";
    String berlinClockRepresentation = berlinClock.getTime(standardRepresentation);

    assertEquals("Y RRRR RRRR OOOOOOOOOOO OOOO",berlinClockRepresentation);
  }

}