class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        """
        Given a binary tree, determine if it is height-balanced.

        For this problem, a height-balanced binary tree is defined as:

        a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
        :param root:
        :return:
        """
        if root is None:
            return True
        if root.left is None and root.right is None:
            return True
        left_h = self.height(root.left)
        right_h = self.height(root.right)
        if abs(left_h - right_h) > 1:
            return False
        else:
            return self.isBalanced(root.right) and self.isBalanced(root.left)

    def height(self, root: 'TreeNode') -> int:
        if root is None:
            return 0
        left_height = 1 + self.height(root.left)
        right_height = 1 + self.height(root.right)
        return max(left_height, right_height)


Solution().isBalanced(None)
