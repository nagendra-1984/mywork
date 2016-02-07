/**
 * MathOperationsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.neoteric.it;

public class MathOperationsServiceLocator extends org.apache.axis.client.Service implements com.neoteric.it.MathOperationsService {

    public MathOperationsServiceLocator() {
    }


    public MathOperationsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MathOperationsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MathOperations
    private java.lang.String MathOperations_address = "http://localhost:8080/WebServices/services/MathOperations";

    public java.lang.String getMathOperationsAddress() {
        return MathOperations_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MathOperationsWSDDServiceName = "MathOperations";

    public java.lang.String getMathOperationsWSDDServiceName() {
        return MathOperationsWSDDServiceName;
    }

    public void setMathOperationsWSDDServiceName(java.lang.String name) {
        MathOperationsWSDDServiceName = name;
    }

    public com.neoteric.it.MathOperations getMathOperations() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MathOperations_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMathOperations(endpoint);
    }

    public com.neoteric.it.MathOperations getMathOperations(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.neoteric.it.MathOperationsSoapBindingStub _stub = new com.neoteric.it.MathOperationsSoapBindingStub(portAddress, this);
            _stub.setPortName(getMathOperationsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMathOperationsEndpointAddress(java.lang.String address) {
        MathOperations_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.neoteric.it.MathOperations.class.isAssignableFrom(serviceEndpointInterface)) {
                com.neoteric.it.MathOperationsSoapBindingStub _stub = new com.neoteric.it.MathOperationsSoapBindingStub(new java.net.URL(MathOperations_address), this);
                _stub.setPortName(getMathOperationsWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MathOperations".equals(inputPortName)) {
            return getMathOperations();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://it.neoteric.com", "MathOperationsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://it.neoteric.com", "MathOperations"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MathOperations".equals(portName)) {
            setMathOperationsEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
