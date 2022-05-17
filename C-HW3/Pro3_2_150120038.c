//Muhammed Enes Gündüz - 150120038
/*In this question, we will write a program to find super digit of a number X using the following
rules:
• If X has only 1 digit, then its super digit is X.
• If X has more than 1 digit, then its super digit is equal to the super digit of the digit-sum of X.*/

#include <stdio.h>


int superDigit(int n, int k, int check){
    int sum = 0;
    int m;
    while(n>0)  //Calculating the sum of digits 
    {    
        m=n%10; //getting each digit
        sum=sum+m; //incrementing sum
        n=n/10;  //getting rid of the digit that we already got
    }   

    if(check){ //If it is first time we call the function, then sum will be multiply by repetition factor k.
        sum *=k;
    }

    if(sum<10){ //If sum is less than 10, return the super digit
        return sum;
    } else { //If it is not, then call the function again and set new parameters
        superDigit(sum,k,0);
    }
   

}

     
int main(){
    int n,k;
    printf("Please enter a number (n=) : ");
    scanf("%d", &n);
    printf("Please enter repetition factor (k=): "); 
    scanf("%d", &k); //Getting inputs

    int superDigitDeger = superDigit(n,k,1);

    printf("Super digit of number ");
    while(k!=0){
        printf("%d",n); //Printing the message
        k--;
    }
    printf(" is %d.", superDigitDeger);
    
    return 0;
}