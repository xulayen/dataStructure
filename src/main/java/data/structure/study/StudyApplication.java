package data.structure.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StudyApplication.class, args);

		var list = init();

		System.out.println("==========================顺序遍历=========================================");
		printList(list);

		System.out.println("==========================倒叙遍历=========================================");
		printListRev(list);

		System.out.println("==========================链表翻转=========================================");
		var list2 = revList(list);
		printList(list2);

		System.out.println("初始化二叉树完成...");
		var treeNode = treeNodeInit();

		System.out.println("==========================二叉树-前序遍历=========================================");
		treeNode.preorder(treeNode);
		System.out.println("");

		System.out.println("==========================二叉树-中序遍历=========================================");
		treeNode.inorder(treeNode);
		System.out.println("");

		System.out.println("==========================二叉树-中序遍历2=========================================");
		treeNode.inorder2(treeNode);
		System.out.println("");

		System.out.println("==========================二叉树-后序遍历=========================================");
		treeNode.postorder(treeNode);
		System.out.println("");

	}

	private static Node<String> init() {
		Node<String> head = null;
		Node<String> tail = null;

		head = new Node("nodedata1");
		tail = head;

		tail.next = new Node("nodedata2");
		tail = tail.next;

		tail.next = new Node("nodedata3");
		tail = tail.next;

		tail.next = new Node("nodedata4");
		tail = tail.next;

		return head;
	}

	/**
	 * 顺序链表
	 */
	private static void printList(Node<String> head) {
		// 拿到当前链条节点头
		Node<String> current = head;
		while (current != null) {
			System.out.println(current.item);
			current = current.next;
		}
	}

	/**
	 * 倒叙遍历
	 * 
	 * @param head
	 */
	private static void printListRev(Node<String> head) {
		if (head != null) {
			printListRev(head.next);
			System.out.println(head.item);
		}
	}

	/**
	 * 单链表反转 主要是逐一改变两个节点间的链接关系来完成
	 * 
	 * @param head
	 * @return
	 */
	private static Node<String> revList(Node<String> head) {
		if (head == null) {
			return null;
		}

		Node<String> nodeResult = null;
		Node<String> preNode = null;
		Node<String> current = head;

		while (current != null) {
			Node<String> nodeNext = current.next;
			if (nodeNext == null) {
				nodeResult = current;
			}
			// 以当前节点为参照，当前节点与相邻节点互换关系
			current.next = preNode;
			preNode = current;
			current = nodeNext;
		}

		return nodeResult;

	}

	private static TreeNode<String> treeNodeInit() {
		TreeNode<String> resultNodeRoot = new TreeNode<String>("A");
		var b = new TreeNode<String>("B");
		var c = new TreeNode<String>("C");
		resultNodeRoot.left = b;
		resultNodeRoot.right = c;

		var d = new TreeNode<String>("D");
		var e = new TreeNode<String>("E");
		b.left = d;
		b.right = e;

		var h = new TreeNode<String>("H");
		var i = new TreeNode<String>("I");
		d.left = h;
		d.right = i;

		var f=new TreeNode<String>("F");
		var g=new TreeNode<String>("G");
		c.left=f;
		c.right=g;

		var j=new TreeNode<String>("J");
		g.left=j;

		var k=new TreeNode<String>("K");
		j.right=k;


		return resultNodeRoot;

	}

}