/**
 * PremiumVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.neoteric.it;

public class PremiumVO  implements java.io.Serializable {
    private int interest;

    private int premium;

    private int principal;

    public PremiumVO() {
    }

    public PremiumVO(
           int interest,
           int premium,
           int principal) {
           this.interest = interest;
           this.premium = premium;
           this.principal = principal;
    }


    /**
     * Gets the interest value for this PremiumVO.
     * 
     * @return interest
     */
    public int getInterest() {
        return interest;
    }


    /**
     * Sets the interest value for this PremiumVO.
     * 
     * @param interest
     */
    public void setInterest(int interest) {
        this.interest = interest;
    }


    /**
     * Gets the premium value for this PremiumVO.
     * 
     * @return premium
     */
    public int getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this PremiumVO.
     * 
     * @param premium
     */
    public void setPremium(int premium) {
        this.premium = premium;
    }


    /**
     * Gets the principal value for this PremiumVO.
     * 
     * @return principal
     */
    public int getPrincipal() {
        return principal;
    }


    /**
     * Sets the principal value for this PremiumVO.
     * 
     * @param principal
     */
    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PremiumVO)) return false;
        PremiumVO other = (PremiumVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.interest == other.getInterest() &&
            this.premium == other.getPremium() &&
            this.principal == other.getPrincipal();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getInterest();
        _hashCode += getPremium();
        _hashCode += getPrincipal();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PremiumVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://it.neoteric.com", "PremiumVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interest");
        elemField.setXmlName(new javax.xml.namespace.QName("http://it.neoteric.com", "interest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premium");
        elemField.setXmlName(new javax.xml.namespace.QName("http://it.neoteric.com", "premium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("principal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://it.neoteric.com", "principal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
