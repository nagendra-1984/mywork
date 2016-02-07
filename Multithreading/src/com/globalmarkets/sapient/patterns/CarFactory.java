package com.globalmarkets.sapient.patterns;

public class CarFactory {

	/**
	 * 
	 * @param strCarType
	 * @return
	 * The below implementation is working well and everyone are happy. However, at some point of time company want to release another new model to market, 
	 * they need to change the produceMobile() method code.
		Design is not extensive and it is closed for modification.
		Adds more complexity to refactor code each time new products added.
	 */
	public static ICar getCarInstance (String strCarType){
		
		ICar carInstance = null;
		
			if(strCarType.equals("Swift")){
				
				carInstance = new Swift();
			}else if(strCarType.equals("Santro")){
				
				carInstance = new Santro();
			}
		return carInstance;
	}
	
	/**
	 * Method used to get the Class Instance using Reflection 
	 * @param strClassName
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static ICar getReflectionCarInstance (String strClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (ICar) Class.forName("com.globalmarkets.sapient.patterns." + strClassName).newInstance();
	}
}
