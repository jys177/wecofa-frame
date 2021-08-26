package example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DivideConquer {



    @Test
    public void main() {
        Random random = new Random();
        int dataSize=100;
        int[] testArray=new int[dataSize];

        for (int i=0;i<dataSize;i++){
            int temp = random.nextInt(dataSize*5)+1;
            testArray[i]=temp;
        }
        int[] answer=divideConquerSorting(testArray);
        for (int a:answer){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public int[] divideConquerSorting(int[] array){
        if(array.length<=2){
            if(array.length==1){
                return array;
            }else {
                if(array[0]>array[1]){
                    int temp =array[0];
                    array[0] =array[1];
                    array[1]=temp;
                }
            }
            return array;
        }else{
            int[] y1 = divideConquerSorting(Arrays.copyOf(array,array.length/2));
            int[] y2 = divideConquerSorting(Arrays.copyOfRange(array,array.length/2,array.length));
            return conquer(y1,y2);
        }
    }
    public int[] conquer(int[] x1, int[] x2){
        int[] answer =  new int[x1.length + x2.length];
        int index1=0;
        int index2=0;
        int n=answer.length;
        for(int i=0; i<n;i++){
            if(index1==x1.length){
                for(;index2<x2.length;index2++){
                    answer[i++]=x2[index2];
                }
                return answer;
            }
            if(index2==x2.length){
                for(;index1<x1.length;index1++){
                    answer[i++]=x1[index1];
                }
                return answer;
            }
            if(x1[index1]>x2[index2]){
                answer[i]=x2[index2++];
            }else {
                answer[i]=x1[index1++];
            }
        }
        return answer;
    }
}
