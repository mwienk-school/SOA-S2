package org.pahospital.www.database;

public class LaboratoryOrder {
    
    private java.lang.String PatientID ;


	public  java.lang.String getPatientID(){
	return PatientID;
	}
	public void setPatientID(java.lang.String param){
        this.PatientID=param;
}
	private java.lang.String OrderID ;


	public  java.lang.String getOrderID(){
	return OrderID;
	}
	
	public void setOrderID(java.lang.String param){
	            this.OrderID=param;
	}
	private java.lang.String CaseID ;
	public  java.lang.String getCaseID(){
	return CaseID;
	}
	public void setCaseID(java.lang.String param){
	
	            this.CaseID=param;
	}
	private java.lang.String SampleID ;
	public  java.lang.String getSampleID(){
	return SampleID;
	}
	public void setSampleID(java.lang.String param){
	
	            this.SampleID=param;
	}
	
	private java.lang.String SampleMaterial ;
	public  java.lang.String getSampleMaterial(){
	return SampleMaterial;
	}
	public void setSampleMaterial(java.lang.String param){
	
	            this.SampleMaterial=param;
	    
	
	}
	
	private java.lang.String[] LabParameter ;
	
	public  java.lang.String[] getLabParameter(){
	return LabParameter;
	}
	protected void validateLabParameter(java.lang.String[] param){
        
        if ((param != null) && (param.length < 1)){
          throw new java.lang.RuntimeException();
        }
        
        }
        public void setLabParameter(java.lang.String[] param){
        
             validateLabParameter(param);

         
                this.LabParameter=param;
        }
	
	
	

}
