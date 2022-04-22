/*
 * ended up not being useful because it didn't apply to numerics
 */

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import java.util.Random;
//import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.SMOreg;
import java.io.File;




public class Evaluating {

	public static void main(String[] args) throws Exception {
		//load dataset 
			ArffLoader loadsf = new ArffLoader();
			File f = new File("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_dataset-01_FINAL.arff");
			loadsf.setSource(f);
			Instances trainDataset= loadsf.getDataSet();
			
			//set class index to the last attribute				
			trainDataset.setClassIndex(trainDataset.numAttributes()-1);
			
			//create and build the classifiers
			//J48 tree = new J48();
			//tree.buildClassifier(trainDataset);
			
			//build model
			SMOreg smo = new SMOreg();
			smo.buildClassifier(trainDataset);
			
			//output model
			System.out.println(smo);
			
		//	Evaluation eval = new Evaluation (trainDataset);
			Random rand = new Random(1);
			int folds=10;
			
			
			//build the classifier with the training set, initialize evaluation with train dataset, then evaluate using test dataset
			
			//test datset for evaluation 
			ArffLoader loadsj = new ArffLoader();
			File j = new File("/Users/aminas/Desktop/MAMS/STEM/datasetEditedv2_02-05-2021/stem1_dataset-02_FINAL.arff");
			loadsj.setSource(j);
			Instances testDataset= loadsj.getDataSet();
			
			//set class index to the last attribute				
			testDataset.setClassIndex(testDataset.numAttributes()-1);
			
			//now evaluate the model
		//	eval.evaluateModel(smo,testDataset);
			//eval.crossValidateModel(smo, testDataset, folds, rand);
		//	System.out.println(eval.toSummaryString("Evaluation results:\n", false));
			
			/*
			System.out.println("Correct % =" + eval.pctCorrect());
			System.out.println("Incorrect % =" + eval.pctIncorrect());
			System.out.println("AUC" + eval.areaUnderROC(1));
			System.out.println("kappa =" +eval.kappa());
			System.out.println("MAE =" +eval.meanAbsoluteError());
			System.out.println("RMSE =" + eval.rootMeanSquaredError());
			System.out.println("RAE =" + eval.relativeAbsoluteError());
			System.out.println("RRSE =" + eval.rootRelativeSquaredError());
			System.out.println("Precision =" + eval.precision(1));
			
			*/
			

	}

}
