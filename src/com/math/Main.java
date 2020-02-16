package com.math;

public class Main{
    public static void main(String args[]){
        System.out.println("math package");
        Complex f = new Complex(1, 2);
        Operable a = new DoubleMatrix(new double[][]{{1,1}, {1,1}});
        Operable b = new DoubleMatrix(new double[][]{{1,2}, {1,4}});
        Operable rt = new ComplexMatrix(new Complex[][]{{f,f}, {f,f}});
        try{
            Operable c = a.add(b);
            c.show();
        }
        catch(Exception ex){
            for (int i = 0; i < ex.getStackTrace().length; i++){
                if (ex.getStackTrace()[i].getFileName().equals("Main.java")){
                    String errorLine = Integer.toString(ex.getStackTrace()[i].getLineNumber());
                    String errorMessage = ex.getMessage();
                    System.out.print(String.format(" Error caused when performing test on string: %s: '%s' ", errorLine, errorMessage));
                }
            }
        }
    }
}