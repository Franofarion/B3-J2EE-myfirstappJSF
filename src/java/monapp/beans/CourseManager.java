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
        //creer la liste de course
    }

    public List<Course> findCourses() {
         //a coder
        return listeCourses;
    }

    public Course findCourse(Integer n) {
        // a coder
        Course caca = new Course();
        return caca;
    }

    public Course saveCourse(Course c) {
        if (c.getId() == null) {
            //ajout dans la liste
        } else {
            //le rechercher et le modifier
        }
        return c;
    }

    public void deleteCourse(Course c) {
        //le supprimer
    }
}
