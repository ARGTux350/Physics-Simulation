import java.io.IOException;
import java.util.Arrays;
import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class ProjectilePlotter {

    public static void plot(double[] xInput, double[] yInput, String chartTitle) throws IOException {
        // Step 1: Fit a quadratic curve (degree 2)
        WeightedObservedPoints obs = new WeightedObservedPoints();
        for (int i = 0; i < xInput.length; i++) {
            obs.add(xInput[i], yInput[i]);
        }

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2); // quadratic
        double[] coeffs = fitter.fit(obs.toList()); // [c, b, a] for ax^2 + bx + c

        // Step 2: Generate smooth curve
        int numPoints = 100;
        double minX = Arrays.stream(xInput).min().getAsDouble();
        double maxX = Arrays.stream(xInput).max().getAsDouble();

        double[] xData = new double[numPoints];
        double[] yData = new double[numPoints];
        for (int i = 0; i < numPoints; i++) {
            xData[i] = minX + (maxX - minX) * i / (numPoints - 1);
            yData[i] = coeffs[2] * xData[i] * xData[i] + coeffs[1] * xData[i] + coeffs[0];
        }

        // Step 3: Create chart
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title(chartTitle)
                .xAxisTitle("Displacement (x)")
                .yAxisTitle("Displacement (y)")
                .build();

        // Fitted curve
        XYSeries fittedSeries = chart.addSeries("Trajectory", xData, yData);
        fittedSeries.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        fittedSeries.setLineColor(java.awt.Color.BLUE);
        fittedSeries.setMarker(SeriesMarkers.NONE);

        // Original data points
        XYSeries dataSeries = chart.addSeries("Original Data", xInput, yInput);
        dataSeries.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        dataSeries.setMarker(SeriesMarkers.CIRCLE);
        dataSeries.setMarkerColor(java.awt.Color.RED);

        // Style
        chart.getStyler().setAxisTitleFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setMarkerSize(6);

        // Show and Save
        new SwingWrapper<>(chart).displayChart();
        BitmapEncoder.saveBitmap(chart, "./Fitted_Curve", BitmapFormat.PNG);
        BitmapEncoder.saveBitmapWithDPI(chart, "./Fitted_Curve_300_DPI", BitmapFormat.PNG, 300);
    }
}
