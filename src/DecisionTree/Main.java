package DecisionTree;

import DecisionTree.Test;
public class Main {
	
	public static DecisionTreeNode root;
	static String filename1;
	static String filename2;
	
	
		
   //static String path = "src\\DecisionTree\\resources\\";
    
    
    public static void main (String [] args) {
    	
    	 System.out.println("Please enter two file names (e.g. hepatitis-training.dat and hepatitis-test.dat) into the command line");
    	
    	if(args.length < 2) {
    	  System.out.println("Please enter two files into the command line");
    	
    	}
    	else{
    	String dir = System.getProperty("user.dir");
    	
    	filename1 = args[0];
    	filename2 = args[1];

       	System.out.println("Reading training data from" + " " + dir + "\\" +  Main.filename1);
		System.out.println("Reading test data from" + " " + dir + "\\" +  Main.filename2);
	
    	
    	}
    	
    /*	filename1 = "hepatitis-training.dat";
     	filename2 = "hepatitis-test.dat";
    */ 	
    	root = new DecisionTreeNode();					// initialises the root node
       	Parser.loadtraining(/*path+ */filename1);              // loads training    	
    	root = BuildTree.buildTree(Parser.training, Parser.attributeslist);			// calls buildTree starting with the root
       	System.out.println("Decision tree output:");
		System.out.println("-------------------------");
		PrintTree.TreeTraversal("", root);		// prints the tree from the root
		Parser.loadtest(/*path + */ filename2); 						// loads test 
		Test.compare();
		
    }
   
    
}
