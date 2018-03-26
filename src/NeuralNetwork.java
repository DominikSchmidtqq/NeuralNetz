public class NeuralNetwork {
    private int inputNodes;
    private int hiddenNodes;
    private int outputNodes;
    private Matrix weightsInputHidden;
    private Matrix weightsHiddenOutput;
    private Matrix biasHidden;
    private Matrix biasOutput;
    public NeuralNetwork(int numberOfInputs, int numberOfHidden, int numberOfOutput) {
        this. inputNodes = numberOfInputs;
        this.hiddenNodes = numberOfHidden;
        this.outputNodes = numberOfOutput;

        this.weightsInputHidden = new Matrix(this.hiddenNodes, this.inputNodes);
        this.weightsHiddenOutput = new Matrix(this.outputNodes, this.hiddenNodes);
        this.biasHidden = new Matrix(this.hiddenNodes, 1);
        this.biasOutput = new Matrix(this.outputNodes, 1);

        this.weightsHiddenOutput.randomize();
        this.weightsInputHidden.randomize();
        this.biasHidden.randomize();
        this.biasOutput.randomize();
    }

    public int getNumberOfInputs(){
        return this.inputNodes;
    }

    public int getNumberOfHidden(){
        return this.hiddenNodes;
    }

    public int getNumberofOutput(){
        return this.outputNodes;
    }

    public static double sigmoid(double x) {
        return 1/(1 + Math.exp(-x));
    }

    public Matrix feedForward(double[] inputArray) {
        Matrix inputs = Matrix.toObject(inputArray);

        Matrix hidden = Matrix.multiplication(this.weightsInputHidden, inputs);
        hidden.Addition(this.biasHidden);

        for (int i = 0; i < hidden.getRows(); i++) {
            for (int j = 0; j < hidden.getRows(); j++) {
                hidden.setValueAtIndex(i,j,sigmoid(hidden.getValueAtIndex(i,j)));
            }
        }

        Matrix output = Matrix.multiplication(this.weightsHiddenOutput, hidden);
        output.Addition(this.biasOutput);

        for (int i = 0; i < output.getRows(); i++) {
            for (int j = 0; j < output.getColumns(); j++) {
                output.setValueAtIndex(i,j, sigmoid(output.getValueAtIndex(i,j)));
            }
        }

        return output;
    }
}