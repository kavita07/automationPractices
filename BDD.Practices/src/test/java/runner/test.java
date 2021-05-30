package runner;

public class test {
	boolean flag = false;
	
	public boolean readSTring(String name) {
		
		for(int i=0, j=(name.length()-1); i<=j; i++, j--) {
			
			if(name.charAt(i)==name.charAt(j)) {
				flag = true;
			}else {
				flag = false;
			}
		}
		return flag;
 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test obj = new test();
		
		System.out.println(obj.readSTring("rever"));
		
		
		
		

	}

}
