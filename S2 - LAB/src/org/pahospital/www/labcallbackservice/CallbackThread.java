package org.pahospital.www.labcallbackservice;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;

import org.apache.axis2.AxisFault;
import org.pahospital.www.database.DB_Manager;
import org.pahospital.www.database.LaboratoryOrder;
import org.pahospital.www.database.LaboratoryReport;
import org.pahospital.www.labcallbackservice.LabCallbackServiceStub.LabValues_type0;

public class CallbackThread extends Thread {
	String OrderID;
	int time;
    public CallbackThread(String str,int waiting) {
	OrderID= str;
	time=waiting;
    }
    public void run() {
    	try {
			sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	DB_Manager db= new DB_Manager();
		if(OrderID.indexOf("TEST")!=-1)
		{
			int ID=Integer.parseInt(OrderID.substring(4));
			try {
				System.out.println("LAB ==> CBT -> Sending report");
				LaboratoryOrder o=db.GetLabOrder(ID);
				//lblNewLabel.setText("the Order will be process and send");
				//contentPane.add(lblNewLabel);
				LabValues_type0 [] val =new LabValues_type0[o.getLabParameter().length];
				LabCallbackServiceStub stub =new LabCallbackServiceStub();
				LabCallbackServiceStub.LabReport labrep=new LabCallbackServiceStub.LabReport();
				labrep.setLabOrderID(OrderID);
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
				System.out.println("LAB ==> CBT -> Sent!");
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
			
		
    }
}
