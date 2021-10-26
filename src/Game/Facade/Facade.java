/**
 * @(#) Facade.java
 */

package Game.Facade;

import Game.Builder_Prototype.*;
import Game.Chat;
import Game.CommandPattern.Controller;
import Game.CommandPattern.ICommand;
import Game.Decorator.*;
import Game.Wrapper;

public class Facade
{
	private static Car decoratedVehicle;
	private static Car decoratedVehicle1;
	private static Car decoratedVehicle2;

	public CarBuilder demoBuilder(String carType)
	{
		CarBuilder builder = new CarBuilder();
		Director director = new Director();
		switch (carType){
			case "Race Car":
				director.constructRaceCar(builder);
				System.out.println(builder.getResult());

				Car newCar = builder.getCar();
				Car shallowCopy = builder.getCar().copyShallow();
				Car deepCopy = builder.getCar().copyDeep();

				System.out.println("primary shield: " + newCar.getShield().getType() + " | " + System.identityHashCode(newCar.getShield()));
				System.out.println("shallow copy shield: " + shallowCopy.getShield().getType() + " | " + System.identityHashCode(shallowCopy.getShield()));
				System.out.println("deep copy shield: " + deepCopy.getShield().getType() + " | " + System.identityHashCode(deepCopy.getShield()));
				break;
			case "Rally Car":
				director.constructRallyCar(builder);
				System.out.println(builder.getResult());
				break;
			default:
				director.constructTruckCar(builder);
				System.out.println(builder.getResult());
				break;
		}

		Chat.AddMessage(builder.getResult().toString());

		return builder;
	}
	
	public Car demoDecorator(String carType, Car car)
	{
		switch (carType){
			case "Race Car":
				decoratedVehicle1 = new ElectricEngine(car);
				decoratedVehicle2 = new Petrol(decoratedVehicle1);
				decoratedVehicle = new Gas(decoratedVehicle2);
				decoratedVehicle.getFuelType();
				break;
			case "Rally Car":
				decoratedVehicle1 = new ElectricEngine(car);
				decoratedVehicle = new Diesel(decoratedVehicle1);
				decoratedVehicle.getFuelType();
				break;
			default:
				decoratedVehicle1 = new ElectricEngine(car);
				decoratedVehicle = new BioFuel(decoratedVehicle1);
				decoratedVehicle.getFuelType();
				break;
		}
		return decoratedVehicle;
	}
}
