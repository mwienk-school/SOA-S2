
/**
 * PhysicianServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package org.pahopital.www.physicianservice;

        /**
        *  PhysicianServiceMessageReceiverInOut message receiver
        */

        public class PhysicianServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        PhysicianServiceSkeletonInterface skel = (PhysicianServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("requestDischargeLetter".equals(methodName)){
                
                org.pahopital.www.physicianservice.DischargeLetter dischargeLetter3 = null;
	                        org.pahopital.www.physicianservice.ExaminationReports wrappedParam =
                                                             (org.pahopital.www.physicianservice.ExaminationReports)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.pahopital.www.physicianservice.ExaminationReports.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               dischargeLetter3 =
                                                   
                                                   
                                                         skel.requestDischargeLetter(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), dischargeLetter3, false, new javax.xml.namespace.QName("http://www.PAHopital.org/PhysicianService/",
                                                    "requestDischargeLetter"));
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(org.pahopital.www.physicianservice.ExaminationReports param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahopital.www.physicianservice.ExaminationReports.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.pahopital.www.physicianservice.DischargeLetter param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.pahopital.www.physicianservice.DischargeLetter.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.pahopital.www.physicianservice.DischargeLetter param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.pahopital.www.physicianservice.DischargeLetter.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.pahopital.www.physicianservice.DischargeLetter wrapRequestDischargeLetter(){
                                org.pahopital.www.physicianservice.DischargeLetter wrappedElement = new org.pahopital.www.physicianservice.DischargeLetter();
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
        
                if (org.pahopital.www.physicianservice.ExaminationReports.class.equals(type)){
                
                           return org.pahopital.www.physicianservice.ExaminationReports.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.pahopital.www.physicianservice.DischargeLetter.class.equals(type)){
                
                           return org.pahopital.www.physicianservice.DischargeLetter.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    