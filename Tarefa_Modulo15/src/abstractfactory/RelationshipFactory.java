package abstractfactory;

public class RelationshipFactory extends Factory{

	@Override
	Car retrieveCar(String requestedGrade) {
		if ("A".equals(requestedGrade)) {
			return new LaFerrari (963, "Podium gas", "Red", "Hybrid V12");
		}else {
		return null;
		}
	}
}
