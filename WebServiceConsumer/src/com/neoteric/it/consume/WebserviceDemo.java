package com.neoteric.it.consume;

import java.rmi.RemoteException;

import com.neoteric.it.MathOperations;
import com.neoteric.it.MathOperationsProxy;
import com.neoteric.it.PremiumVO;

public class WebserviceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			System.out.println("^%^ WebServices Demo ^%^");
			MathOperations mathOperations = new MathOperationsProxy();
			System.out.println("^%^ Get Sum ^%^"+mathOperations.getSum());
			System.out.println("^%^ Get Difference ^%^"+mathOperations.getDifference());
			
			PremiumVO premiumVO = new PremiumVO();
			premiumVO.setInterest(10);
			premiumVO.setPrincipal(350);
			System.out.println("^%^ get Product ^%^"+mathOperations.getProduct(premiumVO));
			
			
		}catch(RemoteException reEx){
			reEx.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
