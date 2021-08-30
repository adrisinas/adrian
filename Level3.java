import java.util.Scanner;
public class Level3
{
    static boolean isPalindrome(String string, int i, int j)
  {
    while(i < j)
    {
      if(string.charAt(i) != string.charAt(j))
        return false; 
      i++;
      j--;
    }
    return true;
  }
 
  static int minPalPartition(String string, int i, int j)
  {   
    if( i >= j || isPalindrome(string, i, j) )
      return 0;
    int ans = Integer.MAX_VALUE, count;
    for(int k = i; k < j; k++)
    {
      count = minPalPartition(string, i, k) +
        minPalPartition(string, k + 1, j) + 1;
 
      ans = Math.min(ans, count);
    }
    return ans;
  }
    
	public static void main(String[] args) {
	    
	    //For capturing user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter non-empty String to check:");
        String str = scanner.nextLine();
        System.out.println(minPalPartition(str, 0, str.length() - 1));
	}
}