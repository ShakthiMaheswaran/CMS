package models;

public class StudentOps {

    //Crud opes on students


    //New Student
    public void addStudent(){
        //Throw not implemented exception
    }

    // Retriveiw Student
    public Student getStudent(){
        return new Student("","");
    }

    //Modify Student
    public boolean modify(){
        // need to do a lot of things like
        //1.check what part of the data modified then call exsate methode to update
        // need more method for update

        return false;
    }

    //For Drop Student need to approach
    //1. remove entaire record
    //2. make him inactive
    //only adding the remove of the record
    public boolean removeStudent(){

        return false;
    }
}
