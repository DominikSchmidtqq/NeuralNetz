public class NeuralNetwork {
    private int inputNodes;
    private int hiddenNotes;
    private int OutputNodes;
    public NeuralNetwork(int numberOfInputs, int numberOfHidden, int numberOfOutput) {
        this. inputNodes = numberOfInputs;
        this.hiddenNotes = numberOfHidden;
        this.OutputNodes = numberOfOutput;
    }

    public int getNumberOfInputs(){
        return this.inputNodes;
    }

    public int getNumberOfHidden(){
        return this.hiddenNotes;
    }

    public int getNumberofOutput(){
        return this.OutputNodes;
    }
}
