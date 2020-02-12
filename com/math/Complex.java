import java.lang.Math;
package math;

public class Complex {
    private double real, img, abs, cos, sin;

    public Complex() {}

    public Complex( double real, double img ) {
        this.real = real;
        this.img  = img;
        toTrigonometry();
    }

    public String toString() {
        if (img >= 0)
            return real + "+" +  img + "i";
        else
            return real + "-" + -img + "i";
    }

    public Complex Add( Complex input ) {
        try {
            input.Abs();
        }
        catch (Exception exception){
            System.out.println("Error: input is null");
            return null;
        }
        Complex sum = new Complex();
        sum.real= real + input.real;
        sum.img = img  + input.img;
        return (sum);
    }

    public Complex Sub( Complex input ) {
        try {
            input.Abs();
        }
        catch (Exception exception){
            System.out.println("Error: input is null");
            return null;
        }
        Complex diff = new Complex();
        diff.real = real - input.real;
        diff.img = img - input.img;
        return (diff);
    }

    public Complex Mult( Complex input ) {
        try {
            input.Abs();
        }
        catch (Exception exception){
            System.out.println("Error: input is null");
            return null;
        }
        Complex mult = new Complex();
        mult.real= real*input.real - img*input.img;
        mult.img = img*input.real  + real*input.img;
        return (mult);
    }

    public Complex Div( Complex input ) {
        try {
            input.Abs();
        }
        catch (Exception exception){
            System.out.println("Error: input is null");
            return null;
        }
        Complex div = new Complex();
        double first, second;
        if (input.real == 0 || input.img == 0){
            return null;
        }
        if(Math.abs( input.real ) >= Math.abs( input.img )) {
            first    = input.img/input.real;
            second   = input.real + first*input.img;
            div.real = (real + first*img)/second;
            div.img  = (img - first*real)/second;
        } else {
            first    = input.real/input.img;
            second   = input.img + first*input.real;
            div.real = (first*real + img)/second;
            div.img  = (first*img - real)/second;
        }
        return (div);
    }

    public double Abs() {
        double x, y, tmp, dAnswer;
        x = Math.abs( real );
        y = Math.abs( img  );
        if (x == 0)
            return y;
        else if (y == 0)
            return x;
        else if (x > y) {
            tmp = y/x;
            return x*Math.sqrt((1.0 + tmp*tmp));
        } else {
            tmp = x/y;
            return y*Math.sqrt((1.0 + tmp*tmp));
        } 
    }

    public String toTrigonometry(){
        this.abs = Abs();
        if (this.abs == 0){
            return "0(0+0i)";
        }
        this.cos = this.real/this.abs;
        this.sin = this.img/this.abs;
        return this.abs+"("+this.cos+"+"+this.sin+"i)";
    }

    public boolean equal(Object object){
        if (object == null){
            return false;
        }
        if (!(object instanceof Complex)){
            return false;
        }
        Complex obj = (Complex)object;
        if (obj.real == this.real && obj.img == this.img){
            return true;
        }
        return false;
    }

    public int hashCode(){
        int result = 17;
        result = result*31 + (int)this.real;
        result = result*31 + (int)this.img;
        return result;
    }

    public static void main ( String args[] ) {
        Complex test = new Complex( 1.0, -1.0 );
        Complex test_div = new Complex( 1.0, -1.0 );
        System.out.println(test_div.equal(test));
    }
}