package com.seerbit.algorithm.xor;

public class XorSubArray {

    private XorSubArray(){}

    public static void add(Node root, int num) {
        Node current = root;
        for (int i = 31; i >= 0; i--) {
            //bit manipulation
            int bit = (num >> i) & 1;
            if (current.children[bit] == null) {
                current.children[bit] = new Node();
            }
            current = current.children[bit];
        }
    }

    public static int findMaxXOR(Node root, int num) {
        Node curr = root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            //doing bit manipulation
            int bit = (num >> i) & 1;
            int oppositeBit = bit ^ 1;
            if (curr.children[oppositeBit] != null) {
                maxXOR |= (1 << i);
                curr = curr.children[oppositeBit];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXOR;
    }

    public static int findMaxXORSubarray(int[] arr) {
        Node root = new Node();
        int maxXOR = Integer.MIN_VALUE;
        int xorSoFar = 0;

        add(root, 0);
        for (int num : arr) {
            xorSoFar ^= num;
            add(root, xorSoFar);
            maxXOR = Math.max(maxXOR, findMaxXOR(root, xorSoFar));
        }

        return maxXOR;
    }
}