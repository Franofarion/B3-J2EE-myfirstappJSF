/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monapp.beans;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CourseManager {

    private List<Course> listeCourses;

    public CourseManager() {
        Course c1 = new Course();
        c1.setName("Architecture JEE");
        c1.setHours(60);
        c1.setDescription("Introduction à JEE.");
        saveCourse(c1);
    }

    public List<Course> findCourses() {
        return listeCourses;
    }

    public Course findCourse(Integer n) {
        // a tester
        Long id = Long.valueOf(n);
        Course returnValue = new Course();
        for(Course course: listeCourses){
            if(course.getId().equals(id)){
                returnValue = course;
            }
        }
        return returnValue;
    }

    public Course saveCourse(Course c) {
        if (c.getId() == null) {
            Long maxId = Long.MIN_VALUE;
            for(Course course : listeCourses){
                maxId = Long.compare(maxId, course.getId()) < 0 ? course.getId() : maxId;
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
        return c;
    }

    public void deleteCourse(Course c) {
        int index = listeCourses.indexOf(c);
        listeCourses.remove(index);
    }
}
