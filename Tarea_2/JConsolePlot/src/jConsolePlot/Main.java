package jConsolePlot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
/**
 * Main class of the JConsolePlot program.
 * <p>
 * Parse the inputs Strings in the console using the JCommander
 * framework and prints an specified plot in console according
 * to the input.
 * <p>
 *  <b>- <u>Observation</u>:</b> The discretization level of the axis can be
 *  adjusted below, setting the <i>XAxisDiscretization</i> and <i>YAxisDiscretization</i>
 *  variables for better resolution of the plot.
 * <p>
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-05-26
 */
class Main {
    // JCommander parameters.
	/**
	 * Boolean variable that indicates if the plot required is Bar Plot.
	 */
	@Parameter(names={"BarPlot"})
	private boolean isBarPlot ;
	/**
	 * Boolean variable that indicates if the plot required is Scatter Plot.
	 */
    @Parameter(names={"ScatterPlot"})
    private boolean isScatterPlot ;
	/**
	 * String ArrayList that contains the values of the input.
	 */
    @Parameter(names = "-P", variableArity = true)
    private ArrayList<String> coupledValuesList = new ArrayList<>();
	/**
	 * File variable that contains the directory of the file 
	 * with the input data.
	 */
    @Parameter(names={"-F"})
    private File file = null;
	/**
	 * String value that indicates the X axis limit value.
	 */
    @Parameter(names={"-x"})
    private int XAxisLimit;
	/**
	 * String value that indicates the Y axis limit value.
	 */
    @Parameter(names={"-y"})
    private int YAxisLimit;
	/**
	 * Parse the string console input using the 
	 * JCommander framework.
	 *
	 * @param  argv JCommander framework arguments.
	 * @throws IOException 
	 */
    public static void main(String ... argv) throws IOException {
        Main main = new Main();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(argv);
        main.run();
    }
	/**
	 * Prints a specific plot in the console according to the
	 * console input or file data.
	 * 
	 * @param  void  
	 * @throws IOException 
	 */
    @SuppressWarnings("resource")
	public void run() throws IOException {   	
    	// Read file.
        if (file != null) {
        	FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        ArrayList<String> data = new ArrayList<String>();
	        String line;
	        while((line = br.readLine()) != null) {
	            data.add(line);
	         }
	        coupledValuesList = data;
		}
        // Set the discretization axis values.
        //-------------------------------------
		int XAxisDiscretization = 20;
	    int YAxisDiscretization = 10;
	    //-------------------------------------
	    Axis XValues = new Axis(getValues(coupledValuesList, 0), XAxisLimit, XAxisDiscretization);
	    Axis YValues = new Axis(getValues(coupledValuesList, 1), YAxisLimit, YAxisDiscretization);
	    IPlot plot;
	    String plotName = null;
        if (isBarPlot) {
        	plotName = "BarPlot";
        }
        else if (isScatterPlot) {
        	plotName = "ScatterPlot";
        }
        else {
        }
        plot = PlotsFactory.getPlot(plotName);
    	plot.setXValues(XValues); plot.setYValues(YValues);
    	plot.draw();
    }
	/**
	 * Recover the elements of a coupled String ArrayList dividing the elements
	 * by a comma (","), with the specified index that indicates the elements
	 * that will be recovered in an String ArrayList.
	 * 
	 * @param  coupledValuesList  An String ArrayList with elements separated by
	 * commas (",").
	 * @param  position  An integer that the indicates 
	 * the position of the the element that will be recovered.
	 * 
	 * @return An String ArrayList with the elements of 
	 * the specified position.
	 */
    public ArrayList<String> getValues(ArrayList<String> coupledValuesList, int position){
    	ArrayList<String> values = new ArrayList<>();
    	for (int i = 0; i < coupledValuesList.size(); i++) {
    		values.add(coupledValuesList.get(i).split(",")[position]);
    	}
    	return values;
    }
}