import weka.classifiers.trees.J48;
import weka.core.Debug.Log;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import weka.classifiers.functions.LinearRegression;



public class machineLearning {

    public static void main(String[] args) throws Exception {
        // Specifying the datasource
        DataSource dataSource = new DataSource("/Users/aminas/Desktop/MAMS/STEM/exceljava/weka-3-9-6/data/diabetes.arff");
        // Loading the dataset
        Instances dataInstances = new Instances (new BufferedReader(new FileReader("Diabetes.arff")));
        		//dataSource.getDataSet();
        		
        // Displaying the number of instances
        //Log.stringToLevel
        
        System.out.println("The number of loaded instances is: " + dataInstances.numInstances());

        System.out.println(("data:" + dataInstances.toString()));
        System.out.println(("The number of attributes in the dataset: " + dataInstances.numAttributes()));
     // Identifying the label index
        dataInstances.setClassIndex(dataInstances.numAttributes() - 1);
        // Getting the number of classes
        System.out.println(("The number of classes: " + dataInstances.numClasses()));
       
    // Creating a decision tree classifier
       J48 treeClassifier = new J48();
       treeClassifier.setOptions(new String[] { "-U" });
       treeClassifier.buildClassifier(dataInstances);
       
       //Build Model
       LinearRegression lr = new LinearRegression();
       lr.buildClassifier(dataInstances);
       System.out.println(lr);
    }
}


