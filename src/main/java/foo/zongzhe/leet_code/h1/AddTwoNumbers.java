package main.java.problems.h1;

import main.java.objects.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0;
            int digit = 1;
            ListNode l1Next = l1.next();
            ListNode l2Next = l2.next();
            int l1Int = 0;
            int l2Int = 0;
            while (l1Next != null || l2Next != null) {
                if (l1Next == null) {
                    l1Int = 0;
                } else {
                    l1Int = l1Next.val;
                }

                if (l2Next == null) {
                    l2Int = 0;
                } else {
                    l2Int = l2Next.val;
                }

                sum += digit * (l1Int + l2Int);
                digit *= 10;
                l1Next = l1.next();
                l2Next = l2.next();

            }
            return new ListNode(sum);

        }
    }

}
