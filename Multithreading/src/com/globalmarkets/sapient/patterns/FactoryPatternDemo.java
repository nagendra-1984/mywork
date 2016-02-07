package com.globalmarkets.sapient.patterns;

public class FactoryPatternDemo {
	
	/**
	 *  Demo Class to test the factory Pattern Design
	 */

	public static void main (String[] args){
		
		System.out.println("^%^ Car Factory Demo ^%^");
		
		ICar santroCar = CarFactory.getCarInstance("Santro");
		
		System.out.println("^%^ Santro Car Color ^%^"+santroCar.getColor());
		
		ICar swiftCar = CarFactory.getCarInstance("Swift");
		
		System.out.println("^%^ Swift Car Color ^%^"+swiftCar.getColor());
		
		
		System.out.println("^%^ Getting the Class Instance using Reflection ^%^");
		try{
			ICar refSwiftCar = CarFactory.getReflectionCarInstance("Swift");
			System.out.println("^%^ Instance using Reflection Swift Car ^%^"+refSwiftCar.getColor());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}
