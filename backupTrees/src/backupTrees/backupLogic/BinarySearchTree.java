package backupTrees.backupLogic;

import backupTrees.util.Results;

public class BinarySearchTree{
    /**
     * @param root
     * @param bNumber
     * @param name
     * @return
     */
    public Node insertBst(Node root,int bNumber,String name){
        Node n=new Node(bNumber,name);
        root=insert(root,n);
        return n;
    }
    /**
     * @param node
     * @param n
     * @return
     */
    public Node insert(Node node, Node n) {
        if(node==null){
            return n;
        }
        if(n.getbNumber()<node.getbNumber()){
            node.left=insert(node.left,n);
        }else{
            node.right=insert(node.right,n);
        }
        return node;
    }
    /**
     * @param fProcessor
     * @param root
     */
    public void inorder(Results fProcessor, Node root){
       inorderTraversal(root,fProcessor);
    }
    public void inorderTraversal(Node node, Results fProcessor){
        if(node==null){
            return;
        }
        inorderTraversal(node.left,fProcessor);
        System.out.print(node.toString()+"\t");
        fProcessor.writeResult(node.toString()+"\t");
        inorderTraversal(node.right,fProcessor);
    }
    /**
     * @param root
     * @param value
     */
    public void updateAll(Node root, int value){
        updateAllNodes(root,value);
    }

    private void updateAllNodes(Node node,int value) {
        if(node==null){
            return;
        }
        updateAllNodes(node.left,value);
        node.setbNumber(node.getbNumber()+value);
        node.notifyAllObservers();
        updateAllNodes(node.right,value);
    }
    public int findSum(Node root){
        return findSumHelper(root);
    }

    private int findSumHelper(Node node) {
        if(node==null){
            return 0;
        }
        int left=findSumHelper(node.left);
        int right=findSumHelper(node.right);
        return left+right+node.getbNumber();
    }
}