package fjab.stringcalculator;

/**
 * Created by franciscoalvarez on 02/03/2016.
 */
public class StringCalculator {

  private String[] delimiter = {",", System.lineSeparator(), null, null};

  int calculate(String str) {

    int indexMultiCharDelimiterDefinition = str.indexOf("//[");
    int indexSingleCharDelimiterDefinition = -1;
    if (indexMultiCharDelimiterDefinition == -1) {
      indexSingleCharDelimiterDefinition = str.indexOf("//");
    }
    int indexCommaDelimiter = str.indexOf(",");
    int indexLineSeparatorDelimiter = str.indexOf(System.lineSeparator());
    int indexSingleCharDelimiter = delimiter[2] != null ? str.indexOf(delimiter[2]) : -1;
    int indexMultiCharDelimiter = delimiter[3] != null ? str.indexOf(delimiter[3]) : -1;

    if (str != null && str.length() == 0) {
      return 0;
    } else if (indexSingleCharDelimiterDefinition != -1) {
      delimiter[2] = str.substring(indexSingleCharDelimiterDefinition + 2, indexSingleCharDelimiterDefinition + 3);
      return calculate(str.substring(indexSingleCharDelimiterDefinition + 3, str.length()));
    } else if (indexMultiCharDelimiterDefinition != -1) {
      delimiter[3] = str.substring(indexMultiCharDelimiterDefinition + 3, str.indexOf("]"));
      return calculate(str.substring(str.indexOf("]") + 1, str.length()));
    } else if (indexCommaDelimiter != -1) {
      return calculate(str.substring(0, indexCommaDelimiter)) + calculate(str.substring(indexCommaDelimiter + 1, str.length()));
    } else if (indexLineSeparatorDelimiter != -1) {
      return calculate(str.substring(0, indexLineSeparatorDelimiter)) + calculate(str.substring(indexLineSeparatorDelimiter + 1, str.length()));
    } else if (indexSingleCharDelimiter != -1) {
      return calculate(str.substring(0, indexSingleCharDelimiter)) + calculate(str.substring(indexSingleCharDelimiter + 1, str.length()));
    } else if (indexMultiCharDelimiter != -1) {
      return calculate(str.substring(0, indexMultiCharDelimiter)) + calculate(str.substring(indexMultiCharDelimiter + delimiter[3].length(), str.length()));
    } else if (Integer.parseInt(str) > 1000) {
      return 0;
    } else if (Integer.parseInt(str) > -1) {
      return Integer.parseInt(str);
    } else {
      throw new RuntimeException();
    }
  }
}
