public class Matrix {
    private int cols;
    private int rows;
    private double[][] matrix;

    public Matrix(int rows, int cols) throws NegativeArraySizeException {
        if (cols > 1 && rows > 1) {
            this.rows = rows;
            this.cols = cols;
            this.matrix = new double[this.rows][this.cols];
        } else {
            throw new NegativeArraySizeException("Матрица должна быть хотя бы 2 на 2");
        }
    }

    public Matrix(double[][] m) throws IllegalArgumentException {
        if (m == null || m[0].length < 1 || m.length < 1 ) {
            throw new NullPointerException("Матрица пуста или слишком мала");
        }
        else {
            this.rows = m.length;
            this.cols = m[0].length;
            this.matrix = m;
        }
    }

    public Matrix(Matrix copy) {
        this.matrix = new double[copy.rows][copy.cols];
        this.rows = copy.rows;
        this.cols = copy.cols;

        for(int i = 0; i < this.rows; ++i) {
            System.arraycopy(this.matrix[i], 0, copy.matrix[i], 0, this.cols);
        }

    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public double get_elem(int row, int column) throws IndexOutOfBoundsException {
        if (row < this.rows && column < this.cols) {
            return this.matrix[row][column];
        } else {
            throw new IndexOutOfBoundsException("Выход за границы матрицы");
        }
    }

    public void print() {
        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.cols; ++j) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Matrix sum(Matrix second) throws UnsupportedOperationException {
        if (this.rows == second.rows && this.cols == second.cols) {
            Matrix result = new Matrix(this.rows, this.cols);

            for(int i = 0; i < this.rows; ++i) {
                for(int j = 0; j < this.cols; ++j) {
                    result.matrix[i][j] = this.matrix[i][j] + second.matrix[i][j];
                }
            }

            return result;
        } else {
            throw new UnsupportedOperationException("Размер матриц должен быть одинаковым для сложения");
        }
    }

    public Matrix minus(Matrix second) throws UnsupportedOperationException {
        if (this.rows == second.rows && this.cols == second.cols) {
            Matrix result = new Matrix(this.rows, this.cols);

            for(int i = 0; i < this.rows; ++i) {
                for(int j = 0; j < this.cols; ++j) {
                    result.matrix[i][j] = this.matrix[i][j] - second.matrix[i][j];
                }
            }

            return result;
        } else {
            throw new UnsupportedOperationException("Размер матриц должен быть одинаковым для вычитания");
        }
    }

    public Matrix multiplication(double number) throws UnsupportedOperationException {
        Matrix result = new Matrix(this.rows, this.cols);

        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.cols; ++j) {
                result.matrix[i][j] = this.matrix[i][j] * number;
            }
        }
        //result.print();
        return result;
    }

    public Matrix multiplication(Matrix second) throws UnsupportedOperationException {
        if (this.cols != second.rows) {
            throw new UnsupportedOperationException("Мы не можем умножить, если кол-во столбцов != кол-ву строк");
        } else {
            Matrix result = new Matrix(this.rows, second.cols);

            for(int i = 0; i < result.rows; ++i) {
                for(int j = 0; j < result.cols; ++j) {
                    double value = 0.0;

                    for(int k = 0; k < this.cols; ++k) {
                        value += this.matrix[i][k] * second.matrix[k][j];
                    }

                    result.matrix[i][j] = value;
                }
            }

            return result;
        }
    }

    public double determinant() throws Exception  {
        if (this.rows != this.cols)
        {
            throw new Exception("Матрица должна быть квадратной");
        }
        double result = 0.0;
        if (this.rows == 3 && this.cols == 3) {
            result = this.matrix[0][0] * this.matrix[1][1] * this.matrix[2][2] + this.matrix[2][0] * this.matrix[0][1] * this.matrix[1][2] + this.matrix[0][2] * this.matrix[1][0] * this.matrix[2][1] - this.matrix[2][0] * this.matrix[1][1] * this.matrix[0][2] - this.matrix[1][0] * this.matrix[0][1] * this.matrix[2][2] - this.matrix[2][1] * this.matrix[1][2] * this.matrix[0][0];
            return result;
        } else if (this.rows == 2 && this.cols == 2) {
            result = this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
            return result;
        } else {
            for(int i = 0; i < this.cols; ++i) {
                int j = 0;

                Matrix tmp;
                int k;
                for(tmp = new Matrix(this.rows - 1, this.cols - 1); j < i; ++j) {
                    for(k = 1; k < this.rows; ++k) {
                        tmp.matrix[k - 1][j] = this.matrix[k][j];
                    }
                }

                for(j = i + 1; j < this.cols; ++j) {
                    for(k = 1; k < this.rows; ++k) {
                        tmp.matrix[k - 1][j - 1] = this.matrix[k][j];
                    }
                }

                if (i % 2 == 0) {
                    result += this.matrix[0][i] * tmp.determinant();
                } else {
                    result -= this.matrix[0][i] * tmp.determinant();
                }
            }

            return result;
        }
    }

    public void set(double value, int col, int row) throws IndexOutOfBoundsException {
        if (col < this.cols && row < this.rows) {
            this.matrix[col][row] = value;
        } else {
            throw new IndexOutOfBoundsException("Опять вышел за пределы");
        }
    }

    public double[] multiply_vector(double[] b) {
        if (b.length == 0) return null;
        if (cols != b.length)
            return null;

        double[] result = new double[this.rows];
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                result[i] += this.matrix[i][j] * b[j];
        return result;
    }
}

