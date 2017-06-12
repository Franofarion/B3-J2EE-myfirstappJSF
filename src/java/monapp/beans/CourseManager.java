/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monapp.beans;

import javax.ejb.Stateless;
import java.util.List;
import java.util.ArrayList;

@Stateless
public class CourseManager {

    private List<Course> listeCourses;

    public CourseManager() {
        listeCourses = new ArrayList<Course>();
    }

    public List<Course> findCourses() {
        return listeCourses;
    }

    public Course findCourse(Integer n) {
        Course returnValue = new Course();
        for(Course course: listeCourses){
            if(course.getId().equals(n)){
                returnValue = course;
            }
        }
        return returnValue;
    }

    public void saveCourse(Course c) {
        if (c.getId() == null) {
            Integer maxId = 0;
            if(listeCourses.size() >= 1){
                for(Course course : listeCourses){
                    maxId = Integer.compare(maxId, course.getId()) < 0 ? course.getId() : maxId;
                }
            }
            c.setId(maxId);
            listeCourses.add(c);
        } else {
            for(Course course: listeCourses){
                if(course.getId().equals(c.getId())){
                    deleteCourse(course);
                    listeCourses.add(c);
                }
            } 
        }
    }

    public void deleteCourse(Course c) {
        int index = listeCourses.indexOf(c);
        listeCourses.remove(index);
    }
}
