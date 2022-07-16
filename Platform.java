/*

Minimum Platforms

Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.


Example 1:

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}

Output: 3

Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.

Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}

Output: 1

Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains. 
*/

import java.util.*;

public class Platform {
    public static void main(String args[]) {
        Scanner ss = new Scanner(System.in);
        System.out.println("\nEnter the number of trains arriving the station:\t");
        int n = ss.nextInt();
        int arr[] = new int[n];
        int dep[] = new int[n];

        System.out.println("\nEnter the Arrival time of "+n+" trains:\t");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = ss.nextInt();
        }

        System.out.println("\nEnter the Departure time of "+n+" trains:\t");
        for(int j = 0 ; j < n ; j++) {
            dep[j] = ss.nextInt();
        }

        System.out.println("\nThe maximum number of platform required is:\t"+findPlatform(arr , dep , n));
    }
    public static int findPlatform(int arr[] , int dep[] , int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1;
        int res = 1;

        int i = 1;// Index use to point the Arrival array
        int j = 0;// Index use to point the Departure array

        while((i < n) && (j < n)) {
            if(arr[i] <= dep[j]) { // This 'if' condition checks, whether the next train arrives earlier than the previous train.
                plat_needed++;
                i++;
            } else if(arr[i] > dep[j]) { // This 'if' condition checks, whether the next train arrives after the departure of previous train.
                plat_needed--;
                j++;
            }

            if(plat_needed > res) {
                res = plat_needed;
            }
        }
        return res;
    }
}
