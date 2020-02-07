package jConsolePlot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import org.junit.Before;

public class JConsolePlotTest {
	
	ArrayList<String> valuesA = new ArrayList<String>();
	ArrayList<String> valuesB = new ArrayList<String>();
	ArrayList<String> valuesC = new ArrayList<String>();
	ArrayList<String> valuesD = new ArrayList<String>();
	ArrayList<String> valuesE = new ArrayList<String>();
	ArrayList<Integer> valuesF = new ArrayList<Integer>();
	ArrayList<String> valuesG = new ArrayList<String>();
	ArrayList<String> valuesH = new ArrayList<String>();
	ArrayList<String> valuesI = new ArrayList<String>();
	ArrayList<String> valuesJ = new ArrayList<String>();
	
	@Before
    public void initialize() {
		valuesA.add("A");
		valuesA.add("B");
		valuesA.add("C");
		valuesB.add("3");
		valuesB.add("5");
		valuesB.add("1");
		valuesC.add("1");
		valuesC.add("3");
		valuesC.add("5");
		valuesD.add("1");
		valuesD.add("3");
		valuesD.add("2");
		valuesE.add("1");
		valuesE.add("5");
		valuesE.add("3");
		valuesF.add(3);
		valuesF.add(5);
		valuesF.add(1);
		valuesG.add("A");
		valuesG.add("B");
		valuesH.add("12");
		valuesH.add("8");
		valuesI.add("4");
		valuesI.add("2");
		valuesJ.add("11");
		valuesJ.add("9");
    }
	
	@Test
	public void axisConstructorTest() {
		Axis axis = new Axis(valuesA, 10, 3);
		assertEquals(valuesA, axis.getValues());
		assertEquals(10, axis.getLimit());
		assertEquals(3, axis.getDiscretizationLevel());
		axis.setValues(valuesB);
		axis.setLimit(0);
		axis.setDiscretizationLevel(4);
		assertEquals(valuesB, axis.getValues());
		assertEquals(0, axis.getLimit());
		assertEquals(4, axis.getDiscretizationLevel());
	}
	
	@Test
	public void axisMethodsTest() {
		Axis axis = new Axis(valuesB, 0, 2);
		assertEquals(3, axis.size());
		assertEquals("1", axis.getElement(2));
		assertEquals(valuesF, axis.stringListToIntegerList());
		assertEquals(1, axis.minElement());
		assertEquals(5, axis.maxElement());
		assertEquals(2, axis.discretizationStep());
		axis.setDiscretizationLevel(10);
		assertEquals(1, axis.discretizationStep());
		axis.setDiscretizationLevel(2);
		axis.setLimit(3);
		assertEquals(1, axis.discretizationStep());
		assertEquals(valuesC, axis.sort().getValues());
		assertEquals(valuesE, axis.indirectSort(new Axis(valuesD, 0, 3)).getValues());
	}
	
	@Test
	public void barPlotTest() {
		Axis XAxis = new Axis(valuesA, 0, 4);
		Axis YAxis = new Axis(valuesB, 0, 4);
		BarPlot barPlotA = new BarPlot();
		assertEquals(null, barPlotA.getXValues());
		assertEquals(null, barPlotA.getYValues());
		BarPlot barPlotB = new BarPlot(XAxis, YAxis);
		assertEquals(valuesA, barPlotB.getXValues().getValues());
		assertEquals(valuesB, barPlotB.getYValues().getValues());
		String stringPlot = "5|     XX      \n4|     XX      \n3| XX  XX      \n2| XX  XX      \n1| XX  XX  XX  \n ==============\n    A   B   C";
		assertEquals(stringPlot, barPlotB.drawBarPlot());
		barPlotB.setXValues(new Axis(valuesC, 0, 4));
		barPlotB.setYValues(new Axis(valuesE, 0, 4));
		assertEquals(valuesC, barPlotB.getXValues().getValues());
		assertEquals(valuesE, barPlotB.getYValues().getValues());
		Axis XAxis2 = new Axis(valuesG, 0, 1);
		Axis YAxis2 = new Axis(valuesH, 0, 1);
		BarPlot barPlotC = new BarPlot(XAxis2, YAxis2);
		String stringPlot2 = "12| XX      \n8 | XX  XX  \n  ==========\n     A   B";
		assertEquals(stringPlot2, barPlotC.drawBarPlot());
	}
	
	@Test
	public void scatterPlotTest() {
		Axis XAxis = new Axis(valuesD, 0, 2);
		Axis YAxis = new Axis(valuesB, 0, 4);
		ScatterPlot scatterPlotA = new ScatterPlot();
		assertEquals(null, scatterPlotA.getXValues());
		assertEquals(null, scatterPlotA.getYValues());
		ScatterPlot scatterPlotB = new ScatterPlot(XAxis, YAxis);
		assertEquals(valuesD, scatterPlotB.getXValues().getValues());
		assertEquals(valuesB, scatterPlotB.getYValues().getValues());
		String stringPlot = "5|  X \n4|   \n3|X   \n2|   \n1| X  \n ====\n  1 2 3 ";
		assertEquals(stringPlot, scatterPlotB.drawScatterPlot());
		scatterPlotB.setXValues(new Axis(valuesC, 0, 2));
		scatterPlotB.setYValues(new Axis(valuesE, 0, 4));
		assertEquals(valuesC, scatterPlotB.getXValues().getValues());
		assertEquals(valuesE, scatterPlotB.getYValues().getValues());
		Axis XAxis2 = new Axis(valuesI, 0, 100);
		Axis YAxis2 = new Axis(valuesJ, 0, 0);
		ScatterPlot scatterPlotC = new ScatterPlot(XAxis2, YAxis2);
		String stringPlot2 = "9|X   \n ====\n  2 3 4 ";
		assertEquals(stringPlot2, scatterPlotC.drawScatterPlot());
	}
	
	@Test
	public void plotsFactory() {
		IPlot plot;
		plot = PlotsFactory.getPlot("BarPlot");
		assertEquals(null, plot.getXValues());
		assertEquals(null, plot.getYValues());
		assertEquals(null, PlotsFactory.getPlot("StrangePlot"));
	}
}