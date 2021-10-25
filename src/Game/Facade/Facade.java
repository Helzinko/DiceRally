/**
 * @(#) Facade.java
 */

package Game.Facade;

import Game.Builder_Prototype.*;
import Game.Chat;
import Game.CommandPattern.Controller;
import Game.CommandPattern.ICommand;
import Game.Decorator.*;

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
				decoratedVehicle = new ElectricEngine(car);
				decoratedVehicle1 = new Petrol(decoratedVehicle);
				decoratedVehicle2 = new Gas(decoratedVehicle1);

				System.out.println(decoratedVehicle2.getFuelType().toString());
				break;
			case "Rally Car":
				decoratedVehicle = new ElectricEngine(car);
				decoratedVehicle1 = new Diesel(decoratedVehicle);
				decoratedVehicle1.getFuelType();
				break;
			default:
				decoratedVehicle = new ElectricEngine(car);
				decoratedVehicle1 = new BioFuel(decoratedVehicle);
				decoratedVehicle1.getFuelType();
				break;
		}
		System.out.println();
		return decoratedVehicle1;
	}
}
