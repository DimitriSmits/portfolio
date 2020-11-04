package killerapp.backend.FakeData;

import killerapp.backend.enitities.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonData {


    //public LessonData(){
//
    //}
    public List<Lesson> getLessons(){
        List<Lesson> lessons = new ArrayList<Lesson>();
        Lesson lesson1 = new Lesson("Les 1","fdskjflhfklsjdfhfjksd","https://youtu.be/jvrcJTzDArI");
        Lesson lesson2 = new Lesson("Les 2","rtrwerdffsew","https://youtu.be/jvrcJTzDArI");
        Lesson lesson3 = new Lesson("Les 3","xcverdsfsdfwe","https://youtu.be/jvrcJTzDArI");

        lessons.add(lesson1);
        lessons.add(lesson2);
        lessons.add(lesson3);
        return lessons;
    }
}
