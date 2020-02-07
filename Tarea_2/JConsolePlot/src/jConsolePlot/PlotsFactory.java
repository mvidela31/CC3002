package jConsolePlot;

import java.util.HashMap;
/**
 * Public class that implements the Flyweigth design pattern to
 * get different types of <i>IPlots</i> from a HashMap located in this
 * class.
 *
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-05-26
 */
public class PlotsFactory {
	// Attributes.
	/**
	 * HashMap data structure of this class.
	 */
	private static HashMap<String, IPlot> plotsMap = new HashMap<String, IPlot>();
	
	// HashMap values assignment. 
	static {
		plotsMap.put("BarPlot", new BarPlot());
		plotsMap.put("ScatterPlot", new ScatterPlot());
	}
	
	// getFlyweight(Key): Flyweight.
	/**
	 * Search an specific type of <i>IPlot</i> in the HashMap of
	 * <i>PlotsFactory</i> and returns it.
	 *
	 * @param  plotName name of the <i>IPlot</i> kind required.
	 * 
	 * @return  The <i>IPlot</i> founded.
	 */
	public static IPlot getPlot(String plotName) {
		IPlot plot = plotsMap.get(plotName);
		if (plot!=null) {
			return plot;
		}
		else {
			// Exception!!!
			return null;
		}
	}
}