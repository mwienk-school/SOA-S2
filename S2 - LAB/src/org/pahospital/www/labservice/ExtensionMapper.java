
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */

        
            package org.pahospital.www.labservice;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://www.PAHospital.org/LabService/".equals(namespaceURI) &&
                  "SampleMaterial_type1".equals(typeName)){
                   
                            return  org.pahospital.www.labservice.SampleMaterial_type1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.PAHospital.org/LabService/".equals(namespaceURI) &&
                  "SampleMaterial_type1".equals(typeName)){
                   
                            return  org.pahospital.www.labservice.SampleMaterial_type1.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    