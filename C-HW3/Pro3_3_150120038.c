//Muhammed Enes Gündüz - 150120038
/*We will print identical triangles nested each other recursively. We will construct
the triangles by using two digits ‘_’(underscore) and ‘1’. */

#include <stdio.h>

/**Drawing logic : Put 1 in _ place into the array that already filled by _ character.*/
void triangleCreator(char coordinates[][63],int iterationNmbr, int length, int firstRow,int firstCol){
    if(iterationNmbr==0){ //If the iteration number is 1, then fill the array for simple default triangle
        int i,j;
        for(i=0;i<length;i++){
            coordinates[firstRow+i][firstCol]='1'; 
            for(j=1;j<=i;j++){ //Putting 1s into the array as the logic that explained
                coordinates[firstRow+i][firstCol+j]='1';
                coordinates[firstRow+i][firstCol-j]='1';
            }
        }
    }else{ //If it has more than 0 iteration, then call the function with given parameters. Maximum iteration will be 5.
        triangleCreator(coordinates, iterationNmbr-1, length/2, firstRow, firstCol);
        triangleCreator(coordinates, iterationNmbr-1, length/2, firstRow+length/2, firstCol-length/2);
        triangleCreator(coordinates, iterationNmbr-1, length/2, firstRow+length/2, firstCol+length/2);
    }
}

int main(void) {
    char coordinates[32][63]; //2 dimentional array for holding the characters

    int i,j;
    for(i=0;i<32;i++){
        for(j=0;j<63;j++){
            coordinates[i][j]='_'; //Filling array with _ characters
        }
    }

    int n;
    printf("number of iteration: ");
    scanf("%d",&n); //Getting inputs

    triangleCreator(coordinates, n,32,0,31); 

    for(i=0;i<32;i++){
        for(j=0;j<63;j++){
            printf("%c",coordinates[i][j]); //Printing the array that has final values.
        }
        printf("\n");
    }

    return 0;
}

