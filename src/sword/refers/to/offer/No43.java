package sword.refers.to.offer;

public class No43 {

	/**
	 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs��
	 * ����n����ӡ��s�����п��ܵ�ֵ���ֵĸ���
	 */
	public static void main(String[] args) {
		printProbability(2);
	}

	private static void printProbability(int num) {
		if(num<1)
			return;
		int gMaxValue=6;
		int[][] probabilities=new int[2][];
		probabilities[0]=new int[gMaxValue*num+1]; 
		probabilities[1]=new int[gMaxValue*num+1]; 
		int flag=0;
		for(int i=1;i<=gMaxValue;i++){
			probabilities[flag][i]=1;
		}
		for(int k=2;k<=num;k++){
			for(int i=0;i<k;i++){ 
			    probabilities[1-flag][i]=0; 
			   } 
			for(int i=k;i<=gMaxValue*k;i++){ 
			    probabilities[1-flag][i]=0; 
			    for(int j=1;j<=i&&j<=gMaxValue;j++)   
			 probabilities[1-flag][i]+=probabilities[flag][i-j]; 
		}
			 flag=1-flag;
		
	}
		double total=Math.pow(gMaxValue, num);for(int i=num;i<=gMaxValue*num;i++){ 

			   double ratio=(double)probabilities[flag][i]/total; 

			   System.out.print(i+" "); 

			   System.out.println(ratio); 
	
	}
	}
}