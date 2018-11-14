package gpacalculator;
import java.util.Scanner;
public class GPAcalculator {

 //GPA CALCULATOR
 //CHRIS HAMM
 //11/13/18
    public static void main(String[] args) {

    //scale to which each course is worth based on the grade. each alligns with the letters above. values go from A+ to F
    String [] letter = {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
    double [] general = {4.3,4.0,3.7,3.3,3.0,2.7,2.3,2.0,1.7,1.3,1.0,0.7,0};
    double [] honors = {5.3,5.0,4.7,4.3,4.0,3.7,3.3,3.0,2.7,2.3,1.0,0.7,0};
    double [] unweighted = {4.0,4.0,3.7,3.3,3.0,2.7,2.3,2.0,1.7,1.3,1.0,0.7,0};
    
    //amount of credits aligns with its equivilant array value in courses
    //these marking periods apply to sophmore year only
    String [] courses ={"Academy Class","Science","Math","English","History","Spanish/French","Gym","DriversEd","Health","Elective 1","elective 2",};
    double [] credits = {10.0,5.0,5.0,5.0,5.0,5.0,2.5,1.25,1.25,2.5,2.5};
    
   //theses arrays store the values user enters, and stores the score mentioned down below used to calculate gpa
    double [] grade = new double[courses.length];
    double [] score = new double[courses.length]; 
    double [] unweightedScore = new double[courses.length];
  
    
    //values used to calculate gpa
    char honorsCheck;
    int scaleValue = 0;
    double WeightedTotal = 0;
    double creditCount = 0;
    double unweightedTotal = 0;
    
       
    Scanner in = new Scanner(System.in);
    
    //entering a 0 allows user to void the class, and it is not counted when calculating gpa
    System.out.println("IMPORTANT MESSAGE: ENTER 0 IF YOU HAVE NOT TAKEN CLASS YET AND CALCULATOR WILL VOID CLASS");
    
    //for loop goes through each course in array, and asks user for the grade in that class
    //once the grade is obtained, user is aked if the course is honors or not
    for(int i = 0;i<courses.length;i++){
        System.out.print(courses[i] + ": ");
        grade[i] = in.nextInt();
        //continues if user voids class
        if(grade[i] == 0){
            System.out.println("");
            continue;
        }
        System.out.print("Honors(y/n): ");
        honorsCheck = in.next().charAt(0);
        
        //once grade is obtained, if statements determine what type of grade it is (A+, A, A-, ...) and sets it equal to a scale value(4.0,3.7,3.3, ...)
        //scale value is used to cacluate the gpa based on the grade earned, used in the array for honors or geneal
        if(grade[i] > 96.5){
            scaleValue = 0;
        }
        else if(grade[i] <96.5 && grade[i] >= 93.5){
            scaleValue = 1;
        }
        else if(grade[i] <93.5 && grade[i] >= 89.5){
            scaleValue = 2;
        }
        else if(grade[i] <89.5 && grade[i] >= 86.5){
            scaleValue = 3;
        }
        else if(grade[i] <86.5 && grade[i] >= 83.5){
            scaleValue = 4;
        }
        else if(grade[i] <83.5 && grade[i] >= 79.5){
            scaleValue = 5;
        }
        else if(grade[i] <79.5 && grade[i] >= 76.5){
            scaleValue = 6;
        }
        else if(grade[i] <76.5 && grade[i] >= 73.5){
            scaleValue = 7;
        }
        else if(grade[i] <73.5 && grade[i] >= 69.5){
            scaleValue = 8;
        }
        else if(grade[i] <69.5 && grade[i] >= 66.5){
            scaleValue = 9;
        }
        else if(grade[i] <66.5 && grade[i] >= 63.5){
            scaleValue = 10;
        }
        else if(grade[i] <63.5 && grade[i] >= 59.5){
            scaleValue = 11;
        }
        else if(grade[i] <59.5){
            scaleValue = 12;
        }
       


        
        //if/else statement determines if this grade should be multiplied by an honors level scale or a regular scale'
        //score is equvilant to the grade scale (4.0 for general, 5.0 for honors) multiplied by the amount of credits for class (typically 5.0 creditis)
        //whether course is honors or not, it multiplies it 
        if(honorsCheck == 'y'){
            score[i] = credits[i] * honors[scaleValue];
        }
        else{
            score[i] = credits[i] * general[scaleValue];
        }
        
        
        
        //a gpa is equivelant to the amount of credits a course is worth, multiplied by the scale(based on grade and type of course(honors/general)
        //this value is then divided by the total credits earned
        
        //the unweighhted gpa is based off 4.0 scale. this is not applicable to multiplying all courses by the general scale, as our general scale is 4.3 and below
        //adds up all unweighted scores
        unweightedScore[i] = credits[i] * unweighted[scaleValue];
        unweightedTotal += unweightedScore[i];
        
        //adds up all weighted scores
        WeightedTotal += score[i];
        
        //adds up total credits for the year
        creditCount += credits[i];
        
        System.out.println("");
    }
    
        double Weightedgpa = WeightedTotal/creditCount;
        double unweightedGPA = unweightedTotal/creditCount;
    
        //final output
        //add decimal format if you want
        System.out.println("unweighted: " + unweightedGPA);
        System.out.println("Weighted: " + Weightedgpa);
    }    
}
