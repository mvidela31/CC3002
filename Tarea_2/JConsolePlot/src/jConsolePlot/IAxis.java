package jConsolePlot;

import java.util.ArrayList;
/**
 * Interfaces that declares and implements the setters, getters and
 * methods of the <i>IAxis</i> objects.
 * <p>
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-05-26
 */
public interface IAxis {
	/**
	 * String ArrayList corresponding to the values of this <i>Axis</i>.
	 *
	 * @return  The current value of this <i>Axis</i> value.
	 */
	public ArrayList<String> getValues();
	/**
	 * Integer corresponding to the max value of this <i>Axis</i>.
	 *
	 * @return  The current value of this <i>Axis</i> limit.
	 */
	public int getLimit();
	/**
	 * Integer corresponding to the discretization level of this <i>Axis</i>.
	 *
	 * @return  The current value of this <i>Axis</i> discretization level.
	 */
	public int getDiscretizationLevel();
	/**
	 * Set the values of the current <i>Axis</i>.
	 *
	 * @param  values new value of this <i>Axis</i> values.
	 */
	public void setValues(ArrayList<String> values);
	/**
	 * Set the limit of the current <i>Axis</i>.
	 *
	 * @param  limit new value of this <i>Axis</i> limit.
	 */
	public void setLimit(int limit);
	/**
	 * Set the discretization level of the current <i>Axis</i>.
	 *
	 * @param  values new value of this <i>Axis</i> discretization level.
	 */
	public void setDiscretizationLevel(int discretizationLevel);
	/**
	 * Gets the size of the <i>Axis</i> values.
	 *
	 * @return  The size of the <i>Axis</i> values ArrayList.
	 */
	public int size();
	/**
	 * Gets an specific element of the <i>Axis</i> values according
	 * to an index position of the ArrayList from values.
	 *
	 * @param  index Integer position of the element that will be extracted.
	 * @return  The element of <i>Axis</i> values according to the index.
	 */
	public String getElement(int index);
	/**
	 * Creates an Integer ArrayList that contains the <i>Axis</i> values
	 * converted from String type to Integer Type.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer ArrayList of the <i>Axis</i> values.
	 */
	public ArrayList<Integer> stringListToIntegerList();
	/**
	 * Extract the min element of the <i>Axis</i> values.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer min value of the <i>Axis</i> values.
	 */
	public int minElement();
	/**
	 * Extract the max element of the <i>Axis</i> values.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer max value of the <i>Axis</i> values.	
	 */
	public int maxElement();
	/**
	 * Get the discretization step of the current <i>Axis</i> according to
	 * its max and min values and it discretization level parameter.
	 * <p>
	 * If the parameter limit is superior to 0, the max value of the discretization
	 * will be replaced with the limit paramater value.
	 * <p>
	 * If The discretization level is superior to the difference between limit <i>Axis</i>
	 * value and min <i>Axis</i> value, this will be setted to 1 by default. 
	 * <p>
	 * <b>-<u>Observation </u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 * 
	 * @return  The current <i>Axis</i> with its values reordered.	
	 */	
	public int discretizationStep();
	/**
	 * Return an Integer ArrayList with the <i>Axis</i> values sorted, discretizaised 
	 * and chopped up according to the discretizaitionLevel and limit <i>Axis</i> parameters.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer ArrayList with the discretizaised <i>Axis</i> values.	
	 */
	public ArrayList<Integer> discretizaiseAxis();
	/**
	 * Sort the current <i>Axis</i> values using the BubbleSort algorithm. 
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 * 
	 * @return  The current <i>Axis</i> with its values reordered.	
	 */	
	public IAxis sort();
	/**
	 * Sort the <i>Axis</i> values according to the sort of an auxiliary <i>Axis</i>
	 * that will be sorting using the BubbleSort algorithm. 
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the sortAxis <i>Axis</i> values must be numeric Strings.
	 * 
	 * @param  sortAxis An auxiliary <i>Axis</i> that will reorder the current
	 * <i>Axis</i> values according to its own sort.
	 * @return  The <i>Axis</i> with its values reordered.	
	 */
	public IAxis indirectSort(IAxis sortAxis);
}