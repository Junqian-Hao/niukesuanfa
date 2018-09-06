package basic_class_01;
//随便测试用的类
public class Test {

	  public static Test t1 = new Test();
	    public static Test t2 = new Test();
	    {
	        System.out.println("构造块");
	    }
	    static
	    {
	        System.out.println("静态块");
	    }
	    public static void main(String[] args)
	    {
	    	Test t = new Test();
	    	double d1=-0.5;
	    	System.out.println("Ceil d1="+Math.ceil(d1));
	    	System.out.println("floor d1="+Math.floor(d1));
	    	
	    	int i = 0;
	    	i=i++;
	    	System.out.println("i=i++"+i);
	    	i = 0;
	    	i = i++ + ++i;
	    	System.out.println("i++ + ++i"+i);
	    	Integer a1 = 127;
	    	Integer a2 = 128;
	    	Integer a3 = 127;
	    	Integer a4 = 128;
	    	System.out.println(a1 == a3);
	    	System.out.println(a2 == a4);
	    	
//	    	Double oD = 3;
	    	double oE = 3;
	    	Double oF = 3.0;
	    	Double oG = (double) 3;
	    	
	    }
	    
}
