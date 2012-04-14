
/**
 * PatServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package org.pahospital.www.patservice;

        /**
        *  PatServiceMessageReceiverInOut message receiver
        */

        public class PatServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        PatServiceSkeletonInterface skel = (PatServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("retrieveRadiologyReport".equals(methodName)){
                
                org.pahospital.www.patservice.RadiologyReport radiologyReport17 = null;
	                        org.pahospital.www.patservice.RadiologyReportOrder wrappedParam =
                                                             (org.pahospital.www.patservice.RadiologyReportOrder)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.patservice.RadiologyReportOrder.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               radiologyReport17 =
                                                   
                                                   
                                                         skel.retrieveRadiologyReport(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), radiologyReport17, false, new javax.xml.namespace.QName("http://www.PAHospital.org/PatService/",
                                                    "retrieveRadiologyReport"));
                                    } else 

            if("createPatientRecord".equals(methodName)){
                
                org.pahospital.www.patservice.PatientID patientID19 = null;
	                        org.pahospital.www.patservice.Patient wrappedParam =
                                                             (org.pahospital.www.patservice.Patient)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.patservice.Patient.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               patientID19 =
                                                   
                                                   
                                                         skel.createPatientRecord(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), patientID19, false, new javax.xml.namespace.QName("http://www.PAHospital.org/PatService/",
                                                    "createPatientRecord"));
                                    } else 

            if("getPatientIDsByName".equals(methodName)){
                
                org.pahospital.www.patservice.IDsList iDsList21 = null;
	                        org.pahospital.www.patservice.PatientName wrappedParam =
                                                             (org.pahospital.www.patservice.PatientName)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.patservice.PatientName.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               iDsList21 =
                                                   
                                                   
                                                         skel.getPatientIDsByName(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), iDsList21, false, new javax.xml.namespace.QName("http://www.PAHospital.org/PatService/",
                                                    "getPatientIDsByName"));
                                    } else 

            if("getPatientByID".equals(methodName)){
                
                org.pahospital.www.patservice.Patient patient23 = null;
	                        org.pahospital.www.patservice.PatientID wrappedParam =
                                                             (org.pahospital.www.patservice.PatientID)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.patservice.PatientID.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               patient23 =
                                                   
                                                   
                                                         skel.getPatientByID(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), patient23, false, new javax.xml.namespace.QName("http://www.PAHospital.org/PatService/",
                                                    "getPatientByID"));
                                    } else 

            if("retrieveLabReport".equals(methodName)){
                
                org.pahospital.www.patservice.LabReport labReport25 = null;
	                        org.pahospital.www.patservice.LabReportOrder wrappedParam =
                                                             (org.pahospital.www.patservice.LabReportOrder)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahospital.www.patservice.LabReportOrder.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               labReport25 =
                                                   
                                                   
                                                         skel.retrieveLabReport(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), labReport25, false, new javax.xml.namespace.QName("http://www.PAHospital.org/PatService/",
                                                    "retrieveLabReport"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
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

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    