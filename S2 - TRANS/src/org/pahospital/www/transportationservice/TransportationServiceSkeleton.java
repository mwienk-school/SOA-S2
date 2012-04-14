/**
 * TransportationServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.transportationservice;

import java.sql.SQLException;
import org.pahospital.www.Database.DB_Manager;

/**
 * TransportationServiceSkeleton java skeleton for the axisService
 */
public class TransportationServiceSkeleton implements
		TransportationServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param patientOrder0
	 * @return
	 */
	public DB_Manager db;

	// private static int when;
	public TransportationServiceSkeleton() {
		// System.out.println("in constructor");
		db = new DB_Manager();
	}

	public void orderPatientTransport(org.pahospital.www.transportationservice.PatientOrder patientOrder0) throws SQLException {
		System.out.println("TRANS ==> Patient transport requested");
		db.InsertPatientOrder(patientOrder0);
		db.LogDB();
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param sampleOrder1
	 * @return
	 * @throws SQLException
	 */

	public void orderSampleTransport(
			org.pahospital.www.transportationservice.SampleOrder sampleOrder1)
			throws SQLException {
		System.out.println("TRANS ==> Sample transport requested");
		db.InsertSampleOrder(sampleOrder1);
		db.LogDB();
	}

}
