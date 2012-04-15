/**
 * PhysicianServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahopital.www.physicianservice;

/**
 * PhysicianServiceSkeleton java skeleton for the axisService
 */
public class PhysicianServiceSkeleton implements
		PhysicianServiceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param examinationReports0
	 * @return dischargeLetter1
	 */

	public org.pahopital.www.physicianservice.DischargeLetter requestDischargeLetter(
			org.pahopital.www.physicianservice.ExaminationReports examinationReports0) {
		DischargeLetter letter = new DischargeLetter();
		letter.setBody("Patient seems healthy");
		return letter;
	}

}
