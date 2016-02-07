/**
 * MathOperationsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.neoteric.it;

public interface MathOperationsService extends javax.xml.rpc.Service {
    public java.lang.String getMathOperationsAddress();

    public com.neoteric.it.MathOperations getMathOperations() throws javax.xml.rpc.ServiceException;

    public com.neoteric.it.MathOperations getMathOperations(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
