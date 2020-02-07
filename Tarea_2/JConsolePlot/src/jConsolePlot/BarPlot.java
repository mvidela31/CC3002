package jConsolePlot;

import java.util.ArrayList;
/**
 * Public class that implements the basic attributes, constructors, 
 * setters, getters and draw methods declared in the <i>IPlot</i> interface.
 *
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-05-26
 */
public class BarPlot implements IPlot{
	
	// Attributes.
	/**
	 * XAxis <i>Axis</i> of this <i>BarPlot</i>.
	 */
	private IAxis XValues;
	/**
	 * YAxis <i>Axis</i> of this <i>BarPlot</i>.
	 */
	private IAxis YValues;
	
	// Constructors.
	/**
	  Initializes a newly created <i>BarPlot</i> object
	  with the all the attributes setted as null by default.
	*/
	public BarPlot() {	
	}
	/**
	  Initializes a newly created <i>BarPlot</i> object
	  with the specified parameters.
	  <p>
	  @param XValues  an <i>Axis</i> object that indicates the current
	                  XAxis Values of this <i>BarPlot</i>.
	  @param YValues  an <i>Axis</i> object that indicates the current
	                  YAxis Values of this <i>BarPlot</i>.
	*/
	public BarPlot(IAxis XValues, IAxis YValues) {
		this.XValues = XValues;
		this.YValues = YValues;
	}
	
	@Override
	public IAxis getXValues() {
		return this.XValues;
	}
	
	@Override
	public IAxis getYValues() {
		return this.YValues;
	}
	
	@Override
	public void setXValues(IAxis XValues) {
		this.XValues = XValues;
	}
	
	@Override
	public void setYValues(IAxis YValues) {
		this.YValues = YValues;
	}
	
	@Override
	public void draw() {
		System.out.println(this.drawBarPlot());
	}
	/**
	 * Creates a string with the characters of a bar plot according
	 * to the parameters values of the current <i>BarPlot</i> object.
	 *
	 * @param  void 
	 * @return A string with the characters of the plot. 
	 */
	public String drawBarPlot() {
		IAxis originalXAxis = this.getXValues(); 
		IAxis originalYAxis = this.getYValues(); 
		ArrayList<Integer> discretizaisedYAxis = this.getYValues().discretizaiseAxis();
		StringBuilder consolePlot = new StringBuilder();
		int maxLengthValue = String.valueOf(discretizaisedYAxis.get(discretizaisedYAxis.size()-1)).length();
		int lengthDifference;
		// Discretizaised YAxis iteration.
		for (int i = discretizaisedYAxis.size() - 1; i >= 0; i--) {
			consolePlot.append(discretizaisedYAxis.get(i));
			lengthDifference = maxLengthValue - String.valueOf(discretizaisedYAxis.get(i)).length();
			for (int j = 0; j < lengthDifference; j++) {
				consolePlot.append(" ");
			}
			consolePlot.append("| ");
			for (int j = 0; j < originalXAxis.size(); j++) {
				if (Integer.parseInt(originalYAxis.getElement(j)) >= discretizaisedYAxis.get(i)) { 
					consolePlot.append("XX");
				}
				else {
					consolePlot.append("  ");
				}
				consolePlot.append("  ");
			}
			consolePlot.append("\n");
		}
		for (int i = 0; i < maxLengthValue; i++) {
			consolePlot.append(" ");
		}
		for (int i = 0; i < originalXAxis.size(); i++) {
			consolePlot.append("====");
		}
		consolePlot.append("==");
		consolePlot.append("\n");
		for (int i = 0; i < maxLengthValue; i++) {
			consolePlot.append(" ");
		}
		for (int i = 0; i < originalXAxis.size(); i++) {
			consolePlot.append("   ");
			consolePlot.append(originalXAxis.getElement(i));
		}
		return consolePlot.toString();
	}
}