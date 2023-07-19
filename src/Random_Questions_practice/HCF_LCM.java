package Random_Questions_practice;

public class HCF_LCM {
    public static void main(String[] args) {
        int n1 = 72;
        int n2 = 120;

        System.out.println(HCF(n1, n2));
        System.out.println(LCM(n1, n2));
    }

    public static int HCF(int a, int b){
        while(a != b){
            if(a > b){
                a -= b;
            }
            else{
                b -= a;
            }
        }

        return a;
    }

    public static int LCM(int a, int b){
        int gcd = 1;

        for (int i = 1; i <=a && i<=b ; i++) {
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }

        }

        return (a * b) / gcd;
    }
}
