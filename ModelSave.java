import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.classifiers.functions.SMOreg;
import java.io.File;

public class ModelSave {

	public static void main(String[] args) throws Exception {
		//load dataset 
		ArffLoader loadsf = new ArffLoader();
		File f = new File("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_dataset-01_FINAL.arff");			
		loadsf.setSource(f);
		Instances trainDataset= loadsf.getDataSet();
				
		//set class index to the last attribute				
		trainDataset.setClassIndex(trainDataset.numAttributes()-1);
				
		//build model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(trainDataset);
				
		//output model
		System.out.println(smo);
		
		//save model
		weka.core.SerializationHelper.write("stem1_model.model", smo);
		
		

	}

}
