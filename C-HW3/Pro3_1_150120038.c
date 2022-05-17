//Muhammed Enes Gündüz - 150120038
//We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal
//2 ears. The even bunnies (2, 4, ..) have 3 ears, because they each have a raised foot. We will recursively
//return the number of “ears” in the bunny line 1, 2, ... n without loops or multiplication.

#include <stdio.h>

void bunnyEars(int line, int earCount, int totalLine){
    if(line==totalLine+1) //If all the lines completed, finish the function
        return;
    
    if(line==0){
        //first line, printing the message and incrementing line
        printf("bunnyEars%d(%d) -> %d\n",totalLine,line,earCount);
        bunnyEars(++line,earCount,totalLine); 
        return;
    }
    if(line%2!=0){
        //odd numbered line, printing the message and incrementing ears by 2 and line
        earCount+=2;
        printf("bunnyEars%d(%d) -> %d\n",totalLine,line,earCount);
        bunnyEars(++line,earCount,totalLine); //Calling function again for other lines
        return;
    } else {
        //even numbered line, printing the message and incrementing ears by 3 and line
        earCount+=3;
        printf("bunnyEars%d(%d) -> %d\n",totalLine,line,earCount);
        bunnyEars(++line,earCount,totalLine);
        return;
    }
}


int main(){

    printf("Please enter the number of lines (n=): ");
    int n;
    scanf("%d", &n); //getting inputs
    
    bunnyEars(0,0,n); //sending number of lines as a parameter to function

    return 0;
}

