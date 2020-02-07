package jConsolePlot;

import java.util.ArrayList;
/**
 * Public class that declares and implements the basic attributes,
 * constructors, setters, getters and methods of the <i>IAxis</i>.
 * interface.
 * <p>
 * Every <i>Axis</i> object can redefine its own values according 
 * to its parameters.
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-05-26
 */
public class Axis implements IAxis {
	// Attributes.
	/**
	 * String ArrayList values of this <i>Axis</i>.
	 */
	private ArrayList<String> values;
	/**
	 * Integer max value of this <i>Axis</i>.
	 */
	private int limit;
	/**
	 * Integer that specify the discretization level of this <i>Axis</i>.
	 */
	private int discretizationLevel;
	
	// Constructor.
	/**
	  Initializes a newly created <i>Axis</i> object
	  with the specified parameters.
	  <p>
	  @param values an String ArrayList with the values of the current <i>Axis</i>.
	  @param limit an Integer that specify the max visible value of the current <i>Axis</i>.
	  @param discretiationLevel an Integer that specify the discretization level of the current <i>Axis</i>.      
	*/
	public Axis(ArrayList<String> values, int limit, int discretizationLevel) {
		this.values = values;
		this.limit = limit;
		this.discretizationLevel = discretizationLevel;
	}
	/**
	 * String ArrayList corresponding to the values of this <i>Axis</i>.
	 *
	 * @return  The current value of this <i>Axis</i> value.
	 */
	@Override
	public ArrayList<String> getValues() {
		return this.values;
	}
	/**
	 * Integer corresponding to the max value of this <i>Axis</i>.
	 *
	 * @return  The current value of this <i>Axis</i> limit.
	 */
	@Override
	public int getLimit() {
		return this.limit;
	}
	/**
	 * Integer corresponding to the discretization level of this <i>Axis</i>.
	 *
	 * @return  The current value of this <i>Axis</i> discretization level.
	 */
	@Override
	public int getDiscretizationLevel() {
		return this.discretizationLevel;
	}
	/**
	 * Set the values of the current <i>Axis</i>.
	 *
	 * @param  values new value of this <i>Axis</i> values.
	 */
	@Override
	public void setValues(ArrayList<String> values) {
		this.values = values;
	}
	/**
	 * Set the limit of the current <i>Axis</i>.
	 *
	 * @param  limit new value of this <i>Axis</i> limit.
	 */
	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}
	/**
	 * Set the discretization level of the current <i>Axis</i>.
	 *
	 * @param  values new value of this <i>Axis</i> discretization level.
	 */
	@Override
	public void setDiscretizationLevel(int discretizationLevel) {
		this.discretizationLevel = discretizationLevel;
	}	
	/**
	 * Gets the size of the <i>Axis</i> values.
	 *
	 * @return  The size of the <i>Axis</i> values ArrayList.
	 */
	@Override
	public int size() {
		return this.getValues().size();
	}
	/**
	 * Gets an specific element of the <i>Axis</i> values according
	 * to an index position of the ArrayList from values.
	 *
	 * @param  index Integer position of the element that will be extracted.
	 * @return  The element of <i>Axis</i> values according to the index.
	 */
	@Override
	public String getElement(int index) {
		return this.getValues().get(index);
	}
	/**
	 * Creates an Integer ArrayList that contains the <i>Axis</i> values
	 * converted from String type to Integer Type.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer ArrayList of the <i>Axis</i> values.
	 */
	@Override
	public ArrayList<Integer> stringListToIntegerList() {
		ArrayList<Integer> IntegerList = new ArrayList<Integer>();
		for (int i = 0; i < this.size(); i++) {
			IntegerList.add(Integer.parseInt(this.getElement(i)));		
		}
		return IntegerList;
	}
	/**
	 * Extract the min element of the <i>Axis</i> values.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer min value of the <i>Axis</i> values.
	 */
	@Override
	public int minElement() {
		ArrayList<Integer> integerList = this.stringListToIntegerList();
		int minElement = integerList.get(0);
		for (int i = 1; i < integerList.size(); i++) {
			minElement = Math.min(minElement, integerList.get(i));
		}
		return minElement;
	}
	/**
	 * Extract the max element of the <i>Axis</i> values.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer max value of the <i>Axis</i> values.	
	 */
	@Override
	public int maxElement() {
		int maxElement = 0;
		ArrayList<Integer> integerList = this.stringListToIntegerList();
		for (int i = 0; i < integerList.size(); i++) {
			maxElement = Math.max(maxElement, integerList.get(i));
		}
		return maxElement;
	}
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
	@Override
	public int discretizationStep() {
		int maxElement;
		int minElement = this.minElement();
		int discretizationLevel = this.getDiscretizationLevel();
		int discretizationStep;
		if (this.getLimit() == 0) {
			maxElement = this.maxElement();
		}
		else {
			maxElement = this.getLimit();
		}
		if (discretizationLevel == 0) {
			discretizationStep = 0;
		}
		else {
			discretizationStep = Math.round((maxElement - minElement) / discretizationLevel);
		}
		if (discretizationStep < 1) {
			discretizationStep = 1;
		}
		return discretizationStep;
	}
	/**
	 * Return an Integer ArrayList with the <i>Axis</i> values sorted, discretizaised 
	 * and chopped up according to the discretizaitionLevel and limit <i>Axis</i> parameters.
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 *
	 * @return  The Integer ArrayList with the discretizaised <i>Axis</i> values.	
	 */
	@Override
	public ArrayList<Integer> discretizaiseAxis() {
		int minElement = this.minElement();
		int discretizationLevel = this.getDiscretizationLevel();
		int discretizationStep = this.discretizationStep();
		if (discretizationLevel > this.maxElement() - this.minElement()) {
			discretizationLevel = this.maxElement() - this.minElement();
		}
		ArrayList<Integer> discretizaisedArray = new ArrayList<Integer>();
		for (int i = 0; i <= discretizationLevel; i++) {
			discretizaisedArray.add(minElement + i*discretizationStep);
		}
		return discretizaisedArray;
	}
	/**
	 * Sort the current <i>Axis</i> values using the BubbleSort algorithm. 
	 * <p>
	 * <b>-<u>Observation</u>:</b> All the <i>Axis</i> values must be numeric Strings.
	 * 
	 * @return  The current <i>Axis</i> with its values reordered.	
	 */	
	@Override
	public IAxis sort() {
		ArrayList<String> values = new ArrayList<String>();
		values = this.getValues();
		int k = values.size();
		String aux; 
		while (k > 1) {
			int i = 0;
			for (int j = 0; j <= k - 2; j++) {
				if (Integer.parseInt(values.get(j)) > Integer.parseInt(values.get(j+1))) {
					aux = values.get(j);
					values.set(j, values.get(j+1));
					values.set(j+1, aux);
					i = j + 1;
				}
			}
			k = i;
		}
		return new Axis(values, this.getLimit(), this.getDiscretizationLevel());
	}
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
	@Override
	public IAxis indirectSort(IAxis sortAxis) {
		ArrayList<String> values = new ArrayList<String>();
		ArrayList<String> sortValues = new ArrayList<String>();;
		values = this.getValues();
		sortValues = sortAxis.getValues();
		int k = values.size();
		String auxA; String auxB;
		while (k > 1) {
			int i = 0;
			for (int j = 0; j <= k - 2; j++) {
				if (Integer.parseInt(sortValues.get(j)) > Integer.parseInt(sortValues.get(j+1))) {
					auxA = sortValues.get(j);
					sortValues.set(j, sortValues.get(j+1));
					sortValues.set(j+1, auxA);
					auxB = values.get(j);
					values.set(j, values.get(j+1));
					values.set(j+1, auxB);
					i = j + 1;
				}
			}
			k = i;
		}
		return new Axis(values, this.getLimit(), this.getDiscretizationLevel());
	}
}