//import weka.core.Instance;
import weka.core.Instances;
//import weka.core.converters.ConverterUtils.DataSource;
import weka.core.converters.ArffLoader;
//import weka.classifiers.functions.LinearRegression;
import java.io.File;
//import weka.gui.GenericObjectEditor;
import weka.classifiers.functions.SMOreg;

public class Regression {

	public static void main(String[] args) throws Exception {
		weka.gui.GenericObjectEditor.determineClasses();
		
		//previous way of loading files
		//load dataset 
		//DataSource Source = new DataSource("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv1_02-05-2021/stem1_dataset_data01-finalAttributesFINALCUT.arff");
		
		ArffLoader loads = new ArffLoader();
		File f = new File("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_dataset-01_FINAL.arff");
		loads.setSource(f);
		Instances dataset= loads.getDataSet();
		
		//set class index to the last attribute
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		
		//build model
		//LinearRegression lr = new LinearRegression();
	    //lr.buildClassifier(dataset);
	     
	     //output model
	     //System.out.println(lr);
	     
		
	    
	    //build model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(dataset);
		
		//output model
		System.out.println(smo);
		
	     /*
	     //load new dataset
	     DataSource source1 = new DataSource ("/Users/aminas/Desktop/MAMS/STEM/excelJava/Dataset_stem1_unknown.arff"); 
	     Instances testDataset = source1.getDataSet();
	     
	     //set class index to the last attribute
	     testDataset.setClassIndex(testDataset.numAttributes()-1);
	    	 
	     }
	     */
	}

}
