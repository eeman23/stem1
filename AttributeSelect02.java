/**
 * for some reason AttributeSelection worked for data01 but not for data02, so I ended up just using a csv to arff converter from online
 */


import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;

import weka.core.Instances;

import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;


public class AttributeSelect02 {

	public static void main(String[] args) throws Exception {
		//load dataset 
			DataSource Source = new DataSource("/Users/aminas/Desktop/MAMS/STEM/datasetEdited/Dataset_Data02-fullAttributes.arff");
			Instances dataset= Source.getDataSet();
			
			//create AttributeSelection object
			AttributeSelection filter = new AttributeSelection();
			
			//create evaluator and search algorithm objects
			CfsSubsetEval eval = new CfsSubsetEval();
			GreedyStepwise search = new GreedyStepwise();
			
			//set the algorithm to search backward
			search.setSearchBackwards(true);
			
			//set the filter to use the evaluator and search algorithm
			filter.setEvaluator(eval);
			filter.setSearch(search);
			
			//specify the dataset
			filter.setInputFormat(dataset);
			
			//apply
			Instances newData = Filter.useFilter(dataset, filter);
			
			//save
			ArffSaver saver= new ArffSaver();
			saver.setInstances(newData);
			saver.setFile(new File ("/Users/aminas/Desktop/MAMS/STEM/datasetEdited/Dataset_Data02-doneAttributes.arff"));
			saver.writeBatch();
	}

}
