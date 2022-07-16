/*
Fractional Knapsack

Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the Knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

*/

class itemComparator implement Comparator<Item> {
    @Override
    public int compare(Item a , Item b) {
        double i1 = (double)(a.value) / (double)(a.weight);
        double i2 = (double)(b.value) / (double)(b.weight);

        if(i1 < i2) {
            return 1;
        } else if(i1 > i2) {
            return -1;
        } else {
            return 0;
        }
    }
}
class Solve {
    double fractionalKnapsack(int W , Item a[] , int n) {
        Arrays.sort(a , new itemComparator());

        int curWeight = 0;
        double finalValue = 0.0;

        for(int i = 0 ; i < n ; i++) {
            if((curWeight + a[i].weight) <= W) {
                curWeight += a[i].weight;
                finalValue += a[i].value;
            } else {
                int remain = (W - curWeight);
                finalValue += (((double)a[i].value / (double)a[i].weight) * (double)remain);
                break;
            }
        }
        return finalValue;
    }
}
