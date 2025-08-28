package abstractfactory;

public class NoRelationshipFactory extends Factory {

	@Override
	Car retrieveCar(String requestedGrade) {
		if ("A".equals(requestedGrade)) {
			return new F296gtb (830, "Normal Gas", "Yellow", "Hybrid V6");
		}else {
		return null;
		}
	}
}