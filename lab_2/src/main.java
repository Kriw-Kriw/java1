public class main{
    public static void main(String[] args){
        ExpressionParser parser = new ExpressionParser();

        String[] expressions = {"14+2*10-3^3",
                "2*sin(0.5)+5*cos(2*0.5)",
                "log(64,2)*lg(100)",
                "f(x,y)",
                "2*x*5",
                "e^2+1"};

        for(String expression:expressions){
            System.out.print(expression+"  ");
            try{
                double str = parser.Parse(expression);
                System.out.print(str+"\n");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}