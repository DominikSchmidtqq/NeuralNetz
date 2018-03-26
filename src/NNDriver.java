public class NNDriver {
    public static void main(String []args) {
        NeuralNetwork nn = new NeuralNetwork(2,2,1);
        double[] input = {1,0};
        Matrix output = nn.feedForward(input);
        for (int i = 0; i < output.getColumns(); i++) {
            for (int j = 0; j < output.getColumns(); j++) {
                System.out.println(output.getValueAtIndex(i,j));
            }
        }
    }
}
