import java.util.Arrays;

public class LCS {
	public static int lcs_memo(String x, String y,int n,int m,int memo[][]) {
		int result;
		if(n==0 || m==0)
			return 0;
		if(memo[n][m] != -1)
			return memo[n][m];
		if(x.charAt(n-1)==y.charAt(m-1))
			result =lcs_memo(x,y,n-1,m-1,memo)+1;
		else {
				result = Math.max(lcs_memo(x,y,n-1,m,memo), lcs_memo(x,y,n,m-1,memo));
		}
		memo[n][m]=result;
		return result;
		
	}
	
	public static int lcs_dp(String x,String y,int n,int m,int memo[][]) {
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++) {
				if(x.charAt(i-1)==y.charAt(j-1))
					memo[i][j] = memo[i-1][j] + 1;
				else
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		return memo[n][m];
	}
public static int lcs_dp3(String x,String y,String z,int n,int m,int o,int memo[][][]) {
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++)
				for(int k=1;k<=o;k++){
				if(x.charAt(i-1)==y.charAt(j-1) && x.charAt(i-1)==z.charAt(k-1))
					memo[i][j][k] = memo[i-1][j-1][k] + 1;
				else
					{
					int s = Math.max(memo[i-1][j][k], memo[i][j-1][k]);
					memo[i][j][k] = Math.max(s, memo[i][j][k-1]);
					}
			}
		return memo[n][m][o];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "STONE";
		String y = "LONGEST";
		String z = "BROTNGEST";
		int [][] memo = new int[x.length()+1][y.length()+1];
		for(int i=0;i<x.length()+1;i++)
			Arrays.fill(memo[i],-1);		
		int len = lcs_memo(x,y,x.length(),y.length(),memo);
		System.out.println("MAx length "+len);
		
		int [][] memo2 = new int[x.length()+1][y.length()+1];
		for(int i=0;i<x.length()+1;i++)
			Arrays.fill(memo[i],0);
		int len1 = lcs_dp(x,y,x.length(),y.length(),memo2);
		System.out.println("MAx lengtha "+len1);
		
		int [][][] memo3 = new int[x.length()+1][y.length()+1][z.length()+1];
		for(int i=0;i<x.length()+1;i++)
			for(int j=0;j<y.length()+1;j++)
				Arrays.fill(memo3[i][j], 0);
		int len3 = lcs_dp3(x,y,z,x.length(),y.length(),z.length(),memo3);
		System.out.println("MAx lengthc "+len3);

	}

}
