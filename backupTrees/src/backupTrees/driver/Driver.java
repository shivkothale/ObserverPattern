package backupTrees.driver;

import backupTrees.backupLogic.BstBuilder;
import backupTrees.util.FileProcessor;
import backupTrees.util.Results;

/**
 * @author placeholder
 *
 */
public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args){
	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
		 		|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

		 	System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
		 	System.exit(0);
		 }
		 Results res=new Results(args[1], args[2]);
		 BstBuilder bstBuilder=new BstBuilder();
		 bstBuilder.readFile(args[0],res);
		 System.out.println("// Inorder traversal");
		 res.writeResult("// Inorder traversal\n");
		 bstBuilder.printAll(res); 
		 System.out.println("// Sum of all the B-Numbers in each tree");
		 res.writeResult("\n// Sum of all the B-Numbers in each tree\n");
		 bstBuilder.printSum(res);
		 int update_value=0;
		 try{
			update_value=Integer.parseInt(args[4]);
		 }catch(NumberFormatException e){
			e.printStackTrace();
			res.writeError("Give Integer value for update value");
			res.colseFileWriter();;
			System.exit(0);
		 }
		 bstBuilder.updateAll(update_value);
		 System.out.println("\n// Sum of all the B-Numbers after increment");
		 res.writeResult("\n// Sum of all the B-Numbers after increment\n");
		 bstBuilder.printSum(res);
		 res.colseFileWriter();
	}
}
