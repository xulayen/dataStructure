package data.structure.study;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import data.structure.study.common.PrintDataStructure;

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

		System.out.println("==========================二叉树-中序遍历降序=========================================");
		treeNode.inorderDesc(treeNode);
		System.out.println("");

		System.out.println("==========================二叉树-后序遍历=========================================");
		treeNode.postorder(treeNode);
		System.out.println("");

		System.out.println("==========================二叉树-插入节点=======================================");
		var mTree = new MyBinSearchTree(null);
		mTree.insert(63);
		mTree.insert(90);
		mTree.insert(70);
		mTree.insert(55);
		mTree.insert(67);
		mTree.insert(42);
		mTree.insert(98);
		mTree.insert(83);
		mTree.insert(10);
		mTree.insert(45);
		mTree.insert(58);

		var printD = new PrintDataStructure();
		printD.printTreeNode(mTree.root);
		System.out.println("");

		// System.out.println("==========================二叉树-搜索元素=======================================");
		// var isExit = mTree.seach(63);
		// System.out.println(isExit ? "找到了！" : "抱歉，没有找到！");

		// System.out.println("==========================二叉树-删除元素=======================================");
		// mTree.delete(42);
		// printD.printTreeNode(mTree.root);
		// System.out.println("");

		// System.out.println("==========================二叉树-修改元素=======================================");
		// mTree.update(42, 48);
		// printD.printTreeNode(mTree.root);
		// System.out.println("");

		// System.out.println("==========================二叉树-翻转=======================================");
		// var nodeTree=mTree.invertTree(mTree.root);
		// printD.printTreeNode(nodeTree);

		// System.out.println("==========================二叉树-填充每个节点的右侧指针=======================================");
		// var nodeTree = mTree.linkTree(mTree.root);
		// printD.printTreeNode(nodeTree);

		// System.out.println("==========================二叉树-拉平二叉树为链表=======================================");
		// nodeTree = mTree.flatten(mTree.root);
		// // printD.printTreeNode(nodeTree);

		// System.out.println("==========================数组转换成二叉树=======================================");
		// int[] array = new int[] { 3, 2, 1, 6, 0, 5 };
		// nodeTree = mTree.constructMaximumBinaryTree(array);
		// printD.printTreeNode(nodeTree);

		// System.out.println("==========================二叉树-查找重复子节点=======================================");
		// var nodes = treeNodeInit();
		// printD.printTreeNode(nodes);
		// var akList = mTree.findDuplicateSubtrees(nodes);
		// System.out.println(akList);

		System.out.println("==========================二叉搜索树-中序遍历=======================================");
		mTree.root.inorder(mTree.root);
		System.out.println("");

		System.out.println("==========================二叉搜索树-寻找第K小的元素=======================================");
		var ele = mTree.select(mTree.root, 1);
		System.out.println(ele);

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

		var f = new TreeNode<String>("F");
		var g = new TreeNode<String>("G");
		c.left = f;
		c.right = g;

		var j = new TreeNode<String>("J");
		g.left = j;

		var k = new TreeNode<String>("K");
		j.right = k;

		var k1 = new TreeNode<String>("K");
		var H1 = new TreeNode<String>("H");
		f.right = H1;
		e.left = k1;

		return resultNodeRoot;
	}

}
