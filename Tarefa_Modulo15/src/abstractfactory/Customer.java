package abstractfactory;

public class Customer {
	
	private String gradeRequest;
	private boolean hasRelationshipFactory;
	
	public Customer(String gradeRequest, boolean hasRelationshipFactory) {
		this.gradeRequest = gradeRequest;
		this.hasRelationshipFactory = hasRelationshipFactory;
	}
	
	public boolean hasRelationshipFactory() {
		return hasRelationshipFactory;
	}
	
	public String gradeRequest() {
		return gradeRequest;
	}
}
