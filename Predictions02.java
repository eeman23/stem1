import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ArffLoader;
import weka.classifiers.functions.SMOreg;
import java.io.File;
import java.io.PrintWriter;


public class Predictions02 {

	public static void main(String[] args) throws Exception{
		//load dataset 
		ArffLoader loadsf = new ArffLoader();
		File f = new File("/Users/aminas/Desktop/MAMS/STEM/stem1_editedDatasets/datasetEditedv3_02-12-2021/stem1_dataset-02_MODEL-FINAL.arff");
		loadsf.setSource(f);
		Instances trainDataset= loadsf.getDataSet();
		
		//set class index to the last attribute				
		trainDataset.setClassIndex(trainDataset.numAttributes()-1);
		
		//build model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(trainDataset);
		
		//output model
		System.out.println(smo);
		
		//load new dataset 
			ArffLoader loadsj = new ArffLoader();
			File j = new File("/Users/aminas/Desktop/MAMS/STEM/stem1_editedDatasets/datasetEditedv3_02-12-2021/stem1_dataset-02_TEST-FINAL.arff");
			loadsj.setSource(j);
			Instances testDataset= loadsj.getDataSet();
		
		//test new datset
		/*
		ArffLoader loadsj = new ArffLoader();
		File j = new File("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_dataset-02_FINAL.arff");
		loadsj.setSource(j);
		Instances testDataset= loadsj.getDataSet();
		*/
		
		//set class index to the last attribute				
		testDataset.setClassIndex(testDataset.numAttributes()-1);
		
		//loop through the new dataset
		System.out.println();
		
		 //loop through the new dataset and make predictions
	     System.out.println("============");
	     System.out.println("Actual Class, SMO Predicted");
	     
	     File csvFile = new File ("/Users/aminas/Desktop/MAMS/STEM/stem1_rawData/stem1_rawData_v2_02-12-2021/stem1_rawData02-FINAL.csv");
	     
	     PrintWriter out = new PrintWriter(csvFile);
	     
	     for (int i=0; i<testDataset.numInstances(); i++) {
	    	 
	    	 //get class double value for current instance
	    	 double actualValue = testDataset.instance(i).classValue();
	    	 
	    	 //get Instance object of current instance
	    	 Instance newInst = testDataset.instance(i);
	    	 
	    	 //call classifyInstance, which returns a double value for the class
	    	 double predSMO1= 100* smo.classifyInstance(newInst);
	    	 int predSMO2 = (int) predSMO1;
	    	 double predSMO = (double)predSMO2/100;
	    	 
	    	 //System.out.println(actualValue + " ," + predSMO);	 
	    	 //out.println(actualValue);
	    	 out.printf("%.2f, %.2f%n", actualValue, predSMO);
	     }
	     
	     out.close();
	

}
}