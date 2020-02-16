package com.math;

public class DoubleMatrix implements Operable{
    private int M;             
    private int N;             
    private double[][] data;   

    public DoubleMatrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    public DoubleMatrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }
    
    public DoubleMatrix transpose() {
        DoubleMatrix A = new DoubleMatrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    @Override
    public Operable add(Operable B_in) throws RuntimeException {
        DoubleMatrix B = (DoubleMatrix)B_in;
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        DoubleMatrix C = new DoubleMatrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j] + B.data[i][j];
        return C;
    }

    @Override
    public Operable minus(Operable B_in) throws RuntimeException {
        DoubleMatrix B = (DoubleMatrix)B_in;
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        DoubleMatrix C = new DoubleMatrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j] - B.data[i][j];
        return C;
    }
    @Override
    public Operable divide(Operable B_in) throws RuntimeException {
        DoubleMatrix B = (DoubleMatrix)B_in;
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        DoubleMatrix C = new DoubleMatrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j] - B.data[i][j];
        return C;
    }

    public boolean equal(Object object) {
        if (object == null){
            return false;
        }
        if (!(object instanceof DoubleMatrix)){
            return false;
        }
        DoubleMatrix B = (DoubleMatrix)object;
        if (B.M != this.M || B.N != this.N) throw new RuntimeException("Illegal matrix sizes");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (this.data[i][j] != B.data[i][j]) return false;
        return true;
    }

    @Override
    public Operable multiply(Operable B_in) throws RuntimeException{
        DoubleMatrix B = (DoubleMatrix)B_in;
        if (this.N != B.M) throw new RuntimeException("Illegal matrix sizes");
        DoubleMatrix C = new DoubleMatrix(this.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < this.N; k++)
                    C.data[i][j] += (this.data[i][k] * B.data[k][j]);
        return C;
    }
    
    @Override
    public String show() {
        String result = new String();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) 
                result = result + data[i][j];
            result = result + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        DoubleMatrix D = new DoubleMatrix(d);
        DoubleMatrix S = new DoubleMatrix(1,1);
        D.add(S);
        D.show();
    }
}