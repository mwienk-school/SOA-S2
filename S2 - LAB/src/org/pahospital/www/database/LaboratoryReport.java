package org.pahospital.www.database;

import java.math.BigDecimal;
import java.util.Map;

import org.pahospital.www.labcallbackservice.LabCallbackServiceStub.LabValues_type0;

public class LaboratoryReport {
	  private java.lang.String PatientID ;


		public  java.lang.String getPatientID(){
		return PatientID;
		}
		
		public void setPatientID(java.lang.String param){
		            this.PatientID=param;
		}
		
		private java.lang.String SampleID ;
		public  java.lang.String getSampleID(){
		return SampleID;
		}
		public void setSampleID(java.lang.String param){
		
		            this.SampleID=param;
		}
		private java.lang.String OrderID ;
		public  java.lang.String getOrderID(){
		return OrderID;
		}
		public void setOrderID(java.lang.String param){
		
		            this.OrderID=param;
		}
		
	   public LabValues_type0[] localLabValues ;
	   public  LabValues_type0[] getLabValues(){
	       return localLabValues;
	   }
	   protected void validateLabValues(LabValues_type0[] param){
	     
	      if ((param != null) && (param.length < 1)){
	        throw new java.lang.RuntimeException();
	      }
	      
	   }
	   public void setLabValues(LabValues_type0[] param){
	      
	           validateLabValues(param);
	
	       
	              this.localLabValues=param;
	   }	


}
