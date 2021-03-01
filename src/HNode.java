
public class HNode {

	private HNode lNode;
	private HNode rNode;
	private String n;//name
	private double p;//probability
	
	//default constructor
	public HNode() {
		lNode = null;
		rNode = null;
		p = 0;
		n = null;
	}
	
	public HNode(String name, double probability, HNode leftNode, HNode rightNode) {
		n = name;
		p = probability;
		lNode = leftNode;
		rNode = rightNode;
	}
	
	public HNode(double probability, HNode leftNode, HNode rightNode) {
		p = probability;
		lNode = leftNode;
		rNode = rightNode;
	}
	
	//setter methods
	public void setNode(String name, double probability, HNode leftNode, HNode rightNode) {
		lNode = leftNode;
		rNode = rightNode;
		p = probability;
		n = name;
	}
	
	public void setNode(String name, double probability) {
		n = name;
		p = probability;
	}
	
	/*
	public void setNode(double probability) {
		p = probability;
	}*/
	
	public void setNode(HNode leftNode, HNode rightNode) {
		lNode = null;
		rNode = null;
	}
	//getter methods
	public String getName() {
		return n;
	}
	
	public double getProbability() {
		return p;
	}
	
	public HNode getLeftNode() {
		return lNode;
	}
	
	public HNode getRightNode() {
		return rNode;
	}

}
