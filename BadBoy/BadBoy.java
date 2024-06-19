import java.util.*;

public class BadBoy {
  /**
   * |  I	 | II |
   * ------------
   * | III | IV |
   */
  enum Region {
    I,
    II,
    III,
    IV
  }

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      var testCount = sc.nextInt();
      sc.nextLine();

      for(int i = 0; i < testCount; i++) {
        var testInfo = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var rows = testInfo[0];
        var columns = testInfo[1];
        var antonRow = testInfo[2];
        var antonColumn = testInfo[3];

        var output = handleTestCase(rows, columns, antonRow, antonColumn);
        System.out.println(output);
      }
    }
  }

  public static String handleTestCase(int rowCount, int columnCount, int antonRow, int antonColumn) {
    float columnMiddle = columnCount / 2;
    float rowMiddle = rowCount / 2;

    int[] antonPosition = new int[] {antonRow, antonColumn};
    int[][] corners = new int[][] {
      new int[] {1,1},
      new int[] {1, columnCount},
      new int[] {rowCount, 1},
      new int[] {rowCount, columnCount}
    };

    var isAntonInACorner = false;
    for (int i = 0; i < corners.length; i++) {
      if(corners[i][0] == antonPosition[0] && corners[i][1] == antonPosition[1]) {
        isAntonInACorner = true;
        break;
      }
    }

    var region = Region.I;
    var isBeforeRowMiddle = antonPosition[0]<=rowMiddle;
    var isBeforeColumnMiddle = antonPosition[1]<=columnMiddle;

    if (isBeforeRowMiddle && !isBeforeColumnMiddle) {
      region = Region.II;
    } else if (!isBeforeRowMiddle && isBeforeColumnMiddle) {
      region = Region.III;
    } else if (!isBeforeRowMiddle && !isBeforeColumnMiddle) {
      region = Region.IV;
    }

    int[] firstCorner = null;
    int[] secondCorner = null;
    switch (region) {
    case Region.I:
      firstCorner = corners[3];
      secondCorner = corners[0];
      if (isAntonInACorner) {
        secondCorner = corners[1];
      }
      break;
    case Region.II:
      firstCorner = corners[2];
      secondCorner = corners[1];
      if (isAntonInACorner) {
        secondCorner = corners[0];
      }
      break;
    case Region.III:
      firstCorner = corners[1];
      secondCorner = corners[2];
      if (isAntonInACorner) {
        secondCorner = corners[0];
      }
      break;
    case Region.IV:
      firstCorner = corners[0];
      secondCorner = corners[3];
      if (isAntonInACorner) {
        secondCorner = corners[1];
      }
      break;
    }

    var equalCorners = firstCorner[0] == secondCorner[0] && firstCorner[1] == secondCorner[1];
    if (equalCorners && rowCount == 1 && columnCount > 1) {
      secondCorner[1] = (secondCorner[1] +1 * (secondCorner[1] == rowCount ? 1 : -1)) ;
    } else if (equalCorners && columnCount == 1 && rowCount > 1) {
      secondCorner[0] = (secondCorner[0] +1 * (secondCorner[0] == columnCount ? 1 : -1)) ;
    }
    return String.format("%s %s %s %s", firstCorner[0], firstCorner[1], secondCorner[0], secondCorner[1]);
  }
}
