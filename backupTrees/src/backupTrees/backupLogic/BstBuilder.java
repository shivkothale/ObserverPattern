package backupTrees.backupLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import backupTrees.util.FileProcessor;
import backupTrees.util.Results;

public class BstBuilder{
    static Node root1=null;
    static Node root2=null;  
    static Node root3=null;
    static Node root4=null;

    static BinarySearchTree bst=new BinarySearchTree();

    static Set<Integer>setI=new HashSet<>();
    static Set<String>setS=new HashSet<>();
   /**
    * Reads data from a file and processes it by adding it to a data structure, likely a tree.
    *
    * @param filePath The path to the file to be read.
    * @param res An instance of the "Results" class for storing results.
    */
    public void readFile(String filePath, Results res){
        FileProcessor fProcessor=new FileProcessor(filePath);
        Scanner sc=fProcessor.getFileReader();
        while(sc.hasNextLine()){
            String []list=fProcessor.readLine(sc);
            addToTree(list,res);
        }
        fProcessor.closeScanner(sc);
    }

    /**
     * @param list
     * @param res
     */
    private void addToTree(String[] list,Results res) {
        int bNumber=0; String b=null;
        String originalString = list[1];
        String name = originalString.substring(0, originalString.length() - 1);
        try{b=list[0];
            if(b.length()==0||originalString.length()==0){
                res.writeError("Invalid Input provided");
            }bNumber=Integer.parseInt(b);}
        catch(NumberFormatException e)
        {e.printStackTrace(); res.writeError("BNumber "+b+" is not a integer");
        res.colseFileWriter();
        System.exit(0);}
       
        Node n=new Node(bNumber, name);
        if(setI.contains(bNumber)|| setS.contains(name)){res.writeError("Duplicate Student"+ n.toString());return;}
        else{setI.add(bNumber);setS.add(name);}
        Node n1=new Node(bNumber, name);
        Node n2=new Node(bNumber, name);
        Node n3=new Node(bNumber, name);
        FilterI filter=new FilterIAllImpl();
        FilterI primeFilter=new FilterPrimeImpl();
        n.registerObserver(filter,n1);
        n.registerObserver(filter,n2);
        n.registerObserver(primeFilter,n3);
        root1=bst.insert(root1,n);
        root2=bst.insert(root2,n1);
        root3=bst.insert(root3,n2);
        root4=bst.insert(root4,n3);
       
    }
    /**
     * @param fProcessor
     */
    public void printAll(Results fProcessor){
        System.out.print("\nMain Bst->");
        fProcessor.writeResult("\nMain Bst->");
        bst.inorder(fProcessor,root1);
        System.out.print("\nBackup1 Bst->");
        fProcessor.writeResult("\nBackup1 Bst->");
        bst.inorder(fProcessor,root2);
        System.out.print("\nBackup2 Bst->");
        fProcessor.writeResult("\nBackup2 Bst->");
        bst.inorder(fProcessor,root3);
        System.out.print("\nBackup3 Bst->");
        fProcessor.writeResult("\nBackup3 Bst->");
        bst.inorder(fProcessor,root4);
        System.out.println();
   }
    /**
     * @param fProcessor
     */
    public void printSum(Results fProcessor){
        System.out.println("\nBst->"+bst.findSum(root1));
        fProcessor.writeResult(String.format("\nBst->%d",bst.findSum(root1)));
        System.out.println("Backup1 Bst->"+bst.findSum(root2));
        fProcessor.writeResult(String.format("\nBackup1 Bst->%d",bst.findSum(root2)));
        System.out.println("Backup2 Bst->"+bst.findSum(root3));
        fProcessor.writeResult(String.format("\nBackup1 Bst->%d",bst.findSum(root3)));      
        System.out.println("Backup3 Bst->"+bst.findSum(root4));  
        fProcessor.writeResult(String.format("\nBackup1 Bst->%d",bst.findSum(root4)));      
        System.out.println();
   }

    public void updateAll(int i) {
        bst.updateAll(root1,i);
    }
}
