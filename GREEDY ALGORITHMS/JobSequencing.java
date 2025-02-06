import java.util.*;

public class JobSequencing {
    // Job class to store job details (id, deadline, profit)
    static class Job {
        int id, deadline, profit;

        public Job(int i, int d, int p) {
            id = i;          // Unique job ID
            deadline = d;    // Maximum time by which job should be completed
            profit = p;      // Profit gained from completing the job
        }
    }

    public static void main(String[] args) {
        // Job information {deadline, profit}
        int jobsInfo[][] = {
            {4, 20},  // Job 0: Deadline = 4, Profit = 20
            {1, 10},  // Job 1: Deadline = 1, Profit = 10
            {1, 40},  // Job 2: Deadline = 1, Profit = 40
            {1, 30}   // Job 3: Deadline = 1, Profit = 30
        };

        // Create a list of Job objects
        ArrayList<Job> jobs = new ArrayList<>();

        // Convert jobsInfo array into Job objects
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Step 1: Sort jobs by profit in descending order (higher profit first)
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline among all jobs
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Create an array to track scheduled jobs at each time slot
        int[] schedule = new int[maxDeadline + 1]; // Array to store scheduled job IDs
        Arrays.fill(schedule, -1); // Initialize all slots as empty (-1 means no job scheduled)

        int totalJobs = 0;  // Count of jobs scheduled
        int totalProfit = 0; // Sum of profits from scheduled jobs

        // Step 4: Assign jobs to available slots
        for (Job job : jobs) {
            // Try to place the job in its latest available time slot (from its deadline to 1)
            for (int t = job.deadline; t > 0; t--) {
                if (schedule[t] == -1) { // If this time slot is free
                    schedule[t] = job.id; // Assign job to this time slot
                    totalJobs++;          // Increase job count
                    totalProfit += job.profit; // Add profit
                    break; // Move to next job after scheduling this one
                }
            }
        }

        // Step 5: Display Results
        System.out.println("Maximum jobs scheduled: " + totalJobs);
        System.out.println("Total profit earned: " + totalProfit);
        System.out.print("Job execution order: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (schedule[i] != -1) { // If a job is scheduled at time i
                System.out.print(schedule[i] + " ");
            }
        }
        System.out.println();
    }
}
