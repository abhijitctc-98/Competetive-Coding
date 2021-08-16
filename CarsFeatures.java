/*
This question was asked by MICROSOFT in 2021 as an online TECH ROUND.
There are N cars, numbered from 0 to N-1.
Each of them has some of the M possible optional features, numbered from 0 to M-1, for example: voice control, keyless entry, sunroof, blind spot detection, etc.
The features of a car are described as a string of M characters, where the K-th character being '1' denotes that the car has the K-th possible feature and '0' denotes that it does not.
Two cars are similar if their descriptions differ by at most one feature.

For example: T1101° and "01001" are similar, because they differ only by feature number 2. On the other hand, "01101" and "11110" are not similar, because they differ in feature numbers 0, 3 and 4.
Each car from the following set is similar to °011°: '011', "111", "001", "010°.

Notice that cars "011" and "011" are similar as their set of features is exactly the same.
We want to suggest to potential customers alternative cars to the one under consideration. In order to do that, for each individual car, calculate the number of other cars to which it is similar (differ from it by at most one feature).

Example: 1. Given cars = ["100", °110°, "010", "011", °1 001 the answer should be [2, 3, 2, 1, 2]. Car number 0 ("100") is similar to car number 1 ("110") and also to car number 4 ("100").

Example : 2. Given cars = row "am ", "01 ", "on 0", "00001, the answer should be [2, 3, 3, 2, 0]. Notice that car number 4 (°0000°) is not similar to any other car. All of the other cars have at least two features, while car number 4 has none.

Write an efficient algorithm
*/

public static int[] similarCars(String[] featuresS) { // O(n*m+n^2)
        BitSet[] features = new BitSet[featuresS.length];
        for(int i = 0; i < featuresS.length; i++) { // O(n * m)
            features[i] = stringToBitSet(featuresS[i]);
        }
        int[] similarCars = new int[features.length];
        for(int i = 0; i < similarCars.length-1; i++) { // O(n^2)
            for (int j = i+1; j < similarCars.length; j++) {
                BitSet aux = (BitSet)features[i].clone();
                aux.xor(features[j]);
                if (aux.cardinality() <= 1) {
                    similarCars[i]++;
                    similarCars[j]++;
                }
            }
        }
        return similarCars;
    }
    
    public static BitSet stringToBitSet(String s) {
        BitSet bs = new BitSet(s.length());
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                bs.set(i);
            }
        }
        return bs;
    }
