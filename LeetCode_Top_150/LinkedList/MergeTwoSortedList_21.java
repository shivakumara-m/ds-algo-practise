package LeetCode_Top_150.LinkedList;

public class MergeTwoSortedList_21 {

    public static void main(String[] args) {
        MergeTwoSortedList_21 m = new MergeTwoSortedList_21();
        ListNode l1 = new ListNode(-10, new ListNode(-10, new ListNode(-9, new ListNode(-4, new ListNode(1, new ListNode(6, new ListNode(6)) )) )));
        ListNode l2 = new ListNode(-7, null);

        ListNode res = m.mergeTwoLists(l1, l2);

        while (res.next != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode mergedList = new ListNode();
        ListNode megListNodeHead = mergedList;
        while (list1 != null && list2 != null) {
            int tmp;
            if (list1.val < list2.val) {
                tmp = list1.val;
                list1 = list1.next;
            } else {
                tmp = list2.val;
                list2 = list2.next;
            }
            //mergedList.val  = tmp;
            mergedList.next = new ListNode(tmp);
            mergedList = mergedList.next;
        }

        if (list1 != null) {
            while (list1 != null) {
                mergedList.next = new ListNode(list1.val, null);
                list1 = list1.next;
                mergedList = mergedList.next;
            }
        }

        if (list2 != null) {
            while (list2 != null) {
                mergedList.next = new ListNode(list2.val, null);
                list2 = list2.next;
                mergedList = mergedList.next;
            }
        }

        return megListNodeHead.next;
    }

}