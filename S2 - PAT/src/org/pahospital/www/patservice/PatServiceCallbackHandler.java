
/**
 * PatServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package org.pahospital.www.patservice;

    /**
     *  PatServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PatServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PatServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PatServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for retrieveRadiologyReport method
            * override this method for handling normal response from retrieveRadiologyReport operation
            */
           public void receiveResultretrieveRadiologyReport(
                    org.pahospital.www.patservice.PatServiceStub.RadiologyReport result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveRadiologyReport operation
           */
            public void receiveErrorretrieveRadiologyReport(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for createPatientRecord method
            * override this method for handling normal response from createPatientRecord operation
            */
           public void receiveResultcreatePatientRecord(
                    org.pahospital.www.patservice.PatServiceStub.PatientID result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createPatientRecord operation
           */
            public void receiveErrorcreatePatientRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPatientIDsByName method
            * override this method for handling normal response from getPatientIDsByName operation
            */
           public void receiveResultgetPatientIDsByName(
                    org.pahospital.www.patservice.PatServiceStub.IDsList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPatientIDsByName operation
           */
            public void receiveErrorgetPatientIDsByName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPatientByID method
            * override this method for handling normal response from getPatientByID operation
            */
           public void receiveResultgetPatientByID(
                    org.pahospital.www.patservice.PatServiceStub.Patient result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPatientByID operation
           */
            public void receiveErrorgetPatientByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveLabReport method
            * override this method for handling normal response from retrieveLabReport operation
            */
           public void receiveResultretrieveLabReport(
                    org.pahospital.www.patservice.PatServiceStub.LabReport result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveLabReport operation
           */
            public void receiveErrorretrieveLabReport(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                


    }
    