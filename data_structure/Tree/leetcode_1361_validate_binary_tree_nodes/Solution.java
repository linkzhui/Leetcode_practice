package Google.data_structure.Tree.leetcode_1361_validate_binary_tree_nodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)    {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node cur;
            int leftChildVal = leftChild[i];
            int rightChildVal = rightChild[i];

            if (nodeMap.containsKey(i)) {
                cur = nodeMap.get(i);
                if (cur.leftChild == -1) {
                    cur.leftChild = leftChildVal;
                } else if (cur.leftChild != leftChildVal) {
                    return false;
                }

                if (cur.rightChild == -1) {
                    cur.rightChild = rightChildVal;
                } else if (cur.rightChild != rightChildVal) {
                    return false;
                }
            } else {
                cur = new Node(leftChildVal, rightChildVal);
            }

            nodeMap.put(i, cur);

            Node leftCur;
            if (leftChildVal != -1) {
                if (nodeMap.containsKey(leftChildVal)) {
                    leftCur = nodeMap.get(leftChildVal);
                    if (leftCur.parent == -1) {
                        leftCur.parent = i;
                    } else if (leftCur.parent != i) {
                        return false;
                    }
                } else {
                    leftCur = new Node(i);
                }
                nodeMap.put(leftChildVal, leftCur);
            }


            Node rightCur;
            if (rightChildVal != -1){
                if (nodeMap.containsKey(rightChildVal)) {
                    rightCur = nodeMap.get(rightChildVal);
                    if (rightCur.parent == -1) {
                        rightCur.parent = i;
                    } else if (rightCur.parent != i) {
                        return false;
                    }
                } else {
                    rightCur = new Node(i);
                }
                nodeMap.put(rightChildVal, rightCur);
            }

        }
        int[] root = new int[1];
        root[0] = -1;
        for (Map.Entry<Integer,Node> entry : nodeMap.entrySet()) {
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            if (!checkLoop(nodeMap, new boolean[n], entry.getKey(), root)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLoop(HashMap<Integer, Node> nodeMap, boolean[] visited, int cur, int[] root) {
        Node curNode = nodeMap.get(cur);
        while(curNode.parent != -1)
        {
            if (visited[cur]) {
                return false;
            }
            visited[cur] = true;
            cur = curNode.parent;
            curNode = nodeMap.get(cur);
        }
        if (root[0] == -1) {
            //check if all the nodes are connected
            root[0] = cur;
        } else if (root[0] != cur) {
            return false;
        }
        return true;
    }

    private class Node {
        int parent = -1;
        int leftChild = -1;
        int rightChild = -1;

        public Node(int parent) {
            this.parent = parent;
        }

        public Node(int leftChild, int rightChild) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}