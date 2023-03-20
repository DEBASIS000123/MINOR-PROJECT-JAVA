import java.util.*;
public class AffineChiper {
	public static String encrypt(String plaintext) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter k1:");
		int k1=sc.nextInt();
		System.out.println("Enter k2:");
		int k2=sc.nextInt();
		String s="";
		for(int i=0;i<plaintext.length();i++) {
			s=s+enc_pt(k1,k2,plaintext.charAt(i));
		}
		return s;
	}
	public static char enc_pt(int k1,int k2,char ch) {
		ch=Character.toUpperCase(ch);
		int p=((int)ch-65)%26;
		int c=(p*k1+k2)%26;
		int res=65+c;
		return (char)res;
	}
	public static String decrypt(String ciphertext) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter k1:");
		int k1=sc.nextInt();
		System.out.println("Enter k2:");
		int k2=sc.nextInt();
		String s="";
		for(int i=0;i<ciphertext.length();i++) {
			s=s+dec_ct(k1,k2,ciphertext.charAt(i));
		}
		return s;
	}
	public static char dec_ct(int k1,int k2,char ch) {
		ch=Character.toUpperCase(ch);
		int c=((int)ch-65)%26;
		int p=mod(((c-k2)*mul_inverse(k1)),26);
		int res=65+p;
		return (char)res;
	}
	public static int mod(int a,int b){
		
		    int r = a % b;
		    return r < 0 ? r + b : r;
	}
	public static int mul_inverse(int k1) {
		
		int i=1;
		while(true) {
			if((i*k1 )% 26 ==1)
				break;
			i+=1;
		}
		return i;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("**********************************************");
			System.out.println("1-Convert plaintext to ciphertext");
			System.out.println("2-Convert ciphertext to plaintext");
			System.out.println("3-Exit");
			System.out.println("Enter your choice:");
			System.out.println("**********************************************");
			int x=sc.nextInt();
			switch(x) {
			case 1:
				System.out.println("Enter plaintext:");
				String p=sc.next();
				System.out.println("The cipher text is:"+encrypt(p));
				break;
			case 2:
				System.out.println("Enter ciphertext:");
				String c=sc.next();
				System.out.println("The cipher text is:"+decrypt(c));
				break;
			case 3:
				System.exit(0);
			}
		}
	}
}
