package abstractfactory;

public class Demo {
	
	public static void main (String[] args) {
		Customer customer = new Customer("A", false);
		Factory factory = getFactory(customer);
		Car car = factory.create(customer.gradeRequest());
		car.startEngine();	
	}
	
	private static Factory getFactory(Customer customer) {
		if (customer.hasRelationshipFactory()) {
			return new RelationshipFactory();
		}
		else {
			return new NoRelationshipFactory();
		}
	}
}
