import java.util.*;
import java.util.Random;
public class BubbleSort
{ int [] nums;
  Random random = new Random();
  static Scanner scanner = new Scanner(System.in);
  public BubbleSort(int numItems, int maxValue, int randomSeed)
  { nums = new int [numItems];
    for (int i=0; i<=numItems-1; i++)
    { randomSeed = random.nextInt(maxValue-1);
      nums[i]= randomSeed; 
    }
    System.out.println("nums: " + Arrays.toString(nums));                         
  }
  public void bubbleSort() 
  { String exchangeThisPass = "";
    int n = nums.length;
    int lastPos=0 , newlastPos=0 , temp=0;
        for (int i = 1; i < n; i++)
           { if (nums[i-1] > nums[i])
             { newlastPos = i; 
               temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                exchangeThisPass += "("+nums[i-1] + "," + nums[i] + ") ";
             } 
           }
           System.out.println("exchangeThisPass: " + exchangeThisPass );
           System.out.println("nums: " + Arrays.toString(nums));
           lastPos = newlastPos;
           exchangeThisPass = "";
           do 
           { for (int i = 1; i < lastPos; i++)
                { if (nums[i-1] > nums[i])
                    { temp = nums[i-1];
                      nums[i-1] = nums[i];
                      nums[i] = temp;
                      exchangeThisPass += "("+nums[i-1] + "," +
                                          nums[i] + ") ";
                     }
                  newlastPos = i;
                 } 
             System.out.println("exchangeThisPass: " + exchangeThisPass );
             System.out.println("nums: " + Arrays.toString(nums));
             exchangeThisPass = "";
             lastPos = newlastPos;
           }while (lastPos > 1);
    }   
  public static void testBubbleSort (int numTests, int numItems)
  { int maxValue = 5*numItems;
    System.out.println("numItems = " + numItems + ", maxValue = " + maxValue + "\n" );
    for (int i = 1; i<numTests; i++)
    { BubbleSort ba = new BubbleSort(numItems, maxValue, i);
      ba.bubbleSort();
      System.out.println(" ");
    }
  }  
  public static void main(String[] args) 
  { System.out.print("Enter #(random items to be sorted, 1 <= numItems < 10): ");
    int numItems = scanner.nextInt();
    testBubbleSort(5, numItems);  
  }
}