package com.math;

public class Matrix{
    private int M;             
    private int N;             
    private Complex[][] data;   

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new Complex[M][N];
    }

    public Matrix(Complex[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new Complex[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }
    
    public Matrix add(Matrix B) throws RuntimeException {
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j].add(B.data[i][j]);
        return C;
    }

    public Matrix minus(Matrix B) throws RuntimeException {
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j].minus(B.data[i][j]);
        return C;
    }

    public boolean equal(Object object) {
        if (object == null){
            return false;
        }
        if (!(object instanceof Matrix)){
            return false;
        }
        Matrix B = (Matrix)object;
        if (B.M != this.M || B.N != this.N) throw new RuntimeException("Illegal matrix sizes");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (this.data[i][j] != B.data[i][j]) return false;
        return true;
    }


    public Matrix multiply(Matrix B) throws RuntimeException{
        if (this.N != B.M) throw new RuntimeException("Illegal matrix sizes");
        Matrix C = new Matrix(this.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < this.N; k++)
                    C.data[i][j] = C.data[i][j].add(this.data[i][k].multiply(B.data[k][j]));
        return C;
	}
	
    public String toString() {
        String result = new String();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) 
                result = result + data[i][j].toString() + " ";
            result = result + "\n";
        }
        return result;
    }

}
