package com.math;

public class Main{
    public static void main(String args[]){
        System.out.println("math package");
        Complex Cd = new Complex(1, 2);
        Matrix CMa = new Matrix(new Complex[][]{{Cd,Cd}, {Cd,Cd}});
        Matrix CMb = new Matrix(new Complex[][]{{Cd}, {Cd}});
        try{
            Matrix CMp = CMa.minus(CMb);
	        System.out.println(CMp);
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
