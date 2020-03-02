package com.math;

public class Main{
    public static void main(String args[]){
        System.out.println("math package");
        Complex Cd = new Complex(1, 2);
        DoubleMatrix DMa = new DoubleMatrix(new double[][]{{1,1}, {1,1}});
        DoubleMatrix DMb = new DoubleMatrix(new double[][]{{1}, {1}});
        ComplexMatrix CMc = new ComplexMatrix(new Complex[][]{{Cd,Cd}, {Cd,Cd}});
        try{
            DoubleMatrix DMr = DMa.add(DMa);
            System.out.println(DMr);
            ComplexMatrix CMp = CMc.minus(CMc);
	        System.out.println(CMp);
	        DoubleMatrix DMe = DMa.add(DMb);
	        System.out.println(DMe);
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
    
}
}
