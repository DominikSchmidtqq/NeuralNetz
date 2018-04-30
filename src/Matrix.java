public class Matrix {
    private int rows, columns;
    private double[][] data;
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[this.rows][this.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.data[i][j] = 0;
            }
        }
    }



    public static Matrix toObject(double[] array) {
        Matrix m = new Matrix(array.length, 1);
        for (int i = 0; i < array.length; i++) {
            m.data[i][0] = array[i];
        }
        return m;
    }

    public void setValueAtIndex(int row, int column, double val) {
        this.data[row][column] = val;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void randomize() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                this.data[i][j] = Math.floor(Math.random()* 2 -1);
            }
        }
    }

    public double getValueAtIndex(int row, int column) {
        return this.data[row][column];
    }

    public void ScalarMultiplication(double Val) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.data[i][j] *= Val;
            }
        }
    }

    public void ScalarAddition(double Val) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.data[i][j] += Val;
            }
        }
    }

    public void Addition(Matrix m) {
        if ((m.getRows() == this.getRows() && (m.getColumns() == this.getColumns()))) {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    this.data[i][j] += m.getValueAtIndex(i,j);
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
                    result.data[i][j] = sum;
                }
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result.data[j][i] = this.getValueAtIndex(i,j);
            }
        }
        return result;
    }
}
