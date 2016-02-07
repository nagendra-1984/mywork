package com.neoteric.it;

public class MathOperationsProxy implements com.neoteric.it.MathOperations {
  private String _endpoint = null;
  private com.neoteric.it.MathOperations mathOperations = null;
  
  public MathOperationsProxy() {
    _initMathOperationsProxy();
  }
  
  public MathOperationsProxy(String endpoint) {
    _endpoint = endpoint;
    _initMathOperationsProxy();
  }
  
  private void _initMathOperationsProxy() {
    try {
      mathOperations = (new com.neoteric.it.MathOperationsServiceLocator()).getMathOperations();
      if (mathOperations != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mathOperations)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mathOperations)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mathOperations != null)
      ((javax.xml.rpc.Stub)mathOperations)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.neoteric.it.MathOperations getMathOperations() {
    if (mathOperations == null)
      _initMathOperationsProxy();
    return mathOperations;
  }
  
  public java.lang.String getDifference() throws java.rmi.RemoteException{
    if (mathOperations == null)
      _initMathOperationsProxy();
    return mathOperations.getDifference();
  }
  
  public java.lang.String getSum() throws java.rmi.RemoteException{
    if (mathOperations == null)
      _initMathOperationsProxy();
    return mathOperations.getSum();
  }
  
  public int getProduct(com.neoteric.it.PremiumVO premiumVO) throws java.rmi.RemoteException{
    if (mathOperations == null)
      _initMathOperationsProxy();
    return mathOperations.getProduct(premiumVO);
  }
  
  
}