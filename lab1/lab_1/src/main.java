public class main {
    public static void main(String[] args) throws Exception {
        double[][] mat1 = {{12, 2, 34, 15},
                {3, 5, 4, 19},
                {12, 2, 88, 8},
                {4, 5, 42, 51},
                {99, 99, 11, 11}};

        double[][] mat2 = {{1, 2,3},
                {1, 2,3},
                {1, 2,3},
                {1, 2,3}};
        Matrix matrix1 = new Matrix(mat1);
        Matrix matrix2 = new Matrix(mat2);


        double[] vector = {4, 5, 16, 21};




        //умножение матриц
        System.out.println("Умножение матрицы A на матрицу B\n");
        System.out.println("Матрица A:");
        matrix1.print();
        System.out.println("Матрица B:");
        matrix2.print();
        System.out.println("Результирующая матрица C: ");
        matrix1.multiplication(matrix2).print();

        System.out.println("------------------------------\n");

        //умножение матрицы на вектор
        System.out.println("Умножение матрицы A на вектор B\n");
        System.out.println("Матрица A:");
        matrix1.print();
        System.out.println("Вектор B:");
        print(vector);
        System.out.println("Результат:");
        print(matrix1.multiply_vector(vector));
        System.out.println("------------------------------\n");


        System.out.println("Определитель матрицы: ");
        double[][] mat4 = {{3, 1, 4, 5}, {22, 32, 11, 6}, {4, 78, 6, 2}, {1, 3, 4, 5}};
        Matrix matrix4 = new Matrix(mat4);
        matrix4.print();
        System.out.println("Определитель матрицы = " + matrix4.determinant());

        System.out.println("------------------------------\n");

        double number = 12;
        System.out.println("Умножение матрицы на число " + number + '\n');
        System.out.println("Матрица до умножения");
        matrix1.print();
        System.out.println("Результат");
        matrix1.multiplication(number).print();

        System.out.println("------------------------------\n");

        System.out.println("Сложение матриц");
        System.out.println("Матрица 1: ");
        matrix1.print();
        System.out.println("Матрица 2: ");
        matrix1.print();
        System.out.println("Результат: ");
        matrix1.sum(matrix1).print();

        System.out.println("------------------------------\n");

        System.out.println("Вычитание матриц");
        System.out.println("Матрица 1: ");
        matrix1.print();
        System.out.println("Матрица 2: ");
        matrix1.print();
        System.out.println("Результат: ");
        matrix1.minus(matrix1).print();
    }

    public static void print(double[] b) {
        for(int i = 0; i < b.length; ++i) {
            System.out.println(b[i]);
        }
        System.out.println();
    }

}