
/**
 * TransportationServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
    package org.pahospital.www.transportationservice;

import java.sql.SQLException;
    /**
     *  TransportationServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface TransportationServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                    * @param patientOrder
         * @throws SQLException 
         */

        
                public void orderPatientTransport
                (
                  org.pahospital.www.transportationservice.PatientOrder patientOrder
                 ) throws SQLException
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param sampleOrder
         * @throws SQLException 
         */

        
                public void orderSampleTransport
                (
                  org.pahospital.www.transportationservice.SampleOrder sampleOrder
                 ) throws SQLException
            ;
        
         }
    