/*
======================== FLOOD FILL ALGORITHM ========================

QUESTION:
You are given an m x n integer grid (image), where image[i][j] represents
the color of a pixel.

You are also given:
- sr (starting row)
- sc (starting column)
- color (new color)

You need to perform a flood fill starting from image[sr][sc].

RULE:
Change the color of the starting pixel and all 4-directionally connected
pixels having the same original color.

=====================================================================
*/

public class FloodFillAlgo {

    /*
    ======================== APPROACH ========================

    We use DFS (Depth First Search).

    1. Save the original color of the starting pixel.
    2. From the starting pixel, move in 4 directions:
       left, right, up, down.
    3. If the next pixel:
       - is inside the grid
       - is not visited
       - has the same original color
       then:
       - mark it visited
       - change its color
       - continue DFS

    ==========================================================
    */

    public void helper(int[][] image, int sr, int sc, int color,
                       boolean[][] vis, int orgCol) {

        // Stop conditions
        if (sr < 0 || sc < 0 ||
            sr >= image.length || sc >= image[0].length ||
            vis[sr][sc] == true ||
            image[sr][sc] != orgCol) {
            return;
        }

        // Mark current pixel as visited
        vis[sr][sc] = true;

        // Fill the pixel with new color
        image[sr][sc] = color;

        // Explore all 4 directions
        helper(image, sr, sc - 1, color, vis, orgCol); // left
        helper(image, sr, sc + 1, color, vis, orgCol); // right
        helper(image, sr - 1, sc, color, vis, orgCol); // up
        helper(image, sr + 1, sc, color, vis, orgCol); // down
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] vis = new boolean[image.length][image[0].length];

        int originalColor = image[sr][sc];

        helper(image, sr, sc, color, vis, originalColor);

        return image;
    }

    public static void main(String[] args) {
        // Test cases can be added here
    }
}

/*
======================== DRY RUN ========================

Input:
image = [
  [1, 1, 1],
  [1, 1, 0],
  [1, 0, 1]
]
sr = 1, sc = 1, color = 2

Step 1:
Starting pixel = image[1][1] = 1
originalColor = 1

Step 2:
Call helper(1, 1)
- valid cell
- not visited
- color == originalColor

Action:
image[1][1] = 2
vis[1][1] = true

Image becomes:
[
  [1, 1, 1],
  [1, 2, 0],
  [1, 0, 1]
]

Step 3: Explore neighbors of (1,1)

LEFT → (1,0)
- value = 1 (same as original)
- change to 2

Image:
[
  [1, 1, 1],
  [2, 2, 0],
  [1, 0, 1]
]

RIGHT → (1,2)
- value = 0 (different)
- stop

UP → (0,1)
- value = 1
- change to 2

Image:
[
  [1, 2, 1],
  [2, 2, 0],
  [1, 0, 1]
]

DOWN → (2,1)
- value = 0 (different)
- stop

Step 4:
Continue DFS from newly changed cells

From (0,1):
LEFT → (0,0) → change to 2
RIGHT → (0,2) → change to 2
UP → out of bounds
DOWN → already visited

From (1,0):
DOWN → (2,0) → change to 2

Final Image:
[
  [2, 2, 2],
  [2, 2, 0],
  [2, 0, 1]
]

======================== OUTPUT ========================
[
  [2, 2, 2],
  [2, 2, 0],
  [2, 0, 1]
]
=======================================================
*/
