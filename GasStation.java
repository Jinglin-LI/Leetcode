/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/
// store the oweGas when the restGas in the position i less than 0. In the end, compare the oweGas with the restGas.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int restGas = 0;
        int oweGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            restGas = restGas + gas[i] - cost[i];
            if (restGas < 0) {
                oweGas = oweGas + restGas;
                restGas = 0;
                start = i + 1;
            }
        }
        return oweGas + restGas >= 0? start : -1;
    }
}
