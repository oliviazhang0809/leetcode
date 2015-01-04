import java.util.ArrayList;

public class PathSum_TreeNode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);

		ArrayList<Integer> list = new ArrayList<Integer>();
		findPath(root, 22, list, 0);
	}

	public static void findPath(TreeNode root, int target,
			ArrayList<Integer> list, int currSum) {
		if (root == null) {
			return;
		}

		currSum += root.val;
		list.add(root.val);
		boolean isLeaf = root.left == null && root.right == null;
		if (currSum == target && isLeaf) {
			System.out.println(list);
		}

		if (root.left != null) {
			findPath(root.left, target, list, currSum);
		}

		if (root.right != null) {
			findPath(root.right, target, list, currSum);
		}

		currSum -= root.val;
		list.remove(list.size() - 1);
	}

}
