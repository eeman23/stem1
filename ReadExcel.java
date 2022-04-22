/*
 * was not used, is easier to output to a CSV file instead
 */
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
     
            int tpreb=0;
            int tpostb=0;
            int tprel=0;
            int tpostl=0;
            int tpresup=0;
            int tpostsup=0;
            int tpresn=0;
            
            int avgpreb=0;
            int avgpostb=0;
            int avgprel=0;
            int avgpostl=0;
            int avgpresup=0;
            int avgpostsup=0;
            int avgpresn=0;
            
            int gtotalpreb=0;
            int gtotalpostb=0;
            int gtotalprel=0;
            int gtotalpostl=0;
            int gtotalpresup=0;
            int gtotalpostsup=0;
            int gtotalpresn=0;

            
  
            
            

           // for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell ccell = sheet.getCell(2, i);
                    CellType type = ccell.getType();
                    Cell gcell = sheet.getCell(3,i);
                    int g= Integer.parseInt(gcell.getContents());
                    

                    if (type == CellType.NUMBER) {
                    	
                    	
                    	if (ccell.getContents().equals(58)) {
                            tpreb++;
                    		gtotalpreb+=g;
                    		avgpreb=gtotalpreb/tpreb;
                    	}
                    	
                    	if (ccell.getContents().equals(59)) {
                            tpostb++;
                    		gtotalpostb+=g;
                    		avgpostb=gtotalpostb/tpostb;
                    	}
                    	
                    	if (ccell.getContents().equals(60)) {
                            tprel++;
                            gtotalprel+=g;
                            avgprel=gtotalprel/tprel;
                    	}
                    	
                    	if (ccell.getContents().equals(61)) {
                            tpostl++;
                            gtotalpostl+=g;
                            avgpostl=gtotalpostl/tpostl;
                    	}
                    	
                    	if (ccell.getContents().equals(62)) {
                            tpresup++;
                            gtotalpresup+=g;
                            avgpresup=gtotalpresup/tpresup;
                    	}
                    	
                    	if (ccell.getContents().equals(63)) {
                            tpostsup++;
                            gtotalpostsup+=g;
                            avgpostsup=gtotalpostsup/tpostsup;
                    	}
                    	
                    	if (ccell.getContents().equals(64)) {
                            tpresn++;
                            gtotalpresn+=g;
                            avgpresn=gtotalpresn/tpresn;
                    	}
                    }

                }
            //}
        } catch (BiffException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel();
        test.setInputFile("/Users/aminas/Desktop/Dataset_stem12.xls");
        test.read();

    }

}