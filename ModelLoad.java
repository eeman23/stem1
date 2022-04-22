import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.classifiers.functions.SMOreg;
import java.io.File;

public class ModelLoad {
	public static void main(String[] args) throws Exception {
		
		//load model
		//observe type-casting
		SMOreg smo = (SMOreg)weka.core.SerializationHelper.read("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_model.model");
		
		//load new dataset
			ArffLoader loadsj = new ArffLoader();
			File j = new File("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_dataset-01_FINAL.arff");
			loadsj.setSource(j);
			Instances testDataset= loadsj.getDataSet();
			
		//set class index to the last attribute				
		testDataset.setClassIndex(testDataset.numAttributes()-1);
		
		//get class double value for first instance
		double actualValue = testDataset.instance(0).classValue();
		
		//get Instance object of first instance
		Instance newInst = testDataset.instance(0);
		
		//call classifyInstance, which returns a double vlaue for the class
		double predSMO= smo.classifyInstance(newInst);
		
		System.out.println(actualValue + ", " +predSMO);
		
	}
}
