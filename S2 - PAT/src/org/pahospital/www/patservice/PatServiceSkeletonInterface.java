
/**
 * PatServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
    package org.pahospital.www.patservice;
    /**
     *  PatServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface PatServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                    * @param radiologyReportOrder
         */

        
                public org.pahospital.www.patservice.RadiologyReport retrieveRadiologyReport
                (
                  org.pahospital.www.patservice.RadiologyReportOrder radiologyReportOrder
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param labReport
         */

        
                public void storeLabReport
                (
                  org.pahospital.www.patservice.LabReport labReport
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param patient
         */

        
                public org.pahospital.www.patservice.PatientID createPatientRecord
                (
                  org.pahospital.www.patservice.Patient patient
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param patientName
         */

        
                public org.pahospital.www.patservice.IDsList getPatientIDsByName
                (
                  org.pahospital.www.patservice.PatientName patientName
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param patientID0
         */

        
                public org.pahospital.www.patservice.Patient getPatientByID
                (
                  org.pahospital.www.patservice.PatientID patientID0
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param labReportOrder
         */

        
                public org.pahospital.www.patservice.LabReport retrieveLabReport
                (
                  org.pahospital.www.patservice.LabReportOrder labReportOrder
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param radiologyReport3
         */

        
                public void storeRadiologyReport
                (
                  org.pahospital.www.patservice.RadiologyReport radiologyReport3
                 )
            ;
        
         }
    