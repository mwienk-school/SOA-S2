package org.pahospital.www.labcallbackservice;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.apache.axis2.AxisFault;
import org.pahospital.www.database.DB_Manager;
import org.pahospital.www.database.LaboratoryOrder;
import org.pahospital.www.database.LaboratoryReport;
import org.pahospital.www.labcallbackservice.LabCallbackServiceStub.LabValues_type0;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

public class CallbackGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CallbackGUI frame = new CallbackGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CallbackGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderid = new JLabel("OrderID");
		lblOrderid.setBounds(20, 69, 46, 14);
		contentPane.add(lblOrderid);
		
		textField = new JTextField();
		textField.setBounds(87, 66, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProcessTest = new JButton("Process Test & send report");
		btnProcessTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DB_Manager db= new DB_Manager();
				if(textField.getText().indexOf("TEST")!=-1)
				{
					int ID=Integer.parseInt(textField.getText().substring(4));
					try {
						LaboratoryOrder o=db.GetLabOrder(ID);
						lblNewLabel.setText("the Order will be process and send");
						contentPane.add(lblNewLabel);
						LabValues_type0 [] val =new LabValues_type0[o.getLabParameter().length];
						LabCallbackServiceStub stub =new LabCallbackServiceStub();
						LabCallbackServiceStub.LabReport labrep=new LabCallbackServiceStub.LabReport();
						labrep.setLabOrderID(textField.getText());
						labrep.setPatientID(o.getPatientID());
						labrep.setSampleID(o.getSampleID());
						
						for(int i=0;i<o.getLabParameter().length;i++ )
						{
							val[i]=new LabValues_type0();
							val[i].setLabParameter(o.getLabParameter()[i]);
							BigDecimal max = new BigDecimal("15" + ".0");
					        BigDecimal randFromDouble = new BigDecimal(Math.random());
					        BigDecimal actualRandomDec = randFromDouble.divide(max,BigDecimal.ROUND_DOWN);
					        actualRandomDec=actualRandomDec.setScale(3, actualRandomDec.ROUND_HALF_DOWN);
					        val[i].setLabValue(actualRandomDec);
							}
						labrep.setLabValues(val);
						stub.sendLabReport(labrep);
						LaboratoryReport rep=new LaboratoryReport();
						rep.setOrderID(o.getOrderID());
						rep.setPatientID(o.getPatientID());
						rep.setSampleID(o.getSampleID());
						rep.setLabValues(labrep.getLabValues());
						db.Insertlabreport(rep);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (AxisFault e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					lblNewLabel.setText("Wrong ID,try again!");
					contentPane.add(lblNewLabel);
				}
					
				
				
			}
		});
		btnProcessTest.setBounds(87, 97, 184, 28);
		contentPane.add(btnProcessTest);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(281, 97, 143, 72);
		contentPane.add(lblNewLabel);
	}
}
