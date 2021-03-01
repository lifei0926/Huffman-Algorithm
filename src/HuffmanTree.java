
public class HuffmanTree {

	private HNode root;
	private HNode[] nodes;
	public static double codeLength = 0;
	public static double[] probabilities;
	
	public void setNodes(String[] str) {
		int numOfNodes = str.length/2;
		HNode[] newNodes = new HNode[numOfNodes];
		
		//put nodes into "newNodes" array
		for(int i = 0; i < newNodes.length; i++) {
			HNode temp = new HNode();
			temp.setNode(str[2*i], Double.parseDouble(str[2*i+1]));
			newNodes[i] = temp;
		}
		
		nodes = newNodes;
		//store probabilities for later use
		probabilities = new double[numOfNodes];
		for(int i = 0; i < probabilities.length; ++i) {
			probabilities[i] = Double.parseDouble(str[2*i+1]);
		}
	}
	
	//sort "nodes" in descending order
	public void sortNodes() {
		for(int i = 0; i < nodes.length-1; ++i) {
			int max = i;
			//find the index of the max probability
			for(int j = i+1; j < nodes.length; ++j) {
				//prevent NullPointerException
				if(nodes[j] != null && nodes[max].getProbability() < nodes[j].getProbability()) {
					max = j;			
					HNode temp = new HNode();
					temp = nodes[i];
					nodes[i] = nodes[max];
					nodes[max] = temp;
				}
			}
		}
	}
	

	
	
	//build Huffman tree
	public void buildTree() {
		int length = nodes.length;
		//if there are i nodes, then we merge every two nodes i-1 times
		for(int i = 0; i < nodes.length-1; i++) {
			double p = nodes[length-i-1].getProbability() + nodes[length-i-2].getProbability();
			HNode temp = new HNode(p, nodes[length-i-1], nodes[length-i-2]);
			nodes[length-i-2] = temp;
			nodes[length-i-1] = null;
			sortNodes();
		}
		root = nodes[0];
	}
	
	//print code tree
	public void printCodeTree(HNode root, String str) {
		//base case
		if(root.getName() != null) {
			System.out.println(root.getName() + ":" + str + "  ");
			codeLength += root.getProbability()*str.length();
		}else{
			printCodeTree(root.getLeftNode(), str + "0");
			printCodeTree(root.getRightNode(), str + "1");
		}
	
	}
	
	//print code tree
	public void printTree() {
		String str = "";
		printCodeTree(root,str);
		System.out.println();
	}
	
	//print average code length
	public void printCodeLength() {
		System.out.println("Average Code Length is: " + codeLength);
	}
	
	//print average code length
	public void printEntropy() {
		double e = 0;
		for(double i: probabilities) 	
			e += Math.abs(i*Math.log(i));	
		e /= Math.log(2);
		System.out.println("Average Entropy is:" + e);
		System.out.println("Redundancy: " + (codeLength - e));
	}
	
	//a method to run Huffman code
	public static void runHuffman(String[] userInput) {
		codeLength = 0;
		HuffmanTree tree = new HuffmanTree();
		tree.setNodes(userInput);
		tree.sortNodes();
		tree.buildTree();
		tree.printTree();
		tree.printCodeLength();
		tree.printEntropy();
		//dividing line
		System.out.println("*******************************************************************************");
	}
	
	public static void main(String[] args) {
		String[] userInput1 = {"x1","0.2","x2","0.15","x3","0.13","x4","0.12","x5","0.1","x6","0.09","x7","0.08","x8","0.07","x9","0.06"}; 
		runHuffman(userInput1);
		
		String[] userInput2 = {"A","0.0642","B","0.0127","C","0.0218","D","0.0317","E","0.1031","F","0.0208","G","0.0152",
							   "H","0.0467","I","0.0575","J","0.0008","K","0.0049","L","0.0321","M","0.0198","N","0.0574",
							   "O","0.0632","P","0.0152","Q","0.0008","R","0.0484","S","0.0514","T","0.0796",
							   "U","0.0228","V","0.0083","W","0.0175","X","0.0013","Y","0.0164","Z","0.0005"," ","0.1859"};
		runHuffman(userInput2);
		
	}

	
}
