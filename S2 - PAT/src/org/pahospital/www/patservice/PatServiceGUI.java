package org.pahospital.www.patservice;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

import javax.swing.*;

import org.apache.axis2.AxisFault;
import org.apache.commons.lang.ArrayUtils;

import org.pahospital.www.patservice.PatServiceStub;
import org.softsmithy.lib.swing.JFloatField;

//import sun.jvm.hotspot.types.JIntField;
//import com.toedter.calendar.JCalendar;

public class PatServiceGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container c = this.getContentPane();
	private JTextField urlfield = null;
	private final String defaultUrl = "http://localhost:9080/S2_-_PAT/services/PatService";
	private String url = defaultUrl;
	int i;
	PatServiceStub.LabValues_type0[] labVal = new PatServiceStub.LabValues_type0[1000];

	public static void main(String[] args) throws AxisFault {
		System.out.println("Hallo");
		new PatServiceGUI();
	}

	public PatServiceGUI() throws AxisFault {
		super("PatService Client");
		wsInit(defaultUrl);
		initialize();
	}

	public PatServiceStub stub;

	public void wsInit(String endpoint) throws AxisFault {
		stub = new PatServiceStub(endpoint);
	}

	private void initialize() {

		c.setLayout(new FlowLayout());

		final String[] choice_list = { "create a new patient record",
				"get the patient ID from his name",
				"get all the information about a patient from his ID",
				"store a radiology report", "retrieve a radiology report",
				"store a lab report", "retrieve a lab report" };

		final JButton button0 = new JButton();
		button0.setText(choice_list[0]);
		final JButton button1 = new JButton();
		button1.setText(choice_list[1]);
		final JButton button2 = new JButton();
		button2.setText(choice_list[2]);
		final JButton button3 = new JButton();
		button3.setText(choice_list[3]);
		final JButton button4 = new JButton();
		button4.setText(choice_list[4]);
		final JButton button5 = new JButton();
		button5.setText(choice_list[5]);
		final JButton button6 = new JButton();
		button6.setText(choice_list[6]);

		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					createPatientRecord();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getPatientIDsByName();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getPatientByID();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					storeRadiologyReport();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					retrieveRadiologyReport();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					storeLabReport();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					retrieveLabReport();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		c.add(button0);
		c.add(button1);
		c.add(button2);
		c.add(button3);
		c.add(button4);
		c.add(button5);
		c.add(button6);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void createPatientRecord() {

		c.setLayout(new FlowLayout());

		JLabel jLabelID = new JLabel();
		jLabelID.setText("ID (max length 5): ");
		JLabel jLabelName = new JLabel();
		jLabelName.setText("Name: ");
		JLabel jLabelStreet = new JLabel();
		jLabelStreet.setText("Street: ");
		JLabel jLabelZip_Code = new JLabel();
		jLabelZip_Code.setText("Zip Code: ");
		JLabel jLabelCity = new JLabel();
		jLabelCity.setText("City: ");
		JLabel jLabelBirthday = new JLabel();
		jLabelBirthday.setText("Birthday: ");
		
		JLabel jLabelResultID = new JLabel();
		jLabelResultID.setText("Result (Patient ID if successful): ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField id = new JTextField(5);
		final JTextField name = new JTextField(50);
		final JTextField street = new JTextField(50);
		final JTextField zip_code = new JTextField(20);
		final JTextField city = new JTextField(30);
		//final JCalendar birthday = new JCalendar();
		final JTextField result = new JTextField(50);

		JButton invokebutton = new JButton();
		invokebutton.setText("Create patient record");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();
				try {
					stub = new PatServiceStub(url);
					PatServiceStub.Patient request = new PatServiceStub.Patient();
					PatServiceStub.PatientID response;
					request.setPatientID(id.getText());
					request.setPatientName(name.getText());
					request.setPatientStreet(street.getText());
					int j = Integer.parseInt(zip_code.getText());
					request.setPatientZipCode(j);
					request.setPatientCity(city.getText());
					request.setPatientBirthday(new Date());

					response = stub.createPatientRecord(request);
					result.setText(response.getPatientID());

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		c.removeAll();
		c.add(jLabelID);
		c.add(id);
		c.add(jLabelName);
		c.add(name);
		c.add(jLabelStreet);
		c.add(street);
		c.add(jLabelZip_Code);
		c.add(zip_code);
		c.add(jLabelCity);
		c.add(city);
		c.add(jLabelBirthday);
		//c.add(birthday);
		c.add(invokebutton);
		c.add(jLabelResultID);
		c.add(result);
		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void getPatientIDsByName() {

		c.setLayout(new FlowLayout());

		JLabel jLabelName = new JLabel();
		jLabelName.setText("Name: ");
		JLabel jLabelID0 = new JLabel();
		jLabelID0.setText("Patient(s) ID: ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField name = new JTextField(50);

		JButton invokebutton = new JButton();
		invokebutton.setText("Get patient ID");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();
				try {
					stub = new PatServiceStub(url);
					PatServiceStub.PatientName request = new PatServiceStub.PatientName();
					PatServiceStub.IDsList response;
					request.setPatientName(name.getText());

					response = stub.getPatientIDsByName(request);
					int size = response.getPatientID().length;
					String[] result = new String[size];
					result = response.getPatientID();
					JTextField id0[] = new JTextField[size];

					for (int g = 0; g < id0.length; g++)
						id0[g] = new JTextField(5);
					for (int d = 0; d < size; d++) {
						c.add(id0[d]);
						id0[d].setText(result[d]);
					}

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		c.removeAll();
		c.add(jLabelName);
		c.add(name);
		c.add(invokebutton);
		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);
		c.add(jLabelID0);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void getPatientByID() {

		c.setLayout(new FlowLayout());

		JLabel jLabelID = new JLabel();
		jLabelID.setText("ID: ");

		JLabel jLabelName = new JLabel();
		jLabelName.setText("Name: ");
		JLabel jLabelStreet = new JLabel();
		jLabelStreet.setText("Street: ");
		JLabel jLabelZip_Code = new JLabel();
		jLabelZip_Code.setText("Zip Code: ");
		JLabel jLabelCity = new JLabel();
		jLabelCity.setText("City: ");
		JLabel jLabelBirthday = new JLabel();
		jLabelBirthday.setText("Birthday: ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField id = new JTextField(5);
		final JTextField name = new JTextField(50);
		final JTextField street = new JTextField(50);
		final JTextField zip_code = new JTextField(20);
		final JTextField city = new JTextField(30);
		final JTextField birthday = new JTextField(50);

		JButton invokebutton = new JButton();
		invokebutton.setText("Get patient information");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();
				try {
					stub = new PatServiceStub(url);
					PatServiceStub.PatientID request = new PatServiceStub.PatientID();
					PatServiceStub.Patient response;

					request.setPatientID(id.getText());

					response = stub.getPatientByID(request);
					name.setText(response.getPatientName());
					street.setText(response.getPatientStreet());
					zip_code.setText(String.valueOf(response
							.getPatientZipCode()));
					city.setText(response.getPatientCity());
					if (response.getPatientBirthday() == null)
						birthday.setText("N/A");
					else {
						DateFormat formatter;
						formatter = new SimpleDateFormat("dd-MMM-yy");
						String stringDate = formatter.format(response
								.getPatientBirthday());
						birthday.setText(stringDate);
					}

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		c.removeAll();
		c.add(jLabelID);
		c.add(id);
		c.add(invokebutton);
		c.add(jLabelName);
		c.add(name);
		c.add(jLabelStreet);
		c.add(street);
		c.add(jLabelZip_Code);
		c.add(zip_code);
		c.add(jLabelCity);
		c.add(city);
		c.add(jLabelBirthday);
		c.add(birthday);

		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void storeRadiologyReport() {

		c.setLayout(new FlowLayout());

		JLabel jLabelPatientID = new JLabel();
		jLabelPatientID.setText("Patient ID (max length 5): ");
		JLabel jLabelRadiologyID = new JLabel();
		jLabelRadiologyID.setText("Radiology report ID (max length 5): ");
		JLabel jLabelDate = new JLabel();
		jLabelDate.setText("Date of Examination: ");
		JLabel jLabelReport = new JLabel();
		jLabelReport.setText("Report Text: ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField patientID = new JTextField(5);
		final JTextField radiologyID = new JTextField(5);
		//final JCalendar date = new JCalendar();
		final JTextField report = new JTextField(50);

		JButton invokebutton = new JButton();
		invokebutton.setText("Store radiology record");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();
				try {
					stub = new PatServiceStub(url);
					PatServiceStub.RadiologyReport request = new PatServiceStub.RadiologyReport();
					request.setPatientID(patientID.getText());
					request.setRadiologyOrderID(radiologyID.getText());
					//request.setDateOfExamination(date.getCalendar().getTime());
					request.setReportText(report.getText());

					stub.storeRadiologyReport(request);

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		c.removeAll();
		c.add(jLabelPatientID);
		c.add(patientID);
		c.add(jLabelRadiologyID);
		c.add(radiologyID);
		c.add(jLabelDate);
		c.add(jLabelReport);
		c.add(report);
		c.add(invokebutton);
		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void retrieveRadiologyReport() {

		c.setLayout(new FlowLayout());

		JLabel jLabelPatientID = new JLabel();
		jLabelPatientID.setText("Patient ID (max length 5): ");
		JLabel jLabelRadiologyID = new JLabel();
		jLabelRadiologyID.setText("Radiology report ID (max length 5): ");
		JLabel jLabelDate = new JLabel();
		jLabelDate.setText("Date of examination: ");
		JLabel jLabelReport = new JLabel();
		jLabelReport.setText("Report text: ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField patientID = new JTextField(5);
		final JTextField radiologyID = new JTextField(5);
		final JTextField date = new JTextField(50);
		final JTextField report = new JTextField(50);

		JButton invokebutton = new JButton();
		invokebutton.setText("Retrieve radiology record");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();
				try {
					stub = new PatServiceStub(url);
					PatServiceStub.RadiologyReportOrder request = new PatServiceStub.RadiologyReportOrder();
					PatServiceStub.RadiologyReport response;
					request.setPatientID(patientID.getText());
					request.setRadiologyOrderID(radiologyID.getText());

					response = stub.retrieveRadiologyReport(request);
					if (response.getDateOfExamination() == null)
						date.setText("N/A");
					else {
						DateFormat formatter;
						formatter = new SimpleDateFormat("dd-MMM-yy");
						String stringDate = formatter.format(response
								.getDateOfExamination());
						date.setText(stringDate);
					}
					report.setText(response.getReportText());

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		c.removeAll();
		c.add(jLabelPatientID);
		c.add(patientID);
		c.add(jLabelRadiologyID);
		c.add(radiologyID);
		c.add(invokebutton);
		c.add(jLabelDate);
		c.add(date);
		c.add(jLabelReport);
		c.add(report);

		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void storeLabReport() {

		labVal[0] = new PatServiceStub.LabValues_type0();
		labVal[0].setLabParameter("");
		labVal[0].setLabValue(new BigDecimal(0));

		c.setLayout(new FlowLayout());
		i = 0;

		JLabel jLabelPatientID = new JLabel();
		jLabelPatientID.setText("Patient ID (max length 5): ");
		JLabel jLabelLabID = new JLabel();
		jLabelLabID.setText("Lab report ID (max length 5): ");
		JLabel jLabelSampleID = new JLabel();
		jLabelSampleID.setText("Sample ID (max length 5): ");
		final JLabel jLabelLabParameters = new JLabel();
		jLabelLabParameters.setText("Lab Parameters ");
		final JLabel jLabelLabValues = new JLabel();
		jLabelLabValues.setText("Lab Values ");
		final JLabel jLabelLabParametersExtra = new JLabel();
		jLabelLabParametersExtra.setText("Lab Parameters ");
		final JLabel jLabelLabValuesExtra = new JLabel();
		jLabelLabValuesExtra.setText("Lab Values ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField patientID = new JTextField(5);
		final JTextField labID = new JTextField(5);
		final JTextField sampleID = new JTextField(5);
		final JTextField labParam0 = new JTextField(50);
		final JFloatField labValue0 = new JFloatField();
		final JTextField[] labParam0Extra = new JTextField[10];
		for (int g = 0; g < labParam0Extra.length; g++)
			labParam0Extra[g] = new JTextField(50);
		final JFloatField[] labValue0Extra = new JFloatField[10];
		for (int y = 0; y < labParam0Extra.length; y++)
			labValue0Extra[y] = new JFloatField();

		JButton invokebutton = new JButton();
		invokebutton.setText("Store lab report");
		JButton addbutton = new JButton();
		addbutton.setText("Add Lab Values");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.add(jLabelLabParametersExtra);
					c.add(labParam0Extra[i]);
					c.add(jLabelLabValuesExtra);
					c.add(labValue0Extra[i]);
					i++;
					labVal[i] = new PatServiceStub.LabValues_type0();
					labVal[i].setLabParameter("");
					labVal[i].setLabValue(new BigDecimal(0));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();
				try {
					stub = new PatServiceStub(url);
					PatServiceStub.LabReport request = new PatServiceStub.LabReport();
					request.setPatientID(patientID.getText());
					request.setLabOrderID(labID.getText());
					request.setSampleID(sampleID.getText());

					PatServiceStub.LabValues_type0 labVal0 = new PatServiceStub.LabValues_type0();
					labVal0.setLabParameter(labParam0.getText());
					labVal0.setLabValue(labValue0.getBigDecimalValue());
					PatServiceStub.LabValues_type0[] labValFirst = { labVal0 };

					for (int u = 0; u < i; u++) {
						if ((labParam0Extra[u].getText() != "")
								&& (labValue0Extra[u].getBigDecimalValue() != new BigDecimal(
										0))) {
							PatServiceStub.LabValues_type0 labVal0Extra = new PatServiceStub.LabValues_type0();
							labVal0Extra.setLabParameter(labParam0Extra[u]
									.getText());
							labVal0Extra.setLabValue(labValue0Extra[u]
									.getBigDecimalValue());
							labVal[u] = labVal0Extra;
						}
					}

					if (i > 0) {
						PatServiceStub.LabValues_type0[] labValSecond = new PatServiceStub.LabValues_type0[i];
						for (int f = 0; f < i; f++)
							labValSecond[f] = labVal[f];
						PatServiceStub.LabValues_type0[] labValMerge = (PatServiceStub.LabValues_type0[]) ArrayUtils
								.addAll(labValFirst, labValSecond);

						request.setLabValues(labValMerge);
					}

					else
						request.setLabValues(labValFirst);

					stub.storeLabReport(request);

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		c.removeAll();
		c.add(jLabelPatientID);
		c.add(patientID);
		c.add(jLabelLabID);
		c.add(labID);
		c.add(jLabelSampleID);
		c.add(sampleID);
		c.add(jLabelLabParameters);
		c.add(labParam0);
		c.add(jLabelLabValues);
		c.add(labValue0);
		c.add(addbutton);
		c.add(invokebutton);
		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

	private void retrieveLabReport() {

		c.setLayout(new FlowLayout());

		JLabel jLabelPatientID = new JLabel();
		jLabelPatientID.setText("Patient ID (max length 5): ");
		JLabel jLabelLabID = new JLabel();
		jLabelLabID.setText("Lab report ID (max length 5): ");
		JLabel jLabelSampleID = new JLabel();
		jLabelSampleID.setText("Sample ID (max length 5): ");

		JLabel urlLabel = new JLabel();
		urlLabel.setText("URL:");

		final JTextField patientID = new JTextField(5);
		final JTextField labID = new JTextField(5);
		final JTextField sampleID = new JTextField(5);

		JButton invokebutton = new JButton();
		invokebutton.setText("Retrieve lab report");
		JButton cleanbutton = new JButton();
		cleanbutton.setText("back to menu");

		cleanbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{

					c.removeAll();
					initialize();

				}
			}
		});

		invokebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = urlfield.getText();

				try {
					stub = new PatServiceStub(url);
					PatServiceStub.LabReportOrder request = new PatServiceStub.LabReportOrder();
					request.setPatientID(patientID.getText());
					request.setLabOrderID(labID.getText());
					PatServiceStub.LabReport response;

					response = stub.retrieveLabReport(request);
					sampleID.setText(response.getSampleID());
					PatServiceStub.LabValues_type0[] labValResult = response
							.getLabValues();
					for (int j = 0; j < labValResult.length; j++) {
						if (labValResult[j].getLabParameter() != "") {
							JTextField labParam0 = new JTextField(50);
							JTextField labValue0 = new JTextField(10);
							JLabel jLabelLabParameters = new JLabel();
							jLabelLabParameters.setText("Lab Parameters ");
							JLabel jLabelLabValues = new JLabel();
							jLabelLabValues.setText("Lab Values ");
							c.add(jLabelLabParameters);
							c.add(labParam0);
							c.add(jLabelLabValues);
							c.add(labValue0);
							labParam0.setText(labValResult[j].getLabParameter());
							labValue0.setText(String.valueOf(labValResult[j]
									.getLabValue()));
						}
					}

				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		urlfield = new JTextField(url);
		urlfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == urlfield) {
					try {
						stub = new PatServiceStub(url);
					} catch (AxisFault e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		c.removeAll();
		c.add(jLabelPatientID);
		c.add(patientID);
		c.add(jLabelLabID);
		c.add(labID);
		c.add(invokebutton);
		c.add(jLabelSampleID);
		c.add(sampleID);
		c.add(urlLabel);
		c.add(urlfield);
		c.add(cleanbutton);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(1420, 550);
		this.setVisible(true);
	}

}
