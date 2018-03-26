public class Matrix {
    private int rows, columns;
    private double[][] Matrix;
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.Matrix[i][j] = 0;
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.getColumns();
    }

    public double getValueAtIndex(int row, int column) {
        return this.Matrix[row][column];
    }

    public void ScalarMultiplication(double Val) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.Matrix[i][j] *= Val;
            }
        }
    }

    public void ScalarAddition(double Val) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.Matrix[i][j] += Val;
            }
        }
    }

    public void Addition(Matrix m) {
        if ((m.getRows() == this.getRows() && (m.getColumns() == this.getColumns()))) {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    this.Matrix[i][j] += m.getValueAtIndex(i,j);
                }
            }
        }
    }

    public static Matrix multiplication(Matrix l, Matrix m) {
        Matrix result = new Matrix(l.getRows(), m.getColumns());
        if (l.getRows() == m.getColumns()) {
            for (int i = 0; i < result.getRows(); i++) {
                for (int j = 0; j < result.getColumns(); j++) {
                    double sum = 0;
                    for (int k = 0; k < l.getColumns(); k++) {
                         sum += l.getValueAtIndex(i,k) * m.getValueAtIndex(k,j);
                    }
                    result.Matrix[i][j] = sum;
                }
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.Matrix[j][i] = this.getValueAtIndex(i,j);
            }
        }
        return result;
    }
}
