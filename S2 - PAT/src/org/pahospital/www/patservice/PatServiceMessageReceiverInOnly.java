

/**
 * PatServiceMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package org.pahospital.www.patservice;

        /**
        *  PatServiceMessageReceiverInOnly message receiver
        */

        public class PatServiceMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractInMessageReceiver{

        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext inMessage) throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(inMessage);

        PatServiceSkeletonInterface skel = (PatServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = inMessage.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        
            if("storeLabReport".equals(methodName)){
            
            org.pahospital.www.patservice.LabReport wrappedParam = (org.pahospital.www.patservice.LabReport)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        org.pahospital.www.patservice.LabReport.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.storeLabReport(wrappedParam);
                                                } else 
            if("storeRadiologyReport".equals(methodName)){
            
            org.pahospital.www.patservice.RadiologyReport wrappedParam = (org.pahospital.www.patservice.RadiologyReport)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        org.pahospital.www.patservice.RadiologyReport.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.storeRadiologyReport(wrappedParam);
                                                
                } else {
                  throw new java.lang.RuntimeException("method not found");
                }
            

        }
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }


        
        //
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.RadiologyReportOrder param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.RadiologyReportOrder.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.RadiologyReport param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.RadiologyReport.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.LabReport param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.LabReport.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.Patient param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.Patient.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.PatientID param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.PatientID.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.PatientName param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.PatientName.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.IDsList param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.IDsList.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahospital.www.patservice.LabReportOrder param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahospital.www.patservice.LabReportOrder.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.patservice.RadiologyReport param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.patservice.RadiologyReport.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.patservice.RadiologyReport wrapRetrieveRadiologyReport(){
                                org.pahospital.www.patservice.RadiologyReport wrappedElement = new org.pahospital.www.patservice.RadiologyReport();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.patservice.PatientID param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.patservice.PatientID.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.patservice.PatientID wrapCreatePatientRecord(){
                                org.pahospital.www.patservice.PatientID wrappedElement = new org.pahospital.www.patservice.PatientID();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.patservice.IDsList param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.patservice.IDsList.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.patservice.IDsList wrapGetPatientIDsByName(){
                                org.pahospital.www.patservice.IDsList wrappedElement = new org.pahospital.www.patservice.IDsList();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.patservice.Patient param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.patservice.Patient.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.patservice.Patient wrapGetPatientByID(){
                                org.pahospital.www.patservice.Patient wrappedElement = new org.pahospital.www.patservice.Patient();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahospital.www.patservice.LabReport param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahospital.www.patservice.LabReport.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahospital.www.patservice.LabReport wrapRetrieveLabReport(){
                                org.pahospital.www.patservice.LabReport wrappedElement = new org.pahospital.www.patservice.LabReport();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.pahospital.www.patservice.RadiologyReportOrder.class.equals(type)){
                
                           return org.pahospital.www.patservice.RadiologyReportOrder.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.RadiologyReport.class.equals(type)){
                
                           return org.pahospital.www.patservice.RadiologyReport.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.LabReport.class.equals(type)){
                
                           return org.pahospital.www.patservice.LabReport.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.Patient.class.equals(type)){
                
                           return org.pahospital.www.patservice.Patient.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.PatientID.class.equals(type)){
                
                           return org.pahospital.www.patservice.PatientID.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.PatientName.class.equals(type)){
                
                           return org.pahospital.www.patservice.PatientName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.IDsList.class.equals(type)){
                
                           return org.pahospital.www.patservice.IDsList.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.PatientID.class.equals(type)){
                
                           return org.pahospital.www.patservice.PatientID.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.Patient.class.equals(type)){
                
                           return org.pahospital.www.patservice.Patient.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.LabReportOrder.class.equals(type)){
                
                           return org.pahospital.www.patservice.LabReportOrder.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.LabReport.class.equals(type)){
                
                           return org.pahospital.www.patservice.LabReport.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahospital.www.patservice.RadiologyReport.class.equals(type)){
                
                           return org.pahospital.www.patservice.RadiologyReport.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    



        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }



        }//end of class

    