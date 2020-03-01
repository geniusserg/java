package com.math;

public class Main{
    public static void main(String args[]){
        System.out.println("math package");
        Complex f = new Complex(1, 2);
        DoubleMatrix a = new DoubleMatrix(new double[][]{{1,1}, {1,1}});
        DoubleMatrix b = new DoubleMatrix(new double[][]{{1}, {1}});
        ComplexMatrix rt = new ComplexMatrix(new Complex[][]{{f,f}, {f,f}});
        try{
            Complex r = f.add(f);
            r.show();
        }
        catch(Exception ex){
            for (int i = 0; i < ex.getStackTrace().length; i++){
                if (ex.getStackTrace()[i].getFileName().equals("Main.java")){
                    String errorLine = Integer.toString(ex.getStackTrace()[i].getLineNumber());
                    String errorMessage = ex.getMessage();
                    System.out.print(String.format("ERROR! when performing test on string: %s: '%s' \n", errorLine, errorMessage));
                }
            }
        }
    
	System.out.println("boo");
}
}
