import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; // Vertical cut costs (m-1 = 5 cuts needed)
        Integer costHor[] = {4, 1, 2}; // Horizontal cut costs (n-1 = 3 cuts needed)

        // Step 1: Sort both arrays in descending order (Greedy approach)
        // Sorting ensures that we always take the costliest cut first
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // Pointers to track cuts in horizontal and vertical arrays
        int hp = 1, vp = 1; // Number of current horizontal and vertical pieces
        int cost = 0; // Total cost of making the cuts

        // Step 2: Process both vertical and horizontal cuts
        while (h < costHor.length && v < costVer.length) {
            // Always pick the more expensive cut first to minimize cost
            if (costVer[v] >= costHor[h]) { // Vertical cut
                cost += (costVer[v] * hp); // Multiply cost by current horizontal partitions
                vp++; // Increase vertical partitions after making a vertical cut
                v++; // Move to the next vertical cut
            } else { // Horizontal cut
                cost += (costHor[h] * vp); // Multiply cost by current vertical partitions
                hp++; // Increase horizontal partitions after making a horizontal cut
                h++; // Move to the next horizontal cut
            }
        }

        // Step 3: Process remaining horizontal cuts (if any)
        while (h < costHor.length) {
            cost += (costHor[h] * vp); // Multiply cost by current vertical partitions
            hp++; // Increase horizontal partitions
            h++;
        }

        // Step 4: Process remaining vertical cuts (if any)
        while (v < costVer.length) {
            cost += (costVer[v] * hp); // Multiply cost by current horizontal partitions
            vp++; // Increase vertical partitions
            v++;
        }

        // Step 5: Print the final minimum cost
        System.out.println("Minimum cost = " + cost);
    }
}
