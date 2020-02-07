package jConsolePlot;
/**
 * Interface that declares the basic attributes, constructors, setters, 
 * getters and draw methods of the <i>IPlot</i> objects.
 * <p>
 * Every <i>IPlot</i> correspond an a specific type of plot, and can
 * print itself into the console according to its parameters.
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-05-26
 */
public interface IPlot {
	/**
	 * <i>Axis</i> object corresponding to the XValues of this <i>IPlot</i>.
	 *
	 * @return  The current value of this <i>IPlot</i> XValues.
	 */
	public IAxis getXValues();
	/**
	 * <i>Axis</i> object corresponding to the YValues of this <i>IPlot</i>.
	 *
	 * @return  The current value of this <i>IPlot</i> YValues.
	 */
	public IAxis getYValues();
	/**
	 * Set the XValues of the current <i>IPlot</i>.
	 *
	 * @param  XValues new value of this <i>IPlot</i> XValues.
	 */
	public void setXValues(IAxis XValues);
	/**
	 * Set the YValues of the current <i>IPlot</i>.
	 *
	 * @param  YValues new value of this <i>IPlot</i> YValues.
	 */
	public void setYValues(IAxis YValues);
	/**
	 * Print an specific type of plot in the console according to the subclass
	 * of the class <i>IPlot</i>.
	 *
	 * @param  void  
	 */
	public void draw();
}