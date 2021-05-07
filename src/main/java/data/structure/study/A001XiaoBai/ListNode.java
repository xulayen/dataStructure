package data.structure.study.A001XiaoBai;

/**
 * 单向链表，使用递归进行操作
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484467&idx=1&sn=beb3ae89993b812eeaa6bbdeda63c494&chksm=9bd7fa3baca0732dc3f9ae9202ecaf5c925b4048514eeca6ac81bc340930a82fc62bb67681fa&scene=21#wechat_redirect
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)，因为要使用到堆栈；如果使用递归则空间复杂度是O(1)
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 翻转链表
     * 
     * @param root
     * @return
     */
    public ListNode reverse(ListNode root) {
        if (root.next == null)
            return root;
        ListNode last = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return last;
    }

    private ListNode successor;

    /**
     * 翻转指定位置链表
     * 
     * @param root
     * @param n
     * @return
     */
    public ListNode reverse(ListNode root, int n) {
        if (root.next == null)
            return root;
        if (n == 1) {
            successor = root.next;
            return root;
        }
        ListNode last = reverse(root, n - 1);
        root.next.next = root;
        root.next = successor;
        return last;
    }

    /**
     * 翻转指定区间节点
     * @param root
     * @param m
     * @param n
     * @return
     */
    public ListNode reverse(ListNode root, int m, int n) {
        if (m > n) {
            return root;
        }
        if (m == 1) {
            return reverse(root, n);
        }
        root.next = reverse(root, m - 1, n - 1);
        return root;
    }

}
