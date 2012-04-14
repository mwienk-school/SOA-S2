/**
 * PatServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package org.pahospital.www.patservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;
import org.apache.derby.jdbc.EmbeddedDriver;


/**
 * PatServiceSkeleton java skeleton for the axisService
 */
public class PatServiceSkeleton implements PatServiceSkeletonInterface {

	/**
	 * @uml.property name="stmt"
	 */
	private Statement stmt = null;
	/**
	 * @uml.property name="rs"
	 */
	private ResultSet rs = null;

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyReportOrder4
	 * @return radiologyReport5
	 */

	public org.pahospital.www.patservice.RadiologyReport retrieveRadiologyReport(
			org.pahospital.www.patservice.RadiologyReportOrder radiologyReportOrder4) {
		RadiologyReport rpt = new RadiologyReport();
		rpt.setPatientID(radiologyReportOrder4.getPatientID());
		rpt.setRadiologyOrderID(radiologyReportOrder4.getRadiologyOrderID());

		AccessDB db = new AccessDB();
		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT PATIENT_ID, RADIOLOGY_ORDER_ID, "
					+ "DATE_OF_EXAM, REPORT_TEXT FROM RADIOLOGY_RECORD");

			int i = 0;
			while (rs.next()) {

				if ((rs.getString(1).equals(radiologyReportOrder4
						.getPatientID()))
						&& (rs.getString(2).equals(radiologyReportOrder4
								.getRadiologyOrderID()))) {
					i++;
					rpt.setDateOfExamination(rs.getDate(3));
					rpt.setReportText(rs.getString(4));

					break;
				}
			}
			if (i == 0)
				throw new java.lang.UnsupportedOperationException(
						"The Patient ID and the Radiology order ID are not match");
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rpt;
		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#retrieveRadiologyReport");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param labReport6
	 * @return
	 */

	public void storeLabReport(
			org.pahospital.www.patservice.LabReport labReport6) {
		System.out.println("PAT ==> Storint lab report");
		AccessDB db = new AccessDB();
		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT LAB_ORDER_ID FROM LAB_RECORD");

			while (rs.next()) {
				if (rs.getString(1).equals(labReport6.getLabOrderID())) {
					rs.close();
					stmt.close();
					conn.close();
					throw new java.lang.UnsupportedOperationException(
							"Cannot save the record. The record already exists in the database!");
				}
			}

			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO LAB_RECORD (PATIENT_ID, "
							+ "LAB_ORDER_ID, SAMPLE_ID, LAB_PARAMETER, LAB_VALUE, INDEX) VALUES (?, ?, ?, ?, ?, ?)");

			statement.setString(1, labReport6.getPatientID());
			statement.setString(2, labReport6.getLabOrderID());
			statement.setString(3, labReport6.getSampleID());
			statement.setInt(6, labReport6.getLabValues().length);

			int i = 0;
			for (LabValues_type0 element : labReport6.getLabValues()) {
				if (i > 0) {
					statement = conn
							.prepareStatement("INSERT INTO "
									+ "LAB_RECORD (PATIENT_ID, LAB_ORDER_ID, SAMPLE_ID, LAB_PARAMETER,"
									+ " LAB_VALUE) VALUES ( ?, ?, ?, ?, ?)");
					statement.setString(1, labReport6.getPatientID());
					statement.setString(2, labReport6.getLabOrderID());
					statement.setString(3, labReport6.getSampleID());
					statement.setString(4, element.getLabParameter());
					statement.setBigDecimal(5, element.getLabValue());
					statement.execute();
					statement.close();
				} else {
					statement.setString(4, element.getLabParameter());
					statement.setBigDecimal(5, element.getLabValue());
					statement.execute();
					statement.close();
				}
				i++;
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO : fill this with the necessary business logic

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param patient7
	 * @return patientID8
	 */

	public org.pahospital.www.patservice.PatientID createPatientRecord(
			org.pahospital.www.patservice.Patient patient7) {
		PatientID createRecord = new PatientID();
		createRecord.setPatientID("failed");

		AccessDB db = new AccessDB();
		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ID FROM PATIENT_RECORD");

			while (rs.next()) {
				if (rs.getString(1).equals(patient7.getPatientID())) {
					rs.close();
					stmt.close();
					conn.close();
					throw new java.lang.UnsupportedOperationException(
							"Cannot save the record. The record already exists in the database!");
				}
			}
			createRecord.setPatientID(patient7.getPatientID());
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO PATIENT_RECORD "
							+ "(ID, NAME, STREET, ZIP_CODE, CITY, BIRTHDAY) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setString(1, patient7.getPatientID());
			statement.setString(2, patient7.getPatientName());
			statement.setString(3, patient7.getPatientStreet());
			statement.setInt(4, patient7.getPatientZipCode());
			statement.setString(5, patient7.getPatientCity());
			statement.setDate(6, new java.sql.Date(patient7
					.getPatientBirthday().getTime()));

			statement.execute();

			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return createRecord;
		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#createPatientRecord");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param patientName9
	 * @return iDsList10
	 */

	public org.pahospital.www.patservice.IDsList getPatientIDsByName(
			org.pahospital.www.patservice.PatientName patientName9) {
		IDsList idlist = new IDsList();
		AccessDB db = new AccessDB();

		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT NAME, ID FROM PATIENT_RECORD");

			int i = 0;
			while (rs.next()) {
				if (rs.getString(1).equals(patientName9.getPatientName())) {
					idlist.addPatientID(rs.getString(2));
					i++;
				}
			}

			if (i == 0)
				throw new java.lang.UnsupportedOperationException(
						"The name doesn't exist in the database");

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idlist;
		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#getPatientIDsByName");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param patientID11
	 * @return patient12
	 */

	public org.pahospital.www.patservice.Patient getPatientByID(
			org.pahospital.www.patservice.PatientID patientID11) {
		Patient patRecord = new Patient();
		AccessDB db = new AccessDB();

		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("SELECT ID, NAME, STREET, ZIP_CODE, CITY, BIRTHDAY"
							+ " FROM PATIENT_RECORD");
			int i = 0;
			while (rs.next()) {
				if (rs.getString(1).equals(patientID11.getPatientID())) {
					i++;
					patRecord.setPatientID(rs.getString(1));
					patRecord.setPatientName(rs.getString(2));
					patRecord.setPatientStreet(rs.getString(3));
					patRecord.setPatientZipCode(rs.getInt(4));
					patRecord.setPatientCity(rs.getString(5));
					patRecord.setPatientBirthday(rs.getDate(6));
					break;
				}
			}

			if (i == 0)
				throw new java.lang.UnsupportedOperationException(
						"The Patient ID does not exists in the data base");
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return patRecord;
		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#getPatientByID");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param labReportOrder13
	 * @return labReport14
	 */

	public org.pahospital.www.patservice.LabReport retrieveLabReport(
			org.pahospital.www.patservice.LabReportOrder labReportOrder13) {
		LabReport rpt = new LabReport();

		rpt.setPatientID(labReportOrder13.getPatientID());
		rpt.setLabOrderID(labReportOrder13.getLabOrderID());
		rpt.setSampleID("null");
		LabValues_type0[] labVal0 = new LabValues_type0[1];
		labVal0[0] = new LabValues_type0();
		labVal0[0].localLabParameter = "null";
		labVal0[0].localLabValue = new BigDecimal(0);
		rpt.setLabValues(labVal0);
		AccessDB db = new AccessDB();
		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("SELECT PATIENT_ID, LAB_ORDER_ID, SAMPLE_ID, "
							+ "LAB_PARAMETER, LAB_VALUE, INDEX FROM LAB_RECORD");

			while (rs.next()) {
				if ((rs.getString(1).equals(labReportOrder13.getPatientID()) && (rs
						.getString(2).equals(labReportOrder13.getLabOrderID())))) {

					rpt.setSampleID(rs.getString(3));
					LabValues_type0[] labVal = new LabValues_type0[rs.getInt(6)];

					for (int i = 0; i < rs.getInt(6); i++)
						labVal[i] = new LabValues_type0();

					labVal[0].localLabParameter = rs.getString(4);
					labVal[0].localLabValue = rs.getBigDecimal(5);

					int index = rs.getInt(6);
					if (index > 1) {
						int j = 1;
						while (rs.next()) {
							labVal[j].localLabParameter = rs.getString(4);
							labVal[j].localLabValue = rs.getBigDecimal(5);

							j++;
							if (j == index)
								break;
						}
					}

					rpt.setLabValues(labVal);
					break;
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rpt;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param radiologyReport15
	 * @return
	 */

	public void storeRadiologyReport(
			org.pahospital.www.patservice.RadiologyReport radiologyReport15) {
		System.out.println("PAT ==> Storint rad report");
		AccessDB db = new AccessDB();
		Connection conn = db
				.dbConnect(
						"jdbc:derby:/home/mark/Documenten/School/1-2a-SOA/SOA - Assignment Series 2/S2 - PAT/MyDB",
						"dimas", "dimas");

		try {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("SELECT RADIOLOGY_ORDER_ID FROM RADIOLOGY_RECORD");

			while (rs.next()) {
				if (rs.getString(1).equals(
						radiologyReport15.getRadiologyOrderID())) {
					rs.close();
					stmt.close();
					conn.close();
					throw new java.lang.UnsupportedOperationException(
							"Cannot save the record. The record already exists in the database!");
				}
			}
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO RADIOLOGY_RECORD "
							+ "(PATIENT_ID, RADIOLOGY_ORDER_ID, DATE_OF_EXAM, REPORT_TEXT) VALUES (?, ?, ?, ?)");
			statement.setString(1, radiologyReport15.getPatientID());
			statement.setString(2, radiologyReport15.getRadiologyOrderID());
			statement.setDate(3, new java.sql.Date(radiologyReport15
					.getDateOfExamination().getTime()));
			statement.setString(4, radiologyReport15.getReportText());
			statement.execute();

			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO : fill this with the necessary business logic

	}

}

class AccessDB {
	public AccessDB() {
	}

	public Connection dbConnect(String db_connect_string, String db_userid,	String db_password) {
		try {
            new EmbeddedDriver();
			Connection conn = DriverManager.getConnection(db_connect_string,
					db_userid, db_password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
