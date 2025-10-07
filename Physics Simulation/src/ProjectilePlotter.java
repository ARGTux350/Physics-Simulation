import java.io.IOException;
import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class Main {

    public static void main(String[] args) throws IOException {
    	// Step 1: Input 5 known points for projectile motion
    	double[] xInput = {0.0, 1.0, 2.0, 3.0, 4.0};
    	double[] yInput = {2.0, 4.5, 5.0, 3.5, 1.0};


        // Step 2: Fit a quadratic curve (degree 2)
        WeightedObservedPoints obs = new WeightedObservedPoints();
        for (int i = 0; i < xInput.length; i++) {
            obs.add(xInput[i], yInput[i]);
        }

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2); // quadratic
        double[] coeffs = fitter.fit(obs.toList()); // returns [c, b, a] for ax^2 + bx + c

        // Step 3: Generate smooth curve
        int numPoints = 100;
        double[] xData = new double[numPoints];
        double[] yData = new double[numPoints];
        for (int i = 0; i < numPoints; i++) {
            xData[i] = -2.0 + 4.0 * i / (numPoints - 1);
            yData[i] = coeffs[2] * xData[i] * xData[i] + coeffs[1] * xData[i] + coeffs[0];
        }

        // Step 4: Plot the curve
        XYChart chart = QuickChart.getChart("Fitted Curve", "X", "Y", "y(x)", xData, yData);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setMarkerSize(0);
        chart.setXAxisTitle("Input (x)");
        chart.setYAxisTitle("Output (y)");

        chart.getStyler().setAxisTitleFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        chart.getStyler().setAxisTitlePadding(10);
        chart.getStyler().setXAxisLabelRotation(0);
        chart.getStyler().setXAxisDecimalPattern("0.0");


        new SwingWrapper(chart).displayChart();
        BitmapEncoder.saveBitmap(chart, "./Fitted_Curve", BitmapFormat.PNG);
        BitmapEncoder.saveBitmapWithDPI(chart, "./Fitted_Curve_300_DPI", BitmapFormat.PNG, 300);
    }
}
