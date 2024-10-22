/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long BFS_Gezi(TreeNode root,int k) {
        List<Long> leveltoplam = new ArrayList<>();
        Queue<TreeNode> Kuyruk = new LinkedList<>();
        Kuyruk.add(root);
        while (!Kuyruk.isEmpty()) {
            int Node_Count = Kuyruk.size();
            long toplam=0;
            for (int i = 0; i < Node_Count; i++) {
                TreeNode Simdiki_Dugum = Kuyruk.poll();
                toplam+=Simdiki_Dugum.val;
                if (Simdiki_Dugum.left != null) {
                    Kuyruk.add(Simdiki_Dugum.left);
                }
                if (Simdiki_Dugum.right != null) {
                    Kuyruk.add(Simdiki_Dugum.right);
                }
            }
            leveltoplam.add(toplam);
        }

        Collections.sort(leveltoplam, Collections.reverseOrder());
        System.out.println(leveltoplam.toString());
        if(k>leveltoplam.size()) return -1;
        else return leveltoplam.get(k-1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        return BFS_Gezi(root,k);
    }
}
