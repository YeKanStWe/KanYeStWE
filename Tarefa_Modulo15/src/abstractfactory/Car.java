package abstractfactory;

public abstract class Car {
	
	private int horsePower;
	private String fuelSource;
	private String color;
	private String engineType;
	
	public Car(int horsePower, String fuelSource, String color, String engineType) {
		this.horsePower = horsePower;
		this.fuelSource = fuelSource;
		this.color = color;
		this.engineType = engineType;
	}
	
	public void startEngine() {
		System.out.println("great choice! you are now a proud owner of a " + getClass().getSimpleName());
		System.out.println("The " + engineType + " engine has been started, and its ready to utilize... " + horsePower + " horses and they are all yours, have fun!");
	}
	
	public void clean() {
		System.out.println("Car has been cleaned and its " + color + " color shines!");
	}
	
	public void mechanicCheck() {
		System.out.println("Everything seems great! The car has been succesfully checked by a mechanic!");
	}
	
	public void fuelCar() {
		System.out.println("The car has been filled with " + fuelSource + " and its ready to be shipped to your adress!");
	}

}
