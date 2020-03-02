package com.math;

public class ComplexMatrix{
    private int M;             
    private int N;             
    private Complex[][] data;   

    public ComplexMatrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new Complex[M][N];
    }

    public ComplexMatrix(Complex[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new Complex[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }
    
    public ComplexMatrix transpose() {
        ComplexMatrix A = new ComplexMatrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    public ComplexMatrix add(ComplexMatrix B_in) throws RuntimeException {
        ComplexMatrix B = (ComplexMatrix)B_in;
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        ComplexMatrix C = new ComplexMatrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j].add(B.data[i][j]);
        return C;
    }

    public ComplexMatrix minus(ComplexMatrix B_in) throws RuntimeException {
        ComplexMatrix B = (ComplexMatrix)B_in;
        if (this.N != B.M || this.M != B.N) throw new RuntimeException("Illegal matrix sizes");
        ComplexMatrix C = new ComplexMatrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = this.data[i][j].minus(B.data[i][j]);
        return C;
    }

    public boolean equal(Object object) {
        if (object == null){
            return false;
        }
        if (!(object instanceof ComplexMatrix)){
            return false;
        }
        ComplexMatrix B = (ComplexMatrix)object;
        if (B.M != this.M || B.N != this.N) throw new RuntimeException("Illegal matrix sizes");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (this.data[i][j] != B.data[i][j]) return false;
        return true;
    }


    public ComplexMatrix multiply(ComplexMatrix B_in) throws RuntimeException{
        ComplexMatrix B = (ComplexMatrix)B_in;
        if (this.N != B.M) throw new RuntimeException("Illegal matrix sizes");
        ComplexMatrix C = new ComplexMatrix(this.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < this.N; k++)
                    C.data[i][j] = C.data[i][j].add(this.data[i][k].multiply(B.data[k][j]));
        return C;
	}
	
    public String show() {
        String result = new String();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) 
                result = result + data[i][j].show() + " ";
            result = result + "\n";
        }
        return result;
    }

}
